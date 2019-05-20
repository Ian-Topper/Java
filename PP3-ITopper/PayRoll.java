package PP03;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import java.util.*;

public class PayRoll {

	private String fileName;
	private PayRecord[] payRecords;
	private  double totalNetPay;
	private  double avgNetPay;
	private int manualNum;
	
	public PayRoll(String fileName, int n){
		
		this.fileName = fileName;
        this.manualNum = n;
	}

////////////////// Read from File ///////////////////////////////////////////////////
	
   public void readFromFile() throws FileNotFoundException, IOException, ParseException{
	    // read the initial data from PayRoll file to create the full 
	    // pay records with gross pay, taxes, and net pay, and then store it in PayRecord.txt file
	   	List<String> empDataFromFile = new ArrayList<String>();
	   	List<String> payDataFromFile = new ArrayList<String>();
	   	String output = "";
	   	
	    String line = "";
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			while (line != null) {
				line = br.readLine();
				if (line == null)
					continue;
				else {
					if (line.split(",")[0].equals("employee")) {
						empDataFromFile.add(line);
					}
					else {
						payDataFromFile.add(line);
					}
				}
			}////end while		
		}
		
		payRecords = new PayRecord[manualNum + empDataFromFile.size()];
		for (int i = 0; i < empDataFromFile.size(); i++) {
			
			String[] empData = empDataFromFile.get(i).split(",");
			String[] payData = payDataFromFile.get(i).split(",");
						
			// instantiate employee
			int id = Integer.parseInt(empData[1].trim());
	    		String fName = empData[2].trim();
	    		String lName = empData[3].trim();
	    		Status stat = Status.FullTime;
	    		if (empData[4].trim().equals("HOURLY"))
	    			stat = Status.Hourly;
	    		Employee emp = null;	
	    		Address addr = new Address(empData[5].trim(), empData[6].trim(), 
	    				empData[7].trim(), empData[8].trim(), Integer.parseInt(
	    				empData[9].trim()));
	    		emp = createEmployee(id,fName, lName,stat, addr); 		
	    		Person.numberOfPeopleInFile++;
	    		// instantiate payPeriod
	    		int periodID = Integer.parseInt(payData[5].trim());
	    		Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(payData[6].trim());
        		Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(payData[7].trim());
        		PayPeriod pp = new PayPeriod(startDate, endDate);
        		pp.setID(periodID);
	    		
        		int pid = Integer.parseInt(payData[1].trim());
        		int mIncome = Integer.parseInt(payData[3].split("<")[0].trim());
        		double income = Double.parseDouble(payData[3].split("<")[0].trim());     		
        		
        		if (emp.empStatus() == Status.FullTime) {
        			int time = Integer.parseInt(payData[4].split("<")[0].trim());
        			createPayRecord(pid, emp, pp, mIncome, time, 0, 0);
        		}
        		else {
        			
        			 createPayRecord(pid, emp, pp,  0, 0,mIncome,income);
        		}
        		PayRecord rec = null;
        		while( i < payRecords.length) {
        			if (payRecords[i] != null) {
        				 rec = payRecords[i] ;
        					output = output + rec.toString() + "\n"; 
        				 avgNetPay();
        				try {
        			 		writeToFile();
        				 } catch (IOException e1) {
        			 			e1.printStackTrace();
        				 	}
        				 	displayPayRecord();
        					break;	
        			 }///end if
        			}///end while
		}///end for		
	}////end method 

//////////////////////////   Write to file   ///////////////////////////////////////////////
   
public void writeToFile() throws IOException{
	   Object currentDatum = "";
	   int e = PayRecord.numberOfRecords-1;
		// write employees' pay records to the PayRecord.txt file, it should add employee pay record to the current file data
	   currentDatum = payRecords[e].toString() + "\n";
	if (currentDatum !=null){
	   FileWriter fw = new FileWriter("PayRecord.txt", true);
	   BufferedWriter bw = new BufferedWriter(fw);
	   bw.write(currentDatum.toString());
	   bw.newLine();
	   bw.flush();
	   bw.close();
	} 
   }
  
/////////////////////////// create employee  ////////////////////////////////////////////////

	public Employee createEmployee(int id, String lName, String fName, Status stat, Address addr) {
		// creates a new Employee object and add it to the employees array, you need to pass parameters to this method
		Employee emp = new Employee(fName, lName, addr);
		emp.setID(id);
		emp.setEmpStatus(stat);
		return emp;
	}

////////////////////////////create pay record  ///////////////////////////////////////////////////
	
	public void createPayRecord(int id, Employee e, PayPeriod pp, double mIncome, int nMonths, double nHour, double payRate) {
		// creates a new PayRecord for an Employee object and add it to  the payRecords array, you need to pass parameters to this method
		PayRecord prec;
		if (e.empStatus() == Status.FullTime) {
			prec = new PayRecord(id, e, pp, mIncome, nMonths);
		}
		else {
			prec = new PayRecord(id, e, pp, nHour, payRate);
		}
		for (int i = 0; i < payRecords.length; i++) {
			if (payRecords[i] == null) {
				payRecords[i] = prec;
				
				break;
			}
		}
		
	}

////////////////// Display pay record /////////////////////////////////////////
	
    public void displayPayRecord() {
		
		// it shows all payroll records for all currently added employee and the total net pay and average net pay in the GUI text area
    	// at should append data to text area, it must not overwrite data in the GUI text area
    	int e = PayRecord.numberOfRecords-1;
    			String currentData = payRecords[e].toString() + "\n";
    				UserGUI.textArea.append(currentData);
    					 currentData = toString() + "\n";
    					 if (PayRecord.numberOfRecords>1)
    					 UserGUI.textArea.append(currentData);	
    		}

/////////////////////////  Average net pay  ////////////////////////////
    
   public double avgNetPay() {
	   	int e = PayRecord.numberOfRecords-1;
	   while( e < payRecords.length) {
		   totalNetPay += payRecords[e].netPay();
	   break;
	   }
	  avgNetPay = totalNetPay / (PayRecord.numberOfRecords);
	   
	  return avgNetPay;
	}
 
///////////////////////  To String  ///////////////////////////////////   
   
   @Override
	public String toString() {
	   
		return "PayRoll [Total Net Pay: $" + String.format("%,.2f", 
				totalNetPay) + ", Avg Net Pay: $" +String.format(
				"%,.2f", avgNetPay)+ "]";
	}
}