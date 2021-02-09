package alg53522658.p32;

/* Esta clase simula el algoritmo que sigue en la actualiodad el TIO GILITO y 
 * que nos reta para que se lo mejoremos gratuitamente (no piensa pagarnos nada el muy usurero) */
public class Gilito2 {

	static int[] monedas; // peso en gramos de las n monedas
	static int watH; // energia media consumida(watioshora=wh)

	/*
	 * Pesa en el platillo izquierdo las monedas entre las posiciones izqMin..izqMax
	 * Pesa en el platillo derecho las monedas entre las posiciones derMin..derMax
	 * Devuelve 1 si pesa menos la izquierda, 2 si la derecha y 3 si igual
	 */
	public static int balanza(int[] monedas, int izqMin, int izqMax, int derMin, int derMax) {
		watH++; // 1 wh consumido
		int pIzq = 0; // peso platillo izquierdo
		for (int i = izqMin; i <= izqMax; i++)
			pIzq = pIzq + monedas[i];

		int pDer = 0; // peso platillo derecho
		for (int i = derMin; i <= derMax; i++)
			pDer = pDer + monedas[i];
		if (pIzq < pDer)
			return 1;
		if (pIzq > pDer)
			return 2;
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

	public static void main(String arg[]) {
		int n = Integer.parseInt(arg[0]);// numero de monedas=tamaño del problema
		monedas = new int[n];
		int posicion;
		// vamos a simular los n casos posibles - moneda falsa en cada posición
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				monedas[j] = 1000; // peso moneda buena
			monedas[i] = 999; // moneda falsa limada para estafar al Gilito
			posicion = gilito2(monedas, 0, monedas.length - 1);
			//System.out.println("POSICION MONEDA FALSA=" + posicion);
		}
		System.out.println("MONEDAS= " + n + "***ENERGIA MEDIA CONSUMIDA= " + watH / n + " WattiosHora");
	}
}