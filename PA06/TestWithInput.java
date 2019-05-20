package PA06;



import javax.swing.JDialog;
import javax.swing.JOptionPane;



public class TestWithInput {

	public static void main(String[] args) {

		String totalPeople = "";
		boolean exit = false;
		int n = 0;
		String output = "People Array:";
		
		///JOption loop till valid input recieved
		
		while(exit==false) {
			////green color box
			JDialog.setDefaultLookAndFeelDecorated(true);
			////Joption takes input
			totalPeople =JOptionPane.showInputDialog(
				"Please enter number of people");
			//cancel button works
			 if (totalPeople == null){
				System.exit(0);
			 }//end cancel button check	

		try{
			n = Integer.parseInt(totalPeople);
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
		Person[] personArray = new Person[n];
		//people = new Person[n];
	
	int letter = 0;
		for ( int z=0;z<n;z++){
			
			  JDialog.setDefaultLookAndFeelDecorated(true);
			    Object[] selectionValues = { "Faculty", "Student" };
			    String initialSelection = "Faculty";
			    Object selection = JOptionPane.showInputDialog(null, "Are you faculty or student",
			        "", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
			    
			
			boolean exit2 = false;
			String addressInput="";
			while(exit2==false) {
				letter=0;
				try {
					/////green joption
				JDialog.setDefaultLookAndFeelDecorated(true);
				////////enter string to joption 
				addressInput =JOptionPane.showInputDialog(
					"Please enter your street name");
				////////Cancel button works
				 if (addressInput == null){
						System.exit(0);
					 }//end cancel button check
					
				for (int y=0;y<addressInput.length();y++){
					if (Character.isLetter(addressInput.charAt(y))){letter+=1;
					  }
					}
				}///end try
					////end try if exception display message
					catch(Exception ex){JOptionPane.showMessageDialog(null,
						"Invalid entry, Please enter a street name that contains "
						+ "two letters minimum");
					}//End for loop
						
					///Check for 2 letters if two or more letters were found 
				   ////exit = true and loop ends
					///onto next button
				if (letter>0){exit2 = true;
				}
				else JOptionPane.showMessageDialog(null,
							"Invalid entry, Please enter a street name that "
							+ "contains two letters minimum"); 	 
				}////end while
			String addressNumber = "";
			boolean exit3 = false;
			int addressNumberInt = 0;
			///JOption loop till valid input recieved
			while(exit3==false) {
				////green color box
				JDialog.setDefaultLookAndFeelDecorated(true);
				////Joption takes input
				addressNumber =JOptionPane.showInputDialog(
					"Please enter address house number");
				//cancel button works
				 if (addressNumber == null){
					System.exit(0);
				 }//end cancel button check	

			try{
				addressNumberInt = Integer.parseInt(addressNumber);
				/////check that integer is greater than 0 and exits loop if so.
				if (addressNumberInt>0) {
				exit3 = true;
				}	
			}	
			///////catch and display message if exception was found
			catch(Exception ex){JOptionPane.showMessageDialog(null,
					"Invalid entry, Please enter a positive whole address number");
			}
			}///end while					
			boolean exit4 = false;
			String cityInput="";
			while(exit4==false) {
				letter=0;
				try {
					/////green joption
				JDialog.setDefaultLookAndFeelDecorated(true);
				////////enter string to joption 
				cityInput =JOptionPane.showInputDialog(
					"Please enter your cities name");
				////////Cancel button works
				 if (cityInput == null){
						System.exit(0);
					 }//end cancel button check
					
				for (int y=0;y<cityInput.length();y++){
					if (Character.isLetter(cityInput.charAt(y))){letter+=1;
					  }
					}
				}///end try
					////end try if exception display message
					catch(Exception ex){JOptionPane.showMessageDialog(null,
						"Invalid entry, Please enter a city name that contains "
						+ "two letters minimum");
					}//End for loop
						
					///Check for 2 letters if two or more letters were found 
				   ////exit = true and loop ends
					///onto next button
				if (letter>0){exit4 = true;
				}
				else JOptionPane.showMessageDialog(null,
							"Invalid entry, Please enter a city name that "
							+ "contains two letters minimum"); 	 
				}////end while
			
			boolean exit5 = false;
			String stateInput= "";
			while(exit5==false) {
				letter=0;
				try {
					/////green joption
				JDialog.setDefaultLookAndFeelDecorated(true);
				////////enter string to joption 
				stateInput =JOptionPane.showInputDialog(
					"Please enter your states name");
				////////Cancel button works
				 if (stateInput == null){
						System.exit(0);
					 }//end cancel button check
					
				for (int y=0;y<stateInput.length();y++){
					if (Character.isLetter(stateInput.charAt(y))){letter+=1;
					  }
					}
				}///end try
					////end try if exception display message
					catch(Exception ex){JOptionPane.showMessageDialog(null,
						"Invalid entry, Please enter a state name that contains "
						+ "two letters minimum");
					}//End for loop
						
					///Check for 2 letters if two or more letters were found 
				   ////exit = true and loop ends
					///onto next button
				if (letter>0){exit5 = true;
				}
				else JOptionPane.showMessageDialog(null,
							"Invalid entry, Please enter a state name that "
							+ "contains two letters minimum"); 	 
				}////end while
			String zip = "";
			boolean exit6 = false;
			int zipInt = 0;
			///JOption loop till valid input recieved
			while(exit6==false) {
				////green color box
				JDialog.setDefaultLookAndFeelDecorated(true);
				////Joption takes input
				zip =JOptionPane.showInputDialog(
					"Please enter your zip code");
				//cancel button works
				 if (zip == null){
					System.exit(0);
				 }//end cancel button check	

			try{
				zipInt = Integer.parseInt(zip);
				/////check that integer is a five digit zip code.
				if (zipInt>9999 && zipInt<100000) {
				exit6 = true;
				}
				else JOptionPane.showMessageDialog(null,
						"Invalid entry, Please enter a positive 5 digit zip code");
			}	
			///////catch and display message if exception was found
			catch(Exception ex){JOptionPane.showMessageDialog(null,
					"Invalid entry, Please enter a positive 6 digit zip code");
			}
			}///end while
			
		
			    if (selection == "Faculty") {
			    	boolean exit7 = false;
			    	String firstName = "";
			    	while(exit7==false) {
						letter=0;
						try {
							/////green joption
						JDialog.setDefaultLookAndFeelDecorated(true);
						////////enter string to joption 
						 firstName =JOptionPane.showInputDialog(
							"Please enter your first name");
						////////Cancel button works
						 if (firstName == null){
								System.exit(0);
							 }//end cancel button check
							
						for (int y=0;y<firstName.length();y++){
							if (Character.isLetter(firstName.charAt(y))){letter+=1;
							  }
							}
						}///end try
							////end try if exception display message
							catch(Exception ex){JOptionPane.showMessageDialog(null,
								"Invalid entry, Please enter your first name that contains "
								+ "two letters minimum");
							}//End for loop
								
							///Check for 2 letters if two or more letters were found 
						   ////exit = true and loop ends
							///onto next button
						if (letter>0){exit7 = true;
						}
						else JOptionPane.showMessageDialog(null,
									"Invalid entry, Please enter your last name that "
									+ "contains two letters minimum"); 	 
						}////end while
			    	String lastName = "";
					exit7 = false;
					while(exit7==false) {
						letter=0;
						try {
							/////green joption
						JDialog.setDefaultLookAndFeelDecorated(true);
						////////enter string to joption 
						lastName =JOptionPane.showInputDialog(
							"Please enter your last name");
						////////Cancel button works
						 if (lastName == null){
								System.exit(0);
							 }//end cancel button check
							
						for (int y=0;y<lastName.length();y++){
							if (Character.isLetter(lastName.charAt(y))){letter+=1;
							  }
							}
						}///end try
							////end try if exception display message
							catch(Exception ex){JOptionPane.showMessageDialog(null,
								"Invalid entry, Please enter your last name that contains "
								+ "two letters minimum");
							}//End for loop
								
							///Check for 2 letters if two or more letters were found 
						   ////exit = true and loop ends
							///onto next button
						if (letter>0){exit7 = true;
						}
						else JOptionPane.showMessageDialog(null,
									"Invalid entry, Please enter your first name that "
									+ "contains two letters minimum"); 	 
						}////end while
					String phone ="";
					exit7 = false;
					while(exit7==false) {
						letter=0;
						try {
							/////green joption
						JDialog.setDefaultLookAndFeelDecorated(true);
						////////enter string to joption 
						phone =JOptionPane.showInputDialog(
							"Please enter your phone number");
						////////Cancel button works
						 if (phone == null){
								System.exit(0);
							 }//end cancel button check
							
						for (int y=0;y<phone.length();y++){
							if (Character.isDigit(phone.charAt(y))){letter+=1;
							  }
							}
						}///end try
							////end try if exception display message
							catch(Exception ex){JOptionPane.showMessageDialog(null,
								"Invalid entry, Please enter your phone number that contains "
								+ "seven digits minimum");
							}//End for loop
								
							///Check for 2 letters if two or more letters were found 
						   ////exit = true and loop ends
							///onto next button
						if (letter>6){exit7 = true;
						}
						else JOptionPane.showMessageDialog(null,
									"Invalid entry, Please enter your phone number that "
									+ "contains 7 digits minimum"); 	 
						}////end while
					exit7 = false;
					String eMail= "";
					while(exit7==false) {
						letter=0;
						try {
							/////green joption
						JDialog.setDefaultLookAndFeelDecorated(true);
						////////enter string to joption 
						eMail =JOptionPane.showInputDialog(
							"Please enter your email address");
						////////Cancel button works
						 if (eMail == null){
								System.exit(0);
							 }//end cancel button check
							
						for (int y=0;y<eMail.length();y++){
							if (Character.isLetter(eMail.charAt(y))){letter+=1;
							  }
							}
						}///end try
							////end try if exception display message
							catch(Exception ex){JOptionPane.showMessageDialog(null,
								"Invalid entry, Please enter your email that contains "
								+ "4 letters minimum");
							}//End for loop
								
							///Check for 4 letters if two or more letters were found 
						   ////exit = true and loop ends
							///onto next button
						if (letter>4){exit7 = true;
						}
						else JOptionPane.showMessageDialog(null,
									"Invalid entry, Please enter your email that "
									+ "contains 4 letters minimum"); 	 
						}////end while
					
					  JDialog.setDefaultLookAndFeelDecorated(true);
					    Object[] selectionValuesF = { "1", "2",
					    		"3", "4" };
					    String initialSelectionF = "1";
					    String rankOfFaculty = (String) JOptionPane.showInputDialog(null,"Select current faculty rank" 
							    +"\n" + "(1) for Lecturer" +"\n"+" (2) "+ "for Assistant Professor" +"\n"+"(3) for Associate Professor "+"\n" + "(4) for Professor",
						        "", JOptionPane.QUESTION_MESSAGE, null, selectionValuesF, initialSelectionF);

						if (rankOfFaculty == "1") {rankOfFaculty = "Lecturer";}
						else if(rankOfFaculty == "2") {rankOfFaculty = "Assitant Professor";}
						else if(rankOfFaculty == "3") {rankOfFaculty = "Associate Professor";}
						else if(rankOfFaculty == "4") {rankOfFaculty = "Professor";}
						
					    
					    
					    String yearString = "";
						boolean exit8 = false;
						int yearInt = 0;
						///JOption loop till valid input recieved
						while(exit8==false) {
							letter= 0;
							////green color box
							JDialog.setDefaultLookAndFeelDecorated(true);
							////Joption takes input

							yearString =JOptionPane.showInputDialog(
								"Please enter 4 digit year");
							//cancel button works
							 if (yearString == null){
								System.exit(0);
							 }//end cancel button check	

						try{
							yearInt = Integer.parseInt(yearString);
							/////check that integer is greater than 0 and exits loop if so.
							for (int y=0;y<yearString.length();y++){
								if (Character.isDigit(phone.charAt(y))){letter+=1;
								  }
								}
							if (yearInt > 999) {
							if (letter > 3 && letter < 5) {
							exit8 = true;
							}
							}
							else JOptionPane.showMessageDialog(null,
									"Invalid entry, Please enter 4 digit year");
						}	
						///////catch and display message if exception was found
						catch(Exception ex){JOptionPane.showMessageDialog(null,
								"Invalid entry, Please enter a 4 digit year");
						}
						}///end while					
					    
					    
					    JDialog.setDefaultLookAndFeelDecorated(true);
					    Object[] selectionValuesMonth = { 1,2,3,4,5,6,7,8,9,10,11,12 };
					    int initialSelectionMonth = 1;
					    int month = (int) JOptionPane.showInputDialog(null,"Select appointment month",
						        "", JOptionPane.QUESTION_MESSAGE, null, selectionValuesMonth, initialSelectionMonth);
					   int day = 1;
					    if (month == 1 || month== 3 || month == 5 || month == 7
					    		|| month == 8 || month == 10 || month == 12) {
						    JDialog.setDefaultLookAndFeelDecorated(true);
						    Object[] selectionValuesDay = { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
						    int initialSelectionDay = 1;
						    day = (int) JOptionPane.showInputDialog(null,"Select appointment day",
							        "", JOptionPane.QUESTION_MESSAGE, null, selectionValuesDay, initialSelectionDay);
					    	}
					    else if (month == 4 || month== 6 || month == 9 || month == 11) {
						    JDialog.setDefaultLookAndFeelDecorated(true);
						    Object[] selectionValuesDay = { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
						    int initialSelectionDay = 1;
						    day = (int) JOptionPane.showInputDialog(null,"Select appointment day",
							        "", JOptionPane.QUESTION_MESSAGE, null, selectionValuesDay, initialSelectionDay);
					    	}
					    
					    else if ((yearInt % 400 == 0) || ((yearInt % 4 == 0) && (yearInt % 100 != 0)) && month == 2 ) {
						    JDialog.setDefaultLookAndFeelDecorated(true);
						    Object[] selectionValuesDay = { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29};
						    int initialSelectionDay = 1;
						    day = (int) JOptionPane.showInputDialog(null,"Select appointment day",
							        "", JOptionPane.QUESTION_MESSAGE, null, selectionValuesDay, initialSelectionDay);}
						else if (month == 2) {
						    JDialog.setDefaultLookAndFeelDecorated(true);
						    Object[] selectionValuesDay = { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28};
						    int initialSelectionDay = 1;
						    day = (int) JOptionPane.showInputDialog(null,"Select appointment day",
							        "", JOptionPane.QUESTION_MESSAGE, null, selectionValuesDay, initialSelectionDay);
					    	} 
					     
					   
					    ////Make some objects
					    
					   
					    MyDate date2 = new MyDate(yearInt,month,day);
					    Address address	= new Address (addressInput, addressNumberInt, cityInput, stateInput, zipInt);
					    Person person = new Faculty(firstName, lastName, address, phone, eMail, rankOfFaculty, date2);
					    personArray[Person.getNumberOfPersons()-1] = person;
					    
			    }///end faculty
			    else if (selection == "Student") {
	boolean exit7 = false;
					String firstNameS= "";
			    	while(exit7==false) {
						letter=0;
						try {
							/////green joption
						JDialog.setDefaultLookAndFeelDecorated(true);
						////////enter string to joption 
						firstNameS=JOptionPane.showInputDialog(
							"Please enter your first name");
						////////Cancel button works
						 if (firstNameS == null){
								System.exit(0);
							 }//end cancel button check
							
						for (int y=0;y<firstNameS.length();y++){
							if (Character.isLetter(firstNameS.charAt(y))){letter+=1;
							  }
							}
						}///end try
							////end try if exception display message
							catch(Exception ex){JOptionPane.showMessageDialog(null,
								"Invalid entry, Please enter your first name that contains "
								+ "two letters minimum");
							}//End for loop
								
							///Check for 2 letters if two or more letters were found 
						   ////exit = true and loop ends
							///onto next button
						if (letter>0){exit7 = true;
						}
						else JOptionPane.showMessageDialog(null,
									"Invalid entry, Please enter your last name that "
									+ "contains two letters minimum"); 	 
						}////end while
			    	String lastNameS = "";
					exit7 = false;
					while(exit7==false) {
						letter=0;
						try {
							/////green joption
						JDialog.setDefaultLookAndFeelDecorated(true);
						////////enter string to joption 
						 lastNameS =JOptionPane.showInputDialog(
							"Please enter your last name");
						////////Cancel button works
						 if (lastNameS == null){
								System.exit(0);
							 }//end cancel button check
							
						for (int y=0;y<lastNameS.length();y++){
							if (Character.isLetter(lastNameS.charAt(y))){letter+=1;
							  }
							}
						}///end try
							////end try if exception display message
							catch(Exception ex){JOptionPane.showMessageDialog(null,
								"Invalid entry, Please enter your last name that contains "
								+ "two letters minimum");
							}//End for loop
								
							///Check for 2 letters if two or more letters were found 
						   ////exit = true and loop ends
							///onto next button
						if (letter>0){exit7 = true;
						}
						else JOptionPane.showMessageDialog(null,
									"Invalid entry, Please enter your first name that "
									+ "contains two letters minimum"); 	 
						}////end while
					String phoneS = "";
					exit7 = false;
					while(exit7==false) {
						letter=0;
						
						try {
							/////green joption
						JDialog.setDefaultLookAndFeelDecorated(true);
						////////enter string to joption 
						phoneS =JOptionPane.showInputDialog(
							"Please enter your phone number");
						////////Cancel button works
						 if (phoneS == null){
								System.exit(0);
							 }//end cancel button check
							
						for (int y=0;y<phoneS.length();y++){
							if (Character.isDigit(phoneS.charAt(y))){letter+=1;
							  }
							}
						}///end try
							////end try if exception display message
							catch(Exception ex){JOptionPane.showMessageDialog(null,
								"Invalid entry, Please enter your phone number that contains "
								+ "seven digits minimum");
							}//End for loop
								
							///Check for 2 letters if two or more letters were found 
						   ////exit = true and loop ends
							///onto next button
						if (letter>6){exit7 = true;
						}
						else JOptionPane.showMessageDialog(null,
									"Invalid entry, Please enter your phone number that "
									+ "contains 7 digits minimum"); 	 
						}////end while
					exit7 = false;
					String eMailS ="";
					while(exit7==false) {
						letter=0;
						try {
							/////green joption
						JDialog.setDefaultLookAndFeelDecorated(true);
						////////enter string to joption 
						 eMailS =JOptionPane.showInputDialog(
							"Please enter your email address");
						////////Cancel button works
						 if (eMailS == null){
								System.exit(0);
							 }//end cancel button check
							
						for (int y=0;y<eMailS.length();y++){
							if (Character.isLetter(eMailS.charAt(y))){letter+=1;
							  }
							}
						}///end try
							////end try if exception display message
							catch(Exception ex){JOptionPane.showMessageDialog(null,
								"Invalid entry, Please enter your email that contains "
								+ "4 letters minimum");
							}//End for loop
								
							///Check for 4 letters if two or more letters were found 
						   ////exit = true and loop ends
							///onto next button
						if (letter>4){exit7 = true;
						}
						else JOptionPane.showMessageDialog(null,
									"Invalid entry, Please enter your email that "
									+ "contains 4 letters minimum"); 	 
						}////end while
					
					  JDialog.setDefaultLookAndFeelDecorated(true);
					    Object[] selectionValuesStud = { "1", "2",
					    		"3", "4" };
					  String initialSelectionStud = "1";
					  String statusStud = (String) JOptionPane.showInputDialog(null, "Select current student status" 
					    +"\n" + "(1) for Freshman" +"\n"+" (2) "+ "for Sophmore" +"\n"+"(3) for Junior "+"\n" + "(4) for Senior",
					        "", JOptionPane.QUESTION_MESSAGE, null, selectionValuesStud,initialSelectionStud);
						if (statusStud == "1") {statusStud = "Freshman";}
						else if(statusStud == "2") {statusStud = "Sophmore";}
						else if(statusStud == "3") {statusStud = "Junior";}
						else if(statusStud == "4") {statusStud = "Senior";}
					  
					  // Person.setRankOfFaculty(statusStud);
					  ////Make Some Objects
					  Address address	= new Address (addressInput, addressNumberInt, cityInput, stateInput, zipInt);
					  Person person = new Student(firstNameS, lastNameS, address, phoneS, eMailS, statusStud);
					  personArray[Person.getNumberOfPersons()-1] = person;
					    
			    }///end Student
		
		}////End For Loop
		String line = System.getProperty("line.separator");
		 for(int k=0; k<(personArray.length); k++) {	
	     	     output += line + (personArray[k].toString()) ;
				 }
	     	     JOptionPane.showMessageDialog(null,
						output);
	}////EndMain Method

}/////End TestWithInput Class
