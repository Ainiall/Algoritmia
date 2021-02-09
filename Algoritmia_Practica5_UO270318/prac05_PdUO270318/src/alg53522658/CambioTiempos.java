package alg53522658;

public class CambioTiempos {
	public static void main(String[] args) {
		Cambio c;
		long t1, t2;
		int nVeces = Integer.parseInt(args[0]);
		for (int n = 10000; n <= 1280000000; n *= 2) {
			c= new Cambio(nVeces);
			t1 = System.currentTimeMillis();

			for (int repeticiones = 1; repeticiones <= nVeces; repeticiones++) {
				c.getNumMonedas(n);
			}

			t2 = System.currentTimeMillis();
			System.out.println(n+"\t"+(t2-t1)+"\t");
		}

	}
}
