package ape.chang.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class P690 {
	
	class Employee {
	    // It's the unique id of each node;
	    // unique id of this employee
	    public int id;
	    // the importance value of this employee
	    public int importance;
	    // the id of direct subordinates
	    public List<Integer> subordinates;
	};
	
	class Solution {
	    public int getImportance(List<Employee> emps, int id) {
	    	Map<Integer, Employee> map = new HashMap<>();
	        for (Employee emp : emps) {
	        	map.put(emp.id, emp);
	        }
	        
	        Queue<Integer> queue = new LinkedList<>();
	        queue.offer(id);
	        int s = 0;
	        while (!queue.isEmpty()) {
	        	Integer empId = queue.poll();
	        	Employee emp = map.get(empId);
	        	s += emp.importance;
	        	queue.addAll(emp.subordinates);
	        }
	        return s;
	    }
	}

}
