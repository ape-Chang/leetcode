package ape.chang.primitives;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IntDisjointSetTest {
	
	@Test
	public void test() {
		IntDisjointSet set = new IntDisjointSet(10);
		for (int i = 0; i < 10; ++i) {
			for (int j = 0; j < 10; ++j) {				
				if (i == j) {
					assertTrue(set.find(i) == set.find(j));
				} else {
					assertTrue(set.find(i) != set.find(j));
				}
			}
		}
		
		for (int i = 1; i < 5; ++i) {
			set.union(i, i - 1);
		}
		
		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {				
				assertTrue(set.find(i) == set.find(j));
			}
		}
		
		for (int i = 6; i < 10; ++i) {
			set.union(i, i - 1);
		}
		
		for (int i = 5; i < 10; ++i) {
			for (int j = 5; j < 10; ++j) {				
				assertTrue(set.find(i) == set.find(j));
			}
		}
		
		for (int i = 0; i < 5; ++i) {
			for (int j = 5; j < 10; ++j) {				
				assertTrue(set.find(i) != set.find(j));
			}
		}
	}
	

}
