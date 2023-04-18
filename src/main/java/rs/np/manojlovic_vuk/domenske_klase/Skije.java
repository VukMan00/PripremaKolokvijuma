package rs.np.manojlovic_vuk.domenske_klase;

import java.util.Objects;
/**
 * Predstavlja skije koje se nalaze u prodavnici.
 * Skije imaju marku i model, duzinu, kolicinu i cenu.
 * 
 * @author Vuk Manojlovic
 *
 */
public class Skije {
	
	/**
	 * Marka i Model skija kao String
	 */
	private String markaModel;
	/**
	 * Duzina skija u cm
	 */
	private int duzina;
	/**
	 * Kolicina skija na stanju
	 */
	private int kolicina;
	/**
	 * Cena skija u dinarima
	 */
	private int cena;

	/**
	 * Vraca marku i model skija
	 * 
	 * @return marka i model skija kao String
	 */
	public String getMarkaModel() {
		return markaModel;
	}

	/**
	 * Postavlja vrednost atributa marka i model skija.
	 *
	 * @param markaModel nova vrednost za atribut marka i model skija. Ne sme biti null ili kraci od 2 karaktera.
	 * 
	 * @throws NullPointerException ako je unesena vrednost markaModel null
	 * @throws IllegalArgumentException ako je unesena vrednost markaModel String sa 2 ili manje karaktera
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException();
		
		if (markaModel.length() < 2)
			throw new IllegalArgumentException();
		
		this.markaModel = markaModel;
	}

	/**
	 * Vraca duzinu skija
	 * 
	 * @return duzina skija u cm
	 */
	public int getDuzina() {
		return duzina;
	}

	/**
	 * Postavlja vrednost atributa duzine skija
	 * 
	 * @param duzina nova vrednost duzine skija. Duzina ne sme biti manja od nule ili veca od 225
	 * 
	 * @throws IllegalArgumentException ako je unesena vrednost manja od 0 ili veca od 225
	 */
	public void setDuzina(int duzina) {
		if (duzina < 0 || duzina > 225)
			throw new IllegalArgumentException();
		
		this.duzina = duzina;
	}

	/**
	 * Vraca kolicinu skija na stanju
	 * 
	 * @return kolicina skija
	 */
	public int getKolicina() {
		return kolicina;
	}

	/**
	 * Postavlja vrednost atributa kolicine skija
	 * 
	 * @param kolicina nova vrednost kolicine skija. Ne sme da bude manja od 0.
	 * 
	 * @throws IllegalArgumentException ako je unesena vrednost kolicine skija manja od 0
	 */
	public void setKolicina(int kolicina) {
		if (kolicina < 0)
			throw new IllegalArgumentException();	
			
		this.kolicina = kolicina;
	}

	/**
	 * Vraca cenu skija
	 * 
	 * @return cena skija u dinarima
	 */
	public int getCena() {
		return cena;
	}

	/**
	 * Postavlja vrednost atributa cena skija.
	 * 
	 * @param cena nova vrednost cene skija. Cena ne sme biti manja od 0.
	 * 
	 * @throws IllegalArgumentException ako je unesena vrednost cene skija manja od 0
	 */
	public void setCena(int cena) {
		if (cena < 0)
			throw new IllegalArgumentException();
		
		this.cena = cena;
	}

	@Override
	public String toString() {
		return "Skije [markaModel=" + markaModel + ", duzina=" + duzina + ", kolicina=" + kolicina + ", cena=" + cena
				+ "]";
	}

	/**
	 * Vraca hash code za skije. 
	 * Izracunava se preko atributa duzine i markaModel.
	 * 
	 * @return hash code izracunat na osnovu duzine,marke i modela
	 */
	@Override
	public int hashCode() {
		return Objects.hash(duzina, markaModel);
	}

	/**
	 * Poredi dva para skije preko atributa duzine i 
	 * marke i modela.
	 * 
	 * @param obj objekat skije sa kojim se uporedjuje
	 * 
	 * @return 
	 * <ul>
	 * <li>true - ako je uneti objekat isti, kao i kada su duzina i markaModel objekata isti</li>
	 * <li>false - ako je uneti objekat null, nije instance objekta Skije i duzina i markaModel objekata razlicita</li>
	 * </ul>
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skije other = (Skije) obj;
		return duzina == other.duzina && Objects.equals(markaModel, other.markaModel);
	}

}
