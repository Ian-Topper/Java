
package PA06; 

public class Student extends Person{
	

	private String status; // Values are Freshman, Sophomore, Junior, Senior 
	
	Student(String firstName, String lastName, Address address,
			String phoneNumber, String emailAddress, String status){
		// call the super class constructor to pass the Person data fields	
		super(firstName, lastName, address, phoneNumber, emailAddress);
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Student [Status: " + status + ", First Name: " + firstname + ", Last Name: " + lastName + ", Address: "
				+ address + ", Phone Number: " + phoneNumber + ", Email Address: " + emailAddress + "]";
	}
}
