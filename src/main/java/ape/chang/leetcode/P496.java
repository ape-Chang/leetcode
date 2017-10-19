package ape.chang.leetcode;

public class P496 {
	
	class Solution {
		
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
		
		class IntStack {
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
		class IntIntMap {

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
		
	}

}
