package alg53522658.p4;

import java.util.Comparator;

/**
 * Representa una arista del grafo con toda su información
 * Dejamos acceso directo a los campos desde cualquier clase del paquete
 * (como si fueran propiedades)
 */
public class Arista {
	int nodoOrigen;		// nodo origen de la arista
	int nodoDestino;	// nodo destino de la arista
	int coste;			// Coste entero de la arista (seria mejor real)
	
	public Arista(int nodoOrigen, int nodoDestino, int coste) {
		this.nodoOrigen= nodoOrigen;
		this.nodoDestino= nodoDestino;
		this.coste= coste;
	}	
	
	public String toString() {
		return nodoOrigen+" -> "+nodoDestino+"("+coste+") ";
	}
}

class AristaComparator implements Comparator<Arista> {
	@Override
	public int compare(Arista a0, Arista a1) {		
		return a0.coste - a1.coste;
	}	
}