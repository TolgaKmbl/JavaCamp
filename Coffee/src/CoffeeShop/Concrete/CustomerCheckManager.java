package CoffeeShop.Concrate;

import CoffeeShop.Abstract.CustomerCheckService;
import CoffeeShop.Entities.Customer;

public class CustomerCheckManager implements CustomerCheckService{

	@Override
	public boolean checkIfRealPerson(Customer customer) {
		
		return true;
	}

}
