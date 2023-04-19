package rs.np.manojlovic_vuk.sistemske_operacije;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.np.manojlovic_vuk.domenske_klase.Skije;

public abstract class SkiProdavnicaTest {

	protected SkiProdavnica prodavnica;

	@Test
	void testNabaviSkijeSveOK() {
		Skije s = new Skije();
		s.setMarkaModel("Marka 2");
		s.setDuzina(100);
		
		prodavnica.nabaviSkije(s);
		
		List<Skije> skije = prodavnica.vratiSveSkije();
		
		assertEquals(1, skije.size());
		assertTrue(skije.contains(s));
	}
	
	@Test
	void testNabaviSkijePostoje() {
		Skije s = new Skije();
		s.setMarkaModel("Marka 2");
		s.setDuzina(100);
		s.setKolicina(1);
		
		prodavnica.nabaviSkije(s);
		prodavnica.nabaviSkije(s);
		
		List<Skije> skije = prodavnica.vratiSveSkije();
		assertEquals(1, skije.size());
		assertEquals(2, skije.get(0).getKolicina());
		assertTrue(skije.contains(s));
	}
	
	@Test
	void testNabaviSkijeNull() {
		assertThrows(NullPointerException.class, ()->prodavnica.nabaviSkije(null));
	}
	
	@Test
	void testProdajSkijeSveOK() {
		Skije s = new Skije();
		s.setMarkaModel("Marka 2");
		s.setDuzina(100);
		s.setKolicina(10);
		
		prodavnica.nabaviSkije(s);
		
		Skije s2 = new Skije();
		s2.setMarkaModel("Marka 2");
		s2.setDuzina(100);
		s2.setKolicina(8);
		
		prodavnica.prodajSkije(s2);
		
		List<Skije> skije = prodavnica.vratiSveSkije();
		assertEquals(2,skije.get(0).getKolicina());
		assertEquals(1, skije.size());
		assertTrue(skije.contains(s));
	}
	
	@Test
	void testProdajSkijeNePostoje() {
		Skije s = new Skije();
		s.setMarkaModel("Marka 2");
		s.setDuzina(100);
		s.setKolicina(10);
		prodavnica.nabaviSkije(s);
		
		Skije s1 = new Skije();
		s1.setMarkaModel("Marka 3");
		s1.setDuzina(200);
		s1.setKolicina(50);
		
		assertThrows(IllegalArgumentException.class, ()->prodavnica.prodajSkije(s1));
	}
	
	@Test
	void testSerijalizujJSONSveOK() {
		Skije s = new Skije();
		
		s.setMarkaModel("Atomic A1");
		s.setDuzina(180);
		s.setKolicina(56);
		s.setCena(12300);
		
		prodavnica.nabaviSkije(s);
		assertEquals("[{\"markaModel\":\"Atomic A1\",\"duzina\":180,\"kolicina\":56,\"cena\":12300}]",prodavnica.serijalizujJSON());
	}

	@Test
	void testDeserijalizujJSONSveOK() {		
		prodavnica.deserijalizujJSON("src/test/resources/proba.json");
		
		Skije s = new Skije();
		
		s.setMarkaModel("Atomic A1");
		s.setDuzina(180);
		s.setKolicina(56);
		s.setCena(12300);
		
		List<Skije> skije = prodavnica.vratiSveSkije();
		
		assertEquals(1, skije.size());
		assertTrue(s.equals(skije.get(0)));
		assertEquals(180, skije.get(0).getDuzina());		
		assertEquals(56, skije.get(0).getKolicina());		
		assertEquals(12300, skije.get(0).getCena());		
		assertEquals("Atomic A1", skije.get(0).getMarkaModel());		
	}
}
