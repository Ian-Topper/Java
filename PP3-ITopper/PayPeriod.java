package PP03;

import java.util.Date;


public class PayPeriod {
	
	private int pID;
    private Date pStartDate, pEndDate;
    
///////// 1- add the class constructor   //////////////
    
    public PayPeriod(Date startDate, Date endDate) {
    		this.pStartDate = startDate;
    		this.pEndDate = endDate;
    }
    
/////// 2- add the setters/getters methods /////////
    
    public void setID(int id) {
    		this.pID = id;
    }
    
    public int getID() {
    		return this.pID;
    }
    
    public void setStartDate(Date sDate) {
    		this.pStartDate = sDate;
    }
    
    public Date getStartDate() {
    		return this.pStartDate;
    }
    
    public void setEndDate(Date eDate) {
    		this.pEndDate = eDate;
    }
    
    public Date getEndDate() {
    		return this.pEndDate;
    }

//////////////// 3- add override method toString() ////////////////////
    
	/*@Override
	public String toString() {
		return this.pID + ", " + this.pStartDate + ", " + this.pEndDate;
	}*/
	@Override
	public String toString() {
		return "Pay Period [pID:" + pID + ", Start Date: " + pStartDate +
				", End Date: " + pEndDate  + "]";
	}
}
