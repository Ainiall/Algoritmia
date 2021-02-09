package alg53522658.p6;

// estructura de datos basada en arboles que se usa para busquedas eficientes 
// en una coleccion grande de strings

// Se usa con colecciones de palabras porque los nodos hoja estan asociados con
// sus padres ya que tienen el mismo prefijo en comun

//Trie Node
class TrieNode {
    public TrieNode[] children = new TrieNode[26]; //26 letras
    public String item = "";
};

// Trie
public class Trie {
    public TrieNode root = new TrieNode();

    public void insert(String word) {
	TrieNode node = root;
	for (char c : word.toCharArray()) {
	    if (node.children[c - 'a'] == null) {
		node.children[c - 'a'] = new TrieNode();
	    }
	    node = node.children[c - 'a'];
	}
	node.item = word;
    }

    public boolean isWord(String word) {
	TrieNode node = root;
	for (char c : word.toCharArray()) {
	    if (node.children[c - 'a'] == null)
		return false;
	    node = node.children[c - 'a'];
	}
	if (node.item.equals(word)) {
	    return true;
	} else {
	    return false;
	}
    }

    public boolean startsWith(String prefix) {
	TrieNode node = root;

	for (char c : prefix.toCharArray()) {
	    if (node.children[c - 'a'] == null)
		return false;
	    node = node.children[c - 'a'];
	}
	return true;
    }
}
