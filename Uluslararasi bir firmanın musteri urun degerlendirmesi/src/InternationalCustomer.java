
public class InternationalCustomer extends Customer{
  
	private String Country;
	private String City;
	
	public InternationalCustomer(){
		Country = null;
		City = null;
	}
	
	public InternationalCustomer(int customerID, String customerName, String customerSurname, String Country, String City){
		super(customerID, customerName, customerSurname);
		this.Country = Country;
		this.City = City;
	}
	//Copy Constructor
	public InternationalCustomer(InternationalCustomer x){
		super(x.getCustomerID(), x.getCustomerName(), x.getCustomerSurname());
		this.Country = x.getCountry();
		this.City = x.getCity();
	}
	// Getter-Setter Methodu
	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String toString(){
		return "Customer ID : " + getCustomerID() + "\nCustomer Name : " + getCustomerName() + "\nCustomer Surname : " + getCustomerSurname()
				+ "\nCustomer Country : " + this.getCountry() + "\nCustomer City : " + this.getCity();
	}
}

