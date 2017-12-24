package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class P322 {
	
	/*
	 * Classic DP problem
	 */
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.coinChange(new int[] {1, 2, 5}, 11), equalTo(3));
		assertThat(solution.coinChange(new int[] {2}, 3), equalTo(-1));
	}
	
	class Solution {
	    public int coinChange(int[] coins, int amount) {
	        // let's dp it
	        // a[i] means fewest number of coins to make up i
	        int[] a = new int[amount+1];
	        Arrays.fill(a, -1);
	        a[0] = 0;
	        // v is the value/amount
	        for (int v = 1; v < a.length; ++v) {
	        	for (int i = 0; i < coins.length; ++i) {
	        		if (v >= coins[i] && a[v-coins[i]] != -1) {
	        			if (a[v] == -1) {
	        				// first time to find the solution
	        				// just assign it
	        				a[v] = a[v-coins[i]] + 1;
	        			} else {
	        				// another time to find the solution
	        				// choose the smaller one
	        				a[v] = Math.min(a[v], a[v-coins[i]] + 1);
	        			}
	        		}
	        	}
	        }
	        return a[amount];
	    }
	}

}
