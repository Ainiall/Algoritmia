package alg53522658.p32;

/* Esta clase esta creada "ad hoc" para medir tiempos y ver si se comporta de forma lineal O(n), 
 * según la complejidad analizada.
 * El tiempo medido para cada n es el caso peor, que dado el algoritmo, 
 * es que la moneda falsa sea la ultima  */
public class Gilito1Tiempos
{
	static int []monedas;  // peso en gramos de las n monedas

	public static int balanza (int[] monedas,int izqMin,int izqMax,int derMin,int derMax)
	{
		int pIzq=0;      // peso platillo izquierdo
		for (int i=izqMin;i<=izqMax;i++)
			pIzq=pIzq+monedas[i];

		int pDer=0;      // peso platillo derecho   
		for (int i=derMin;i<=derMax;i++)
			pDer=pDer+monedas[i];
		if (pIzq<pDer) return 1;
		if (pIzq>pDer) return 2;
		return 3;
	}

	public static int gilito1(int[]monedas)
	{
		int res=0;
		for (int i=0;i<monedas.length/2;i++)
		{
			res=balanza(monedas,2*i,2*i,2*i+1,2*i+1); // una  y la siguiente a cada platillo
			if (res==1) return 2*i;
			else if (res==2) return 2*i+1;
		}
		return (monedas.length-1);  //si n es impar y la falsa es la ultima  

	}

	public static void main (String arg[])
	{
		int nVeces=Integer.parseInt(arg[0]); // escala de tiempo
		long t1,t2; 
		int posicion=0;
		for (int n=100;n<10000;n*=2)
		{
			monedas=new int[n];
			for (int i=0;i<n;i++)  monedas[i]=1000; 
			monedas[n-1]=999; //caso peor que nos piden = la ultima
			t1=System.currentTimeMillis();
			for (int i=0;i<nVeces;i++)
				posicion=gilito1(monedas);
			t2=System.currentTimeMillis();
			System.out.printf("POSICION  %d  =***MONEDAS= %d ***TIEMPO= %d ***ESCALA= %d\n",posicion,n, (t2-t1), nVeces);
		}
	} 
}