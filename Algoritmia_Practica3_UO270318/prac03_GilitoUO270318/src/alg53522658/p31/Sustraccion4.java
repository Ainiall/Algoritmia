package alg53522658.p31;

public class Sustraccion4 {

	/**
	 * Los parametros son: a=3; b=2; k=1
	 * Luego la complejidad temporal es O(3^(n/2))
	 */

	static long cont;

	public static boolean rec4(int n) {
		if (n <= 0)
			cont++;
		else {
			for (int i = 1; i < n; i++) {
				cont++; // O(n) k=1
			}
			rec4(n - 2);
			rec4(n - 2);
			rec4(n - 2); // a=3 b=2
		}
		return true;
	}

	public static void main(String arg[]) {
		long t1, t2, cont;
		int nVeces = Integer.parseInt(arg[0]);
		boolean b = true;

		for (int n = 1; n <= 100; n++) {
			t1 = System.currentTimeMillis();

			for (int repeticiones = 1; repeticiones <= nVeces; repeticiones++) {
				cont = 0;
				b = rec4(n);
			}

			t2 = System.currentTimeMillis();
			System.out.println(b + " n=" + n + "**TIEMPO=" + (t2 - t1) + "**nVeces=" + nVeces);
		} // for
	} // main
} // class
