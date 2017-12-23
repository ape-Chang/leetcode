package ape.chang.leetcode;

public class P220 {

	class Solution {
		public boolean containsNearbyAlmostDuplicate(int[] a, int k, int t) {
			if (k <= 0 || t < 0) {
				return false;
			}

			for (int i = 0; i < a.length; ++i) {
				for (int j = i + 1, n = Math.min(i + k, a.length - 1); j <= n; ++j) {
					// a[i] - a[j] may overflow, however, i-j never overflow
					if (Math.abs(((long) a[j]) - a[i]) <= ((long) t)) {
						return true;
					}
				}
			}
			return false;
		}
	}

}
