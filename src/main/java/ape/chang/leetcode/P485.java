package ape.chang.leetcode;

public class P485 {
	
	class Solution {
		
		public int findMaxConsecutiveOnes(int[] nums) {
			int max = 0, consecutives = 0;
			for (int i = 0, n = nums.length; i < n; ++i) {
				if (nums[i] == 1) {
					consecutives++;
				} else {
					max = Math.max(max, consecutives);
					consecutives = 0;
				}
			}
			return Math.max(max, consecutives);
		}
		
	}

}
