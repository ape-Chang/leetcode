package ape.chang.leetcode;

public class P389 {
	
	class Solution {
		public char findTheDifference(String s, String t) {
			int[] counts = new int[26];
			for (char c : s.toCharArray()) {
				counts[c - 'a']++;
			}
			for (char c : t.toCharArray()) {
				counts[c - 'a']--;
			}
			for (int i = 0; i < counts.length; ++i) {
				if (counts[i] == -1) {
					return (char) ('a' + i);
				}
			}
			return 'A';
		}
	}

}
