package rs.np.manojlovic_vuk.sistemske_operacije;

import java.util.List;

import rs.np.manojlovic_vuk.domenske_klase.Skije;


public interface SkiProdavnica {
	
	public void nabaviSkije(Skije skije);
	
	public void prodajSkije(Skije skije);
	
	public List<Skije> vratiSveSkije();

}
