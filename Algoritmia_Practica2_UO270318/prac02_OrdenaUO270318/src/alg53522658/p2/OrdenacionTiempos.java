package alg53522658.p2;


public class OrdenacionTiempos {
	private static int nTam= 18; //tamaño a probar
	private static int nVeces= 1000;

	/** Este programa sirve para probar todos los algoritmos de ordenacion
	 * */
	public static void main (String arg []){
		String opcion= arg[0];
		
		int[] it = new int[nTam];
		int i= 0;
		for (int tam= 10000; tam<=Integer.MAX_VALUE && i<it.length; tam*= 2) {
			it[i]= tam;
			i++;
		}
//		int[] it = new int[] { 1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 256000, 512000, 1024000,
//				2048000, 4096000, 8192000, 16384000, 32768000, 65536000, 131072000, 262144000, 524288000 };
		int n = it[0];
		System.out.println("i= "+i);
		System.out.println(opcion);
		
		// Medir tiempo: Insercion
		//medirTiempos(new Insercion(n), it, opcion);
		
		// Medir tiempo: Seleccion
		//medirTiempos(new Seleccion(n), it, opcion);
		
		// Medir tiempo: Burbuja
		//medirTiempos(new Burbuja(n), it, opcion);
		
		// Medir tiempo: RapidoFatal
		//medirTiempos(new RapidoFatal(n), it, opcion);
		
		// Medir tiempo: RapidoCentral
		//medirTiempos(new RapidoCentral(n), it, opcion);
		
		// Medir tiempo: RapidoMediana
		medirTiempos(new RapidoMediana(n), it, opcion);
		

	}
	
	public static void medirTiempos(Vector v, int[] iteraciones, String opcion) {
		long t1,t2;
		
		System.out.println(" \n\nMedir tiempo: "+v.getNombre());
		System.out.println ("n   \tTiempo");
		for (int n : iteraciones) {
			v.inicializa(n);
			if (opcion.compareTo("ordenado")==0)
				v.ordenDirecto();
			else if (opcion.compareTo("inverso")==0)
				v.ordenInverso();
			else
				v.ordenAleatorio();

			
			t1 = System.currentTimeMillis();
			for (int repeticiones = 1; repeticiones <= nVeces; repeticiones++) {
				v.ordenar();
			}
			t2 = System.currentTimeMillis();

			System.out.println (n+"\t"+(t2-t1));
		}
	}
	
}
