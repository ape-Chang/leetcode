package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P374 {
	
	@Test
	public void test() {
		Solution solution;
		
		solution = new Solution(6);
		assertThat(solution.guessNumber(10), equalTo(6));
		
		solution = new Solution(1702766719);
		assertThat(solution.guessNumber(2126753390), equalTo(1702766719));
	}
	
	public class GuessGame {
		int p;
		GuessGame(int p) {
			this.p = p;
		}
		
		int guess(int k) {
			return p - k;
		}
	}
	
	public class Solution extends GuessGame {
	    Solution(int p) {
			super(p);
		}

		public int guessNumber(int n) {
	        int l = 1, h = n, m, g;
	        while (l < h) {
	        	// l+h maybe overflow
	        	m = l + (h-l) / 2;
	        	g = guess(m);
	        	if (g == 0) {
	        		return m;
	        	}
	        	
	        	if (g > 0) {
	        		l = m+1;
	        	} else {
	        		h = m-1;
	        	}
	        }
	        // l == m at this point
	        return l;
	    }
	}

}
