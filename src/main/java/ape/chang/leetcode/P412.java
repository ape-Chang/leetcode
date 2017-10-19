package ape.chang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P412 {
	
	class Solution {
		
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
		
	}

}
