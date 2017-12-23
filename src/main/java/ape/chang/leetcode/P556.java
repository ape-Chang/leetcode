package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P556 {

	Solution solution = new Solution();

	@Test
	public void test() {
		 assertThat(solution.nextGreaterElement(21), equalTo(-1));
		 assertThat(solution.nextGreaterElement(12), equalTo(21));
		 assertThat(solution.nextGreaterElement(1999999999), equalTo(-1));
	}

	class Solution {

		public int nextGreaterElement(int n) {
			// get the digits
			int[] digits = new int[10];
			int k = 0;
			for (; n > 0; ++k, n /= 10) {
				digits[k] = n % 10;
			}
			// first find the turning point
			int p = 1;
			for (int i = 0; p < k; ++i, ++p) {
				if (digits[p] < digits[i]) {
					break;
				}
			}

			// which means digits is sorted ascend
			if (p == k) {
				return -1;
			}

			// then find the smallest number larger than turning point
			int q = 0;
			for (; q < p; ++q) {
				if (digits[q] > digits[p]) {
					break;
				}
			}
			// swap
			swap(digits, p, q);
			// sort descending of numbers previous of turning point
			reverse(digits, 0, p - 1);
			// reconstruct the number, may overflow
			long m = 0, b = 1;
			for (int i = 0; i < k; ++i, b *= 10) {
				m += (digits[i] * b);
			}
			return m > Integer.MAX_VALUE ? -1 : (int) m;
		}

		void reverse(int[] a, int p, int q) {
			for (; p < q; ++p, --q) {
				swap(a, p, q);
			}
		}

		void swap(int[] a, int p, int q) {
			a[p] ^= a[q];
			a[q] ^= a[p];
			a[p] ^= a[q];
		}
	}

}
