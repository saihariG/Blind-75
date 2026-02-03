package Tries;

public class PrefixTree {
    
    private final TrieNode root;

    static class TrieNode {
        private final TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if(word.isEmpty() || word == null) {
            return;
        }

        TrieNode current = root;

        for(int i = 0 ; i < word.length() ; i++) {
            
            char ch = word.charAt(i);
            int index = ch - 'a';

            if(current.children[index] == null) {
                TrieNode temp = new TrieNode();
                current.children[index] = temp;
                current = temp;
            } else {
                current = current.children[index];
            }
        }

        current.isWord = true;
    }

    public boolean search(String word) {
        
        TrieNode current = root;

        for(int i = 0 ; i < word.length() ; i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';

            if(current.children[index] == null) {
                return false;
            } else {
                current = current.children[index];
            }

        }

        return current.isWord;
    }

    public boolean startsWith(String prefix) {

        TrieNode current = root;

        for(int i = 0 ; i < prefix.length() ; i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';

            if(current.children[index] == null) {
                return false;
            } else {
                current = current.children[index];
            }
        }

        return true;
    }
}
