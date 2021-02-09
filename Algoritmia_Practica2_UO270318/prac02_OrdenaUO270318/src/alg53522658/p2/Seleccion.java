package alg53522658.p2;

import alg53522658.p2.Vector;

/**
 * Este programa sirve para ordenar n elementos con un algoritmo de los "malos"
 * (cuadrático)· es la SELECCION
 */
public class Seleccion extends Vector {
	public Seleccion(int nElementos) {
		super(nElementos);
	}

	/**
	 * Ordenación por selección
	 */

	// CASO MEJOR: O(n^2)
	// CASO PEOR: O(n^2)
	// CASO MEIDO: O(n^2)
	@Override
	public void ordenar() {
		// TODO: Implementación del método de ordenación
		int n = this.elements.length;
		int posmin;
		for (int i = 0; i < n - 1; i++) {
			// buscar posición del mas pequeño
			posmin = i;
			for (int j = i + 1; j < n; j++)
				if (this.elements[j] < this.elements[posmin])
					posmin = j;
			intercambiar(i, posmin);
		} // for
	}

	@Override
	public String getNombre() {
		return "Selección";
	}
}
