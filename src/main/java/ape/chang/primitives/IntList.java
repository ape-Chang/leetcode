package ape.chang.primitives;

public class IntList {

	// The API

	public IntList() {
		list = new int[16];
	}

	public void add(int x) {
		list[size++] = x;
		if (size == list.length) {
			expand();
		}
	}

	public void set(int k, int x) {
		if (k >= size) {
			throw new IllegalArgumentException();
		}
		list[k] = x;
	}

	public int get(int k) {
		if (k >= size) {
			throw new IllegalArgumentException();
		}
		return list[k];
	}

	public void remove(int x) {
		for (int i = 0, p = 0, n = size; i < n; ++i) {
			if (list[i] != x) {
				list[p++] = list[i];
			} else {
				size--;
			}
		}
	}

	public void removeAt(int k) {
		if (k >= size || k < 0) {
			throw new IllegalArgumentException();
		}
		
		size--;
		for (int i = k; i < size; ++i) {
			list[i] = list[i+1];
		}
	}
	
	public int indexOf(int x) {
		return firstIndexOf(x);
	}
	
	public int lastIndexOf(int x) {
		for (int i = size-1; i >= 0; --i) {
			if (list[i] == x)  {
				return i;
			}
		}
		return -1;
	}
	
	public int firstIndexOf(int x) {
		for (int i = 0; i < size; ++i) {
			if (list[i] == x)  {
				return i;
			}
		}
		return -1;
	}
	
	public boolean contains(int x) {
		for (int i = 0; i < size; ++i) {
			if (list[i] == x)  {
				return true;
			}
		}
		return false;
	}
	
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < size; ++i) {
			sb.append(list[i]).append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof IntList)) {
			return false;
		}
		IntList l = (IntList) o;
		for (int i = 0; i < size; ++i) {
			if (get(i) != l.get(i)) {
				return false;
			}
		}
		return true;
	}
	// The implementation

	int[] list;
	int size;

	void expand() {
		int[] newList = new int[(list.length << 1)];
		System.arraycopy(list, 0, newList, 0, size);
	}

}
