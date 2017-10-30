package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class P599 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.findRestaurant(new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[] {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"}), equalTo(new String[] {"Shogun"}));
	}
	
	class Solution {
	    public String[] findRestaurant(String[] list1, String[] list2) {
	    	Map<String, Integer> map = new HashMap<String, Integer>();
	    	for (int i = 0; i < list1.length; ++i) {
	    		map.put(list1[i], i);
	    	}
	    	List<String> common = new ArrayList<String>();
	    	int min = list1.length + list2.length;
	    	for (int i = 0; i < list2.length; ++i) {
	    		if (map.containsKey(list2[i])) {
	    			int s = map.get(list2[i]) + i;
	    			if (s == min) {
	    				common.add(list2[i]);
	    			} else if (s < min) {
	    				min = s;
	    				common.clear();
	    				common.add(list2[i]);
	    			}
	    		}
	    	}
	    	return common.toArray(new String[common.size()]);
	    }
	}

}
