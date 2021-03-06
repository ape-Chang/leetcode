package ape.chang.primitives;

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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < slots.length; ++i) {
			if (slots[i] != NOT_A_KEY) {				
				sb.append(slots[i]).append(",");
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
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
		// ---------------
		mask = (mask << 1) + 1;
		
		for (int x : t) {
			if (x != NOT_A_KEY) {
				doAdd(x);
			}
		}

	}

	int hash(int x) {
		return (x * 0x1989 + 0x0806) & mask;
	}

	int[] slots;
	int size;

	int mask;

	static final int NOT_A_KEY = Integer.MAX_VALUE;
	
}
