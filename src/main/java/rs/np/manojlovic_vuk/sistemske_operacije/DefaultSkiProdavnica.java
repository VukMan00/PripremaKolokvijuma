package rs.np.manojlovic_vuk.sistemske_operacije;

import java.util.ArrayList;
import java.util.List;

import rs.np.manojlovic_vuk.domenske_klase.Skije;



public class DefaultSkiProdavnica implements SkiProdavnica {
	
	private List<Skije> sveSkije = new ArrayList<Skije>();

	@Override
	public void nabaviSkije(Skije skije) {
		if (skije == null)
			throw new NullPointerException();
		
		if (!sveSkije.contains(skije))
			sveSkije.add(skije);
		else {
			int indeks = sveSkije.indexOf(skije);
			
			Skije s = sveSkije.get(indeks);
			
			s.setKolicina(s.getKolicina() + skije.getKolicina());
		}
	}

	@Override
	public void prodajSkije(Skije skije) {
		if (!sveSkije.contains(skije))
			throw new IllegalArgumentException();
		
		int indeks = sveSkije.indexOf(skije);
		
		Skije s = sveSkije.get(indeks);
		
		s.setKolicina(s.getKolicina() - skije.getKolicina());
	}

	@Override
	public List<Skije> vratiSveSkije() {
		return sveSkije;
	}

}
