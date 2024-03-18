package co.udea.sitas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SitasApplicationTests {

	@Test
	void contextLoads() {
		String prueba = "prueba";
		assertEquals("prueba", prueba);
	}

}
