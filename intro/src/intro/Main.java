package intro;

public class Main {

	public static void main(String[] args) {
		
		String internetSubeButonu = "�nternet �ubesi";
		double dolarDun = 7.69;
		double dolarBugun = 8.18;
		int vade = 36;
		boolean dustuMu = false;
		
		if (dolarBugun > dolarDun) {
			System.out.println("Y�kseldi");
		} else if (dolarBugun < dolarDun) {
			System.out.println("D��t�");			
		}
		else {
			System.out.println("E�it");
		}
		
		System.out.println("Hello world");
		System.out.println(internetSubeButonu);
		System.out.println(dolarDun);
		System.out.println(vade);
		System.out.println(dustuMu);
		
		String[] krediler = {"Kredi 1", "Kredi 2", "Kredi 3"};
		
		for(String kredi : krediler) {
			System.out.println(kredi);
		}
		
		for(int i = 0; i<krediler.length; i++) {
			System.out.println(krediler[i]);
		}

	}

}
