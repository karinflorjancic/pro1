/*
 * Miza.java
 * 
 * Opis:
 * Program, za prikaz delovanja GUI na primeru razredov poslovne logike
 * na primeru razredov poslovne logike Steklenica in PivskaSteklenica
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
  * @version Primer 20  (GUI)
 */

public class Miza extends JFrame implements ActionListener {

	// Deklaracija zasebnih lastnosti
	private JPanel povrsina;
	private JButton dodajButton;
	private JTextField znamkaVnos;
	private JTextField alkoholVnos;
	private JTable stekleniceTable;
	private PivskaSteklenicaTableModel modelTabele;
	
	
	
	/** Javna statična metoda, ki se izvede ob zagonu programa
	 * @param args Seznam nizov (vhodnih argumentov), ki jih vnesemo ob zagonu programa
	 */
	 
	public static void main(String[] args) {
	
		// Izpišemo pozdrav v konzolo
		System.out.println("Zaganjam GUI...");
		
		// Ustvarjamo objekt tipa miza (kličemo konstruktor razreda miza)
		Miza m = new Miza();
	}
		
	// Javni konstruktor za ustvarjanje novega okna s prikazom steklenic
	
	public Miza() {
		
		// Pokličemo konstruktor nadrazreda
		super("Miza s steklenicami");
		
		// Nastavimo obnašanje križca (x) tako, da konča aplikacijo
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Nastavimo velikost okna
		setSize(800, 600);
		
		// Inicializiramo lastnosti
		povrsina = new JPanel();
		dodajButton = new JButton("Dodaj steklenico");
		znamkaVnos = new JTextField(32);
		alkoholVnos = new JTextField(4);
		modelTabele = new PivskaSteklenicaTableModel();
		tabela = new JTable(modelTabele);
		
		// Gumbu za dodajanje dodamo action listener
		dodajButton.addActionListener(this);
		
		// Na površino dodamo vnosna polja
		povrsina.add(new JLabel("Znamka:"));
		povrsina.add(znamkaVnos);
		povrsina.add(new JLabel("Stopnja alkohola:"));
		povrsina.add(alkoholVnos);
		
		// Gumb dodamo na površino
		povrsina.add(dodajButton);
		
		// Na površino dodamo tabelo
		povrsina.add(tabela);
	
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
			 System.out.println("Dodajam steklenico...");
			 System.out.println("Znamka:"  + znamkaVnos.getText());
			 System.out.println("Stopnja alkohola: " + alkoholVnos.getText());
			 
			 // Ustvarimo spremenljivko za stopnjo alkohola
			 double sa = Double.parseDouble(alkoholVnos.getText());
			 
			// Ustvarimo objekt tipa pivska stekelnica
			PivskaSteklenica nova = new PivskaSteklenica(znamkaVnos.getText(), 500);
			
			// Pivsko steklenico dodamo v model tabele
			modelTabele.addPivskaSteklenica(nova);
		 }
	}
