package ape.chang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 406
 */
public class LFUCache {
	
	int size;
	int capacity;
	
	Map<Integer, Entry> map;
	Entry head;
	Entry tail;
	
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        
        this.map = new HashMap<Integer, LFUCache.Entry>(capacity);
        head = tail = new Entry();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
    	Entry entry = map.get(key);
    	if (entry == null) {
    		return -1;
    	} else {
    		int freq = entry.frequency + 1;
    		entry.frequency = freq;
    		
    		Entry p = entry.prev;
    		while (p != null && p.frequency == freq) {
    			p = p.prev;
    		}
    		
    		entry.prev.next = entry.next;
    		entry.next.prev = entry.prev;
    		
    		if (p == null) {
    			
    		} else {
    			entry.next = p.next;
        		p.next.prev = entry;
    			p.next = entry;
        		entry.prev = p;
    		}
    		
    		return entry.value;
    	}
    }
    
    public void put(int key, int value) {
        
    }
    
    static class Entry {
    	public int key;
    	public int value;
    	public int frequency;
    	public Entry next;
    	public Entry prev;
    }
    
	
	public static void main(String[] args) {
		
	}

}
