package alg53522658w.p12;

public class Bucle3 {

	public static long bucle3(int n)
	{
		//COMPLEJIDAD TOTAL: O(n^2)
		long cont = 0;
		for (int i = 1; i <= n; i++) 
			for (int j = 1; j <= i; j++) 
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
				c += bucle3(n);
			}

			t2 = System.currentTimeMillis();

			System.out.println(n+"\t"+(t2-t1)+"\t"+c);

		} // for

	} // main
} // class