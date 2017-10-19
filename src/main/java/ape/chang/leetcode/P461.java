package ape.chang.leetcode;

public class P461 {
	
	class Solution {
		
		public int hammingDistance(int x, int y) {
			return countBit(x ^ y);
		}
		
		private int countBit(int n) {
			int k = 0;
			while (n != 0) {
				k++;
				n = n & (n - 1);
			}
			return k;
		}
	}

}
