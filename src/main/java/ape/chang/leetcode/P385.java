package ape.chang.leetcode;

import java.util.List;

import org.junit.Test;

public class P385 {

	// wtf is the gramma definition?!!!!

	public class NestedInteger {

		public NestedInteger() {

		}

		public NestedInteger(int value) {
		}

		public boolean isInteger() {
			return false;
		}

		public Integer getInteger() {
			return null;
		}

		public void setInteger(int value) {
		}

		public void add(NestedInteger ni) {
		}

		public List<NestedInteger> getList() {
			return null;
		}
	}
	
	// ---------------------------------------------
	// S -> E
	// E -> number | L
	// L -> [ ES ]
	// ES -> epsilon | E EX
	// EX -> epsilon | , E EX

	class Solution {
		
		char[] buffer;
		int p;
		
		public NestedInteger deserialize(String s) {
			buffer = s.toCharArray();
			p = 0;
			return parse();
		}
		
		private NestedInteger parse() {
			return parseElement();
		}
		
		private NestedInteger parseElement() {
			if(buffer[p] == '[') {
				p++;
				return parseList();
			} else {
				return new NestedInteger(parseInteger());
			}
		}
		
		private NestedInteger parseList() {
			NestedInteger list = new NestedInteger();
			if (buffer[p] == ']') {
				p++;
			} else {
				list.add(parseElement());
				while (true) {
					if (buffer[p] == ',') {
						++p;
						list.add(parseElement());
					} else {
						++p;
						break;
					}
				}
			}
			return list;
		}
		
		private int parseInteger() {
			int sign = 1;
			if (buffer[p] == '-') {
				sign = -1;
				++p;
			} 
			int val = 0;
			for (; p < buffer.length && Character.isDigit(buffer[p]); ++p) {
				val = val * 10 + (buffer[p] - '0');
			}
			
			return sign * val;
		}
	}
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		solution.deserialize("324");
	}

}
