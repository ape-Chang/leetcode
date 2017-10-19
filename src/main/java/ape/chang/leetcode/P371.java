package ape.chang.leetcode;

public class P371 {
	
	class Solution {
		public int getSum(int a, int b) {
			int s = a, c = b;
			do {
				a = s;
				b = c;
				s = a ^ b;
				c = (a & b) << 1;
			} while (c != 0);
			return s;
		}
	}

}
