package PP03;

public class TaxIncome implements Taxable {

////// 1- this class implements the Taxable interface
	// 2- implement all the unimplemented abstract methods in the Taxable Interface, 
	// income tax is computed based on state and federal taxes   
	
	
	public double compStateTax(double grossPay) {
		return grossPay * STATE_TAX;
	}
	
	public double compFederalTax(double grossPay) {
		return grossPay * FEDERAL_TAX;
	}
	
	public double compIncomeTax(double grossPay) {
		double stateTax = compStateTax(grossPay);
		double fedTax = compFederalTax(grossPay);
		return stateTax + fedTax;
	}

	public TaxIncome() {
		super();
		// TODO Auto-generated constructor stub
	}

}