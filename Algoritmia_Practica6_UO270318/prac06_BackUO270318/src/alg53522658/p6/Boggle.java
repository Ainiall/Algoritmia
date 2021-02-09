package alg53522658.p6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Boggle {
    // problema np completo, se resuelve por backtracking
    // para seguir el orden establecido en las casillas adyacentes
    public static int[] col = { 0, 1, 1, 1, 0, -1, -1, -1 };
    public static int[] row = { -1, -1, 0, 1, 1, 1, 0, -1 };

    private static int n; // tamaño del problema
    private char[][] table;
    private boolean[][] visited;
    // treeset no admite duplicados y ordena alfabeticamente
    private Set<String> words = new TreeSet<String>();
    private List<String> dictionary = new ArrayList<String>();

    private String currentWord = "";
    // puntuacion para cada tamaño de palabra
    private int[] score = { 0, 0, 1, 2, 5, 7, 9, 12, 15, 19, 24 };

    private int totalScore; // puntos
    private int cont; // contador de palabras
    private int mov; // contador de movimientos

    // constructor que usa ficheros
    public Boggle(String dictionaryFileName, String tableFileName) {
	BufferedReader file = null;
	String line;

	fillDictionary(dictionaryFileName);

	try {
	    // Se abre el fichero de texto
	    file = new BufferedReader(new FileReader(tableFileName));
	    line = file.readLine();
	    // La primera línea contiene el tamaño
	    n = Integer.parseInt(line);
	    // Se crea el array del tamaño adecuado
	    table = new char[n][n];
	    visited = new boolean[n][n];
	    // se rellena la tabla
	    for (int i = 0; i < n; i++) {
		line = file.readLine();
		String[] chars = line.split(" ");
		for (int j = 0; j < chars.length; j++) {
		    table[i][j] = chars[j].charAt(0);
		}
	    }

	} catch (FileNotFoundException e) {
	    System.out.println("No se encuentra el fichero: " + tableFileName);
	} catch (IOException e) {
	    System.out.println(
		    "Error en la lectura del fichero: " + tableFileName);
	}

    }

    // metodo para rellenar la lista de palabras
    private void fillDictionary(String dictionaryFileName) {
	Path path = Paths.get(dictionaryFileName, "");
	try {
	    List<String> lines = Files.readAllLines(path,
		    StandardCharsets.UTF_8);
	    for (String s : lines)
		dictionary.add(s);

	} catch (FileNotFoundException e) {
	    System.out.println(
		    "No se encuentra el fichero: " + dictionaryFileName);
	} catch (IOException e) {
	    System.out.println(
		    "Error en la lectura del fichero: " + dictionaryFileName);
	}
    }

    // constructor que usa tamaño de tabla
    public Boggle(String dictionaryFileName, int tableSize) {
	fillDictionary(dictionaryFileName);
	n = tableSize;
	table = new char[n][n];
	visited = new boolean[n][n];
	Random r = new Random();
	
	// Creamos un array simétrico para una matriz de adyacencias de
	// un grafo no dirigido
	for (int i = 0; i < n; i++)
	    for (int j = 0; j < n; j++)
		table[i][j] = (char)(r.nextInt(26) + 'a');// valores entre 1 y max

    }

    // metodo que devuelve una lista con las palabras encontradas
    public List<String> getSoluciones() {
	List<String> list = new ArrayList<String>(words);
	return list;
    }

    // metodo que devuelve la puntuacion total
    public long getPuntosTotales() {
	return totalScore;
    }

    // metodo que muestra el tablero
    public void imprimirTablero() {
	System.out.println(Arrays.deepToString(table));
    }

    // metodo que imprime las palabras encontradas
    public void imprimirSoluciones() {
	System.out.println(words.toString());
    }

    // metodo que realiza el backtraking
    public void encontrarSoluciones() {
	// insert all words into a trie
	Trie root = new Trie();
	for (String w : dictionary) {
	    // para comparar con key trie
	    root.insert(w.toLowerCase());
	}

	if (table.length > 1) { // poda, si solo tiene 1 char no forma palabras
	    for (int i = 0; i < table.length; i++) {
		for (int j = 0; j < table.length; j++) {
		    // busqueda en profundidad
		    dfs(currentWord, i, j, root);
		}
	    }
	}

    }

    public void dfs(String str, int i, int j, Trie root) {
	mov++;
	if (i < 0 || j < 0 || i >= n || j >= n) {
	    return;
	}
	
	if (visited[i][j])
	    return;

	str = str + Character.toLowerCase(table[i][j]);

	if (!root.startsWith(str))
	    return;

	if (root.isWord(str)) {
	    if (!words.contains(str)) {
		words.add(str);
		cont++;
		if(str.length()>1)
		    totalScore += score[str.length()];
	    }

	}

	visited[i][j] = true;
	dfs(str, i - 1, j, root);
	dfs(str, i - 1, j + 1, root);
	dfs(str, i, j + 1, root);
	dfs(str, i + 1, j + 1, root);
	dfs(str, i + 1, j, root);
	dfs(str, i + 1, j - 1, root);
	dfs(str, i, j - 1, root);
	dfs(str, i - 1, j - 1, root);
	visited[i][j] = false;
    }

}
