package alg53522658.p4;

public class ViajanteTiempos {

	public static void main(String[] args) {
		Viajante v;
		long t1, t2;
		int nVeces = Integer.parseInt(args[0]);
		for (int n = 40; n <= 100000; n *= 2) {
			v= new Viajante(n,n);
			t1 = System.currentTimeMillis();

			for (int repeticiones = 1; repeticiones <= nVeces; repeticiones++) {
				v.devorador1(0);
			}

			t2 = System.currentTimeMillis();
			System.out.println(n+"\t"+(t2-t1)+"\t");
		}
//		long t3,t4;
//		for (int n = 40; n <= 100000; n *= 2) {
//			v= new Viajante(n,n);
//			t3 = System.currentTimeMillis();
//
//			for (int repeticiones = 1; repeticiones <= nVeces; repeticiones++) {
//				v.devorador2();
//			}
//
//			t4 = System.currentTimeMillis();
//			System.out.println(n+"\t"+(t4-t3)+"\t");
//		}
	}
}
