/*
 * ImplementcijaLight.java
 * 
 * Opis:
 * Program, ki v ukazno konzolo izpiše "Pozavljeni!"
 * V nadaljevanju služi prikazu delovanja razredov in objektov
 *
 * @author Karin Florjančič
 * @version Vaja 32 (vmesnik)
 */
 
 // Uvozimo vse razrede in pakete za delo z vhodno-izhodnimi napravami in pripomočki
 import java.io.*;
 import java.util.*;

/**
 * Javni razred za prikaz delovanja jave
 */
	public class ImplementacijaLight {
		
	// Deklariramo lastnost (objekt) za vnos iz konzole
	private static BufferedReader in;
	
	// Abstraktni seznam objektov razreda Reflektor
	private static ArrayList<Reflektor> Reflektorji;
	
	/** Javna statična metoda, ki se izvede ob zagonu programa
	 * @param args Seznam nizov (vhodnih argumentov), ki jih vnesemo ob zagonu programa
	 * @return Metoda ne vrača nič (ker je tipa void)
	 */
	 
		public static void main(String[] args) {
			
		// Inicializiramo statično lastnost za vnos iz tipkovnice
		// Konstruktor kot vhodni parameter prejme anonimni objekt razreda InputStreamreader
		in = new BufferedReader(new InputStreamReader(System.in));
		
		// Inicializiramo seznam reflektorjev
		Reflektorji = new ArrayList<Reflektor>();
		
		// Izpišemo pozdrav v konzolo
		System.out.println("Pozdravljeni!");
		
		// Ustvarimo dva objekta tipa/razreda Light
		Light modra = new Light(5, "Modra");
		Light bela = new Light(7, "Bela");
		
		
		// Lučem spremenimo barvo (kličemo metodo, ki spremeni barvo)
		try {
			String color = modra.spremeniBarvo("Bela");
			System.out.println("Barva luči je " + color);
		}
		catch (Exception e) {
			System.out.println("Barva luči se ni spremenila, zaradi: " + e.getMessage());
		}
		
		try {
			String color1 = bela.spremeniBarvo("Modra");
			System.out.println("Barva luči je " + color1);
		}
		catch (Exception e) {
			System.out.println("Barva luči se ni spremenila, zaradi: " + e.getMessage());
		}
		
		
		// prižgemo modro luč
			modra.turnOn();
			System.out.println();
		
		// Ustvarimo tri reflektorje
		Reflektor gledaliskiReflektor = new Reflektor(2000.0, "Modra");
		Reflektor zobozdravstveniReflektor = new Reflektor(1500.0, "Bela");
		Reflektor cestniReflektor = new Reflektor(1000.0, "Rumena");
		
		// Reflektorje dodamo v seznam
		Reflektorji.add(gledaliskiReflektor);
		Reflektorji.add(zobozdravstveniReflektor);
		Reflektorji.add(cestniReflektor);
		
		// Dodamo nov reflektor za nek drug namen uporabe
		Reflektorji.add(new Reflektor(2000.0, 5, "Gledališki reflektor", "Modra", 10));
		
		// Prižgemo vse reflektorje
		for(int c=0; c<Reflektorji.size(); c++) {
			
			if(Reflektorji.get(c).turnOn()) {
				
				System.out.println("Reflektor številka " + c + " je uspešno prižgana.");
			}
		}
		
		// Kličemo metodo, ki so bile deklarirane v nadrazredu
		try {
			System.out.println("Spremenili smo barvo na " + gledaliskiReflektor.spremeniBarvo("modra"));
		}
		catch(Exception e) {
			System.out.println("Prišlo je do napake pri menjanju barve gledaliskega reflektorja.");
		}
	
		
		
		
		// Luči menjamo jakost svetlobe
		
		int jakost = modra.changeBrightness(2);
		System.out.println("Jakost svetlobe luči je spremenjena na:" + jakost);
		
		// To je cena reflektorja
		double cr = 5000.0;
		
		try {
			System.out.print("Kolikšna naj bo cena reflektorja? ");
			
			String cenaReflektorja = in.readLine();
			cr = Double.parseDouble( cenaReflektorja );
		}
		catch( Exception e) {
			System.out.println("Verjetno se je zgodila napaka:" + e);
		}
	
		Reflektor nogometniReflektor = new Reflektor(cr, 10, "osvetljuje igrišče", "Bela", 10);
		double mojaCena = nogometniReflektor.getCena();
		System.out.println("Cena reflektorja znaša: " + mojaCena + " EUR.");
	
	}
} 