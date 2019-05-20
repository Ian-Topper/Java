package PP2;

public class CreditCard {
	
	private long number;
	private String expDate;
	
	public CreditCard(long number, String expDate){
		this.number = number;
		this.expDate = expDate;
	}
	
	// add public setter/getter methods, and also the toString method
	

	  long getNumber() {
	        return number;
	    }///get
	    public void setNumber(Long newNumber) {
	        this.number = newNumber;
	    }// set
	  String getExpDate() {
	        return expDate;
	    }
	    public void setExpDate(String newExpDate) {
	        this.expDate = newExpDate;
	    }

		
		public String toString() {
			return "CreditCard:" + " Experation Date=" + expDate +
					"   Private Card Number=";
		}
		
}
