package alg53522658.p6;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BoggleTest {

    
	@Test
	public void testCase01() {
		String dictionaryFileName = "datos/dictionary80368.txt";
		String tableFileName = "datos/table01.txt";
				
    	Boggle problem = new Boggle(dictionaryFileName, tableFileName); //The input needs the dictionary and the board files
    	problem.imprimirTablero(); //To print the board game
    	problem.encontrarSoluciones(); //To execute the main algorithm (backtracking in this case)
    	problem.imprimirSoluciones(); //To print the list of words sorted alphabetically in ascending order
    	
    	assertEquals(0, problem.getSoluciones().size()); //In this case, there are no solutions
    	assertEquals(0, problem.getPuntosTotales()); //So, total points should be 0
	}
	
	@Test
	public void testCase02() {
		String dictionaryFileName = "datos/dictionary80368.txt";
		String tableFileName = "datos/table02.txt";
				
    	Boggle problem = new Boggle(dictionaryFileName, tableFileName);
    	
    	problem.imprimirTablero();
    	problem.encontrarSoluciones();
    	problem.imprimirSoluciones();
    	
    	assertEquals(12, problem.getSoluciones().size());
    	assertEquals("ups", problem.getSoluciones().get(10)); //Since solutions are sorted, we should be sure that in position 10 the word is "us"
    	assertEquals(19, problem.getPuntosTotales());
	}

	@Test
	public void testCase03() {
		String dictionaryFileName = "datos/dictionary80368.txt";
		String tableFileName = "datos/table03.txt";
				
    	Boggle problem = new Boggle(dictionaryFileName, tableFileName);
    	problem.imprimirTablero();
    	problem.encontrarSoluciones();
    	problem.imprimirSoluciones();
    	
    	assertEquals(32, problem.getSoluciones().size());
    	assertEquals("sum", problem.getSoluciones().get(28));
    	assertEquals(84, problem.getPuntosTotales());
	}
	
	@Test
	public void testCase04() {
		String dictionaryFileName = "datos/dictionary80368.txt";
		String tableFileName = "datos/table04.txt";
				
    	Boggle problem = new Boggle(dictionaryFileName, tableFileName);
    	
    	problem.imprimirTablero();
    	problem.encontrarSoluciones();
    	problem.imprimirSoluciones();
    	
    	assertEquals(65, problem.getSoluciones().size());
    	assertEquals("tog", problem.getSoluciones().get(61));
    	assertEquals(160, problem.getPuntosTotales());
	}
	
	@Test
	public void testCase05() {
		String dictionaryFileName = "datos/dictionary80368.txt";
		String tableFileName = "datos/table05.txt";
				
    	Boggle problem = new Boggle(dictionaryFileName, tableFileName);
    	
    	problem.imprimirTablero();
    	problem.encontrarSoluciones();
    	problem.imprimirSoluciones();
    	
    	assertEquals(173, problem.getSoluciones().size());
    	assertEquals("thou", problem.getSoluciones().get(157));
    	assertEquals(682, problem.getPuntosTotales());
	}
	
	@Test
	public void testCase15() {
		String dictionaryFileName = "datos/dictionary80368.txt";
		String tableFileName = "datos/table15.txt";
				
    	Boggle problem = new Boggle(dictionaryFileName, tableFileName);
    	
    	problem.imprimirTablero();
    	problem.encontrarSoluciones();
    	problem.imprimirSoluciones();
    	
    	assertEquals(957, problem.getSoluciones().size());
    	assertEquals("zee", problem.getSoluciones().get(953));
    	assertEquals(4006, problem.getPuntosTotales());
	}
	
	@Test
	public void testCase46() {
		String dictionaryFileName = "datos/dictionary80368.txt";
		String tableFileName = "datos/table46.txt";
				
    	Boggle problem = new Boggle(dictionaryFileName, tableFileName);
    	
    	problem.imprimirTablero();
    	problem.encontrarSoluciones();
    	problem.imprimirSoluciones();
    	
    	assertEquals(6777, problem.getSoluciones().size());
    	assertEquals("zetas", problem.getSoluciones().get(6749));
    	assertEquals(40802, problem.getPuntosTotales());
	}
	
	@Test
	public void testCase100() {
		String dictionaryFileName = "datos/dictionary100.txt";
		String tableFileName = "datos/table100.txt";
				
    	Boggle problem = new Boggle(dictionaryFileName, tableFileName);
    	
    	problem.imprimirTablero();
    	problem.encontrarSoluciones();
    	problem.imprimirSoluciones();
    	
    	assertEquals(91, problem.getSoluciones().size());
    	assertEquals("your", problem.getSoluciones().get(90));
    	assertEquals(314, problem.getPuntosTotales());
	}
	
	
	@Test
	public void testCase205() {
		String dictionaryFileName = "datos/dictionary100.txt";
		String tableFileName = "datos/table205.txt";
				
    	Boggle problem = new Boggle(dictionaryFileName, tableFileName);
    	
    	problem.imprimirTablero();
    	problem.encontrarSoluciones();
    	problem.imprimirSoluciones();
    	
    	assertEquals(96, problem.getSoluciones().size());
    	assertEquals("your", problem.getSoluciones().get(95));
    	assertEquals(349, problem.getPuntosTotales());
	}

	
	@Test
	public void testCase205_2() {
		String dictionaryFileName = "datos/dictionary80368.txt";
		String tableFileName = "datos/table205.txt";
				
    	Boggle problem = new Boggle(dictionaryFileName, tableFileName);
    	
    	problem.imprimirTablero();
    	problem.encontrarSoluciones();
    	problem.imprimirSoluciones();
    	
    	assertEquals(32650, problem.getSoluciones().size());
    	assertEquals("zorils", problem.getSoluciones().get(32631));
    	assertEquals(282921, problem.getPuntosTotales());
	}
	
	@Test
	public void testCase500() {
		String dictionaryFileName = "datos/dictionary80368.txt";
		String tableFileName = "datos/table500.txt";
				
    	Boggle problem = new Boggle(dictionaryFileName, tableFileName);
    	
    	problem.imprimirTablero();
    	problem.encontrarSoluciones();
    	problem.imprimirSoluciones();
    	
    	assertEquals(58368, problem.getSoluciones().size());
    	assertEquals("zymase", problem.getSoluciones().get(58355));
    	assertEquals(603192, problem.getPuntosTotales());
	}
	
	@Test
	public void testCase1000() {
		String dictionaryFileName = "datos/dictionary80368.txt";
		String tableFileName = "datos/table1000.txt";
				
    	Boggle problem = new Boggle(dictionaryFileName, tableFileName);
    	
    	problem.imprimirTablero();
    	problem.encontrarSoluciones();
    	problem.imprimirSoluciones();
    	
    	assertEquals(75141, problem.getSoluciones().size());
    	assertEquals("zymosis", problem.getSoluciones().get(75136));
    	assertEquals(844340, problem.getPuntosTotales());
	}
	
}
