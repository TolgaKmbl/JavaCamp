package interfaces;

public class Utils {
	public static void runLoggers(Logger[] loggers, String message) {
		for(Logger logs : loggers) {
			logs.log(message);
		}
	}
}
