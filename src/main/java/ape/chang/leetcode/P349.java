package ape.chang.leetcode;

import java.util.Arrays;

public class P349 {
	
	class Solution {
	    public int[] intersection(int[] a, int[] b) {
	    	int n = a.length, m = b.length;
	    	int[] intersect = new int[Math.min(m, n)];
	        Arrays.sort(a);
	        Arrays.sort(b);
	        int i = 0, j = 0, k = 0;
	        while (i < n && j < m) {
	        	if (a[i] == b[j]) {
	        		intersect[k++] = a[i];
	        		for (++i; i < n && a[i] == a[i-1]; ++i)
	        			;
	        		for (++j; j < m && b[j] == b[j-1]; ++j)
	        			;
	        	} else if (a[i] < b[j]) {
	        		for (++i; i < n && a[i] == a[i-1]; ++i)
	        			;
	        	} else {
	        		for (++j; j < m && b[j] == b[j-1]; ++j)
	        			;
	        	}
	        }
	        return Arrays.copyOfRange(intersect, 0, k);
	    }
	}

}
