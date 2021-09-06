package interfaces;

public class Main {

	public static void main(String[] args) {

		CustomerManager customerManager = new CustomerManager(new Logger[] {new SmsLogger(), new EmailLogger(), new DatabaseLogger()});				
		
		Customer tolga = new Customer(1, "Tolga", "Kümbül");
		
		customerManager.add(tolga);

	}

}
