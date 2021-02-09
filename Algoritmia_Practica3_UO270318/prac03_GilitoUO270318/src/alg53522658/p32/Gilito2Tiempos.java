package alg53522658.p32;

public class Gilito2Tiempos
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

	public static int gilito2(int[] mon, int init, int fin) {
		// SI ES IMPAR
		int res=0;
		int n=fin-init+1;
		if ((fin - init) <= 1)
			return (mon[init] <= mon[fin]) ? init : fin; // devuelve pos
		else {
			int m = (fin + init) / 2;
			if(n%2==0) { //si es par se divide a la mitad
				res = balanza(mon, init, m, m+1, fin);
				if (res == 1) {
					return gilito2(mon, init, m);
				} else if (res == 2) {
					return gilito2(mon, m+1, fin);
				}
			}else {
				res = balanza(mon, init, m - 1, m, fin - 1);
				if (res == 1) {
					return gilito2(mon, init, m - 1);
				} else if (res == 2) {
					return gilito2(mon, m, fin - 1);
				}
			}
			return fin;
		}
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
			monedas[0]=999; //caso peor que nos piden = la primera
			t1=System.currentTimeMillis();
			for (int i=0;i<nVeces;i++)
				posicion = gilito2(monedas, 0, monedas.length - 1);
			t2=System.currentTimeMillis();
			System.out.printf("POSICION  %d  =***MONEDAS= %d ***TIEMPO= %d ***ESCALA= %d\n",posicion,n, (t2-t1), nVeces);
		}
	} 
}