package ape.chang.leetcode;

import java.util.Objects;

public class ArrayView implements IArrayView {
	
	private int[] array;
	
	public ArrayView(int[] array) {
		this.array = Objects.requireNonNull(array);
	}

	public int length() {
		return array.length;
	}

	public int get(int index) {
		return array[index];
	}

}
