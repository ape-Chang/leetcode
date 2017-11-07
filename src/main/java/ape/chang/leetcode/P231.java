package ape.chang.leetcode;

public class P231 {
	
	class Solution {
	    public boolean isPowerOfTwo(int n) {
	    	return n > 0 && ((n-1) & n) == 0;
	    }
	}

}
