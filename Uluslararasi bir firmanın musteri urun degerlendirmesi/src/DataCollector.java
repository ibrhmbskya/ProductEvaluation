import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DataCollector {
	public Customer [] customers = new Customer[200];
	public int [][] productRates;
	public String productNames[];
	
	public DataCollector(){
		this.readFile();
	}
	// Dosya okuma iþlemini yapýyoruz
	public void readFile() throws NullPointerException{
		Scanner scanner = null;
		try {
			scanner = new Scanner (new FileInputStream("Firma.txt"));
			
			String fileInfo = scanner.nextLine();
			// StringTokenizer stringimizi kullanýyoruz
			StringTokenizer st = new StringTokenizer(fileInfo,",");
			int counterP = 0;
			int productCount = 0;
			productCount = Integer.valueOf(st.nextToken());
			this.productNames = new String[productCount];
			while(st.hasMoreTokens()){
				this.productNames[counterP] = st.nextToken();
				counterP++;
			}
			this.productRates = new int[200][productCount];
			
			
			int countC = 0;
			while(scanner.hasNext()){
				String customerInfo = scanner.nextLine();
				StringTokenizer ct = new StringTokenizer(customerInfo,",");
				String customerType = ct.nextToken();
				
				Customer customer;
				if(customerType.equals("i")){
					customer = new InternationalCustomer(Integer.valueOf(ct.nextToken()),ct.nextToken(),ct.nextToken(),ct.nextToken(),ct.nextToken());
				}
				else if(customerType.equals("n")){
					customer = new NationalCustomer(Integer.valueOf(ct.nextToken()),ct.nextToken(),ct.nextToken(),Integer.valueOf(ct.nextToken()),ct.nextToken());
				}
				else{
					customer = new Customer();
				}
				this.customers[countC] = customer;
				
				String customerRates = scanner.nextLine();

				StringTokenizer cr = new StringTokenizer(customerRates,",");
				
				for(int i=0; i<productNames.length;i++){
					this.productRates[countC][i] = Integer.valueOf(cr.nextToken());
				}
				
				countC++;
			}
			/*
			for(String i : productNames){
				System.out.println(i);
			}
			System.out.println(productCount);

			for(Customer i : customers){
				if(i == null){
					break;
				}
					System.out.println(i);
				
			}
			System.out.println(productRates.length);
			System.out.println(productRates[1].length);
			for(int i=0; i< productRates.length ;i++){
				System.out.println("index : " + i);
				System.out.print("Rates : ");
				for(int j = 0 ; j < productRates[i].length ; j++){
					System.out.print(productRates[i][j] + ", ");
				}
				System.out.println("\n----------------");
			}
			
			for(String pn : this.productNames){
				System.out.println(pn);
			}*/
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}
	}
	
	public static void main(String args[]){
		DataCollector dc = new DataCollector();
	}
}
