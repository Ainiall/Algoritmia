package alg53522658.p7;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import alg53522658.p7.utils.Utils;

public class BoggleBacktracking {

	private Trie diccionary; // diccionario a utilizar
	private String currentWord = "";
	private int n, numberWordsConcatenated, numberCellRepeated;
	private char[][] table;
	private int[][] visited;
	private TreeMap<String, Integer> words = new TreeMap<String, Integer>();
	private int totalScore; // puntos

	private int repetitions = 0;
	private String repeatedWord;
	private boolean moreRepetitions = false;
	private Map.Entry<String, Integer> maxEntry = null;

	// todas las palabras tienen una longitud >=2
	// todas las palabras tienen una longitud <=20
	// si una palabra aparece en el diccionario, no puede aparecer en ese
	// diccionario esa palabra repetida 2 o más veces: (se coge la de mayor
	// puntuacion)

	public BoggleBacktracking(String dictionaryFileName, int numberOfTimesAWordCanBeConcanetaded,
			int numberOfTimesACellCanBeRepeated, String tableFileName) {
		diccionary = Utils.fillDictionary(dictionaryFileName);
		Utils.getBoard(tableFileName);
		n = Utils.getSize();
		table = Utils.getTable();
		visited = new int[n][n];

		numberWordsConcatenated = numberOfTimesAWordCanBeConcanetaded;
		numberCellRepeated = numberOfTimesACellCanBeRepeated;
	}

	// constructor que usa tamaño de tabla
	public BoggleBacktracking(String dictionaryFileName, int tableSize, int numberOfTimesAWordCanBeConcanetaded,
			int numberOfTimesACellCanBeRepeated) {
		diccionary = Utils.fillDictionary(dictionaryFileName);
		n = tableSize;
		table = new char[n][n];
		visited = new int[n][n];
		Random r = new Random();

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				table[i][j] = (char) (r.nextInt(26) + 'a');// alfabeto
		numberWordsConcatenated = numberOfTimesAWordCanBeConcanetaded;
		numberCellRepeated = numberOfTimesACellCanBeRepeated;

	}

	public void printTable() {
		System.out.println(Arrays.deepToString(table));
	}

	public void findSolutions() {
		if (table.length > 1) { // poda, si solo tiene 1 char no forma palabras
			for (int i = 0; i < table.length; i++) {
				for (int j = 0; j < table.length; j++) {
					// busqueda en profundidad
					dfs(currentWord, i, j, diccionary);
				}
			}
		}
		calculateTotalPoints();
	}

	private void calculateTotalPoints() {
		Iterator<String> iter = words.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			int value = words.get(key);
			// totalScore += Math.pow(key.length(), value) + key.length() * value;
			totalScore += value;
		}
	}

	// recorrido en profundidad
	public void dfs(String str, int i, int j, Trie root) {
		if (i < 0 || j < 0 || i >= n || j >= n) {
			return;
		}

		if (visited[i][j] == numberCellRepeated)
			return;

		str = str + Character.toLowerCase(table[i][j]);

		// comprueba si hay palabras en el arbol con el mismo prefijo
		if (!root.startsWith(str)) {
			if (isDuplicate(str)) {
				String repeatedWord = getRepeatedWord();
				int repetitions = getRepetitions();
				int score = (int) (Math.pow(repeatedWord.length(), repetitions) + repeatedWord.length() * repetitions);
				words.put(repeatedWord, score);
			} else if (!moreRepetitions) {
				return;
			}
		}

		if (root.isWord(str)) {
			if (!words.containsKey(str)) {
				words.put(str, (int) (Math.pow(str.length(), 1) + str.length() * 1));
			}
		}

		visited[i][j]++;

		dfs(str, i - 1, j, root);
		dfs(str, i - 1, j + 1, root);
		dfs(str, i, j + 1, root);
		dfs(str, i + 1, j + 1, root);
		dfs(str, i + 1, j, root);
		dfs(str, i + 1, j - 1, root);
		dfs(str, i, j - 1, root);
		dfs(str, i - 1, j - 1, root);

		visited[i][j]--;
	}

	private int getRepetitions() {
		return repetitions;
	}

	private String getRepeatedWord() {
		return repeatedWord;
	}

	private boolean isDuplicate(String str) {
		for (int i = 0; i < words.size(); i++) {
			String key = (String) words.keySet().toArray()[i];
			String concatenated = key.repeat(numberWordsConcatenated);
			if (concatenated.contains(str.substring(0, str.length() - 1))) {
				moreRepetitions = true;
				if (concatenated.equals(str)) {
					repeatedWord = key;
					repetitions = numberWordsConcatenated;
					moreRepetitions = false;
					return true;
				}
				for (int j = 2; j < numberWordsConcatenated; j++) {
					if (str.equals(key.repeat(j))) {
						repeatedWord = key;
						repetitions = j;
						return true;
					}
				}
				break;
			} else {
				moreRepetitions = false;
			}
		}
		return false;
	}

	public void printSolutions() {
		System.out.println(words.toString());
	}

	public TreeMap<String, Integer> getSolutions() {
		return words;
	}

	public int getTotalPoints() {
		return totalScore;
	}

	public void findBestSolution() {
		for (Map.Entry<String, Integer> entry : words.entrySet()) {
			if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
				maxEntry = entry;
			}
		}
	}

	public String getBestSolution() {
		return maxEntry.toString();
	}

}
