class TrieNode {
    char c;
    boolean isWord;
    HashMap<Character, TrieNode> children;
    TrieNode() {
        isWord = false;
        children = new HashMap<Character, TrieNode>();
    }
    TrieNode(char c) {
        this.c = c;
        isWord = false;
        children = new HashMap<Character, TrieNode>();
    }
}
class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!cur.children.containsKey(c)) {
                TrieNode node = new TrieNode(c);
                cur.children.put(c, node);
            }
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
    public boolean find(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.isWord;
    }
    public boolean startWith(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return true;
    }
}
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return res;
        }
        int m = board.length;
        int n = board[0].length;
        HashSet<String> set = new HashSet<String>();
        Trie trie = new Trie();
        for(String word : words) {
            trie.insert(word);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                helper(board, trie, res, i, j, set, "");
            }
        }
        return res;
    }
    private void helper(char[][] board,  Trie trie, List<String> res, int x, int y, HashSet<String> set, String s) {
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == '#') {
            return;
        }
        s += board[x][y];
        if(!trie.startWith(s)) {
            return;
        }
        if(trie.find(s)) {
            if(!set.contains(s)) {
                res.add(s);
            }
            set.add(s);
        }
        char c = board[x][y];
        board[x][y] = '#';
        helper(board, trie, res, x + 1, y, set, s);
        helper(board, trie, res, x - 1, y, set, s);
        helper(board, trie, res, x, y + 1, set, s);
        helper(board, trie, res, x, y - 1, set, s);
        board[x][y] = c;
    }
}