package alg53522658.p4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 * Permite implementar el algoritmo para resolver el problema del viajante
 */
public class Viajante {
	private int numNodos; // número de nodos del grafo
	private int[][] mat; // matriz de adyacencias del grafo
	private int[] sol; // array con la lista de nodos que forman el ciclo de hamilton
	private int[][] solGrafo; // matriz de adyacencias sólo con las aristas solución
	
	private static int inic = 0;

	public int[] getSol() {
		return sol;
	}

	public static void main(String[] args) {
		Viajante v = null;
        if (args.length == 1) {
            String nomFich = "fichPrueba/" + String.valueOf(args[0]) + ".txt";
            v = new Viajante(nomFich);
        }else if (args.length == 2) {
            int numNodos = Integer.parseInt(args[0]);
            int max = Integer.parseInt(args[1]);
            v = new Viajante(numNodos, max);
        }else {
        	throw new IllegalArgumentException("Parametro de entrada incorrecto");
        }
        
        int c = v.devorador1(inic);
        v.escribirSolucion();
        System.out.println("Coste= " + c);
        

	}

	/**
	 * Constructor que carga el grafo a partir de un fichero
	 * 
	 * @param nomFich Nombre del fichero
	 */
	public Viajante(String nomFich) {
		mat = cargar(nomFich);
		sol = new int[numNodos + 1];// mat.length+1];
		inic = sol[0];
		solGrafo = new int[numNodos][numNodos]; // inicialmente a 0
	}

	/**
	 * Constructor que crea un grafo aleatorio
	 * 
	 * @param numNodos Número de notos del grafo
	 * @param max      valor máximo para las distancias (pesos)
	 */
	public Viajante(int numNodos, int max) {
		this.numNodos = numNodos;
		mat = rellenar(numNodos, max);
		sol = new int[numNodos + 1];// mat.length+1];
		inic = sol[0];
		solGrafo = new int[numNodos][numNodos]; // inicialmente a 0
	}

	/**
	 * Este método da valores aleatorios a la matriz de enteros, Genera una matriz
	 * triangular simétrica respecto a la diagonal principal. Además, todos los
	 * valores están entre 1 y max excepto la diagonal principal que son infinito
	 * utiliza para ello la clase Random del paquete java.util
	 * 
	 * @param tam tamaño del array
	 * @param max valor máximo para el rango de aleatorios
	 **/
	private int[][] rellenar(int tam, int max) {
		int[][] elementos = new int[tam][tam];

		Random r = new Random();

		// Creamos un array simétrico para una matriz de adyacencias de
		// un grafo no dirigido
		for (int i = 0; i < tam; i++)
			for (int j = i; j < tam; j++)
				if (i == j)
					elementos[i][j] = Integer.MAX_VALUE; // realmente no hay camino
				else {
					elementos[i][j] = r.nextInt(max - 1) + 1;// valores entre 1 y max
					elementos[j][i] = elementos[i][j];
				}

		return elementos;
	} // fin de rellena

	/**
	 * Carga los valores de la matriz de enteros desde un fichero. Formato fichero:
	 * Primera línea, tamaño de la matriz (n), resto de las líneas, la fila
	 * correspondiente en la que cada valor estará separado por un tabulador del
	 * siguiente.
	 * 
	 * @param nomFich nombre del fichero en el directorio de trabajo
	 **/
	private int[][] cargar(String nomFich) {
		BufferedReader fich = null;
		String linea;
		int[][] elementos = null;

		try {
			// Se abre el fichero de texto
			fich = new BufferedReader(new FileReader(nomFich));
			linea = fich.readLine();
			// La primera línea contiene el número de elementos
			numNodos = Integer.parseInt(linea);

			// Se crea el array del tamaño adecuado
			elementos = new int[numNodos][numNodos];
			for (int i = 0; i < numNodos; i++) {
				linea = fich.readLine();
				String valores[] = linea.split("\t");
				for (int j = 0; j < numNodos; j++) {
					elementos[i][j] = Integer.parseInt(valores[j]);
					if (elementos[i][j] == 0)
						elementos[i][j] = Integer.MAX_VALUE; // no hay camino
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero: " + nomFich);
		} catch (IOException e) {
			System.out.println("Error en la lectura del fichero: " + nomFich);
		}

		return elementos;
	}

	/**
	 * Este método muestra el contenido de la matriz por pantalla
	 **/
	public void escribirMat() {
		for (int i = 0; i < numNodos; i++) {
			for (int j = 0; j < numNodos; j++) {
				if (mat[i][j] == Integer.MAX_VALUE)
					System.out.print("∞\t");
				else
					System.out.print(mat[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();

	} // fin de escribe

	/* Escribe el ciclo a seguir */
	public void escribirSolucion() {
		for (int i = 0; i < sol.length; i++) {
			System.out.print(sol[i]);
			if (i < sol.length - 1)
				System.out.print(" -- ");
		}
		System.out.println();
		System.out.println();
	}

	/** Calcula el ciclo de Hamilton
	 *  El heurístico es buscar la arista de menor coste del nodo actual 
	 *  a uno de los nodos no conectados 
	 * @param nodoInicial Nodo a partir del cual iniciamos el ciclo
	 * @return coste del ciclo
	 */
	public int devorador1(int nodoInicial) {
        int minCost=0, cost=0, nodeToAdd= 0;
        int currentNode = nodoInicial;
        boolean[] path = new boolean[numNodos];
        path [nodoInicial] = true; //inicio
        sol[0] = nodoInicial; //inicio
        
        for(int i=0; i <numNodos -1;i++ ) {
            minCost = Integer.MAX_VALUE;
            for(int node=0;node<numNodos; node++) {
            	// si no se ha visitado aun y la arista es menor
                if(mat[currentNode][node]< minCost && !path[node]) {
                    minCost = mat[currentNode][node]; //se actualiza el menor coste
                    nodeToAdd = node; //se actualiza el nodo mas cercano
                }
            }
            sol[i+1] = nodeToAdd; //se inserta al camino seguido
            solGrafo [currentNode][nodeToAdd] = minCost; //se inserta el peso
            path[nodeToAdd] = true; // nodo ya visitado
            cost += mat[currentNode][nodeToAdd]; //se actualiza el coste total del ciclo
            currentNode = nodeToAdd; // se cambia el nodo pivote
        }
        //coste desde el último nodo al primero
        // si es un grafo completo es sobre si mismo por lo que esto no influye)
        solGrafo[currentNode][nodoInicial] = mat[currentNode][nodoInicial];
        cost += mat[currentNode][nodoInicial];
       //retorna coste del ciclo (lo calculado + el coste de cerrar el ciclo desde el último nodo al primero)
       return cost;
	}

	/**
	 * Calcula el ciclo de Hamilton El heurístico es buscar la arista de menor coste
	 * de todo el grafo y comprobar que ningún nodo tenga más de dos aristas
	 * incidentes y que no se formen ciclos
	 * 
	 * @return coste del ciclo
	 */
	public int devorador2() {
		int cost = 0; // en este momento no nos hemos movido => el coste actual es 0
		
		
		return cost;
	}

	/**
	 * Recibe un array de adyacencias sólo con las aristas que forman el ciclo de
	 * hamilton Devuelve un array unidimensional lista de nodos con el camino
	 * Hamiltoniano ordenado
	 * 
	 * @param solGrafo array de adyacencias sólo con las aristas del ciclo
	 * @param inicial  nodo inicial a partir del que mostramos el ciclo
	 * @return array con la lista de nodos del ciclo
	 */
	private int[] convertirAristasSol(int[][] solGrafo, int inicial) {
		sol[0] = inicial;
		for (int i = 1; i < numNodos; i++) {
			for (int j = 0; j < numNodos; j++)
				if (solGrafo[sol[i - 1]][j] != 0 || solGrafo[j][sol[i - 1]] != 0) {
					sol[i] = j;
					solGrafo[sol[i - 1]][j] = solGrafo[j][sol[i - 1]] = 0;
					break;
				}
		}

		sol[numNodos] = inicial;
		return sol;
	}

}
