时间复杂度是m*n*4^(k-1). 也就是m*n*4^k.
m X n is board size, k is word size.
recuision最深是k层，recursive部分空间复杂度应该是O(k) + O(m*n)
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) {
        	return true;
        }
        if(board == null || board.length == 0 || board[0].length == 0) {
        	return false;
        }
        int m = board.length;
        int n = board[0].length;
        //注意查找类型的题目中标记数组的使用
        boolean[][] isUsed = new boolean[m][n];
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(helper(board, word, i, j, 0, isUsed)) {
        			return true;
        		}
        	}
        }
        return false;
    }
    private boolean helper(char[][] board, String word, int i, int j,int index, boolean[][] isUsed) {
    	//应该先判断index，因为递归函数中index + 1，每次是一个递进的关系，如果不先判断会造成越界
    	if(index == word.length()) {
    		return true;
    	}
    	if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j] || isUsed[i][j] == true) {
    		return false;
    	}
    	isUsed[i][j] = true;
    	boolean res = helper(board, word, i + 1, j, index + 1, isUsed) || 
    	helper(board, word, i - 1, j, index + 1, isUsed) || 
    	helper(board, word, i, j + 1, index + 1, isUsed) || 
    	helper(board, word, i, j - 1, index + 1, isUsed) ;
    	isUsed[i][j] = false;
    	return res;
    }
}