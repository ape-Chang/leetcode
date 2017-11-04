package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class P677 {
	
	@Test
	public void test() {
		MapSum ms = new MapSum();
		ms.insert("apple", 3);
		assertThat(ms.sum("ap"), equalTo(3));
		ms.insert("app", 2);
		assertTrue(ms.sum("ap") == 5);
	}
	
	class MapSum {

	    /** Initialize your data structure here. */
	    public MapSum() {
	        
	    }
	    
	    public void insert(String key, int val) {
	        
	    }
	    
	    public int sum(String prefix) {
	    	return 0;
	    }
	}

}
