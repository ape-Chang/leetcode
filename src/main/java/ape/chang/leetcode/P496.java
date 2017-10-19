package ape.chang.leetcode;

import ape.chang.leetcode.Solution.IntIntMap;
import ape.chang.leetcode.Solution.IntStack;

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
		
	}

}
