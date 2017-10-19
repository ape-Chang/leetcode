package ape.chang.leetcode;

public class P476 {
	
	class Solution {
		public int findComplement(int n) {
			int k = 0;
			for (int p = n; p != 0; p >>= 1, k++)
				;

			return (~n) & ((1 << k) - 1);
		}
	}

}
