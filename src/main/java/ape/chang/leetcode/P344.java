package ape.chang.leetcode;

public class P344 {
	
	class Solution {
		
		public String reverseString(String s) {
			char[] A = s.toCharArray();
			for (int i = 0, j = A.length - 1; i < j; ++i, --j) {
				char c = A[i];
				A[i] = A[j];
				A[j] = c;
			}
			return new String(A);
		}
		
	}

}
