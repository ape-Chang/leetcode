package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class P542 {

	Solution solution = new Solution();

	@Test
	public void test() {
		assertThat(solution.updateMatrix(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }),
				equalTo(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));

		assertThat(solution.updateMatrix(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } }),
				equalTo(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 2, 1 } }));
	}

	class Solution {
		public int[][] updateMatrix(int[][] matrix) {
			int n = matrix.length, m = matrix[0].length;
			Queue<int[]> queue = new LinkedList<>();
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < m; ++j) {
					int[] p = new int[] { i, j };
					if (matrix[i][j] == 0) {
						queue.add(p);
					} else {
						matrix[i][j] = Integer.MAX_VALUE;
					}
				}
			}

			int[][] dirs = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

			for (int k = 1; !queue.isEmpty(); ++k) {
				int s = queue.size();
				while (s-- > 0) {
					int[] p = queue.poll();
					for (int[] dir : dirs) {
						int x = p[0] + dir[0];
						int y = p[1] + dir[1];
						if (x >= 0 && x < n && y >= 0 && y < m && matrix[x][y] > k) {
							matrix[x][y] = k;
							queue.offer(new int[] { x, y });
						}
					}
				}
			}
			return matrix;
		}
	}

}
