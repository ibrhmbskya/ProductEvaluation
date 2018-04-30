
public class NationalCustomer extends Customer{
  
	private int LicencePlateNumber;
	private String Occupation;
	
	public NationalCustomer(){
		LicencePlateNumber = (Integer) null;
		Occupation = null;
	}
	
	public NationalCustomer(int customerID, String customerName, String customerSurname, int LicencePlateNumber, String Occupation){
		super(customerID, customerName, customerSurname);
		this.LicencePlateNumber = LicencePlateNumber;
		this.Occupation = Occupation;
	}
	//Copy Constructor
	public NationalCustomer(NationalCustomer x){
		super(x.getCustomerID(), x.getCustomerName(), x.getCustomerSurname());
		this.LicencePlateNumber = x.getLicencePlateNumber();
		this.Occupation = x.getOccupation();
	}
	public int getLicencePlateNumber() {
		return LicencePlateNumber;
	}
	
	public void setLicencePlateNumber(int licencePlateNumber) {
		LicencePlateNumber = licencePlateNumber;
	}
	
	public String getOccupation() {
		return Occupation;
	}

	public void setOccupation(String occupation) {
		Occupation = occupation;
	}

	public String toString(){
		return "Customer ID : " + getCustomerID() + "\nCustomer Name : " + getCustomerName() + "\nCustomer Surname : " + getCustomerSurname()
				+ "\nCustomer Licance Plate Number : " + this.getLicencePlateNumber() + "\nOccupation : " + this.getOccupation();
	}
}

