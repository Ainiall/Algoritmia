package alg53522658.p2;

import alg53522658.p2.Vector;

/**
 * Este programa sirve para ordenar n elementos con un algoritmo de los "malos"
 * (cuadrático)· Es la INSERCIÓN DIRECTA
 */
public class Insercion extends Vector {

	public Insercion(int nElementos) {
		super(nElementos);
	}

	/**
	 * Ordenación por inserción directa
	 */

	//CASO MEJOR: O(n)
	//CASO PEOR: O(n^2)
	//CASO MEIDO: O(n^2)
	@Override
	public void ordenar() {
		// TODO: Implementación del método de ordenación
		for (int i = 1; i < this.elements.length; i++) {
			int x = this.elements[i];
			int j = i - 1;
			while (j >= 0 && x < this.elements[j]) {
				this.elements[j + 1] = this.elements[j]; // desplaza el elemento del array
				j=j-1;
			}
			this.elements[j+1]=x; //mete el elemento a ordenar en el hueco
		}
	}

	@Override
	public String getNombre() {
		return "Inserción directa";
	}
}
