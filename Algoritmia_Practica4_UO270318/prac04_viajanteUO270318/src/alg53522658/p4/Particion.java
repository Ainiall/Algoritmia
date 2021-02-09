package alg53522658.p4;

/**
 * Estructura para mantener información de que nodos del grafo están conectados
 * Inicialmente todos los nodos están desconectados (o tienen su propia componente)
 * Cada vez que conectamos 1 elegimos como representante el de menor valor.
 * Esto nos va a permtir evitar ciclos. 
 */
public class Particion {
	private int numEle;
	private int[] p;

	public Particion(int numEle) {
		this.numEle= numEle;
		p= new int[numEle];
		// Inicialmente no hay aristas y todos los nodos están desconectados
		for (int i= 0; i<numEle; i++)
			p[i]= i;		
	}
	
	/** Fusiona nodos en una única partición al trazar una nueva arista entre a y b
	 * @param a nodo 1 a fusionar
	 * @param b nodo 2 a fusionar
	 */
	public void fusionarNodos(int a, int b) {
		int temp;
		
		if (a>b) { // los intercambiamos
			temp= a;
			a= b;
			b= temp;
		}
		
		for (int i= 0; i<numEle; i++) {
			if (p[i]==b) p[i]= a;
		}
	}
	
	
	/** Comprueba si sólo hay una componente conexa en el grafo */
	public boolean unicaComponenteConexa() {
		for (int i= 0; i<numEle; i++)
			if (p[i]!=0) return false;
		return true;
	}
	
	/** Devuelve el representante de la componente a la que pertenece
	 * el nodo pasado como argumento
	 */
	public int obtenerComponente(int i) {
		return p[i];
	}
}