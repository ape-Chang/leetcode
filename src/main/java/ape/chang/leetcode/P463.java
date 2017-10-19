package ape.chang.leetcode;

public class P463 {
	
	class Solution {
		public int islandPerimeter(int[][] M) {
			int n = M.length;
			int m = M[0].length;
			int islands = 0;
			int connections = 0;
			for (int i = 0, state = 0; i < n; ++i) {
				boolean hasIslandInThisRow = false;
				for (int j = 0; j < m; ++j) {
					if (M[i][j] == 1) {
						++islands;
						if (j > 0 && M[i][j - 1] == 1) {
							++connections;
						}
						if (i > 0 && M[i - 1][j] == 1) {
							++connections;
						}
						hasIslandInThisRow = true;
					}
				}

				// this is a little speed up, no need to examine next rows.
				if (hasIslandInThisRow) {
					state = 1;
				} else {
					if (state == 1) {
						break;
					}
				}
			}
			return islands * 4 - connections * 2;
		}
	}

}
