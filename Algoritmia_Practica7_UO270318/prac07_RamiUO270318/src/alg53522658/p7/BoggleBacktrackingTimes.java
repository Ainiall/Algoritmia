package alg53522658.p7;

public class BoggleBacktrackingTimes {
	public static void main(String arg[]) {
		long t1, t2;
		String dictionaryFileName = "datos/dicL1L2L3L4.txt";
		for (int n = 1; n < Integer.MAX_VALUE; n++) {
			BoggleBacktracking problem = new BoggleBacktracking(dictionaryFileName, n, 5, 5);
			t1 = System.currentTimeMillis();
			problem.findSolutions();
			t2 = System.currentTimeMillis();
			System.out.println(
					String.format("Tamaño: %d - Tiempo: %s ms - Puntos: %s", 
							n, t2 - t1, problem.getTotalPoints()));
		}
	}
}
