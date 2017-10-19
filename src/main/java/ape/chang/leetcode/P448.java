package ape.chang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P448 {
	
	class Solution {
		
		public List<Integer> findDisappearedNumbers(int[] nums) {
			for (int i = 0; i < nums.length; ++i) {
				int index = Math.abs(nums[i]) - 1;
				if (nums[index] > 0) {
					nums[index] = -nums[index];
				}
			}

			List<Integer> ret = new ArrayList<Integer>();
			for (int i = 0; i < nums.length; ++i) {
				if (nums[i] > 0) {
					ret.add(i + 1);
				}
			}

			return ret;
		}
		
	}

}
