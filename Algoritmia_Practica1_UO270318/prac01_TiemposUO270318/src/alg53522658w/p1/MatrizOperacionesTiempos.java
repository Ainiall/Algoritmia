package alg53522658w.p1;


public class MatrizOperacionesTiempos {
	public static void main(String[] args) {				
		int nVeces = Integer.parseInt (args[0]);	// veces que se repite la operación

		long t1,t2;

		System.out.println("nVeces = "+ nVeces);
		System.out.println ("Tamaño\tTiempo\tResultado");   
		for ( int n=3; n<= 100000000 ; n*=2) // n se va incrementando *5   
		{
			MatrizOperaciones mat= new MatrizOperaciones(n);

			t1=System.currentTimeMillis();

			int s= 0;
			// hay que repetir todo el proceso a medir (lo que que estaba entre t1 y t2) 
			for (int repeticion= 1; repeticion<=nVeces; repeticion++)
			{  	
				s= mat.sumarDiagonal2();
			}

			t2=System.currentTimeMillis();
			System.out.println (n+"\t"+(t2-t1)+"\t"+s);   

		} // fin de for
		
		System.out.println("\nFin de la medición de tiempos *****");

	}
}