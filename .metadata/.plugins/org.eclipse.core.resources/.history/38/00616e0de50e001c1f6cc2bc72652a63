package CoffeeShop;


import CoffeeShop.Abstract.BaseCustomerManager;
import CoffeeShop.Adapters.MernisServiceAdapter;
import CoffeeShop.Concrate.StarbucksCustomerManager;
import CoffeeShop.Entities.Customer;

public class Main {

	public static void main(String[] args) {
Customer customer1 = new Customer(1,"mert","yýlmaz",1998,"21788570806");
BaseCustomerManager customerManager =new StarbucksCustomerManager(new MernisServiceAdapter());		
customerManager.save(customer1);

	}

}
