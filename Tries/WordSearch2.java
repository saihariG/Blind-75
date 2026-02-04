package Tries;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
    
    List<String> result = new ArrayList<>();

    // TrieNode Represen
    class TrieNode {
        private final TrieNode[] children;
        private String word;

        public TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }

    private TrieNode root = new TrieNode();

    private void insert(String word) {
        if(word.isEmpty() || word == null) return;

        TrieNode current = root;

        for(char ch: word.toCharArray()) {
            int index = ch - 'a';

            if(current.children[index] == null) {
                TrieNode temp = new TrieNode();
                current.children[index] = temp;
                current = temp;
            } else {
                current = current.children[index];
            }
        }

        // keeping track of the word itself
        current.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        
        // inserting all the words into the Trie
        for(int i = 0 ; i < words.length ; i++) {
            insert(words[i]);
        }

        for(int row = 0 ; row < board.length ; row++) {
            for(int column = 0 ; column < board[0].length ; column++) {
                dfs(board, root, row, column);
            }
        }

        return result;
    }

    private void dfs(char[][] board,
                     TrieNode node, 
                     int r, 
                     int c) {

        // checking index out of bounds
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return;
        }

        char ch = board[r][c];
        
        // checking if a character is already visited
        if(ch == '#') return;

        // checking for child nodes
        if(node.children[ch - 'a'] == null) return;

        node = node.children[ch - 'a'];

        if(node.word != null) {
            // found a word
            result.add(node.word);
            node.word = null;
        }

        // To denote if the character is visited
        board[r][c] = '#'; // we can restore it when backtracking

        dfs(board, node, r+1, c);
        dfs(board, node, r-1, c);
        dfs(board, node, r, c-1);
        dfs(board, node, r, c+1);

        board[r][c] = ch;
    }
}
