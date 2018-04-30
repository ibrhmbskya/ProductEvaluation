import java.util.Scanner;
import java.util.Arrays;

public class Main {

	private static final char[] f3 = null;

	public static DataCollector dc = new DataCollector();
	//Her bir ürün için o ürüne ait ortalama derecelendirme puaný hesaplama
	
	/*
	 * Customer Type : 0 = all, 1 = NationalCustomer, 2 = InternationalCustomer
	 * */
	static double overals[] = new double[dc.productNames.length];
	static int [][] rates = dc.productRates;

	private static char[] fark1;
	public static void printOverals(int customerType, String param){//ürünlerin ortalama derecelendirmeleri

		double internationalCustomerOverals[] = new double[dc.productNames.length];
		double nationalCustomerOverals[] = new double[dc.productNames.length];
		double nationalSpecificCustomerOverals[] = new double[dc.productNames.length];
		//Customer customer = customerType == 0 ? new Customer() : customerType == 1 ? new NationalCustomer(): new InternationalCustomer();
		
		for(int i=0; i< rates.length ;i++){
			for(int j = 0 ; j < rates[i].length ; j++){
				if(dc.customers[i] != null && dc.customers[i].getClass().getSimpleName().equals(NationalCustomer.class.getSimpleName())){
					nationalCustomerOverals[j] += rates[i][j];
					
					/*spesific occupation*/
					if(((NationalCustomer)dc.customers[i]).getOccupation().equals(param)){
						nationalSpecificCustomerOverals[j] += rates[i][j];
					}
				}
				else if(dc.customers[i] != null && dc.customers[i].getClass().getSimpleName().equals(InternationalCustomer.class.getSimpleName())){
					internationalCustomerOverals[j] += rates[i][j];
				}
				overals[j] += rates[i][j];
			}
		}

		int customerCount = 0;
		int internationalCustomerCount = 0;
		int nationalCustomerCount = 0;
		int nationalSpecificCustomerCount = 0;
		while(dc.customers[customerCount] != null ){
			if(dc.customers[customerCount].getClass().getSimpleName().equals(NationalCustomer.class.getSimpleName())){
				nationalCustomerCount++;
				/*spesific occupation*/
				if(((NationalCustomer)dc.customers[customerCount]).getOccupation().equals(param)){
					nationalSpecificCustomerCount++;
				}
			}else{
				internationalCustomerCount++;
			}
			customerCount++;
		}
		
		for(int i=0 ; i< overals.length; i++){
			overals[i] = overals[i]/customerCount;
		}
		
		for(int i=0 ; i< internationalCustomerOverals.length; i++){
			internationalCustomerOverals[i] = internationalCustomerOverals[i]/internationalCustomerCount;
		}
		
		for(int i=0 ; i< nationalCustomerOverals.length; i++){
			nationalCustomerOverals[i] = nationalCustomerOverals[i]/nationalCustomerCount;
		}

		for(int i=0 ; i< nationalCustomerOverals.length; i++){
			nationalSpecificCustomerOverals[i] = nationalSpecificCustomerOverals[i]/nationalSpecificCustomerCount;
		}
		if(param == null){
			if(customerType == 1){
				System.out.println("National Customer - Ortalama Ürün Derecelendirmesi");
				for(int i = 0; i< dc.productNames.length; i++){
					System.out.println(dc.productNames[i] + " : " + nationalCustomerOverals[i]);
				}
			}
			else if(customerType == 2){
				System.out.println("International Customer - Ortalama Ürün Derecelendirmesi");
				for(int i = 0; i< dc.productNames.length; i++){
					System.out.println(dc.productNames[i] + " : " + internationalCustomerOverals[i]);
				}			
			}
			else if(customerType == 0){
				System.out.println("Ortalama Ürün Derecelendirmesi");
				for(int i = 0; i< dc.productNames.length; i++){
					System.out.println(dc.productNames[i] + " : " + overals[i]);
				}
			}
		}
		else if(customerType == 1 && param.equals("Doktor")){
			System.out.println("National Doktorlar - Ürün Derecelendirmesi");
			for(int i = 0; i< dc.productNames.length; i++){
				System.out.println(dc.productNames[i] + " : " + nationalSpecificCustomerOverals[i]);
			}
		}
		else if(customerType == 1 && param.equals("Bilgisayar Muhendisi")){
			System.out.println("National bmüh - Ürün Derecelendirmesi");
			for(int i = 0; i< dc.productNames.length; i++){
				System.out.println(dc.productNames[i] + " : " + nationalSpecificCustomerOverals[i]);
			}
		}
	}
	//0: all customer, 1 : national customer, 2 : international customer
	public static void printLowerOverals(int customerType){
		Main.printOverals(5, null);//deðerler girilsin diye
		for(int i = 0; i < dc.productNames.length ; i++){
			System.out.println(dc.productNames[i] + "'ya ortalamanýn altýnda verenler:");
			for(int j = 0; j < rates.length ; j++){
				if(customerType == 1 && dc.customers[j] != null && dc.customers[j].getClass().getSimpleName().equals(NationalCustomer.class.getSimpleName())&&(rates[j][i] < overals[i])){
					System.out.println(dc.customers[j].getCustomerName());
				}
				if(customerType == 2 && dc.customers[j] != null && dc.customers[j].getClass().getSimpleName().equals(InternationalCustomer.class.getSimpleName())&&(rates[j][i] < overals[i])){
					System.out.println(dc.customers[j].getCustomerName());
				}
				if(customerType == 0 && dc.customers[j] != null &&(rates[j][i] < overals[i])){
					System.out.println(dc.customers[j].getCustomerName());
				}
			}
		}
	}
	
	public static void main(String args[]){
		Main.printOverals(0,null);
		Main.printOverals(1,null);
		Main.printOverals(2,null);
		Main.printOverals(1,"Doktor");
		//Main.printOverals(1,"Bilgisayar Muhendisi");
		
		/*System.out.println("-All Customer-");
		Main.printLowerOverals(0);*/
		System.out.println("-National Customer-");
		Main.printLowerOverals(1);
		System.out.println("-International Customer-");
		Main.printLowerOverals(2);
		
		/*customerCount hesaplama*/
		int customerCount = 0;
		for(Customer i : dc.customers){
			if(i == null){
				break;
			}
			customerCount++;
		}
		int fileCustomerCount = customerCount;
		
		Scanner scn = new Scanner(System.in);
		
		while(true){
			System.out.print("Müþteri Tipini Giriniz : ");
			String input = scn.nextLine();
			Customer newCustomer = null;
			
			 if(input.equals("i") || input.equals("n")){
				String customerType = input;
				int customerId;
				String customerName = "";
				String customerSurname = "";
				int licencePlateNumber;
				String occupation = "";
				String city = "";
				String country = "";
				System.out.print("Müþteri Idsini Giriniz : ");
				customerId = Integer.valueOf(scn.nextLine());
				System.out.print("Müþteri Adýný Giriniz : ");
				customerName = scn.nextLine();
				System.out.print("Müþteri Soyadýný Giriniz : ");
				customerSurname = scn.nextLine();
				if(customerType.equals("n")){//national
					System.out.print("Müþteri Plaka Kodu Giriniz : ");
					licencePlateNumber = Integer.valueOf(scn.nextLine());
					System.out.print("Müþteri Mesleðini Giriniz : ");
					occupation = scn.nextLine();
					
					newCustomer = new NationalCustomer(customerId, customerName, customerSurname, licencePlateNumber, occupation);
				}
				else{//international
					System.out.print("Müþteri Country Giriniz : ");
					country = scn.nextLine();
					System.out.print("Müþteri Mesleðini Giriniz : ");
					city = scn.nextLine();
					newCustomer = new InternationalCustomer(customerId, customerName, customerSurname, country, city);
				}
				
			}
			 
			else {
				System.out.println("gecersiz harf");
				break;
			}
			dc.customers[customerCount] = newCustomer;
			customerCount++;

			int tahminDizisi [] = new int [dc.productNames.length];
			
			for(int i = 1; i < dc.productNames.length; i++){
				System.out.print(dc.productNames[i-1]+"'ürünü için puaný: ");
				rates[customerCount][i-1] = Integer.valueOf(scn.nextLine());
				tahminDizisi[i-1] = rates[customerCount][i-1];
			}
			

			int smallest [] = {dc.customers.length+1 , Integer.MAX_VALUE};
			for(int i = 0; i < customerCount; i++){
				int temp = 0;
				
				for(int j = 1; j < rates[i].length; j++){
					temp += Math.abs(rates[i][j-1] - tahminDizisi[j-1]);
				}
				if(smallest[1] > temp){
					smallest[0] = i;
					smallest[1] = temp;
				}
			}
			
			
			int toplam = 0;
			int esitSayisi = 0;
			
			for(int i = 0; i < customerCount; i++){
				int temp = 0;
				
				for(int j = 1; j < rates[i].length; j++){
					temp += Math.abs(rates[i][j-1] - tahminDizisi[j-1]);
				}
				if(smallest[1] == temp){
					esitSayisi++;
					toplam += rates[i][dc.productNames.length-1];
				}
			}
			rates[customerCount][dc.productNames.length -1] = toplam / esitSayisi;
			System.out.println("Tahmin edilen deðer : " + rates[customerCount][dc.productNames.length -1]);
		}
		double [] sonradanOrtalama = new double[dc.productNames.length];
		for(int i = fileCustomerCount; i < customerCount; i++){
			for(int j = 0 ; j < rates[i+1].length ; j++){	
				sonradanOrtalama[j] += rates[i+1][j];
			}
		}
		for(int i = 0; i<sonradanOrtalama.length; i++){
			sonradanOrtalama[i] = sonradanOrtalama[i] /(Double.valueOf(customerCount)- Double.valueOf(fileCustomerCount));
		}
		
		for(int i = fileCustomerCount; i < customerCount; i++){
			System.out.println(dc.customers[i]);
		}
		for(int i = 0; i < sonradanOrtalama.length ; i++){
			System.out.println(dc.productNames[i] + " : " + sonradanOrtalama[i]);
		}
	}

}
			
			
			

		


