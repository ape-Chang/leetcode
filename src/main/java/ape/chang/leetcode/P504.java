package ape.chang.leetcode;

public class P504 {
	
	class Solution {
	    public String convertToBase7(int n) {
	    	if (n == 0) {
	    		return "0";
	    	}
	        StringBuilder sb = new StringBuilder();
	        boolean neg = n < 0;
	        for (n = neg ? -n : n; n > 0; sb.append(n%7), n = n/7) {
	        	;
	        }
	        return (neg ? sb.append("-") : sb).reverse().toString();
	    }
	}

}
