package alg53522658.p31;

/**
 * Clase que modeliza T(n)= T(n-1) + O(n) La complejidad temporal es cuadrática
 * O(n^2) y el gasto de pila es Mpila=O(n) En consecuencia la pila se desborda
 */
//a=1, b=1, k=1 -> O(n^2)
public class Sustraccion2 {

	static long cont;

	public static boolean rec2(int n) {
		if (n <= 0)
			cont++;
		else {
			for (int i = 0; i < n; i++)
				cont++; // O(n) k=1
			rec2(n - 1); //a=1, b=1
			for (int i = 0; i < n; i++)
				cont++; // O(n) k=1
		}
		return true;
	}

	public static void main(String arg[]) {
		long t1, t2, cont;
		int nVeces = Integer.parseInt(arg[0]);
		boolean b = true;
		for (int n = 1; n <= 100000; n *= 2) {
			t1 = System.currentTimeMillis();

			for (int repeticiones = 1; repeticiones <= nVeces; repeticiones++) {
				cont = 0;
				b = rec2(n);
			}

			t2 = System.currentTimeMillis();

			System.out.println(b + " n=" + n + "**TIEMPO=" + (t2 - t1) + "**nVeces=" + nVeces);
		} // for
	} // main
} // class