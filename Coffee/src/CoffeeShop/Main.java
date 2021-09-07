package CoffeeShop;


import CoffeeShop.Abstract.BaseCustomerManager;
import CoffeeShop.Adapters.MernisServiceAdapter;
import CoffeeShop.Concrete.NeroCustomerManager;
import CoffeeShop.Concrete.StarbucksCustomerManager;
import CoffeeShop.Entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class Main {

	public static void main(String[] args) {
		Customer customer1 = new Customer(1,"Tolga","Kümbül",1992,"12345789");
		BaseCustomerManager customerManager =new StarbucksCustomerManager(new MernisServiceAdapter());		
		customerManager.save(customer1);
		BaseCustomerManager customerManager2 =new NeroCustomerManager();
		customerManager2.save(customer1); // Does not check for the validity of a identity.
		

	}

}
