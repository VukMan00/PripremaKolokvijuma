package rs.np.manojlovic_vuk.sistemske_operacije;

import java.util.List;

import rs.np.manojlovic_vuk.domenske_klase.Skije;

/**
 * Predstavlja prodavnicu skija. Omogucava nabavku nabavku, prodaju skija.
 * 
 * @author Vuk Manojlovic
 *
 */
public interface SkiProdavnica {
	
	/**
	 * Dodavanje skija u prodavnicu.
	 * 
	 * Ukoliko dati par skija vec postoji u prodavnicu, njihova kolicina na stanju se 
	 * povecava kolicinu prosledjenog para skija.
	 * 
	 * Par skija takodje ne sme biti null
	 * 
	 * @param skije novi par skija koje se dodalju u prodavnicu
	 * 
	 * @throws NullPointerException ako su unete skije null
	 */
	public void nabaviSkije(Skije skije);
	
	/**
	 * Prodaja skija, odnosno skidanja kolicine na stanju skija.
	 * 
	 * @param skije skije koje treba prodati odnosno smanjiti kolicinu
	 * 
	 * @throws IllegalArgumentException ako skije koje su unete ne postoje u prodavnici
	 */
	public void prodajSkije(Skije skije);
	
	/**
	 * Vraca sve skije koje se nalaze u prodavnici 
	 * 
	 * @return lista svih skija u prodavnici
	 */
	public List<Skije> vratiSveSkije();
	
	/**
	 * Serijalizaje liste svih skija
	 * 
	 * @return String Json formata svih skija u prodavnici
	 */
	public String serijalizujJSON();
	
	/**
	 * Uzima jedan par objekta Skije iz Json fajla i dodaje u listu skija.
	 * 
	 * @param fajl putanja do fajla na kom se nalazi objekat Skije
	 */
	public void deserijalizujJSON(String fajl);

}
