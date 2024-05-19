/*
 * Light.java
 * 
 * Opis:
 * Delo z lučmi
 *
 * @author Karin Florjančič
 * @version Vaja 28 (javljanje izjem)
 */

/**
 * Javni razred za prikaz dela z razredi in objekti
 */
public class Light {
	
	// Deklariramo lastnosti luči
	private boolean lightOn;
	private boolean lightBlink;
	private String lightColor;
	private String lightShape;
	private int lightBrightness;
	 
	
	
	/** Javni konstruktor za ustvarjanje novega objekta tipa/razreda Steklenoica
	 * @param k Kapaciteta steklenice
	 * @param v Vrsta vsebine
	 * @return Nov objekt tipa steklenica
	 */
	 
	public Light(int b, String c) {
		
		// Inicializiramo lastnosti
		lightOn = true;
		lightBlink = false;
		lightColor = c;
		lightBrightness = b;
		
		// Izpišemo podatke
		System.out.println("Ustvarjam objekt tipa Light svetlosti " + b + ", " + c + " barve.");
	
	}
	
	/** Javna metoda, ki spremeni barvo
	 * @param c Barva, ki jo želimo spremeniti
	 * @return lightColor
	 */
	 
	 public String spremeniBarvo(String c) throws Exception {
		 
		 // Če je luč prižgana
		 if (lightOn) {
			 // Spremenimo barvo
			 System.out.println("Barva luči pred spreminjanjem barve: " + lightColor);
			 
			 lightColor = c;
	
			 System.out.println("Barva luči po spreminjanju barve: " + lightColor);
			 
			 // Vrnemo nazaj prvotno barvo
			return lightColor;
		 }
		 // Če je luč ugasnjena, vrne prazno vsebino
		 else {
			 throw new Exception("Ne morem menjati barve luči, ker je ugasnjena.");
		 }
		 
	 }
	 
	/** Javna metoda, ki prižge luč
	 * @return Vrne false, če je je bila luč že prižgana ali true, če je bila ugasnjena pred prižigom luči
	 */
	 
	 public boolean turnOn() {
		 // Če je luč že prižgana
		 if(lightOn) {
			 // Vrnemo false, ker je že prižgana
			 return false;
		 }
		 // Če je luč ugasnjena
		 else {
			 // Spremenimo lastnost (jo prižgemo)
			 lightOn = true;
			 // Vrnemo true (ker je bilo prižiganje uspešno)
			 return true;
		 }
	 }
	 
	  public boolean turnOff() {
		 // Če je luč prižgana
		 if(lightOn) {
			 // Jo ugasnemo
			 lightOn = false;
			 return true;
			 // Vrnemo false ker je že ugasnjena
		 } else {
			return false;
		}	
			}

	 
	 public int changeBrightness (int b) {
		 // Če je luč prižgana 
		 if (lightOn) {
			 // Spremeni jakost svetobe
			 System.out.println("Jakost svetosti luči pred spreminjanjem svetlosti: " + lightBrightness);
			 
			 lightBrightness = b;
			 
			 System.out.println("jakost svetlosti luči po spreminjanju svetlosti: " + lightBrightness);
			 //Vrnemo
			 return lightBrightness;
		 }
		 // Če je luč ugasnjena
		 else {
			 System.out.println("Ne moremo menjati svetlosti, ker je luč ugasnjena.");
			 return 0;
	
		 }
	 }
	 
	 
	/** Javna metoda, ki vrne svetlost
	 * @return Vrne nivo svetlosti luči
	 */
	 
	 public int getlightBrightness() {
		 // Vrnemo nivo svetlosti luči
		 return lightBrightness;
	 }
}