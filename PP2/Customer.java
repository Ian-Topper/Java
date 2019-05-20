package PP2;


public class Customer {
	
	public static Customer[] ToString;
	private int id;
	private String fName, lName;
	private double amount;
	private CreditCard card;
	private static int noOfCustomers = 0;
	
	public Customer(String fName, String lName, int id, 
			double amount, CreditCard card) {
		
		super();
		this.fName = fName;
		this.lName = lName;
		this.id = id;
		this.amount = amount;
		this.card = card;
		noOfCustomers++;
	}

	public static int getNoOfCustomers() {
		return noOfCustomers;
	}

	public static void setNoOfCustomers(int noOfCustomers) {
		Customer.noOfCustomers = noOfCustomers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}


	public String toString() {
		return "Customer: Id=" + id + ", First Name=" + fName +
				", Last Name=" + lName + ", Amount=" + String.format("%.2f", amount)+ "["  + card;
	}
	


}
