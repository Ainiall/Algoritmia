package alg53522658w.p12;

public class Bucle5 {

	public static long bucle5(int n) {
		// COMPLEJIDAD TOTAL: O(n^3 logn) QUASI CUBICA
		long cont = 0;
//		for (int i = 1; i <= n*n*n; i++)
//			for (int j = 1; j <= n; j*=2)
//				cont++;
	
		for (int i = 1; i <= n; i++)
			for (int j = n; j >= 0; j--)
				for (int k = 1; k <= n; k*=2)
					for(int l=n; l>=0; l--)
						cont++;
		return cont;

	}

	public static void main(String arg[]) {
		long c = 0;
		long t1, t2;
		int nVeces = Integer.parseInt(arg[0]);

		for (int n = 8; n <= 100000; n *= 2) {
			t1 = System.currentTimeMillis();

			for (int repeticiones = 1; repeticiones <= nVeces; repeticiones++) {
				c += bucle5(n);
			}

			t2 = System.currentTimeMillis();

			System.out.println(n + "\t" + (t2 - t1) + "\t" + c);

		} // for

	} // main
} // class