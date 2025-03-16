package leetcode;

import leetcode.helper.TrieNode;

// WordDictionary
public class Solution211 {

    private final TrieNode root;

    public Solution211() {
        this.root = new TrieNode();
    }

    // Add a word to the Trie
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    // Search a word in the Trie
    public boolean search(String word) {
        return dfsSearch(word, 0, root);
    }

    // DFS search with support for '.'
    private boolean dfsSearch(String word, int index, TrieNode node) {
        if (index == word.length()) return node.isWord;

        char c = word.charAt(index);
        if (c == '.') {
            // Wildcard search: explore all possible paths
            for (TrieNode child : node.children.values()) {
                if (dfsSearch(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            // Regular character lookup
            if (!node.children.containsKey(c)) return false;
            return dfsSearch(word, index + 1, node.children.get(c));
        }
    }

    public static void main(String[] args) {
        Solution211 wordDictionary = new Solution211();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println("Search 'pad': " + wordDictionary.search("pad")); // false
        System.out.println("Search 'bad': " + wordDictionary.search("bad")); // true
        System.out.println("Search '.ad': " + wordDictionary.search(".ad")); // true
        System.out.println("Search 'b..': " + wordDictionary.search("b..")); // true
    }
}
