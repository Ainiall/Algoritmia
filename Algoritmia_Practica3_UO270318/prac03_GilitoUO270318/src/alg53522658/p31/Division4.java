package alg53522658.p31;

public class Division4 {

	/**
	 * 
	 * Es un método recursivo POR DIVISION 
	 * Los parámetros son: a=4; b=3; k=2 Como
	 * a<b*k, la complejidad es O(n^k)
	 */

	static long cont;

	public static boolean rec4(int n) {
		if (n <= 0)
			cont++;
		else {
			for (int i = 1; i < n; i++) {
				for (int j = 1; j < i; j++) {
					cont++; // O(n^2) k=2
				}
			}
			rec4(n / 3);
			rec4(n / 3);
			rec4(n / 3);
			rec4(n / 3); // 4 subproblemas b=3
		}
		return true;
	}

	public static void main(String arg[]) {
		long t1, t2, cont;
		int nVeces = Integer.parseInt(arg[0]);
		boolean b = true;

		for (int n = 1; n <= 10000000; n *= 2) {
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
