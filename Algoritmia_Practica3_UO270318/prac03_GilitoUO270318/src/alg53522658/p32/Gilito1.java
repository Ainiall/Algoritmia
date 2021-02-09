package alg53522658.p32;

/* Esta clase simula el algoritmo que sigue en la actualiodad el TIO GILITO y 
 * que nos reta para que se lo mejoremos gratuitamente (no piensa pagarnos nada el muy usurero) */
public class Gilito1
{

	static int []monedas;  // peso en gramos de las n monedas
	static int watH;       // energia media consumida(watioshora=wh) 

	/* Pesa en el platillo izquierdo las monedas entre las posiciones izqMin..izqMax
	   Pesa en el platillo derecho las monedas entre las posiciones derMin..derMax
	   Devuelve 1 si pesa menos la izquierda, 2 si la derecha y 3 si igual    */     
	public static int balanza (int[] monedas,int izqMin,int izqMax,int derMin,int derMax)
	{
		watH++;           // 1 wh consumido   
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

	/* Algoritmo actual,que se nos pide mejorar
	   Devuelve la posición donde se encuentra la moneda falsa	
	   En el caso mejor, es una de las dos primeras la falsa, gasta 1 wh.
	   En el caso peor, es la ultima la falsa, gasta aprox. n/2 wh.
	   En el caso medio, media de todas las posiciones,  gasta aprox. n/4 wh.
	   luego esta algoritmo es lineal O(n) en el caso peor y medio   */
	public static int gilito1(int[]monedas)
	{

		int res=0;
		for (int i=0;i<monedas.length/2;i++)
		{
			//vector, izq (2i), der (2i+1)
			//System.out.println();
			res=balanza(monedas,2*i,2*i,2*i+1,2*i+1); // una  y la siguiente a cada platillo
			if (res==1) 
				return 2*i; //si izq menor
			else if (res==2) 
				return 2*i+1; //si der menor
		}
		return (monedas.length-1);  //si n es impar y la falsa es la ultima  
	}

	public static void main (String arg[])
	{
		int n=Integer.parseInt(arg[0]);//numero de monedas=tamaño del problema
		monedas=new int[n];
		int posicion;
		//vamos a simular los n casos posibles - moneda falsa en cada posición
		for (int i=0;i<n;i++){ 
			for (int j=0;j<n;j++) monedas[j]=1000; //peso moneda buena
			monedas[i]=999; //moneda falsa limada para estafar al Gilito 
			posicion=gilito1(monedas);
			//System.out.println ("POSICION MONEDA FALSA="+posicion);
		}
		System.out.println("MONEDAS= "+n+"***ENERGIA MEDIA CONSUMIDA= "+watH/n+" WattiosHora");
	} 
}