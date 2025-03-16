package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution212 {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; // Store word at end of a valid path
    }

    private final TrieNode root = new TrieNode();
    private final List<String> result = new ArrayList<>();

    // Inserts a word into the Trie
    private void insertWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.word = word; // Store complete word
    }

    public List<String> findWords(char[][] board, String[] words) {
        // Step 1: Build Trie with words
        for (String word : words) {
            insertWord(word);
        }

        // Step 2: Start DFS from every cell
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node) {
        char c = board[i][j];

        // Step 3: Stop search if no matching Trie path
        if (c == '#' || node.children[c - 'a'] == null) return;

        node = node.children[c - 'a'];

        // Step 4: If we found a word, add to result and remove from Trie
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Avoid duplicate results
        }

        // Step 5: Mark cell as visited
        board[i][j] = '#';

        // Step 6: Explore neighbors (Up, Down, Left, Right)
        if (i > 0) dfs(board, i - 1, j, node); // Up
        if (i < board.length - 1) dfs(board, i + 1, j, node); // Down
        if (j > 0) dfs(board, i, j - 1, node); // Left
        if (j < board[0].length - 1) dfs(board, i, j + 1, node); // Right

        // Step 7: Restore cell
        board[i][j] = c;
    }

    public static void main(String[] args) {
        Solution212 solution = new Solution212();
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(solution.findWords(board, words)); // Output: [oath, eat]
    }
}