package leetcode.common;

public class TrieNode2 {

    public TrieNode2[] children;
    public String word; // Store word at end of a valid path

    public TrieNode2() {
        this.children = new TrieNode2[26];
        this.word = null;
    }
}
