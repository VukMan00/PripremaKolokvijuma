package rs.np.manojlovic_vuk.sistemske_operacije;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class DefaultSkiProdavnicaTest extends SkiProdavnicaTest{

	@BeforeEach
	void setUp() throws Exception {
		prodavnica = new DefaultSkiProdavnica();
	}

	@AfterEach
	void tearDown() throws Exception {
		prodavnica = null;
	}
}
