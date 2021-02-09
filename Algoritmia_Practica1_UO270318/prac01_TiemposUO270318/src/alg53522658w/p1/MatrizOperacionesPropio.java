import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class MatrizOperacionesPropio {

	// matriz cuadrada
	private int[][] mtx;

	/**
	 * Crea una matriz de tamaño nxn y la rellena con valores aleatorios,
	 * estos valores aleatorios deben de ser parametrizables entre un
	 * máximo y un mínimo.
	 * 
	 * @param n
	 *              tamaño de la matriz
	 */
	public MatrizOperacionesPropio(int n) {
		this.mtx = new int[n][n];
		rellena(1, 4);
	}

	/**
	 * Rellena la matriz que se le pasa como parámetro con unos valores
	 * generados automáticamente.
	 * 
	 * @param mtx
	 *                matriz para rellenar
	 */
	private void rellena(int min, int max) {
		Random r = new Random();
		for (int i = 0; i < mtx.length; i++)
			for (int j = 0; j < mtx.length; j++)
				//min y max incluidos
				mtx[i][j] = r.nextInt(max + 1 - min) + min;
	}

	/**
	 * Crea una matriz a partir de los datos del fichero. El formato del
	 * fichero será: Primera línea, un entero con tamaño de la matriz (n),
	 * resto de las líneas, la fila correspondiente en la que cada valor
	 * estará separado por un tabulador del siguiente.
	 * 
	 * @param nomFich
	 */
	public MatrizOperacionesPropio(String nomFich) {
		cargaFichero(nomFich);
	}

	private void cargaFichero(String nomFich) {
		String line;
		String[] lineas = null;

		try {
			BufferedReader file = new BufferedReader(new FileReader(nomFich));
			line = file.readLine();
			mtx= new int[Integer.parseInt(line)][Integer.parseInt(line)];
			int cont=0;
			while (file.ready()) {
				line = file.readLine();
				lineas = line.split("\t");
				rellenarFila(cont,lineas);
				cont++;
			}
			file.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}

	}

	private void rellenarFila(int cont, String[] lineas) {
		for (int i = 0; i < mtx.length; i++) {
				mtx[cont][i] = Integer.parseInt(lineas[i]);
		}
		
	}

	/**
	 * Devuelve el tamaño de la matriz.
	 */
	public int getTam() {
		return mtx.length;
	}

	/**
	 * Muestra el contenido de la matriz por pantalla.
	 */
	public void escribir() {
		System.out.println(Arrays.deepToString(mtx));
//		for (int i=0; i<mtx.length; i++){
//			for (int j=0; j<mtx.length; j++)
//				System.out.print (mtx[i][j]+" ");
//			System.out.println();
//		}
	}

	/**
	 * Calcula de forma iterativa la suma de la diagonal. Forma 1:
	 * recorrer toda la matriz, pero sólo sumando los elementos de la
	 * diagonal
	 */
	public int sumarDiagonal1() {
		int suma=0;
		for(int i=0;i<mtx.length;i++)
			for(int j=0;j<mtx.length;j++)
				if (i==j) 
					suma+=mtx[i][j];
		return suma; 

	}

	/**
	 * Calcula de forma iterativa la suma de la diagonal. Forma 2:
	 * recorrer los elementos de la diagonal sumándolos
	 */
	public int sumarDiagonal2() {
		int suma=0;
		for(int i=0;i<mtx.length;i++)
			suma+=mtx[i][i];
		return suma; 
	}

	/**
	 * En una matriz cuyos valores varían entre 1 y 4 vamos a trazar un
	 * “camino” partienendo de la posición (i,j) que pasamos como
	 * parámetro y utilizando los valores de la matriz como códigos de
	 * dirección: 1 - arriba, 2 - derecha, 3 - abajo, 4 – izquierda. Vamos
	 * a utilizar para marcar el camino el código -1. El proceso
	 * finalizará cuando el camino salga de los límites de la matriz o
	 * bien alcance una casilla ya recorrida.
	 * 
	 * @param i
	 * @param j
	 */
	public void recorrerCamino(int i, int j) {
		int puntero= mtx[i][j];
		String s="["+i+","+j+"]";
		try {
			while(puntero!=-1) {
				//ARRIBA
				if(mtx[i][j]==1) {
					mtx[i][j]=-1;
					i-=1;
					puntero= mtx[i][j];
					s+=" - ["+i+","+j+"]";
				//DERECHA
				}else if(mtx[i][j]==2) {
					mtx[i][j]=-1;
					j+=1;
					puntero= mtx[i][j];
					s+=" - ["+i+","+j+"]";
				//ABAJO
				}else if(mtx[i][j]==3) {
					mtx[i][j]=-1;
					i+=1;
					puntero= mtx[i][j];
					s+=" - ["+i+","+j+"]";
				//IZQUIERDA
				}else {
					mtx[i][j]=-1;
					j-=1;
					puntero= mtx[i][j];
					s+=" - ["+i+","+j+"]";
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println(s);
		}
		
	}
}
