package alg53522658w.p1 ;


/** Este programa sirve para medir tiempos de la operacion maximo.
Va incrementando automáticamente el tamaño del problema y además
según una escala de tiempos determinada 
por nVeces, que se mete como argumento en ejecución
 */

public class Vector5
{
	static int []v;

	public static void main (String arg [] )
	{
		int nVeces = Integer.parseInt (arg[0]);
		long t1,t2;
		System.out.println("nVeces = "+ nVeces);

		for ( int n=10; n<= 100000000 ; n*=3) // n se va incrementando *3   
		{
			v = new int [n] ;
			Vector1.rellena (v);

			//  escribe (v);
			int [] m = new int [2];
			t1=System.currentTimeMillis();

			for (int repeticion=1;repeticion<=nVeces;repeticion++)
				// hay que repetir todo el proceso a medir (lo que que estaba
				// entre t1 y t2) 
			{  

				Vector1.maximo (v,m); 	
			}
			t2=System.currentTimeMillis();
			
			System.out.println(n+"\t"+(t2-t1)+"\t"+m[1]);
//			System.out.println ("TAMAÑO = "+n+"**"+"TIEMPO = "+(t2-t1)+"**"+" nVeces = "+nVeces+"**"+m[0]);   

			//  System.out.println ("EL MAXIMO ESTA EN POSICION = "+ m[0]);
			//  System.out.println ("EL MAXIMO ES = "+ m[1]);

		} // fin de for 

	} // fin de main

} // fin de clase
