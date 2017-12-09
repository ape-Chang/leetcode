package ape.chang.leetcode;

public class P414 {
	
	class Solution {
	    public int thirdMax(int[] a) {
	    	Integer f = null, s = null, t = null;
	    	for (int i : a) {
	    		if ((f != null && f.intValue() == i) ||
	    				(s != null && s.intValue() == i ||
	    				(t != null && t.intValue() == i))) {
	    			continue;
	    		}
	    		if (f == null) {
	    			f = i;
	    		} else if (f.intValue() < i) {
	    			t = s;
	    			s = f;
	    			f = i;
	    		} else if (s == null) {
	    			s = i;
	    		} else if (s.intValue() < i) {
	    			t = s;
	    			s = i;
	    		} else if (t == null || t.intValue() < i) {
	    			t = i;
	    		} 
	    	}
	    	return t == null ? f : t;
	    }
	}

}
