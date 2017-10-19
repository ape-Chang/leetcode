package ape.chang.leetcode;

public class P557 {
	
	class Solution {
		public String reverseWords(String s) {
			char[] A = s.toCharArray();
			int n = A.length;
			int i = 0;
			int j = -1;
			while (i < n && j < n) {
				for (i = j + 1; i < n && Character.isWhitespace(A[i]); ++i) {
					;
				}
				for (j = i + 1; j < n && !Character.isWhitespace(A[j]); ++j) {
					;
				}
				{
					int p = i;
					int q = j - 1;
					while (p < q) {
						char c = A[p];
						A[p] = A[q];
						A[q] = c;
						p++;
						q--;
					}
				}
			}

			return new String(A);
		}
	}

}
