package PP2;



public class Validation {


  // Return true if the card number is valid, otherwise returns false, 
	///this method is already implemented
  public boolean aValidNumber(String n) {

	long number = Long.parseLong(n);
	//return true;

	return  (numLength(number) >= 13) && (numLength(number) <= 16) &&
        (prefixCheck(number, 4) || prefixCheck(number, 5) ||
        prefixCheck(number, 6) || prefixCheck(number, 37)) &&
        (totalEvenNumbers(number) + totalOddNumbers(number)) % 10 == 0;

  }// end of aValidNumber method

  //get the sum of even places numbers, Starting from the second digit from right
  private int totalEvenNumbers(long number) {
	   long cardNum = number;
	   long cardNumMod2 = 0;
	   int cardNumMod = 0;
	   int sumEven = 0;
	   int g = 0; 
	    while (cardNum != 0) {
	        cardNumMod2 = cardNum % 10; 
	         g++;
	        if ((g % 2) == 0) {
	        cardNumMod	= singleDigit ((int) (cardNumMod2));
	        	sumEven = (int) (sumEven + cardNumMod);
	        }
	        cardNum = cardNum / 10;		       
	    	}	
	   
	  return sumEven;
 }// end of totalEevenNumbers method

//Return the same number if it is a single digit, otherwise, return the sum of
 // the two digits in this number
 private int singleDigit(int number) {
	 
	  int numberMult = number*2; 
	 if ( numberMult <= 9) {
		
		  return numberMult;
	  }
	  else {
		 int numberAdd = ((numberMult % 10) + (numberMult / 10));
	
	  	return numberAdd;
	  }
		  
 } // end of singleDigit method

  // Return the sum of odd place digits in number
	////test methods
  private int totalOddNumbers(long number) {
	   long cardNum = number; 
	   long cardNumMod3 = 0;
	   int sumOdd = 0;
	   int g = 0; 
	    while (cardNum != 0) {
	        cardNumMod3 = cardNum % 10;   
	        if ((g % 2) == 0) {
	            //cardNumMod	= singleDigit ((int) (cardNumMod3));
	        	sumOdd = (int) (sumOdd + cardNumMod3);
	        }
	         g++;
	        cardNum = cardNum / 10;		       
	    	}	
	  return sumOdd;

  }// end of totalOddNumbers method

  //Return true if the digit d is a prefix for number
 private boolean prefixCheck(long number, int d) {

	 int validation = 0;	
	 validation = (int) numPrefix(number, d);
	 if (validation == 4) {return true;}
	 if (validation == 5) {return true;}
	 if (validation == 6) {return true;}
	 if (validation == 37) {return true;}
	 else return false;
	  
 }

  // Return the number of digits in this number parameter
  private int numLength(long number) {
	  int letters = 0;
	  
	  String numberString = Long.toString(number);
	  //String.valueOf(numberString).length; 
      for ( int i = 0; i < numberString.length(); i++ ) {
      numberString.charAt(i);
          letters++;}
  
    return letters;
  }// end of numLength method

  // Return the first k number of digits from number, which is either a first digit or first two digits
  // Depending on the card type
  private long numPrefix(long number, int k) {
	 
	  String numberdString = Long.toString(number);
	
	  for ( int i = 0; i < numberdString.length(); i++ ) {
	    char letter = numberdString.charAt(0);
	    char letter2 = numberdString.charAt(1);
	    int num2 = Character.getNumericValue(letter2);
	    int num = Character.getNumericValue(letter);
		  if( (3 == num) && (7 == num2)) {
		  return 37;}
	else if(4 == num) {
			  return 4;}  
	else if(num ==5) {
			return num;}
	else if(6 == num) {
		return 6;}
	   }
	  return 1;   
	 
  
  }// end of numPrefix method

}// end of the class
