package alg53522658.p7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BoggleTest {
	@Test
	public void testAlg00() {
		String dictionaryFileName = "datos/dictionary80368.txt";
		String tableFileName = "datos/table02.txt";

		int numberOfTimesAWordCanBeConcanetaded = 3;
		int numberOfTimesACellCanBeRepeated = 3;
		BoggleBacktracking problem = new BoggleBacktracking(dictionaryFileName, numberOfTimesAWordCanBeConcanetaded,
				numberOfTimesACellCanBeRepeated, tableFileName); // The input needs the dictionary and the board files

		problem.printTable(); // To print the board game
		problem.findSolutions(); // To execute the main algorithm (backtracking in this case)
		problem.printSolutions(); // To print the list of words sorted alphabetically in ascending order

		assertEquals(20, problem.getSolutions().size()); // In this case, there are no solutions
		assertEquals(380, problem.getTotalPoints()); // So, total points should be 0
	}

	@Test
	public void testAlg01() {
		String dictionaryFileName = "datos/dicL1L2L3L4.txt";
		String tableFileName = "datos/table04.txt";

		int numberOfTimesAWordCanBeConcanetaded = 5;
		int numberOfTimesACellCanBeRepeated = 5;
		BoggleBacktracking problem = new BoggleBacktracking(dictionaryFileName, numberOfTimesAWordCanBeConcanetaded,
				numberOfTimesACellCanBeRepeated, tableFileName);

		problem.printTable();
		problem.findSolutions();
		problem.printSolutions();

		assertEquals(71, problem.getSolutions().size());
		assertEquals("aa", problem.getSolutions().firstKey());
		assertEquals("um", problem.getSolutions().lastKey());
		assertEquals(2626, problem.getTotalPoints());
	}
	
	
	@Test
	public void testAlg02() {
		String dictionaryFileName = "datos/dicL1L2L3L4.txt";
		String tableFileName = "datos/table04.txt";

		int numberOfTimesAWordCanBeConcanetaded = 5;
		int numberOfTimesACellCanBeRepeated = 5;
		BoggleBacktracking problem = new BoggleBacktracking(dictionaryFileName, numberOfTimesAWordCanBeConcanetaded,
				numberOfTimesACellCanBeRepeated, tableFileName);

		problem.printTable();
		problem.findSolutions();
		problem.printSolutions();
		problem.findBestSolution();

		assertEquals("aim=258", problem.getBestSolution());
	}
}
