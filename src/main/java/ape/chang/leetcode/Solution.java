package ape.chang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Solution {

	/*
	 * 461
	 */
	public int hammingDistance(int x, int y) {
		return countBit(x ^ y);
	}

	/*
	 * 557
	 */
	public String reverseWords(String s) {
		char[] A = s.toCharArray();
		int n = A.length;
		int i = 0;
		int j = -1;
		while (i < n && j < n) {
			for (i = j + 1; i < n && Character.isWhitespace(A[i]); ++i) {
				;
			}
			for (j = i + 1; j < n && !Character.isWhitespace(A[j]); ++j) {
				;
			}
			{
				int p = i;
				int q = j - 1;
				while (p < q) {
					char c = A[p];
					A[p] = A[q];
					A[q] = c;
					p++;
					q--;
				}
			}
		}

		return new String(A);
	}

	/*
	 * 476
	 */
	public int findComplement(int n) {
		int k = 0;
		for (int p = n; p != 0; p >>= 1, k++)
			;

		return (~n) & ((1 << k) - 1);
	}

	/*
	 * 500
	 */
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

	/*
	 * 412
	 */
	public List<String> fizzBuzz(int n) {
		List<String> r = new ArrayList<String>();
		for (int i = 1; i <= n; ++i) {
			if (i % 15 == 0) {
				r.add("FizzBuzz");
				continue;
			}
			if (i % 3 == 0) {
				r.add("Fizz");
				continue;
			}
			if (i % 5 == 0) {
				r.add("Buzz");
				continue;
			}

			r.add(String.valueOf(i));
		}
		return r;
	}

	/*
	 * 344
	 */
	public String reverseString(String s) {
		char[] A = s.toCharArray();
		for (int i = 0, j = A.length - 1; i < j; ++i, --j) {
			char c = A[i];
			A[i] = A[j];
			A[j] = c;
		}
		return new String(A);
	}

	/*
	 * 496
	 */
	public int[] nextGreaterElement(int[] A, int[] B) {
		IntStack stack = new IntStack();
		IntIntMap next = new IntIntMap();
		for (int b : B) {
			if (stack.empty() || stack.top() >= b) {
				stack.push(b);
			} else {
				while (!stack.empty() && stack.top() < b) {
					next.put(stack.pop(), b);
				}
				stack.push(b);
			}
		}
		int[] R = new int[A.length];
		for (int i = 0; i < A.length; ++i) {
			R[i] = next.getOrDefault(A[i], -1);
		}
		return R;
	}

	// -------------------------------------------------
	// helper
	// -------------------------------------------------
	private int countBit(int n) {
		int k = 0;
		while (n != 0) {
			k++;
			n = n & (n - 1);
		}
		return k;
	}

	// -------------------------------------------------
	// data structure
	// -------------------------------------------------

	/*
	 * Not thread safe
	 */
	static class IntStack {
		private int[] stack = new int[64];
		private int p = -1;

		public IntStack() {
		}

		public void push(int x) {
			stack[++p] = x;
			if (p == stack.length) {
				// expand
				int[] newStack = new int[stack.length * 2];
				System.arraycopy(stack, 0, newStack, 0, stack.length);
				stack = newStack;
			}
		}

		public int top() {
			// ignore bound check
			return stack[p];
		}

		public int pop() {
			// ignore bound check
			return stack[p--];
		}

		public boolean empty() {
			return p < 0;
		}
	}

	/*
	 * Not thread safe. Open index. seems OK
	 */
	static class IntIntMap {

		int[] keys;
		int[] values;

		int zeroValue;
		boolean zeroValuePutted;

		int mask;

		int size;
		int capacity;

		public IntIntMap() {
			capacity = 1 << 8;
			mask = capacity - 1;
			keys = new int[capacity];
			values = new int[capacity];
		}

		public void put(int key, int value) {
			if (key == 0) {
				zeroValue = value;
				if (zeroValuePutted) {
					return;
				} else {
					zeroValuePutted = true;
					size++;
				}

			} else {
				int index;
				for (int k = key;; k++) {
					index = indexOf(k);
					if (keys[index] == 0) {
						break;
					}

					if (keys[index] == key) {
						values[index] = value;
						return;
					}
				}

				keys[index] = key;
				values[index] = value;
				size++;
			}

			if (size > capacity / 2) {
				rehash();
			}
		}

		private void rehash() {
			int[] keys = this.keys;
			int[] values = this.values;
			this.capacity *= 2;
			this.mask = capacity - 1;
			this.keys = new int[capacity];
			this.values = new int[capacity];
			for (int i = 0, n = keys.length; i < n; ++i) {
				if (keys[i] != 0) {
					put(keys[i], values[i]);
				}
			}
		}

		public int getOrDefault(int key, int defaultValue) {
			if (key == 0) {
				return zeroValuePutted ? zeroValue : defaultValue;
			}

			for (int k = key;; k++) {
				int index = indexOf(k);
				if (keys[index] == 0) {
					return defaultValue;
				}

				if (keys[index] == key) {
					return values[index];
				}
			}
		}

		public boolean contains(int key) {
			if (key == 0) {
				return zeroValuePutted;
			}

			for (int k = key;; k++) {
				int index = indexOf(k);
				if (keys[index] == 0) {
					return false;
				}

				if (keys[index] == key) {
					return true;
				}
			}
		}

		private int indexOf(int key) {
			return key & mask;
		}
	}

	static class IntList {
		int capacity;
		int p;

		int[] list;

		public IntList() {
			capacity = 1 << 8;
			list = new int[capacity];
		}

		public void add(int e) {
			list[p++] = e;
			if (p == list.length) {
				int[] ref = this.list;
				this.list = new int[ref.length * 2];
				System.arraycopy(ref, 0, this.list, 0, ref.length);
			}
		}
	}

	// -------------------------------------------------
	// argument parser
	// -------------------------------------------------
	

	// -------------------------------------------------
	// test
	// -------------------------------------------------
	@Test
	public void testHammingDistance() {
		assertEquals(hammingDistance(1, 4), 2);
	}

	@Test
	public void testReverseWords() {
		assertEquals(reverseWords("Let's take LeetCode contest"), "s'teL ekat edoCteeL tsetnoc");
	}

	@Test
	public void testFindComplement() {
		assertEquals(findComplement(5), 2);
		assertEquals(findComplement(1), 0);
		assertEquals(findComplement(2147483647), 0);
	}

	@Test
	public void testFindWords() {
		String[] words = new String[] { "Hello", "Alaska", "Dad", "Peace" };
		String[] selected = new String[] { "Alaska", "Dad" };
		assertArrayEquals(findWords(words), selected);
	}

	@Test
	public void testFizzBuzz() {
		String[] expected = new String[] { "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11",
				"Fizz", "13", "14", "FizzBuzz" };
		assertArrayEquals(fizzBuzz(15).toArray(new String[15]), expected);
	}

	@Test
	public void testReverseString() {
		assertEquals(reverseString("hello"), "olleh");
	}

	@Test
	public void testNextGreaterElement() {
		assertArrayEquals(nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 }), new int[] { -1, 3, -1 });
		assertArrayEquals(nextGreaterElement(new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 }), new int[] { 3, -1 });
	}

}
