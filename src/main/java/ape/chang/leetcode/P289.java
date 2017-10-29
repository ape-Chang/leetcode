package ape.chang.leetcode;

public class P289 {
	
	class Solution {
	    public void gameOfLife(int[][] board) {
	    	int n = board.length, m = board[0].length;
	    	for (int i = 0; i < n; ++i) {
	    		for (int j = 0; j < m; ++j) {
	    			int lives = 0;
	    			lives += (i > 0              && (board[i-1][j]   & 0x1) == 1) ? 1 : 0;
	    			lives += (i > 0   && j > 0   && (board[i-1][j-1] & 0x1) == 1) ? 1 : 0;
	    			lives += (           j > 0   && (board[i][j-1]   & 0x1) == 1) ? 1 : 0;
	    			lives += (i < n-1 && j > 0   && (board[i+1][j-1] & 0x1) == 1) ? 1 : 0;
	    			lives += (i < n-1            && (board[i+1][j]   & 0x1) == 1) ? 1 : 0;
	    			lives += (i < n-1 && j < m-1 && (board[i+1][j+1] & 0x1) == 1) ? 1 : 0;
	    			lives += (           j < m-1 && (board[i][j+1]   & 0x1) == 1) ? 1 : 0;
	    			lives += (i > 0   && j < m-1 && (board[i-1][j+1] & 0x1) == 1) ? 1 : 0;
	    			// if live on next generation, turn on the 2nd bit
	    			if (board[i][j] == 0) {
	    				if (lives == 3) {
	    					board[i][j] |= 0x2;
	    				}
	    			} else {
	    				if (lives == 2 || lives == 3) {
	    					board[i][j] |= 0x2;
	    				} 
	    			}
	    		}
	    	}
	    	
	    	for (int i = 0; i < n; ++i){
	    		for (int j = 0; j < m; ++j){
	    			board[i][j] >>>= 1;
	    		}
	    	}
	    }
	}

}
