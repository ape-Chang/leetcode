package ape.chang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P500 {
	
	class Solution {
		
		public String[] findWords(String[] words) {
			int[] rowIndexMap = new int[] {
					// a, b, c, d, e,
					2, 3, 3, 2, 1,
					// f, g, h, i, j,
					2, 2, 2, 1, 2,
					// k, l, m, n, o,
					2, 2, 3, 3, 1,
					// p, q, r, s, t,
					1, 1, 1, 2, 1,
					// u, v, w, x, y, z
					1, 3, 1, 3, 1, 3 };
			List<String> selected = new ArrayList<String>();
			for (String word : words) {
				char[] A = word.toLowerCase().toCharArray();
				int rowIndex = rowIndexMap[A[0] - 'a'];
				int i = 1, n = A.length;
				for (; i < n; ++i) {
					if (rowIndexMap[A[i] - 'a'] != rowIndex) {
						break;
					}
				}
				if (i == n) {
					selected.add(word);
				}
			}
			return selected.toArray(new String[selected.size()]);
		}
		
	}

}
