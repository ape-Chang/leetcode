package ape.chang.leetcode;

public class P680 {

	class Solution {
		public boolean validPalindrome(String s) {
			int i = 0, j = s.length() - 1;
			for (; i < j; ++i, --j) {
				if (s.charAt(i) != s.charAt(j)) {
					return cont(s, i, j-1) || cont(s, i+1, j);
				}
			}
			return true;
		}

		boolean cont(String s, int l, int r) {
			for (; l < r; ++l, --r) {
				if (s.charAt(l) != s.charAt(r)) {
					return false;
				}
			}
			return true;
		}
	}

}
