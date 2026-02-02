package Tries;

public class DesignAddSearchWordDataStructure {

    private final TrieNode root;

    static class TrieNode {
        private final TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    public DesignAddSearchWordDataStructure() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        if(word.length() == 0 || word == null) {
            return;
        }

        word = word.toLowerCase();
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
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, TrieNode root) {
        TrieNode current = root;

        for(int i = j ; i < word.length() ; i++) {

            char ch = word.charAt(i);

            if(ch == '.') {
                for(TrieNode child: current.children) {
                    if(child != null && dfs(word, i+1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                int index = ch - 'a';

                if(current.children[index] == null) {
                    return false;
                } else {
                    current = current.children[index];
                }
            }
        }

        return current.isWord;
    }
}
