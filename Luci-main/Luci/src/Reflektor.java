/*
 * Reflektor.java
 * 
 * Opis:
 * Delo z reflektorji
 *
 * @author Karin Florjančič
 * @version Vaja 32 (vmesnik)
 */

/**
 * Javni razred ki razširja razred Light
 */
public class Reflektor extends Light implements NamenUporabe {
	
	
	// Vse lastnosti od nadrazreda se prenesejo
	// Deklarirmao dodatne zasebne lastnosti, ki so značilne le za pivske steklenice
	private double cena;
	private int velikost; // V metrih 
	private String VrstaReflektorja;
	
	
	// Statična lastnosti, ki je enaka vsem pivskim steklenicam (vsem objektom razreda - lasko, union in heineken)
	
	private static String tehnologja = "LED"; // Vsi reflektorji imajo LED tehnologijo
	
	/** Javni konstruktor za ustvarjanje novega objekta tipa/razreda Light
	 * @param v Velikost reflektorja
	 * @param u Namen uporabe reflektorja
	 * @return Nov objekt tipa reflektor
	 */
	 
	public Reflektor(double c, String u) {
	
		// Pokličem drug konstruktor tega istega razreda
		this(c, u, "gledališkiReflektor");
	
	}
	
	/** Javni konstruktor za ustvarjanje novega objekta tipa/razreda Steklenoica
	 * @param c Cena reflektorja
	 * @param u NamenUporabe
	 * @param v Velikost
	 * @return Nov objekt tipa reflektor
	 */
	 
	public Reflektor(double c, int v, String u, String ba, int b ) {
		
		
		// Pokličemo konstruktor od luči
		super(b, ba);
		
		// Inicializiramo še dodatne lastnosti podrazreda
		cena = c;
		velikost = v; 
		namenUporabe = u;
		
		// Izpišemo podatke
		System.out.println("Ta reflektor se uporablja za: " + u);
		
		// Inicializiramo privzet namen uporabe reflektorja
		namenUporabe = uporabaReflektorja;
		
	
	}
	
	/** Javna metoda, ki vrne ceno reflektorja
	 * @return Cena reflektorja
	 */
	public double getCena() {
		
		// Vrnemo ceno
		return cena;
	}
	
	
	 
	/** Javna metoda, ki vrne stopnjo alkohola
	 * @return Stopnja alkohola
	 */
	 public double getVrstaReflektorja() {
		 
		 // Vrnemo namen uporabe
		return vrstaReflektorja;
	 }
	 
}