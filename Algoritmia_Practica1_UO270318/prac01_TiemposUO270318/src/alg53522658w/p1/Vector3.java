package alg53522658w.p1 ;



/** Esta Clase utiliza los métodos estáticos de la clase Vector1.
 *  Sirve para medir tiempos con distintos tamaños del problema,
 *  incrementándolos automáticamente
 */
public class Vector3
{
	static int []v;

	public static void main (String arg [] )
	{
		long t1,t2;

		System.out.println ("Tamaño\tTiempo\tResultado");   
		for ( int n=10; n<= 1000000000 ; n*=3) // n se va incrementando exponencialmente (*5)
		{
			System.out.print (n+"\t");
			v = new int [n] ;
			Vector1.rellena (v);

			// Medida del tiempo de la operación suma()
			t1=System.currentTimeMillis();
			int s=Vector1.suma (v);
			t2=System.currentTimeMillis();
			System.out.print ((t2-t1)+"\t");   

			System.out.println (s);		
		} // fin de for de tamaño del problema
		
		System.out.println("\nFin de la medición de tiempos *****");

	} // fin de main

} // fin de clase