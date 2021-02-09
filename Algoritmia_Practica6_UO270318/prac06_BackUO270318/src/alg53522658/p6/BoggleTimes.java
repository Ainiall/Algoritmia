package alg53522658.p6;

public class BoggleTimes {

    public static void main(String arg[]) {
	long t1, t2;
	String dictionaryFileName = "datos/dictionary80368.txt";
	for (int n = 1; n < Integer.MAX_VALUE; n++) {
	    Boggle problem = new Boggle(dictionaryFileName, n);
	    // In this case, instead of a board, a indicate the size and a
	    // random board should be created
	    t1 = System.currentTimeMillis();
	    problem.encontrarSoluciones();
	    t2 = System.currentTimeMillis();
	    System.out.println(
		    String.format("Tamaño: %d - Tiempo: %s ms - Puntos: %d", n,
			    t2 - t1, problem.getPuntosTotales()));
	}
    }
}