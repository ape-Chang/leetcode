package ape.chang.leetcode;

public class P520 {
	
	class Solution {
		
		public boolean detectCapitalUse1(String word) {
			int capitals = 0, n = word.length();
			for (int i = 0; i < n; ++i) {
				capitals += (Character.isUpperCase(word.charAt(i)) ? 1 : 0);
			}
			return capitals == 0 || capitals == n || (capitals == 1 && Character.isUpperCase(word.charAt(0)));
		}
		
		public boolean detectCapitalUse(String word) {
			int n = word.length();
			if (n <= 1) {
				return true;
			}

			boolean firstCapital = Character.isUpperCase(word.charAt(0));
			boolean secondCapital = Character.isUpperCase(word.charAt(1));
			if (firstCapital && secondCapital) {
				for (int i = 2; i < n; ++i) {
					if (Character.isLowerCase(word.charAt(i))) {
						return false;
					}
				}
				return true;
			}

			if (firstCapital && !secondCapital || (!firstCapital && !secondCapital)) {
				for (int i = 2; i < n; ++i) {
					if (Character.isUpperCase(word.charAt(i))) {
						return false;
					}
				}
				return true;
			}

			return false;
		}
		
	}

}
