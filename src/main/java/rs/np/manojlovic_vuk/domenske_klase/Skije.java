package rs.np.manojlovic_vuk.domenske_klase;

import java.util.Objects;

public class Skije {
	
	private String markaModel;
	
	private int duzina;
	
	private int kolicina;
	
	private int cena;

	public String getMarkaModel() {
		return markaModel;
	}

	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException();
		
		if (markaModel.length() < 2)
			throw new IllegalArgumentException();
		
		this.markaModel = markaModel;
	}

	public int getDuzina() {
		return duzina;
	}

	public void setDuzina(int duzina) {
		if (duzina < 0 || duzina > 225)
			throw new IllegalArgumentException();
		
		this.duzina = duzina;
	}

	public int getKolicina() {
		return kolicina;
	}

	public void setKolicina(int kolicina) {
		if (kolicina < 0)
			throw new IllegalArgumentException();	
			
		this.kolicina = kolicina;
	}

	public int getCena() {
		return cena;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(duzina, markaModel);
	}

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
