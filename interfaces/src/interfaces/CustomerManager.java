package interfaces;

public class CustomerManager {
	
	private Logger[] loggers;
	
	public CustomerManager(Logger[] loggers) {
		this.loggers = loggers;
	}

	public void add(Customer customer) {
		System.out.println("Müþteri eklendi " + customer.getFirstName());	
		Utils.runLoggers(loggers, customer.getFirstName());
//		for(Logger logs : loggers) {
//			logs.log(customer.getFirstName());
//		}
//		this.logger.log(customer.getFirstName());
	}
	
	public void delete(Customer customer) {
		System.out.println("Müþteri silindi " + customer.getFirstName());
		Utils.runLoggers(loggers, customer.getLastName());
//		for(Logger logs : loggers) {
//			logs.log(customer.getFirstName());
//		}
//		this.logger.log(customer.getFirstName());
	}
}
