package inheritance2;

public class CustomerManager {
	public void add(Logger logger) {
		// Müþteri ekleme kodlarý.
		System.out.println("Müþteri eklendi.");
//		DatabaseLogger logger = new DatabaseLogger();
		logger.log();
	}
}
