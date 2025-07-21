package leetcode;

import java.util.*;

/**
 * LeetCode Problem 1268: Search Suggestions System :
 * <p>
 * Given an array of products and a search word, this class provides a method to
 * return a list of suggested products based on the search word. The suggestions
 * are sorted lexicographically and limited to a maximum of three suggestions per prefix.
 */
public class Solution1268 {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        int n = products.length;
        String prefix = "";

        for (char ch : searchWord.toCharArray()) {
            prefix += ch;
            List<String> suggestions = new ArrayList<>();

            // Binary Search to find left-most start of prefix
            int start = lowerBound(products, prefix);

            // Add up to 3 matching products
            for (int i = start; i < Math.min(start + 3, n); i++) {
                if (products[i].startsWith(prefix)) {
                    suggestions.add(products[i]);
                } else {
                    break;
                }
            }
            result.add(suggestions);
        }

        return result;
    }

    // Custom lower bound: returns first index >= prefix
    private int lowerBound(String[] products, String prefix) {
        int low = 0, high = products.length;

        while (low < high) {
            int mid = (low + high) >> 1; // Equivalent to (low + high) / 2
            if (products[mid].compareTo(prefix) < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

//    // TrieNode class
//    static class TrieNode {
//        Map<Character, TrieNode> children = new TreeMap<>();
//        List<String> suggestions = new ArrayList<>();
//    }
//
//    private TrieNode root = new TrieNode();
//
//    // Insert a word into the trie
//    private void insert(String product) {
//        TrieNode node = root;
//        for (char ch : product.toCharArray()) {
//            node.children.putIfAbsent(ch, new TrieNode());
//            node = node.children.get(ch);
//
//            // Add product to suggestions list if under 3
//            if (node.suggestions.size() < 3) {
//                node.suggestions.add(product);
//            }
//        }
//    }
//
//    // Search trie based on each prefix of searchWord
//    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
//        Arrays.sort(products); // So lex order is preserved
//        for (String product : products) {
//            insert(product);
//        }
//
//        List<List<String>> result = new ArrayList<>();
//        TrieNode node = root;
//
//        for (char ch : searchWord.toCharArray()) {
//            if (node != null) {
//                node = node.children.get(ch);
//            }
//            if (node != null) {
//                result.add(node.suggestions);
//            } else {
//                result.add(new ArrayList<>());
//            }
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        Solution1268 sol = new Solution1268();
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        List<List<String>> res = sol.suggestedProducts(products, searchWord);
        for (List<String> list : res) {
            System.out.println(list);
        }
    }
}
