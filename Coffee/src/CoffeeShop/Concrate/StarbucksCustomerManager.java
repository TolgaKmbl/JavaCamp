package CoffeeShop.Concrate;

import CoffeeShop.Abstract.BaseCustomerManager;
import CoffeeShop.Abstract.CustomerCheckService;
import CoffeeShop.Entities.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager{
private CustomerCheckService customerCheckService;

public StarbucksCustomerManager(CustomerCheckService customerCheckService) {
	super();
	this.customerCheckService = customerCheckService;
}

@Override
public void save(Customer customer) {
	if(customerCheckService.checkIfRealPerson(customer)) {
	super.save(customer);
	}
	else {
		System.out.println("Invaild Person !");
	}
}


	
}
