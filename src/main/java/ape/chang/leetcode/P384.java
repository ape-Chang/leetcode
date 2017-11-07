package ape.chang.leetcode;

import java.util.Arrays;
import java.util.Random;

public class P384 {
	
	class Solution {
		
		int[] a;
		Random random = new Random(System.currentTimeMillis());

	    public Solution(int[] a) {
	        this.a = a;
	    }
	    
	    /** Resets the array to its original configuration and return it. */
	    public int[] reset() {
	        return Arrays.copyOf(a, a.length);
	    }
	    
	    /** Returns a random shuffling of the array. */
	    public int[] shuffle() {
	    	int n = a.length, k, t;
	        int[] p = new int[n];
	        for (int i = 0; i < n; ++i) {
	        	p[i] = i;
	        }
	        // do the shuffle
	        for (int i = 0; i < n; ++i) {
	        	k    = random.nextInt(n-i) + i;
	        	t    = p[k];
	        	p[k] = p[i];
	        	p[i] = t;
	        }
	        int[] r = new int[n];
	        for (int i = 0; i < n; ++i)
	        	r[i] = a[p[i]];
	        return r;
	    }
	}

}
