package ape.chang.leetcode;

import java.util.Arrays;

public class P561 {
	
	class Solution {
	    public int arrayPairSum(int[] a) {
	        Arrays.sort(a);
	        int s = 0;
	        for (int i = 0; i < a.length; i += 2) {
	        	s += a[i];
	        }
	        return s;
	    }
	}

}
