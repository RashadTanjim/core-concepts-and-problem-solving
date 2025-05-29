package leetcode;

import leetcode.common.TrieNode;

import java.util.ArrayList;
import java.util.List;

// Trie class
class Solution208 {
    private final TrieNode root;

    public Solution208() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    private TrieNode findNode(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return null;
            }
            node = node.children.get(c);
        }
        return node;
    }

    public List<String> getNextWords(String word) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char original = chars[i];

            for (char c = 'a'; c <= 'z'; c++) {
                if (c == original) continue;

                chars[i] = c;
                if (search(new String(chars))) {
                    neighbors.add(new String(chars));
                }
            }
            chars[i] = original;
        }
        return neighbors;
    }

    public boolean delete(String word) {
        return deleteHelper(root, word, 0);
    }

    private boolean deleteHelper(TrieNode node, String word, int index) {
        if (index == word.length()) {
            if (!node.isWord) return false; // Word doesn't exist
            node.isWord = false; // Unmark the word
            return node.children.isEmpty(); // If no children, node can be deleted
        }

        char c = word.charAt(index);
        TrieNode child = node.children.get(c);
        if (child == null) return false; // Word doesn't exist

        boolean shouldDelete = deleteHelper(child, word, index + 1);

        if (shouldDelete) {
            node.children.remove(c);
            return node.children.isEmpty() && !node.isWord;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution208 trie = new Solution208();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");

        System.out.println(trie.search("apple")); // true
        System.out.println(trie.search("app"));   // true
        System.out.println(trie.startsWith("ba"));// true

        trie.delete("apple");
        System.out.println(trie.search("apple")); // false
        System.out.println(trie.search("app"));   // true

        trie.delete("app");
        System.out.println(trie.search("app"));   // false
        System.out.println(trie.startsWith("app"));// false
    }
}
