时间复杂度Omnjk^4,j是words长度，k是单词平均长度
空间 Omn + Ok 
TLE;考虑方法二，Trie
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0){
        	return res;
        }
        for(String word : words) {
        	if(helper(board, word)) {
        		res.add(word);
        	}
        }
        return res;
    }
    private boolean helper(char[][] board, String word) {
    	int m = board.length;
    	int n = board[0].length;
    	boolean[][] isUsed = new boolean[m][n];
    	for(int i = 0; i < m; i++) {
    		for(int j = 0; j < n; j++) {
    			if(helper1(board, word, i, j, isUsed, 0)) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
    private boolean helper1(char[][] board, String word, int i, int j, boolean[][] isUsed, int index) {
    	if(index == word.length()) {
    		return true;
    	}
    	if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || isUsed[i][j] == true || word.charAt(index) != board[i][j]) {
    		return false;
    	}
    	isUsed[i][j] = true;
    	boolean res = helper1(board, word, i + 1, j, isUsed, index + 1) ||
    	helper1(board, word, i - 1, j, isUsed, index + 1) || 
    	helper1(board, word, i, j + 1, isUsed, index + 1) || 
    	helper1(board, word, i, j - 1, isUsed, index + 1) ;
    	isUsed[i][j] = false;
    	return res;
    }
}