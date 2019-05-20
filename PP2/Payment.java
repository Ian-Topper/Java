package PP2;


import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class Payment {

	public static Validation validating;
	public static HashCode hashing;
	public static Customer[] customers;
	
	public static void main(String[] args) {
		
		// the main entry method of the program that will get data from user and
		// perform the business logic
			String fNameInput = null;
			hashing = new HashCode();
			validating = new  Validation();
			long inputCard = 0;	
			Boolean exit8 = false;
			////initialize variable
			String totalCustomers = "";
			boolean exit = false;
			int n = 0;
			///JOption loop till valid input recieved
			while(exit==false) {
				////green color box
				JDialog.setDefaultLookAndFeelDecorated(true);
				////Joption takes input
				totalCustomers =JOptionPane.showInputDialog(
					"Please enter number of customers");
				//cancel button works
				 if (totalCustomers == null){
					System.exit(0);
				 }//end cancel button check	

			try{
				n = Integer.parseInt(totalCustomers);
				/////check that integer is greater than 0 and exits loop if so.
				if (n>0) {
				exit = true;
				}	
			}	
			///////catch and display message if exception was found
			catch(Exception ex){JOptionPane.showMessageDialog(null,
					"Invalid entry, Please enter a positive whole number");
			}
			}///end while
		
			customers = new Customer[n];
			
			for ( int z=0;z<n;z++){	
				 exit8 = false;
	         // must hold the number of customers based
			 //on the user input
			n = Integer.parseInt(totalCustomers);

			 /////get card number input parse Long
			while(exit8 == false) { 
			JDialog.setDefaultLookAndFeelDecorated(true);
				String inputCardString =JOptionPane.showInputDialog(
					"Please enter card number");
				//cancel button works
				 if (totalCustomers == null){
					System.exit(0);
				 }//end cancel button check
				 try {
				inputCard = Long.parseLong(inputCardString);
				}
				  catch (Exception eM) 
				 {JOptionPane.showMessageDialog(null, "Card Declined");
				 }
	
			if (inputCard>1) {
			Boolean checkBool = isValidCard(inputCardString);
				if (checkBool == true) {exit8 = true;
				}		
				if (checkBool == true) {JOptionPane.
					showMessageDialog(null, "Card Accepted");
				}
				 } 
				else JOptionPane.showMessageDialog(null, "Card Declined");				
			}

			// get card expiration input validation
			String inputCardExp = null;
			SimpleDateFormat dateFormat = new SimpleDateFormat ("MM-yy");
			dateFormat.setLenient(false);

			do {
				try {
					JDialog.setDefaultLookAndFeelDecorated(true);
					 inputCardExp =JOptionPane.showInputDialog("Please "
					 		+ "enter card expiration  MM-yy");
					//cancel button works
					 if (inputCardExp == null){
						System.exit(0);
					 }//end cancel button check
					dateFormat.parse(inputCardExp.trim());
					break;  //loop break when receive valid date for example 03-18

				} catch (ParseException pe) {
					JOptionPane.showMessageDialog(null, "Invalid input:ex (MM-yy) " + pe);
				}
			}
			while (true); 				
				////Create a credit card
				CreditCard cardNew = new CreditCard(inputCard, inputCardExp);
			
				/////// get customer id input
			// initialize variables
			String idInputString = null;
			boolean exit9 = false;
			int idInput = 0;

			// JOptionPane loop until valid input received
			do { 

			try {
			//green color box
				JDialog.setDefaultLookAndFeelDecorated(true);

			// JOptionPane takes input
				idInputString = JOptionPane.showInputDialog("Please enter an "
						+ "ID number or Zero to Stop entering inputs and exit " 
						+ "\n" + "Please enter a minimum two digit positive whole "
						+ "number greater than 0" + "\n");

			//cancel button works
			if (idInputString == null){
			System.exit(0);
			}

			idInput = Integer.parseInt(idInputString);
			if (idInput == 0) {
				int	numClick =JOptionPane.showConfirmDialog(null,
				"Would you like to exit the program");
					if (numClick==0 )System.exit(0);
				}
			}
			// catch and display message if exception was found 
			catch(Exception ex){
				JOptionPane.showMessageDialog(null,"Invalid entry, Please"
					+ " enter a two digit positive whole number greater than 0");
			} 
			// check that integer is greater than 0 and exits loop if so.
			if (idInput > 1) {
				exit9 = true;
			}
			else JOptionPane.showMessageDialog(null,"Invalid entry,"
					+ " Please enter a two digit positive whole number greater than 0");
			} while (exit9 == false); 

				for (int z1 = 0; z1 < idInput; z1++){ 
					exit9 = false; 
				} // end for loop

				 /////initialize variables
				boolean exit2 = false;
				int letter = 0;

				//////Joption Loop
				while(exit2==false) {
					try {
						/////green joption
					JDialog.setDefaultLookAndFeelDecorated(true);
					////////enter string to joption 
					fNameInput =JOptionPane.showInputDialog(
						"Please enter first name");
					////////Cancel button works
					 if (fNameInput == null){
							System.exit(0);
						 }//end cancel button check
						
					for (int y=0;y<fNameInput.length();y++){
						if (Character.isLetter(fNameInput.charAt(y))){letter+=1;
						  }
						}
					}///end try
						////end try if exception display message
						catch(Exception ex){JOptionPane.showMessageDialog(null,
							"Invalid entry, Please enter a name that contains "
							+ "two letters minimum");
						}//End for loop
							
						///Check for 2 letters if two or more letters were found exit = true and loop ends
						///onto next button
					if (letter>0){exit2 = true;
					}
					else JOptionPane.showMessageDialog(null,
								"Invalid entry, Please enter a name that contains two letters minimum"); 	 
					}////end while
				 					
				// get LAST name input
				// initialize variables
				boolean again = false;
				int letterNew = 0;
			String lNameInput="";
			// JOptionPane Loop
			do{
				try{
					// green JOptionPane
					JDialog.setDefaultLookAndFeelDecorated(true);
					// enter string to JOptionPane 
					lNameInput =JOptionPane.showInputDialog("Please "
							+ "enter LAST name");
					// Cancel button works
					if (lNameInput == null)
						{
						System.exit(0);
						}//end cancel button check
					// check for number of letters and adds them up in 
					///"letter" this is more 
					// validation than is needed but I like it
					for (int y = 0; y < lNameInput.length(); y++){
						if (Character.isLetter(lNameInput.charAt(y))){
							letterNew+=1;
						} 
					}//End for loop
					}// end try if exception display message
						catch(Exception ex)
							{JOptionPane.showMessageDialog(null,"Invalid entry "
								+ ", Please enter a Last name that contains two "
								+ "letters minimum");
							}
						// Check for 2 letters if two or more letters were found 
						//exit = true and loop ends
						// onto next button
						if (letterNew > 1) {
								again = true;
							}
						else JOptionPane.showMessageDialog(null,"Invalid entry ,"
							+ " Please enter a Last name that contains two "
							+ "letters minimum");

						} while(again==false);
				/////// get customer id input
					double totalAmount= 0;
					double amountInput = 0;
					while (amountInput<=0) {
					JDialog.setDefaultLookAndFeelDecorated(true);
				String amountInputString =JOptionPane.showInputDialog(
					"Please enter amount");
				// Cancel button works
				if (amountInputString == null){
						System.exit(0);
					}//end cancel button check
				try {
			 amountInput = Double.parseDouble(amountInputString);
				}
				catch (Exception ol){
					JOptionPane.showMessageDialog(null,"Invalid entry, "
						+ "Please enter a two digit positive whole number"
						+ " greater than 0");
					}
				if (amountInput>1) {
			boolean q = false;
		double discount = 1;
			while (q==false) {			
			 
				discount =(Math.random());
			if ( .05 <=  discount && .2>= discount ) {q = true;
			}		
			}
			
			 totalAmount = amountInput - (amountInput * discount) ;
		double percent = discount*100;
			 JDialog.setDefaultLookAndFeelDecorated(true);
			 JOptionPane.
						showMessageDialog(null,
					"Amount entered: " + String.format("%.2f", amountInput)	
					+"\n"+"Random discount "
					+ "percent:" + String.format("%.2f", percent) + "\n" 
					+ "Total after discount: "+ String.format("%.2f", totalAmount));
				}
					}
			///Create a customer
		Customer customerNew = new Customer(fNameInput, lNameInput, idInput,
				totalAmount, cardNew);
			///add customer to array
		//Customer[] customers = 
				addCustomer(customerNew);
			}////end inputs for loop
		
			
			try {
				writeToFile();
			} 
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			displayStat();
			
	}////end main method
	
	
	// this will check whether a card is valid
	public static Boolean isValidCard(String number){
	
		Boolean checkBool = validating.aValidNumber(number);
		return checkBool;	
	}// end of the isValidCard method

	
	// creates a hash code for the credit card number to be stored in file
    public static String createHashCode(String number){
    	
    	String hashStash = hashing.getHashCode(number);
		return hashStash;
	}// end of the createHashCode method

     // it adds a new customer to the array of customers once the 
     //payment was successful
 	 
    
    public static void addCustomer(Customer customer){

 
 			customers[Customer.getNoOfCustomers()-1] = customer;			  
 	 } // end of the addCustomer method

	// it displays the payments AVG, MAX payment, and MIN payment,
	// only for accepted payments with valid cards
	public static void displayStat()
	{int i = 0;
		////////max amount
		  double max = customers[0].getAmount();
		  for ( i = 0; i < customers.length; i++) {
				if (customers[i].getAmount() > max)		
				{max = customers[i].getAmount();
				}
			}			
	////////////min amount
		  double min = customers[0].getAmount();
		  for ( i = 0; i < customers.length; i++) {	  
				if (customers[i].getAmount() < min) 		
				{min = customers[i].getAmount();}
		  }
	/////////Average amount
		  double average = 0; 
		  String output = "Customers:";
     		double sum = 0;///change to 0
     		 String hashStamp = "";
     	
     		 for(int e=0; e<(customers.length); e++){
     			double scores = customers[e].getAmount(); 
     			sum = sum + scores;
     		}  ///end for loop
     			//calculate average value
     		average = sum / Customer.getNoOfCustomers();
     
     	   for(int z=0; z<(customers.length); z++) {
     			hashStamp = createHashCode(Long.toString(
     					customers[z].getCard().getNumber()));
         		
     	      output = output + "\n" + (customers[z].toString()) 
     	    		  + hashStamp + "]" ;     	      
     	   }

			JOptionPane.showMessageDialog(null,
     			"Purchase Stats" +"\n"+ "Amount Average:" 
			+String.format("%.2f", average) +"\n" +"Lowest Amount:"
     		+ String.format("%.2f", min) +"\n" +"Highest Amount:" 
			+ String.format("%.2f", max) +"\n"  + output);
	
	}// end of the displayStat method

	// write data to file, the credit card number should be encrypted
	// using one-way hash method in the Hashing class
    
	
	public static void writeToFile() throws FileNotFoundException{
    	String fileName = "Customer"  + ".txt";
    	java.io.File file = new java.io.File(fileName);
        // Create a file
        java.io.PrintWriter output = new java.io.PrintWriter(file);
        // Write formatted output to the file
        for(int z=0; z<(Customer.getNoOfCustomers()); z++) {
        	String hashStamp = createHashCode(Long.toString(
        			customers[z].getCard().getNumber()));
        				output.print(customers[z]);
        				output.println( hashStamp + "]" );
        }///end for
        	// Close the file
        	output.close();
    } // end of the writeToFile method



	

}/////end  class
