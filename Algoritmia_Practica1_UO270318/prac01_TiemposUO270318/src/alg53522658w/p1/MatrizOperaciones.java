package alg53522658w.p1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Implementa operaciones sobre una matriz cuadrada de enteros
 */
public class MatrizOperaciones {
	private int[][] mat;
	
	public static void main(String[] args) {
		MatrizOperaciones m= new MatrizOperaciones(10);//("matriz01.txt");
		m.escribir();
		//System.out.println("La suma de todos los elementos es: "+m.sumarDiagonal1());
		//System.out.println("La suma de la diagonal principal es: "+m.sumarDiagonal2());
		m.recorrerCamino(m.getTam()/2, 0);
		m.escribir();
	}
	
	/**
	 * Crea una matriz de tama�o nxn y la rellena con valores aleatorios
	 * @param n tama�o de la matriz cuadrada
	 */
	public MatrizOperaciones(int n) {
		mat= new int[n][n];
		//rellenar(99,199);
		rellenar(1,4);
	}
	
	/**
	 * Devuelve el tama�o de la matriz
	 * @return tama�o filas de la matriz
	 */
	public int getTam() { return mat.length; }
	
	/**
	 * Crea una matriz a partir de los datos del fichero
	 * @param nomFich nombre del fichero en el directorio de trabajo
	 */
	public MatrizOperaciones(String nomFich) {
		mat = cargar(nomFich);
		
	}
	
	/** Este m�todo da valores aleatorios a la matriz de enteros, 
	 * utiliza para ello la clase Random del paquete java.util
	 * @param min valor m�nimo para el rango de aleatorios
	 * @param max valor m�ximo para el rango de aleatorios  
     **/
	private void rellenar(int min, int max)
	{
		Random r= new Random ();
		int n= mat.length;
		for(int i=0; i<n; i++)
			for (int j= 0; j<n; j++)
				mat[i][j]= r.nextInt(max-min+1)+min;//valores entre -99 y 99

	}  // fin de rellena   

	/** Este m�todo saca el contenido de la matriz por pantalla
	**/
	public void escribir()
	{
	  int n= mat.length;
		for(int i=0; i<n; i++) {
			for (int j= 0; j<n; j++)
				System.out.print(mat[i][j]+"\t");
			System.out.println();
		}
		System.out.println();
	
	}  // fin de escribe   

	/** Este metodo calcula de forma iterativa la suma de la diagonal
	 * Forma 1: recorrer toda la matriz pero s�lo sumando los elementos de la diagonal
	 */
	public int sumarDiagonal1()
	{
		int n= mat.length;
		int suma= 0;
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				if (i==j) suma+= mat[i][j];
		return suma; 
	}  // fin de sumarDiagonal1   


	/**  Este m�todo calcula de otra forma iterativa la suma de	la diagonal.
	 * Forma 2: recorrer los elementos de la diagonal sum�ndolos
	 */
	public int sumarDiagonal2()
	{
		int n= mat.length;
		int suma= 0;
		for(int i=0; i<n; i++)
			suma+= mat[i][i];
		return suma; 
	}  // fin de sumarDiagonal2   

	/** Carga los valores de la matriz de enteros desde un fichero.
	 *  Formato fichero: Primera l�nea, tama�o de la matriz (n), resto de las l�neas, la fila correspondiente 
	 *  en la que cada valor estar� separado por un tabulador del siguiente.
	 *  @param nomFich nombre del fichero en el directorio de trabajo
	 **/
	private int[][] cargar(String nomFich)
	{
		BufferedReader fich= null;
		String linea;
		int n;
		int[][] elementos= null;

		try {
			// Se abre el fichero de texto
			fich= new BufferedReader(new FileReader(nomFich));
			linea= fich.readLine();
			// La primera l�nea contiene el n�mero de elementos
			n= Integer.parseInt(linea);

			// Creo el array del tama�o adecuado
			elementos= new int[n][n];
			for (int i= 0; i<n; i++) {
				linea= fich.readLine();
				String valores[]= linea.split("\t");
				for (int j= 0; j<n; j++)
					elementos[i][j]= Integer.parseInt(valores[j]);
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero: "+nomFich);
		} catch (IOException e) {
			System.out.println("Error en la lectura del fichero: "+nomFich);
		}

		return elementos;
	}
	
	/**
	 * 
	 * @param i
	 * @param j
	 */
	public void recorrerCamino(int i, int j) {
		boolean fin= false;
		int n= mat.length;
		//int[][] cam= new int[n][n];

		while (!fin) {
			int val= mat[i][j];
			mat[i][j]= -1;
			escribir();
			
			/* Codificaci�n 1 - arriba, 2 - derecha, 3 - abajo, 4 - izquierda */
			switch(val) {
			case 1: i= i-1;
			break;
			case 2: j= j+1;
			break;
			case 3: i= i+1;
			break;
			case 4: j= j-1;
			break;
			case -1: fin= true;
			break;
			}
			if (i<0 || i>=n || j<0 || j>=n)
				fin= true;
		}
	}

}