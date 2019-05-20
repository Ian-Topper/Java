package PP03;

import java.text.DecimalFormat;

public class PayRecord {
	
	private int rID;
    private Employee employee;
    private PayPeriod payPeriod;
    private TaxIncome payTax;
    
    private double payHours;
    private double payRate;
    
    private double montlyIncome;
    private int numMonths;
    public static int numberOfRecords=0;
       
    
    public static final int REG_HOURS = 40;
    public static final double OT_RATE = 1.25;
    
//////////////  pay record constructor for hourly employee  ///////////////////////
    
    public PayRecord(int id, Employee e, PayPeriod period, double hours, double rate){
    	
    	this.rID = id;
    	this.employee = e;
    	this.payPeriod = period;
    	this.payHours = hours;
    	this.payRate = rate;
    	this.montlyIncome = 0;
    	this.numMonths = 0;
    	this.payTax = new TaxIncome();
    	numberOfRecords++;
    }
    
//////// pay record constructor for full time employee /////////////////////////
    
    public PayRecord(int id, Employee e, PayPeriod period, double mIncome, int mNum){
 	
 	this.rID = id;
 	this.employee = e;
 	this.payPeriod = period;
 	this.payHours = 0;
 	this.payRate = 0;
 	this.montlyIncome = mIncome;
 	this.numMonths = mNum;
 	this.payTax = new TaxIncome();
 	numberOfRecords++;
 }

///////////////////// 1- add setters and getters methods  //////////////
    
  public static int getNumberOfRecords() {
		return numberOfRecords;
	}

	
    public int getID() {
    		return this.rID;
    }
    
    public void setID(int id) {
    		this.rID = id;
    }
    
    public Employee getEmployee() {
    		return this.employee;
    }
    
    public void setEmployee(Employee emp) {
    		this.employee = emp;
    }
    
    public PayPeriod getPayPeriod() {
    		return this.payPeriod;
    }
    
    public void setPayPeriod(PayPeriod pr) {
    		this.payPeriod = pr;
    }
    
    public double getPayHours() {
    		return this.payHours;
    }
    
    public void setPayHours(double payh) {
    		this.payHours = payh;
    }
    
    public double getPayRate() {
    		return this.payRate;
    }
    
    public void setPayRate(double payr) {
    		this.payRate = payr;
    }
    
    public double getMonthlyIncome() {
    		return this.montlyIncome;
    }
    
    public void setMonthlyIncome(double mi) {
    		this.montlyIncome = mi;
    }
    
    public int getNumMonths() {
    		return this.numMonths;
    }
    
    public void setNumMonths(int nm) {
    		this.numMonths = nm;
    }
    
    public TaxIncome getTaxIncome() {
    		return this.payTax;
    }
    
    public void setTaxIncome(TaxIncome ti) {
    		this.payTax = ti;
    		
    }
    
////////////////////// To String  ///////////////////////////////
    
    @Override
	public String toString() {
		String r = "";
		if (employee.empStatus() == Status.FullTime) {
			r = montlyIncome + "<m>, " + numMonths + "<n>, ";
		} else {
			r = payHours + "<h>, " + payRate + "<r>, ";
		}
		
        DecimalFormat newFormat = new DecimalFormat("$#,##0.00");  // Format Output
        
		return "Pay Record [Record ID: " + rID + ", " + employee +
		", " + r + payPeriod + ", Gross Pay: " + newFormat.format(grossPay()) 
		+ ", Income Tax: " + newFormat.format(payTax.compIncomeTax(grossPay())) + ", "
		+ "Net Pay: " + newFormat.format(netPay()) ;
}
    
/////////// 3- complete the code in the following methods: grossPay() and netPay()  /////////    
    // complete the code to compute the gross pay for the employee based on the employee status
    
	public double grossPay() {
		double grossPay = 0;
		if (employee.empStatus() == Status.FullTime) {
			grossPay = montlyIncome * numMonths;
		}
		else {
			grossPay = payHours * payRate;
			if (REG_HOURS < payHours) {
				Double ot = payHours - REG_HOURS;
				grossPay = grossPay + (ot * OT_RATE);
			}
		}
		return grossPay;
	}
    
/////////// complete the code in this method to compute 
	///////////the net pay of the employee after taxes (state and federal) ////////////
	
     public double netPay() {
    	 	return grossPay() - this.payTax.compIncomeTax(grossPay());
  }
}
