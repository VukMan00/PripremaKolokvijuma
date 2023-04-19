package rs.np.manojlovic_vuk.domenske_klase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SkijeTest {

	Skije s;
	
	@BeforeEach
	void setUp() throws Exception {
		s = new Skije();
	}

	@AfterEach
	void tearDown() throws Exception {
		s = null;
	}

	@Test
	void testSetMarkaModelSveOK() {
		s.setMarkaModel("Model 2");
		assertEquals("Model 2", s.getMarkaModel());
	}
	
	@Test
	void testSetMarkaModelNull() {
		assertThrows(NullPointerException.class, ()->s.setMarkaModel(null));
	}
	
	@Test
	void testSetMarkaModelVanOpsega() {
		assertThrows(IllegalArgumentException.class, ()->s.setMarkaModel("M"));
	}

	@Test
	void testSetDuzinaSveOK() {
		s.setDuzina(10);
		assertEquals(10, s.getDuzina());
	}
	
	@Test
	void testSetDuzinaVanGranicaKratko() {
		assertThrows(IllegalArgumentException.class, ()->s.setDuzina(-1));
	}
	@Test
	void testSetDuzinaVanGranicaDugacko() {
		assertThrows(IllegalArgumentException.class, ()->s.setDuzina(250));
	}
	
	@Test
	void testSetKolicinaSveOK() {
		s.setKolicina(10);
		assertEquals(10, s.getKolicina());
	}
	
	@Test
	void testSetKolicinaVanGranica() {
		assertThrows(IllegalArgumentException.class, ()->s.setKolicina(-1));
	}
	
	@Test
	void testSetKolicinaNula() {
		s.setKolicina(0);
		assertEquals(0, s.getKolicina());
	}
	
	@Test
	void testSetCenaSveOK() {
		s.setDuzina(10);
		assertEquals(10, s.getDuzina());
	}
	
	@Test
	void testSetCenaVanGranica() {
		assertThrows(IllegalArgumentException.class, ()->s.setCena(-1));
	}
	
	@Test
	void testSetCenaNula() {
		s.setCena(0);
		assertEquals(0, s.getCena());
	}
	
	@Test
	void testToString() {
		s.setCena(10);
		s.setDuzina(100);
		s.setKolicina(5);
		s.setMarkaModel("Marka 2");
		
		String potpis = s.toString();
		
		assertTrue(potpis.contains("10"));
		assertTrue(potpis.contains("100"));
		assertTrue(potpis.contains("5"));
		assertTrue(potpis.contains("Marka 2"));
	}
	
	@ParameterizedTest
	@CsvSource({
		"Marka1,100,Marka1,100,true",
		"Marka1,100,Marka2,100,false",
		"Marka1,100,Marka1,200,false",
		"Marka1,100,Marka2,200,false"
	})
	void testEquals(String markaModel1,int duzina1,String markaModel2,int duzina2,boolean isti) {
		s.setDuzina(duzina1);
		s.setMarkaModel(markaModel1);
		
		Skije s2 = new Skije();
		s2.setDuzina(duzina2);
		s2.setMarkaModel(markaModel2);
		
		assertEquals(isti, s.equals(s2));
	}
	
	@Test
	void testEqualsNull() {
		assertFalse(s.equals(null));
	}
	
	@Test
	void testEqualsIsti() {
		assertTrue(s.equals(s));
	}
}
