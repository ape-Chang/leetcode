package ape.chang.primitives;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class IntSet {

	// The API

	public IntSet() {
		slots = new int[16];
		for (int i = 0; i < slots.length; ++i) {
			slots[i] = NOT_A_KEY;
		}
		mask = 0xf;
	}

	public int size() {
		return size;
	}

	public void add(int x) {
		if (contains(x)) {
			return;
		}

		// load factor .5
		if (((++size) << 1) == slots.length) {
			expandAndRehash();
		}
		doAdd(x);
	}

	public void remove(int x) {
		int k = index(x);
		if (k != -1) {
			slots[k] = NOT_A_KEY;
			size--;
		}
	}

	public boolean contains(int x) {
		return index(x) != -1;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	// The Implementation

	int index(int x) {
		int k = hash(x);
		while (true) {
			if (slots[k] == x) {
				return k;
			}
			if (slots[k] == NOT_A_KEY) {
				return -1;
			}
			if (++k == slots.length) {
				k = 0;
			}
		}
	}

	void doAdd(int x) {
		int k = hash(x);
		while (true) {
			if (slots[k] == NOT_A_KEY) {
				slots[k] = x;
				return;
			}
			
			if (++k == slots.length) {
				k = 0;
			}
		}
	}

	void expandAndRehash() {
		int[] newSlots = new int[slots.length << 1], t = slots;
		for (int i = 0; i < newSlots.length; ++i) {
			newSlots[i] = NOT_A_KEY;
		}

		slots = newSlots;
		
		for (int x : t) {
			if (x != NOT_A_KEY) {
				doAdd(x);
			}
		}

		// ---------------
		mask = (mask << 1) + 1;
	}

	int hash(int x) {
		return (x * 0x32124533) & mask;
	}

	int[] slots;
	int size;

	int mask;

	static final int NOT_A_KEY = Integer.MAX_VALUE;
	
	// The test
	
	@Test
	public void test() {
		IntSet set = new IntSet();
		assertThat(set.isEmpty(), equalTo(true));
		for (int i = 0; i < 32; ++i) {
			set.add(i);
			assertThat(set.isEmpty(), equalTo(false));
			assertThat(set.size(), equalTo(i+1));
			assertThat(set.contains(i), equalTo(true));
		}
		for (int i = 0; i < 32; ++i) {
			set.add(i);
			assertThat(set.size(), equalTo(32));
		}
		for (int i = 0; i < 32; ++i) {
			set.remove(i);
		}
	}

}
