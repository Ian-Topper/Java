package PP03;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;


import PP03.PayRoll;

public class UserGUI extends JPanel {

	  // Employee
	  private JLabel label1;
	  private JLabel label2;
	  private JLabel label3;
	  private JLabel label4;
	  private JLabel label5;
	  private JTextField empID;
	  private JTextField fName;
	  private JTextField lName;
	  private JRadioButton fulltime;
	  private JRadioButton hourly;
	  private JButton addEmpButton;
	  
	  // Address
	  private JLabel label6;
	  private JLabel label7;
	  private JLabel label8;
	  private JLabel label9;
	  private JLabel label10;
	  private JLabel label11;
	  private JTextField street;
	  private JTextField aptNo;
	  private JTextField city;
	  private String[] listState = { "Alabama", "Alaska", "Arizona", "Arkansas",
			  						"California", "Colorado", "Connecticut", "Delaware",
			  						"District of Columbia", "Florida", "Georgia", 
			  						"Hawaii", "Idaho", "Illinois", "Indiana", "Iowa",
			  						"Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", 
			  						"Massachusetts", "Michigan", "Minnesota", "Mississippi", 
			  						"Missouri", "Montana", "Nebraska", "Nevada", 
			  						"New Hampshire", "New Jersey", "New Mexico", "New York",
			  						"North Carolina", "North Dakota", "Ohio", "Oklahoma", 
			  						"Oregon", "Pennsylvania", "Rhode Island", "South Carolina",
			  						"South Dakota", "Tennessee", "Texas", "Utah", "Vermont", 
			  						"Virginia", "Washington", "West Virginia", "Wisconsin", 
			  						"Wyoming" };
	  private JComboBox state;
	  private JTextField zipCode;
	  
	  
	  // Pay Period
	  private JLabel label12;
	  private JLabel label13;
	  private JLabel label14;
	  private JLabel label15;
	  private JTextField ppID;
	  private JTextField ppStartDate;
	  private JTextField ppEndDate;
	  
	  // Pay Record
	  private JLabel label16;
	  private JLabel label17;
	  private JLabel label18;
	  private JLabel label19;
	  private JLabel label20;
	  private JLabel label21;
	  private JTextField prID;
	  private JTextField mIncome;
	  private JTextField nMonths;
	  private JTextField pHours;
	  private JTextField pRate;
	  private JButton addPayRecordButton;
	  
	  // TextArea
	  private JLabel label22;
	  private JButton CloseButton;
	  static JTextArea textArea;
	  private JScrollPane jp;
	  private PayRoll payRoll;
	  private String fileName = "PayRoll.txt";
	  
	  private Employee emp;

///////////////////////////    User GUI  //////////////////////////////////////////	  
	  
	  public UserGUI() throws FileNotFoundException, IOException, ParseException {

         // prompt the user to input the number of pay records
		
		 int n = 0;
			boolean exit = false;
			
			//Input number of audiences.
			while(exit==false) {
				////green color box
				JDialog.setDefaultLookAndFeelDecorated(true);
				////Joption takes input
				 String input =JOptionPane.showInputDialog(
						 "Please input the number of pay records to be manually entered: ");
				//cancel button works
				 if (input == null){
					System.exit(0);
				 }//end cancel button check	

			try{
				n = Integer.parseInt(input);
				/////check that integer is greater than 0 and exits loop if so.
				if (n>0) {
				exit = true;
				}
				else JOptionPane.showMessageDialog(null,
						"Invalid entry, Please enter a positive whole number");
				
			}	
			///////catch and display message if exception was found
			catch(Exception ex){JOptionPane.showMessageDialog(null,
					"Invalid entry, Please enter a positive whole number");
			}
			}///end while
	int l=n + Person.numberOfPeopleInFile;
		 payRoll = new PayRoll(fileName,n);
		 
	    initGUI();
	    doTheLayout();
	    
////////////////////  Read from File  ////////////////////////////////////	    
	    
	    
	    //String initialData =
	    		payRoll.readFromFile();  
	    
		//textArea.setText(initialData);

///////////////////////// Action Listeners //////////////////////////////////	    
	    
	    CloseButton.addActionListener( new java.awt.event.ActionListener() {
	        public void actionPerformed(ActionEvent e){
	            close();
	            }
	    });
	    
	    fulltime.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			mIncome.setEditable(true);
	    			nMonths.setEditable(true);
	    			pHours.setEditable(false);
	    			pHours.setText("");
	    			pRate.setEditable(false);
	    			pRate.setText("");
	    		}
	    });
	    
	    hourly.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				mIncome.setEditable(false);
    				mIncome.setText("");
    				nMonths.setEditable(false);
    				nMonths.setText("");
    				pHours.setEditable(true);
    				pRate.setEditable(true);
    			}
	    });
	    
	    addEmpButton.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			
	    			
	    			if (PayRecord.getNumberOfRecords() < l + Person.numberOfPeopleInFile ) {
	    				
/////////////////////////////////  ID VALIDATION  //////////////////////////////////////////	
	    				
	    				int id = 0;
						boolean exit = false;
						
						while(exit==false) {
							empID.requestFocus();
							////green color box
							//cancel button works
							addPayRecordButton.setEnabled(false);
						try{
							id =	Integer.parseInt(empID.getText());;
							/////check that integer is greater than 0 and exits loop if so.
							if (id>0) {
							exit = true;
							}	
							else {
								JOptionPane.showMessageDialog(null,
										"Invalid entry, Please enter a positive ID number");
								empID.setText("");
								return;	
							}
						}	
						///////catch and display message if exception was found
						catch(Exception ex){JOptionPane.showMessageDialog(null,
								"Invalid entry, Please enter a positive ID number");
						empID.setText("");
						return;
						}
						}///end while
		
	//////////////////////  FIRST NAME VALIDATION  /////////////////////////
				
						int letter = 0;
						String firstName = "";
						exit = false;
						while (exit == false) {
							letter = 0;
							fName.requestFocus();
							try { 	
							firstName = fName.getText();
								
								
							for (int y=0;y<firstName.length();y++){
								if (Character.isLetter(firstName.charAt(y))){letter+=1;
								  }
								}
							}///end try
								////end try if exception display message
								catch(Exception ex){JOptionPane.showMessageDialog(null,"Invalid entry, Please enter a first name that "
										+ "contains two letters minimum");
								fName.setText("");
								return;
								}//End for loop
								 
							   ////exit = true and loop ends
								///onto next button
							if (letter>1){exit = true;
							}
							else {JOptionPane.showMessageDialog(null,"Invalid entry, Please enter a first name that "
										+ "contains two letters minimum");
							fName.setText("");
							
									return;
							}
							}/////end while
		
	//////////////////////  Last NAME VALIDATION  //////////////////////////////////////////////////	
						
						String lastName = "";
						exit = false;
						while (exit == false) {
							letter = 0;
							lName.requestFocus();
							try { 	
							lastName = lName.getText();	
								
								
							for (int y=0;y<lastName.length();y++){
								if (Character.isLetter(lastName.charAt(y))){letter+=1;
								  }
								}
							}///end try
								////end try if exception display message
								catch(Exception ex){JOptionPane.showMessageDialog(null,"Invalid "
										+ "entry, Please enter a last name that "
										+ "contains two letters minimum");
								lName.setText("");
								return;
								}//End for loop
								  
							   ////exit = true and loop ends
								///onto next button
							if (letter>1){exit = true;
							}
							else {JOptionPane.showMessageDialog(null,"Invalid entry, Please enter a last name that "
										+ "contains two letters minimum");
							lName.setText("");
							
									return;
							}
							}/////end while
						
/////////////////////  STREET VALIDATION  ////////////////////////////////////////////////////////////
			
						String streetSt = "";
						exit = false;
						while (exit == false) {
							letter = 0;
							street.requestFocus();
							try { 	
							streetSt = street.getText();	
								
								
							for (int y=0;y<streetSt.length();y++){
								if (Character.isLetter(streetSt.charAt(y))){letter+=1;
								  }
								}
							}///end try
								////end try if exception display message
								catch(Exception ex){JOptionPane.showMessageDialog(null,"Invalid "
										+ "entry, Please enter a street name that "
										+ "contains two letters minimum");
								street.setText("");
								return;
								}//End for loop
							
							   ////exit = true and loop ends
								///onto next button
							if (letter>1){exit = true;
							}
							else {JOptionPane.showMessageDialog(null,"Invalid entry, Please"
									+ " enter a street name that "
										+ "contains two letters minimum");
							street.setText("");
							
									return;
							}
							}/////end while
						
////////////////////////////  HOUSE NUMBER VALIDATION  ///////////////////////////////////////////			
						String aptNum= "";
						exit = false;
						//////////ID
						while(exit==false) {
							letter = 0;
							aptNo.requestFocus();
								letter = 0;
							try { 	
								aptNum = aptNo.getText();	
							
								}///end try
									////end try if exception display message
									catch(Exception ex){JOptionPane.showMessageDialog(null,"Invalid "
											+ "entry, Please enter a House/Apt number");
									aptNo.setText("");
									return;
									}//End catch
							for (int y=0;y<aptNum.length();y++){
								if (Character.isDigit(aptNum.charAt(y))){letter+=1;
								  }
								}
								if (aptNum.equals("")){JOptionPane.showMessageDialog(null,"Invalid entry, Please"
										+ " enter a House/Apt number");
								aptNo.setText("");
								return;
								}
								else if (letter>0)
									exit = true;
								if (letter<=0) {
									aptNo.setText("");
									JOptionPane.showMessageDialog(null,"Invalid entry, Please"
											+ " enter a House/Apt number "+"\n"+"that contains at least one digit");
									return;}
								}/////end while
						
////////////////////////////  CITY VALIDATION  ///////////////////////////////////////////////////////	
						
						String cityV = "";
						exit = false;
						while (exit == false) {
							letter = 0;
							city.requestFocus();
							try { 	
							cityV = city.getText();	
								
								
							for (int y=0;y<cityV.length();y++){
								if (Character.isLetter(cityV.charAt(y))){letter+=1;
								  }
								}
							}///end try
								////end try if exception display message
								catch(Exception ex){JOptionPane.showMessageDialog(null,"Invalid "
										+ "entry, Please enter a city name that "
										+ "contains two letters minimum");
								city.setText("");
								return;
								}//End for loop
								 
							   ////exit = true and loop ends
								///onto next button
							if (letter>1){exit = true;
							}
							else {JOptionPane.showMessageDialog(null,"Invalid entry, Please enter a city name that "
										+ "contains two letters minimum");
							city.setText("");
							
									return;
							}
							}/////end while
												
	////////////////////////////  ZIP CODE VALIDATION  //////////////////////////////////////////////		
						
	    				 int zc = 0;
	    				 exit = false;

						while(exit==false) {
							zipCode.requestFocus();
							////green color box
							//cancel button works

						try{
							zc =	Integer.parseInt(zipCode.getText());
							/////check that integer is greater than 0 and exits loop if so.
							if (zc>9999 && zc<100000) {
							exit = true;
							}	
							else {
								JOptionPane.showMessageDialog(null,
										"Invalid entry, Please enter a positive 5 digit zip number");
								zipCode.setText("");
								return;	
							}
						}	
						///////catch and display message if exception was found
						catch(Exception ex){JOptionPane.showMessageDialog(null,
								"Invalid entry, Please enter a positive 5 digit zip code number");
						zipCode.setText("");
						return;
						}
						}///end while
						
//////////////////////////////////// Address /////////////////////////////////////////////////////////////////////						

	    				Address addr = new Address(streetSt, aptNum, cityV, state.getSelectedItem().toString(), zc);
	    				Status stat = Status.FullTime;
	    				if (hourly.isSelected())
	    					stat = Status.Hourly;
	    				emp = payRoll.createEmployee(id, lastName, firstName, stat, addr);
	    				JOptionPane.showMessageDialog(null, "Successfully added a new employee" + emp.toString());		
	    				////Clear entries and disable textfields and add button.
	    				 
	    				  zipCode.setEnabled(false);
	    				  empID.setEnabled(false);
	    				   fName.setEnabled(false);
	    				   lName.setEnabled(false);
	    				   street.setEnabled(false);
	    				  aptNo.setEnabled(false);
	    				  city.setEnabled(false);
	    				  addEmpButton.setEnabled(false);
	    				  fulltime.setEnabled(false);
	    				  hourly.setEnabled(false);
	    				 /////
	    				  addPayRecordButton.setEnabled(true);
	    				  ppID.requestFocus();
	    			}///end big then
	    		else {textArea.append("Array is Full" + "\n");
	    		zipCode.setEnabled(false);
				  empID.setEnabled(false);
				   fName.setEnabled(false);
				   lName.setEnabled(false);
				   street.setEnabled(false);
				  aptNo.setEnabled(false);
				  city.setEnabled(false);
				  addEmpButton.setEnabled(false);
				  fulltime.setEnabled(false);
				  hourly.setEnabled(false);
	    			addPayRecordButton.setEnabled(true);
  				  prID.setEnabled(false);
  				   mIncome.setEnabled(false);;
  				   nMonths.setEnabled(false);;
  				  pHours.setEnabled(false);;
  				 pRate.setEnabled(false);;
  				 ppID.setEnabled(false);;
  				 ppStartDate.setEnabled(false);;
  				 ppEndDate.setEnabled(false);;
	    			}
	    			}
	    		}
	    
	    
	    );
	    
	    addPayRecordButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			if (PayRecord.getNumberOfRecords() < l + Person.numberOfPeopleInFile ) {
    				
    			Date endDate = null;
    			Date startDate = null;
    			double monthlyIncome = 0;
				int numMonths = 0;
				double payHours = 0;
				double payRate = 0;
				
////////////////////////////  PERIOD ID VALIDATION  ////////////////////////////////////	    				 

    				int payPeriodID = 0;
					boolean exit = false;
					//////////ID
					while(exit==false) {
						ppID.requestFocus();
						////green color box
						//cancel button works

					try{
						payPeriodID =	Integer.parseInt(ppID.getText());
						/////check that integer is greater than 0 and exits loop if so.
						if (payPeriodID>0) {
						exit = true;
						}	
						else {
							JOptionPane.showMessageDialog(null,
									"Invalid entry, Please enter a positive ID number");
							ppID.setText("");
							return;	
						}
					}	
					///////catch and display message if exception was found
					catch(Exception ex){JOptionPane.showMessageDialog(null,
							"Invalid entry, Please enter a positive ID number");
					ppID.setText("");
					return;
					}
					}///end while
    				
//////////////////////////// START DATE VALIDATION  ///////////////////    			
					
						exit = false;
						//////////ID
						while(exit==false) {
							ppStartDate.requestFocus();
					try {
						startDate = new SimpleDateFormat("dd/MM/yyyy")
								.parse(ppStartDate.getText());
					} 
					catch (ParseException e1){JOptionPane.showMessageDialog(null,
							"Invalid entry, Please enter date in this format dd/MM/yyyy");
					ppStartDate.setText("");
					return;
					}
					exit = true;
						
					}
						
////////////////////////////  END DATE VALIDATION  ////////////////////////////////////////
						
						exit = false;
						PayPeriod pr = null;
						while(exit==false) {
							ppEndDate.requestFocus();
					try {
						endDate = new SimpleDateFormat("dd/MM/yyyy")
								.parse(ppEndDate.getText());
					} 
					catch (ParseException e1){JOptionPane.showMessageDialog(null,
							"Invalid entry, Please enter date in this format dd/MM/yyyy");
					ppEndDate.setText("");
					return;
					}
    				
    				if (startDate.compareTo(endDate) <= 0) {
    						exit = true;
    					 
    				pr = new PayPeriod(startDate, endDate);
    				pr.setID(payPeriodID);
    					}
    				else {
					 JOptionPane.showMessageDialog(null,
								"Invalid entry negative time employed based on dates, Please enter valid end and start dates");
						ppEndDate.setText("");	
						return;
						}	
						
    			
						}
    										
////////////////////////////  RECORD ID VALIDATION  ////////////////////////////////////////

    				 int payRecordID = 0;
						 exit = false;
						//////////ID
						while(exit==false) {
							prID.requestFocus();
							////green color box
							//cancel button works

						try{
							payRecordID =	Integer.parseInt(prID.getText());
							/////check that integer is greater than 0 and exits loop if so.
							if (payRecordID>0) {
							exit = true;
							}	
							else {
								JOptionPane.showMessageDialog(null,
										"Invalid entry, Please enter a positive ID number");
								prID.setText("");
								return;	
							}
						}	
						///////catch and display message if exception was found
						catch(Exception ex){JOptionPane.showMessageDialog(null,
								"Invalid entry, Please enter a positive ID number");
						prID.setText("");
						return;
						}
						}///end while

////////////////////////////  MONTHLY INCOME VALIDATION  ///////////////////
    			
						if (hourly.isSelected() == false) {
    					 monthlyIncome = 0;
						 exit = false;
						//////////ID
						while(exit==false) {
							mIncome.requestFocus();
							////green color box
							//cancel button works

						try{
							monthlyIncome =	Double.parseDouble(mIncome.getText());
							/////check that integer is greater than 0 and exits loop if so.
							if (monthlyIncome>0) {
							exit = true;
							}	
							else {
								JOptionPane.showMessageDialog(null,
										"Invalid entry, Please enter a monthly income ex. 100.50");
								mIncome.setText("");
								return;	
							}
						}	
						///////catch and display message if exception was found
						catch(Exception ex){JOptionPane.showMessageDialog(null,
								"Invalid entry, Please enter a monthly income ex. 100.50");
						mIncome.setText("");
						return;
						}
						}///end while
    					
////////////////////////////  NUMBER OF MONTHS VALIDATION  ///////////////////////////////////    					 

    					 numMonths = 0;
						 exit = false;
						 long days =0;
						//////////ID
						while(exit==false) {
							nMonths.requestFocus();

						try{
							long time = Math.abs(startDate.getTime() - endDate.getTime());
							long daysPast = time / (24 * 60 * 60 * 1000);
							numMonths = Integer.parseInt(nMonths.getText());
						    days = ((numMonths*(365))/12);
							/////check that integer is greater than 0 and exits loop if so.
						    if (days >=0 && days<=30) {
						    	days =30;
						    	daysPast = 30;
						    }
							if (numMonths>=0 && daysPast >= days){
							exit = true;
							}	
							else {
								JOptionPane.showMessageDialog(null,
										"Invalid entry, Please enter a positive number of months worked"
										+ "\n"+"number cannot be larger than time span of employement");
								nMonths.setText("");
								return;	
							}
						}	
						///////catch and display message if exception was found
						catch(Exception ex){JOptionPane.showMessageDialog(null,
								"Invalid entry, Please enter a positive number of months worked");
						nMonths.setText("");
						return;
						}
						}///end while
						
						}////end then
						
////////////////////////////  HOURS VALIDATION  ///////////////////////////////////////////
						
    				else {

    					 payHours = 0;
						 exit = false;
						//////////ID
						while(exit==false) {
							pHours.requestFocus();
							////green color box
							//cancel button works

						try{
							payHours =	 Double.parseDouble(pHours.getText());
							/////check that integer is greater than 0 and exits loop if so.
							double time = Math.abs(startDate.getTime() - endDate.getTime());
							double daysPast = time / (24 * 60 * 60 * 1000);
							double payDays = payHours/24;
							if ((daysPast + 1) > payDays) {
							exit = true;
							}	
							else {
								JOptionPane.showMessageDialog(null,
										"Invalid entry cannot work more than 24 hours in a day" +"\n"+", Please enter number of hours ex. 3.5");
								pHours.setText("");
								return;	
							}
						}	
						///////catch and display message if exception was found
						catch(Exception ex){JOptionPane.showMessageDialog(null,
								"Invalid entry, Please enter number of hours ex. 3.5");
						pHours.setText("");
						return;
						}
						}///end while
						
////////////////////////////  PAY RATE VALIDATION  ///////////////////////////////////////
    					 	    				
    					 payRate = 0;
						 exit = false;
						//////////ID
						while(exit==false) {
							pRate.requestFocus();

						try{
							payRate = Double.parseDouble(pRate.getText());
							/////check that integer is greater than 0 and exits loop if so.
							if (payRate>0) {
							exit = true;
							}	
							else {
								JOptionPane.showMessageDialog(null,
										"Invalid entry, Please enter hourly rate ex 10.25");
								pRate.setText("");
								return;	
							}
						}	
						///////catch and display message if exception was found
						catch(Exception ex){JOptionPane.showMessageDialog(null,
								"Invalid entry, Please enter hourly rate ex 10.25");
						pRate.setText("");
						return;
						}
						}///end while
    				}	    				
    				
/////////////////////////////  END VALIDATION OF ENTRIES  //////////////////////////////////////////////////////
						
						//////call payroll methods
	    				payRoll.createPayRecord(payPeriodID, emp, pr, monthlyIncome, numMonths, payHours, payRate);
	    				payRoll.avgNetPay(); 
	    					 try {
							payRoll.writeToFile();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	    				payRoll.displayPayRecord();
	    			
	    				JOptionPane.showMessageDialog(null, "Added a new pay record.");
	    				/////////enable addEmp features with clear textfields 
	    				empID.setEnabled(true);
	    				   fName.setEnabled(true);
	    				   lName.setEnabled(true);
	    				   street.setEnabled(true);
	    				  aptNo.setEnabled(true);
	    				  city.setEnabled(true);
	    				  zipCode.setEnabled(true);
	    				  addEmpButton.setEnabled(true);
	    				  empID.setText("");
	    				   fName.setText("");
	    				   lName.setText("");
	    				   street.setText("");
	    				  aptNo.setText("");
	    				  city.setText("");
	    				  zipCode.setText("");
	    				  empID.requestFocus();
	    				  fulltime.setEnabled(true);
	    				  hourly.setEnabled(true);
	    				  
	    				  /////////Disable jbtnPayRecord and clear fields.
	    				  
	    				  addPayRecordButton.setEnabled(false);
	    				  prID.setText("");
	    				   mIncome.setText("");
	    				   nMonths.setText("");
	    				  pHours.setText("");
	    				 pRate.setText("");
	    				 ppID.setText("");
	    				 ppStartDate.setText("");
	    				 ppEndDate.setText("");
	    				
	    				
	    			}////end then	
	    			else textArea.append("Record Array is full"+ "\n" + "Please select (Exit) or (Alt+x) to close program" );
	    			addPayRecordButton.setEnabled(false);
	    		}
	    });

	  } // end of constructor
	  
///////////////////////////////   Initialize GUI   /////////////////////////////////////////////	  

	  private void initGUI(){

		  // Employee
		  label1 = new JLabel("Employee:");
		  label1.setForeground(Color.BLUE);
	      label2 = new JLabel("ID:");
	      label3 = new JLabel("First Name:");
	      label4 = new JLabel("Last Name:");
	      empID = new JTextField(3);
	      fName = new JTextField(8);
		  lName = new JTextField(8);
	      label5 = new JLabel("Employee Status:");
		  fulltime = new JRadioButton("Full Time");
		  hourly = new JRadioButton("Hourly");
	      ButtonGroup bGroup = new ButtonGroup();
	      bGroup.add(fulltime);
		  bGroup.add(hourly);
		  fulltime.setSelected(true);
		  addEmpButton = new JButton("Add Employee");
		  addEmpButton.setMnemonic(KeyEvent.VK_E);
	      // Address
	      label6 = new JLabel("Employee Address:");
	      label7 = new JLabel("Street:");
	      label8 = new JLabel("H/Apt Number:");
	      label9 = new JLabel("City");
	      label10 = new JLabel("State:");
	      label11 = new JLabel("Zip Code:");
	      street = new JTextField(8);
	      aptNo = new JTextField(4);
	      city = new JTextField(4);
	      state = new JComboBox(listState);
	      zipCode = new JTextField(4);
	      
	      // Pay Period
	      label12 = new JLabel("Pay Period:");
	      label12.setForeground(Color.BLUE);
	      label13 = new JLabel("ID:");
	      label14 = new JLabel("Start Date (ex. dd/MM/yyyy):");
	      label15 = new JLabel("End Date (ex. dd/MM/yyyy):");
	      ppID = new JTextField(3);
	      ppStartDate = new JTextField(6);
	      ppEndDate = new JTextField(6);
	      
	      // Pay Record
	      label16 = new JLabel("Pay Record:");
	      label16.setForeground(Color.BLUE);
	      label17 = new JLabel("ID:");
	      label18 = new JLabel("Monthly Income:");
	      label19 = new JLabel("Number of Months:");
	      label20 = new JLabel("Pay Hours:");
	      label21 = new JLabel("Pay Rate:");
	      prID = new JTextField(3);
	      mIncome = new JTextField(4);
	      nMonths = new JTextField(4);
	      pHours = new JTextField(4);
	      pHours.setEditable(false);
	      pRate = new JTextField(4);
	      pRate.setEditable(false);
	      addPayRecordButton = new JButton("Add Pay Record");
	      addPayRecordButton.setEnabled(false);
	      addPayRecordButton.setMnemonic(KeyEvent.VK_R);
	      // Text Area
	      label22 = new JLabel("Current Employee Record and Stat (Total & Average Pays)");
	      label22.setForeground(Color.BLUE);
	      
	      textArea = new JTextArea(5, 15);
	      textArea.setEditable(false);
	      jp = new JScrollPane(textArea);
	      jp.setPreferredSize(new Dimension(600, 200));
	      DefaultCaret caret = (DefaultCaret) textArea.getCaret();
	      caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);	      
	      CloseButton = new JButton("Exit");
	      CloseButton.setMnemonic(KeyEvent.VK_X);
	  }// end of creating objects method
	  
///////////////////////////////////  Layout /////////////////////////////////////////	  

	  private void doTheLayout() {
		  // Employee
		  JPanel empHeader = new JPanel();
		  empHeader.setPreferredSize(new Dimension(700, 20));
		  empHeader.add(label1);
		  add(empHeader);
		  JPanel empFields = new JPanel();
		  empFields.add(label2);
		  empFields.add(empID);
		  empFields.add(label3);
		  empFields.add(fName);
		  empFields.add(label4);
		  empFields.add(lName);
		  add(empFields);
		  JPanel empFields2 = new JPanel();
		  empFields2.add(label5);
		  empFields2.add(fulltime);
		  empFields2.add(hourly);
		  add(empFields2);
		  
		  // Address
		  JPanel addrHeader = new JPanel();
		  addrHeader.setPreferredSize(new Dimension(700, 20));
		  addrHeader.add(label6);
		  add(addrHeader);
		  JPanel addrFields = new JPanel();
		  addrFields.add(label7);
		  addrFields.add(street);
		  addrFields.add(label8);
		  addrFields.add(aptNo);
		  addrFields.add(label9);
		  addrFields.add(city);
		  addrFields.add(label10);
		  addrFields.add(state);
		  addrFields.add(label11);
		  addrFields.add(zipCode);
		  add(addrFields);

		  // Add Employee BUTTON
		  JPanel addEmpPanel = new JPanel();
		  addEmpPanel.setPreferredSize(new Dimension(700, 50));   // To show full button
		  addEmpPanel.add(addEmpButton);
		  add(addEmpPanel);
		  
		  // Pay Period
		  JPanel ppHeader = new JPanel();
		  ppHeader.setPreferredSize(new Dimension(700, 20));
		  ppHeader.add(label12);
		  add(ppHeader);
		  JPanel ppFields = new JPanel();
		  ppFields.add(label13);
		  ppFields.add(ppID);
		  ppFields.add(label14);
		  ppFields.add(ppStartDate);
		  ppFields.add(label15);
		  ppFields.add(ppEndDate);
		  add(ppFields);
		  
		  // Pay Record BUTTON  (below)
		  JPanel prHeader = new JPanel();
		  prHeader.setPreferredSize(new Dimension(700, 20));
		  prHeader.add(label16);
		  add(prHeader);
		  JPanel prFields = new JPanel();
		  prFields.add(label17);
		  prFields.add(prID);
		  prFields.add(label18);
		  prFields.add(mIncome);
		  prFields.add(label19);
		  prFields.add(nMonths);
		  prFields.add(label20);
		  prFields.add(pHours);
		  prFields.add(label21);
		  prFields.add(pRate);
		  add(prFields);
		  JPanel addPayRecordPanel = new JPanel();
		  addPayRecordPanel.setPreferredSize(new Dimension(700, 50));  // To show full button
		  addPayRecordPanel.add(addPayRecordButton);
		  add(addPayRecordPanel);
		  
		  // Text Area
		  JPanel taHeader = new JPanel();
		  taHeader.setPreferredSize(new Dimension(700, 30));
		  taHeader.add(label22);
		  add(taHeader);
		  JPanel taPanel = new JPanel();
		  taPanel.add(jp);
		  add(taPanel);
		  
		  // Close Button
	      JPanel bottom = new JPanel();
	      bottom.setPreferredSize(new Dimension(700, 50));  // To show full button
	      bottom.setLayout( new FlowLayout());
	      bottom.add(CloseButton);
	      add(bottom);

	  }// end of Layout method

	  void close(){
	      System.exit(0);
	  }// end of transfer action event method
	  
/////////////////////////////////////  Main   ////////////////////////////////////////////////////////////

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
	    JFrame f = new JFrame("Pay Roll");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = f.getContentPane();
        contentPane.add(new UserGUI());
        f.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        f.pack();
        f.setSize(700, 700);
        f.setVisible(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Point middle = new Point(screenSize.width / 2, screenSize.height / 2);
        Point newLocation = new Point(middle.x - (f.getWidth() / 2), 
                                      middle.y - (f.getHeight() / 2));
        f.setLocation(newLocation);
	}
}
