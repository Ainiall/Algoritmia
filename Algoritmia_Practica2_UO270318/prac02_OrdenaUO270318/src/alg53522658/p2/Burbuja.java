package alg53522658.p2;

import alg53522658.p2.Vector;

public class Burbuja extends Vector {
	public Burbuja(int nElementos) {
		super(nElementos);
	}

	/**
	 * Ordenación por el método de Burbuja
	 */

	// CASO MEJOR: O(n^2)
	// CASO PEOR: O(n^2)
	// CASO MEIDO: O(n^2)
	@Override
	public void ordenar() {
		// TODO: Implementación del método de ordenación
		int n = this.elements.length;
		for (int i = 0; i <= n - 2; i++)
			for (int j = n - 1; j > i; j--)
				if (this.elements[j - 1] > this.elements[j])
					intercambiar(j - 1, j);

	}

	@Override
	public String getNombre() {
		return "Burbuja";
	}
}