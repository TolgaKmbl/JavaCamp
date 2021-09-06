package inheritance;

public class Main {

	public static void main(String[] args) {

		IndividualCustomer tolga = new IndividualCustomer();
		tolga.id = 1;
		tolga.customerNumber = "123123";
		
		CorporateCustomer hepsiBurada = new CorporateCustomer();
		hepsiBurada.id = 2;
		hepsiBurada.customerNumber = "1355";
		
		SendikaCustomer abc = new SendikaCustomer();
		abc.customerNumber = "9999";
		
		CustomerManager customerManager = new CustomerManager();
//		customerManager.add(hepsiBurada);
//		customerManager.add(tolga);
//		customerManager.add(abc);
		Customer[] customers = {hepsiBurada, tolga, abc};
		customerManager.addMultiple(customers);
		
	}

}
