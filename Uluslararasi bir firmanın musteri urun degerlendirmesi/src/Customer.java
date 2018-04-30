
public class Customer {
	// Deðiþkenleri tanýmladýk
	private int customerID; 
	private String customerName;
	private String customerSurname;
	

	// Parametresiz Constructor
	public Customer() {
		customerID = (Integer) null;
		customerName = null;
		customerSurname = null;
		
	}
	// Copy Constructor
	public void Customer(Customer x){
		
		this.customerID = x.getCustomerID();
		this.customerName = x.getCustomerName();
		this.customerSurname = x.getCustomerSurname();
	}
	 // Tüm deðiþkenleri kullanan Constructor
	public Customer(int customerID, String customerName, String customerSurname){
		
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerSurname = customerSurname;
				
	}
	 // ToString Method
	public String toString(){
		return "Customer ID : " + getCustomerID() + "\nCustomer Name : " + getCustomerName() + "\nCustomer Surname : " + getCustomerSurname();
	}
	 // Getter and Setter Methods
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerSurname() {
		return customerSurname;
	}
	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}
	

	public static void main(String args []){
		Customer c = new Customer(1232,"burak","sivrikaya");
		System.out.println(c);
	}
}





