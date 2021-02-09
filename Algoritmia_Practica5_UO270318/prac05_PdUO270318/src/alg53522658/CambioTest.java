package alg53522658;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CambioTest {

	@Test
	void testCaso01() {
		String file = "fichPrueba/caso01.txt";
		int[] esperado= {1, 2, 1};
		int numMonedasEsperado= 4;
    	Cambio c1= new Cambio(file);
    	int numMonedas= c1.getNumMonedas(15);
    	
    	assertEquals(numMonedasEsperado,numMonedas);
    	assertArrayEquals(esperado,c1.getMejoresMonedas());
	}

	@Test
	void testCaso02() {
		String file = "fichPrueba/caso02.txt";
		int[] esperado= {0, 0, 3, 0, 0, 0};
		int numMonedasEsperado= 3;
    	Cambio c1= new Cambio(file);
    	int numMonedas= c1.getNumMonedas(60);
    	
    	assertEquals(numMonedasEsperado,numMonedas);
    	assertArrayEquals(esperado,c1.getMejoresMonedas());
	}

	@Test
	void testCaso03() {
		String file = "fichPrueba/caso03.txt";
		int[] esperado= {0, 0, 3, 0, 0, 0, 0, 0};
		int numMonedasEsperado= 3;
    	Cambio c1= new Cambio(file);
    	int numMonedas= c1.getNumMonedas(15);
    	
    	assertEquals(numMonedasEsperado,numMonedas);
    	assertArrayEquals(esperado,c1.getMejoresMonedas());
	}

	@Test
	void testCaso04() {
		String file = "fichPrueba/caso04.txt";
		int[] esperado= {0, 0, 1, 1, 0};
		int numMonedasEsperado= 2;
    	Cambio c1= new Cambio(file);
    	int numMonedas= c1.getNumMonedas(15);
    	
    	assertEquals(numMonedasEsperado,numMonedas);
    	assertArrayEquals(esperado,c1.getMejoresMonedas());
	}

	@Test
	void testCaso05() {
		String file = "fichPrueba/caso05.txt";
		int[] esperado= {0, 2, 1, 1, 1, 1, 0, 1};
		int numMonedasEsperado= 7;
    	Cambio c1= new Cambio(file);
    	int numMonedas= c1.getNumMonedas(289);
    	
    	assertEquals(numMonedasEsperado,numMonedas);
    	assertArrayEquals(esperado,c1.getMejoresMonedas());
	}

}
