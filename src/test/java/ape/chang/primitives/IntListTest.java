package ape.chang.primitives;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IntListTest {
	
	@Test
	public void test() {
		IntList list = new IntList();
		assertTrue(list.isEmpty());
		assertTrue(list.size() == 0);
		for (int i = 0; i < 100; ++i) {
			list.add(i);
			assertTrue(list.size() == i+1);
		}
		for (int i = 0; i < 100; ++i) {
			assertTrue(list.get(i) == i);
		}
		for (int i = 0; i < 90 ; ++i) {
			list.removeAt(9);
			assertTrue(list.get(9) == 10+i);
			assertTrue(list.size() == 99-i);
		}
		for (int i = 0; i < 10 ; ++i) {
			list.set(i, 11);
		}
		list.remove(11);
		assertTrue(list.isEmpty());
	}

}
