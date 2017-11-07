package ape.chang.leetcode;

public class P342 {

	class Solution {
	    public boolean isPowerOfFour(int n) {
	    	return n > 0 && ((n-1) & n) == 0 && (0xaaaaaaaa & n) == 0;
	    }
	}
	
}
