package CoffeeShop.Abstract;

import CoffeeShop.Entities.Customer;

public interface CustomerCheckService {
boolean checkIfRealPerson(Customer customer);
}
