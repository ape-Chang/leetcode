package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;

public class P609 {
	
	@Test
	public void test() {
		// can't pass the test
		// according the problem description, the order of result 
		// is irrelevant, but why this interface?
		// maybe we do some adapting.
		Solution solution = new Solution();
		assertThat(
				Arrays.asList(Arrays.asList("root/a/2.txt","root/c/d/4.txt","root/4.txt"), 
				Arrays.asList("root/a/1.txt","root/c/3.txt")), 
				
				equalTo(solution.findDuplicate(new String[] {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"})));
	}
	
	class Solution {
	    public List<List<String>> findDuplicate(String[] paths) {
	    	LinkedHashMap<String, List<String>> map = new LinkedHashMap<String, List<String>>();
	    	for (String path : paths) {
	    		String[] parts = path.split("\\s+");
	    		String dir = parts[0];
	    		for (int i = 1; i < parts.length; ++i) {
	    			int l = parts[i].indexOf("(");
	    			int r = parts[i].indexOf(")", l);
	    			String filename = parts[i].substring(0, l);
	    			String content = parts[i].substring(l+1, r);
	    			String absPath = dir.equals("/") ? (dir + filename) : (dir + "/" + filename);
	    			
	    			if (!map.containsKey(content)) {
	    				map.put(content, new ArrayList<String>());
	    			}
	    			map.get(content).add(absPath);
	    		}
	    	}
	    	
	    	List<List<String>> duplicates = new ArrayList<List<String>>();
	    	for (Entry<String, List<String>> entry : map.entrySet()) {
	    		List<String> value = entry.getValue();
	    		if (value.size() > 1) {
	    			duplicates.add(value);
	    		}
	    	}
	        return duplicates;
	    }
	}

}
