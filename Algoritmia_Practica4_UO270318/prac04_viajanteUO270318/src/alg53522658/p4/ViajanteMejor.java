package alg53522658.p4;

public class ViajanteMejor {

	// ejecute los dos heurísticos con varios problemas aleatorios de diversos tamaños 
	// y que compruebe cuál alcanza mejores soluciones. 
	public static void main(String[] args) {
							//nodos, distancia max	
		Viajante v1 = new Viajante(10, 10);
		Viajante v2 = new Viajante(100, 100);
		Viajante v3 = new Viajante(1000, 1000);
		Viajante v4 = new Viajante(10000, 10000);
		
		double coste11=0.0, coste12=0.0, coste13=0.0,coste14=0.0;
		double coste21=0.0, coste22=0.0, coste23=0.0,coste24=0.0;
		int n=10;
		for(int i=0;i< n;i++) {
			coste11 += v1.devorador1(0);
			coste12 += v2.devorador1(0);
			coste13 += v3.devorador1(0);
			coste14 += v4.devorador1(0);
			
			coste21 += v1.devorador2();
			coste22 += v2.devorador2();
			coste23 += v3.devorador2();
			coste24 += v4.devorador2();
		}
		System.out.println("COSTE MEDIO HEURISTICO1 V1: "+coste11/n);
		System.out.println("COSTE MEDIO HEURISTICO1 V2: "+coste12/n);
		System.out.println("COSTE MEDIO HEURISTICO1 V3: "+coste13/n);
		System.out.println("COSTE MEDIO HEURISTICO1 V4: "+coste14/n);
		System.out.println("---------------------------------------");
//		System.out.println("COSTE MEDIO HEURISTICO2 V1: "+coste21/n);
//		System.out.println("COSTE MEDIO HEURISTICO2 V2: "+coste22/n);
//		System.out.println("COSTE MEDIO HEURISTICO2 V3: "+coste23/n);
//		System.out.println("COSTE MEDIO HEURISTICO2 V4: "+coste24/n);
		

	}
	
}
