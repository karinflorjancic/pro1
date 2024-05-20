/*
 * Miza.java
 * 
 * Opis:
 * Program, za prikaz delovanja GUI na primeru razredov poslovne logike
 * na primeru razredov poslovne logike Reflektorji in Namen uporabe 
 *
 */
 
 // Uvozimo vse razrede iz pakete za delo z vhodno-izhodnimi napravami, GUI in pripomočki
 import java.util.*;
 import java.io.*;
 import javax.swing.*;
 import java.awt.event.*;
 
 /**
  * Javni razred za zagon uporabniškega vmesnika
  *
  * @author Karin Florjančič
  * @version Vaja 35  (GUI)
 */

public class Prostor extends JFrame implements ActionListener {

	// Deklaracija zasebnih lastnosti
	private JPanel povrsina;
	private JButton dodajButton;
	private JTextField vrstaReflektorjaVnos;
	private JTextField barvaReflektorjaVnos;
	private JTable reflektorjiTable;
	
	
	
	/** Javna statična metoda, ki se izvede ob zagonu programa
	 * @param args Seznam nizov (vhodnih argumentov), ki jih vnesemo ob zagonu programa
	 */
	 
	public static void main(String[] args) {
	
		// Izpišemo pozdrav v konzolo
		System.out.println("Zaganjam GUI...");
		
		// Ustvarjamo objekt tipa miza (kličemo konstruktor razreda miza)
		Prostor nahajanjeReflektorja = new Prostor();
	}
		
	// Javni konstruktor za ustvarjanje novega okna s prikazom Reflektorjev
	
	public Prostor() {
		
		// Pokličemo konstruktor nadrazreda
		super("Prostor z reflektorji");
		
		// Nastavimo obnašanje križca (x) tako, da konča aplikacijo
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Nastavimo velikost okna
		setSize(800, 600);
		
		// Inicializiramo lastnosti
		povrsina = new JPanel();
		dodajButton = new JButton("Dodaj reflektor");
		vrstaReflektorjaVnos = new JTextField(32);
		barvaReflektorjaVnos = new JTextField(4);
		
		// Gumbu za dodajanje dodamo action listener
		dodajButton.addActionListener(this);
		
		// Na površino dodamo vnosna polja
		povrsina.add(new JLabel("Vrsta reflektorja:"));
		povrsina.add(vrstaReflektorjaVnos);
		povrsina.add(new JLabel("Barva reflektorja"));
		povrsina.add(barvaReflektorjaVnos);
		
		// Gumb dodamo na površino
		povrsina.add(dodajButton);
		
		// Povrsino dodamo na okno
		add(povrsina);
		
		// Napravimo okno vidno
		setVisible(true);
	}
	
		/**
		 * Metoda, ki izvaja aktivnosti glede na dogodke
		 * @param e Dogodek, ki je sprožil, klical metodo
		 */
		public void actionPerformed(ActionEvent e) {
			 
			 // Izpišemo indikator klika gumba
			 System.out.println("Dodajam reflektor...");
			 System.out.println("Vrsta:"  + vrstaReflektorjaVnos.getText());
			 System.out.println("Barva reflektorja: " + barvaReflektorjaVnos.getText());
		 }
	}
