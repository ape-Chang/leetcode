package ape.chang.leetcode;

import java.util.Iterator;

public class P284 {
	
	class PeekingIterator implements Iterator<Integer> {
		
		Integer peek;
		Iterator<Integer> iterator;

		public PeekingIterator(Iterator<Integer> iterator) {
		    this.iterator = iterator;
		}

		public Integer peek() {
	        if (peek == null) {
	        	peek = iterator.next();
	        }
	        return peek;
		}

		
		public Integer next() {
		    if (peek == null) {
		    	return iterator.next();
		    } else {
		    	Integer p = peek;
		    	peek = null;
		    	return p;
		    }
		}

		public boolean hasNext() {
		    return peek != null ? true : iterator.hasNext();
		}
	}

}
