package alg53522658.p4;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * Clase de prueba para Viajante busca los ficheros con los datos en la carpeta fichPrueba
 * que debería estar en el directorio de trabajo
 * Prueba tanto el método devorador1, como devorador2, 
 * desactivar las pruebas si no implementas el método
 */
class ViajanteTest {

	@Test
	public void testCaseOptimo4Devorador1() {
		String file = "fichPrueba/distancias04Opt.txt";
		int[] esperado= {0, 1, 2, 3, 0};
		int costeEsperado= 10;
    	Viajante v= new Viajante(file);
    	int coste= v.devorador1(0);
    	
    	assertEquals(costeEsperado,coste);
    	assertArrayEquals(esperado,v.getSol());
	}

//	@Test
//	public void testCaseOptimo4Devorador2() {
//		String file = "fichPrueba/distancias04Opt.txt";
//		int[] esperado= {0, 1, 2, 3, 0};
//		int costeEsperado= 10;
//    	Viajante v= new Viajante(file);
//    	int coste= v.devorador2();
//    	
//    	assertEquals(costeEsperado,coste);
//    	assertArrayEquals(esperado,v.getSol());
//	}

	@Test
	public void testCaseNoOptimo6Devorador1() {
		String file = "fichPrueba/distancias06noOpt.txt";
		int[] esperado= {0, 1, 2, 4, 3, 5, 0};
		int costeEsperado= 58;
    	Viajante v= new Viajante(file);
    	int coste= v.devorador1(0);
    	
    	assertEquals(costeEsperado,coste);
    	assertArrayEquals(esperado,v.getSol());
	}

//	@Test
//	public void testCaseNoOptimo6Devorador2() {
//		String file = "fichPrueba/distancias06noOpt.txt";
//		int[] esperado= {0, 1, 2, 4, 3, 5, 0};
//		int costeEsperado= 58;
//    	Viajante v= new Viajante(file);
//    	int coste= v.devorador2();
//    	System.out.println(Arrays.toString(v.getSol()));
//    	
//    	assertEquals(costeEsperado,coste);
//    	assertArrayEquals(esperado,v.getSol());
//	}

	@Test
	public void testCaseOptimo10Devorador1() {
		String file = "fichPrueba/distancias10Optb.txt";
		int[] esperado= {0 , 1 , 2 , 3 , 4 , 7 , 6 , 8 , 5 , 9 , 0};
		int costeEsperado= 257;
    	Viajante v= new Viajante(file);
    	int coste= v.devorador1(0);
    	System.out.println(Arrays.toString(v.getSol()));
    	
    	assertEquals(costeEsperado,coste);
    	assertArrayEquals(esperado,v.getSol());
	}

//	@Test
//	public void testCaseOptimo10Devorador2() {
//		String file = "fichPrueba/distancias10Opt.txt";
//		int[] esperado= {0, 1, 4, 2, 3, 8, 6, 5, 7, 9, 0};
//		int costeEsperado= 133;
//    	Viajante v= new Viajante(file);
//    	int coste= v.devorador2();
//    	System.out.println(Arrays.toString(v.getSol()));
//    	
//    	assertEquals(costeEsperado,coste);
//    	assertArrayEquals(esperado,v.getSol());
//	}

	@Test
	public void testCaseNoOptimo10Devorador1() {
		String file = "fichPrueba/distancias10noOpt.txt";
		int[] esperado= {0, 5, 2, 6, 4, 7, 9, 1, 8, 3, 0};
		int costeEsperado= 230;
    	Viajante v= new Viajante(file);
    	int coste= v.devorador1(0);
    	System.out.println(Arrays.toString(v.getSol()));
    	
    	assertEquals(costeEsperado,coste);
    	assertArrayEquals(esperado,v.getSol());
	}

//	@Test
//	public void testCaseNoOptimo10Devorador2() {
//		String file = "fichPrueba/distancias10noOpt.txt";
//		int[] esperado= {0, 3, 9, 7, 4, 8, 1, 6, 2, 5, 0};
//		int costeEsperado= 179;
//    	Viajante v= new Viajante(file);
//    	int coste= v.devorador2();
//    	System.out.println(Arrays.toString(v.getSol()));
//    	
//    	assertEquals(costeEsperado,coste);
//    	assertArrayEquals(esperado,v.getSol());
//	}
}
