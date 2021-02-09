package alg53522658.p7.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import alg53522658.p7.Trie;

public class Utils {

	private static int n; //board size
	private static char[][] table;
	private static boolean [][] visited;
	
	public static Trie fillDictionary(String dictionaryFileName) {
		Path path = Paths.get(dictionaryFileName, "");
		Trie root = new Trie();
		try {
		    List<String> lines = Files.readAllLines(path,
			    StandardCharsets.UTF_8);
		    for (String s : lines)
		    	if(s.length()>=2 && s.length()<=20)
		    		root.insert(s.toLowerCase());
		} catch (FileNotFoundException e) {
		    System.out.println(
			    "No se encuentra el fichero: " + dictionaryFileName);
		} catch (IOException e) {
		    System.out.println(
			    "Error en la lectura del fichero: " + dictionaryFileName);
		}
		return root;
	}
	
	public static void getBoard(String tableFileName) {
		BufferedReader file = null;
		String line;
	
		try {
		    // Se abre el fichero de texto
		    file = new BufferedReader(new FileReader(tableFileName));
		    line = file.readLine();
		    // La primera línea contiene el tamaño
		    n = Integer.parseInt(line);
		    // Se crea el array del tamaño adecuado
		    table = new char[n][n];
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
	
	public static int getSize() {
		return n;
	}
	
	public static boolean[][] getVisited(){
		return visited;
	}
	
	public static char[][] getTable(){
		return table;
	}
}
