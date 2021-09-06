package CoffeeShop.Adapters;

import java.rmi.RemoteException;
import java.util.Locale;

import CoffeeShop.Abstract.CustomerCheckService;
import CoffeeShop.Entities.Customer;
import MernisServiceReference.KPSPublicSoapProxy;

public class MernisServiceAdapter implements CustomerCheckService{

	
	@Override
	public boolean checkIfRealPerson(Customer customer) {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		boolean result=true;
		try {
			result = client.TCKimlikNoDogrula(Long.parseLong(customer.getNationalId()),customer.getFirstName().toUpperCase(new Locale("tr")),
					customer.getLastName().toUpperCase(new Locale("tr")),customer.getDateOfBirth());
		
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
