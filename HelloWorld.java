/*
 * HelloWorld.java
 * 
 * Opis:
 * Program, ki v ukazno konzolo izpiše "Pozdravljen, svet!"
 * V nadaljevanju služi prikazu delovanja razredov in objektov
 *
 * @author Karin Florjančič
 * @version Primer 19a  (vmesnik)
 */
 
 // Uvozimo vse razrede iz pakete za delo z vhodno-izhodnimi napravami in pripomočki
 import java.util.*;
 import java.io.*;

/**
 * Javni razred za prikaz delovanja jave
 */
public class HelloWorld {
	
	// Deklariramo statične lastnosti
	
	// Objekt za vnos iz konzole
	private static BufferedReader in;
	
	// Abstraktni seznam objektov razreda PivskaSteklenica
	private static ArrayList<PivskaSteklenica> PivskeSeklenice;
	
	/** Javna statična metoda, ki se izvede ob zagonu programa
	 * @param args Seznam nizov (vhodnih argumentov), ki jih vnesemo ob zagonu programa
	 * @return Metoda ne vrača nič (ker je tipa void)
	 */
	 
	public static void main(String[] args) {
		
		// Inicializiramo statično lastnost za vnos iz tipkovnice
		// Konstruktor kot vhodni parameter prejme anonimni objekt razreda InputStreamreader
		in = new BufferedReader(new InputStreamReader(System.in));
		
		// Inicializiramo seznam pivskih steklenic
		PivskeSeklenice = new ArrayList<>();
		
		// Izpišemo pozdrav v konzolo
		System.out.println("Pozdravljen, svet!");
		
		// Ustvarimo dva objekta tipa/razreda Steklenica
		Steklenica zganje = new Steklenica(50, "Žganje");
		Steklenica voda = new Steklenica(500, "Voda");
		
		// Deklariramo in inicializiramo spremenljivko za količino vode
		int kv = 0;
		
		
		// Poskusimo prebrati niz s tipkovnico
		try {
			System.out.print("Koliko vode naj natočim v kozarec?");
			
			// Niz, vnešen preko tipkovnce, preberemo v spremenljivko
			String kolicinaVode = in.readLine();
			
			// Niz zapišemo v celo število
			kv = Integer.parseInt(kolicinaVode);
			
			System.out.print("V kozarec bom natočil " + kolicinaVode + " ml vode.");
		}
		catch(Exception e) {
			System.out.println("Prišlo je do napake pri vnosu: " + e);
		}
		
		
		// Iz steklenice za vodo poskusimo izprazniti toliko, kot smo vnesli v konzoli 
		// (kličemo metodo izprazni objekta voda)
		try {
		voda.odpri();
		String vsebinaKozarca = voda.izprazni(kv);
		System.out.println("Vsebina kozarca je " + vsebinaKozarca);
		}
		catch(Exception e) {
			System.out.println("Prišlo je do napake pri praznenju steklenice: " + e);
		}
		
		// Odpremo steklenico z žganjem
		zganje.odpri();
		
		// Iz steklenice z žganjem poskusimo narediti požirek
		try {
			String pozirek = zganje.izprazni(20);
			System.out.println("Naredili smo požirek " + pozirek);
		}
		catch(Exception e) {
			System.out.println("Prišlo je do napake pri praznenju steklenice žganja: " + e);
		}
		
		// Ustvarjamo tri pivske steklenice
		PivskaSteklenica velikoLasko = new PivskaSteklenica("Lasko", 500);
		PivskaSteklenica maliUnion = new PivskaSteklenica("Union", 330);
		PivskaSteklenica heineken = new PivskaSteklenica("Heineken", 330);
		
		// Steklenice dodamo v seznam
		PivskeSeklenice.add(velikoLasko);
		PivskeSeklenice.add(maliUnion);
		PivskeSeklenice.add(heineken);
		
		// Dodamo novo brezalkoholno pivo
		PivskeSeklenice.add(new PivskaSteklenica("laško Malt", 500, 0.0));
		
		// Odpremo vse tsteklenice v seznamu
		for(int c=0; c<PivskeSeklenice.size(); c++) {
			
			if(PivskeSeklenice.get(c).odpri()) {
				System.out.println("Stekklenica st. " + c + " uspešno odprta.");
			}
		}
		
		// Kličemo metode, ki so bile deklarirane že v nadrazredu
		try {
	//		velikoLasko.odpri();
			System.out.println("Naredili smo požirek " + velikoLasko.izprazni(50));
		}
		catch(Exception e) {
			System.out.println("Prišlo je do napake pri praznenju steklenice Laškeg: " + e);
		}
	}
} 