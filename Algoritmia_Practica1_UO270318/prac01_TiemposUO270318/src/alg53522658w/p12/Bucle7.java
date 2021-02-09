package alg53522658w.p12;

public class Bucle7 {

	public static long bucle7(int n) {
		// COMPLEJIDAD TOTAL: O(logn * logn)
		long cont = 0;
		for (int i = 1; i <= n; i*=2)
			for (int j = 1; j <= n; j*=2)
				cont++;
	
		return cont;

	}
}
