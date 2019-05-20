package PP03;

// 1- The Employee class extends superclass Person
public class Employee extends Person {
	
	private int eID;
    private Status empStatus;
    
    
///////// 2- add the subclass Employee constructor that calls the  ////////
    ///super Person class constructor, you should provide input
    ///data for all parent class data fields
  
	Employee(String fName, String lName, Address address) {
		super(fName, lName, address);
		
	}
	
	
    public Employee(int eID, Status empStatus) {
		super();
		this.eID = eID;
		this.empStatus = empStatus;
	}

//////////// 3- add setters/getters methods  ///////////////////////////////

	public int geteID() {
		return eID;
	}

	public void setID(int eID) {
		this.eID = eID;
	}
	
	public  Status empStatus() {
		return empStatus;
	}

	public void setEmpStatus(Status empStatus) {
		this.empStatus = empStatus;
	}

//////// 4- add override toString() method that overrides toString() /////////////////
	/////in the superclass Person 

	@Override
	public String toString() {
		return "Employee [eID: " + eID + ", Status: " + empStatus + "]"+ super.toString();
	}
}
