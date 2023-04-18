package rs.np.manojlovic_vuk.sistemske_operacije;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

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

	@Override
	public String serijalizujJSON() {
		Gson gson = new Gson();
		return gson.toJson(sveSkije);
	}

	@Override
	public void deserijalizujJSON(String fajl) {
		try(FileReader in = new FileReader(fajl)){
			Gson gson = new Gson();
			Skije skija = gson.fromJson(in, Skije.class);
			nabaviSkije(skija);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
