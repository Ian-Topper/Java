package PP03;

public class Person {
	
	protected String fName ;
    protected String lName ;
    protected Address address;
    public static int numberOfPeopleInFile=0;
    public Person(){
    	
    }
    
////////////////////////////////////////////////////////////////
    
	public Person(String fName, String lName, Address address) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		
	}

////////////////  Get n Set  /////////////////
	
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

	public Address getAddress() {
		return address;
	}

	public void setAdsress(Address address) {
		this.address = address;
	}

///////////////////  To String  /////////////////////////////////////
	
	@Override
	public String toString() {
		return "Person [First Name: " + fName + ", Last Name: " + lName +
				", Address: " + address + "]";
	}
}
