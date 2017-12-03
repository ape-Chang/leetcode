package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class P507 {
	
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.checkPerfectNumber(28), equalTo(true));
	}
	
	class Solution {
	    public boolean checkPerfectNumber(int n) {
	        if (n == 1) {
	        	return false;
	        }
	        
	        return fatorize(n).sumUp() == 2 * n;
	    }
	    
	    Factors fatorize(int n) {
	    	Factors factors = new Factors();
	    	int a = 2, k = 0;
	    	while (n >= a) {
	    		if (n % a == 0) {
	    			for (k = 0; n >= a && n%a == 0; n /= a) {
	    				++k;
	    			}
	    			factors.add(a, k);
	    		}
	    		++a;
	    	}
	    	return factors;
	    }
	    
	    class Factors {
	    	List<Integer> factors = new ArrayList<Integer>();
	    	
	    	{
	    		factors.add(1);
	    	}
	    	
	    	void add(int a, int k) {
	    		List<Integer> list = new ArrayList<Integer>(k);
	    		for (int i = 0, t = 1; i < k; ++i) {
	    			list.add(t = t * a);
	    		}
	    		
	    		for (int i = 0, n = factors.size(); i < n; ++i) {
	    			for (int j = 0; j < list.size(); ++j) {
	    				factors.add(factors.get(i) * list.get(j));
	    			}
	    		}
	    	}
	    	
	    	int sumUp() {
	    		int s = 0;
	    		for (Integer facor : factors) {
	    			s += facor;
	    		}
	    		return s;
	    	}
	    	
	    	@Override
	    	public String toString() {
	    		return factors.toString();
	    	}
	    }
	}

}
