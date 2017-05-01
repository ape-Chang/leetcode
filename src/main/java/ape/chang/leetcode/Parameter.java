package ape.chang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Parameter {

	final char[] buffer;
	final int n;
	int p;

	public Parameter(String literal) {
		buffer = literal.toCharArray();
		n = buffer.length;
	}
	
	public static Parameter from(String literal) {
		return new Parameter(literal);
	}
	
	public static int[] asArray(int... numbers) {
		return numbers;
	}
	
	public static int[][] asMatrix(int rows, int... elements) {
		int columns = elements.length / rows;
		int[][] matrix = new int[rows][columns];
		for (int i = 0, p = 0; i < rows; ++i) {
			for (int j = 0; j < columns; ++j, ++p) {
				matrix[i][j] = elements[p];
			}
		}
		return matrix;
	}
	
	public int[] toArray() {
		return null;
	}

	public int[][] toMatrix() {
		skipWhiteSpace();
		readStartOfMatrix();
		List<int[]> rows = new ArrayList<int[]>();
		do {
			skipWhiteSpace();
			readStartOfRow();
			IntList row = new IntList();
			do {
				skipWhiteSpace();
				row.add(readInteger());
				skipWhiteSpace();
			} while (hasMoreItemIfHasThenSkipItemSeperator());
			skipWhiteSpace();
			readEndOfRow();
			rows.add(row.toArray());
			skipWhiteSpace();
		} while (hasMoreRowIfHasThenSkipRowSeperator());
		skipWhiteSpace();
		readEndOfMatrix();
		return rows.toArray(new int[rows.size()][]);
	}
	
	// -------------------------------------------------------------
	// data structure
	// -------------------------------------------------------------
	
	static class IntList {
		int capacity;
		int p;

		int[] list;

		public IntList() {
			capacity = 1 << 8;
			list = new int[capacity];
		}

		public void add(int e) {
			list[p++] = e;
			if (p == list.length) {
				int[] ref = this.list;
				this.list = new int[ref.length * 2];
				System.arraycopy(ref, 0, this.list, 0, ref.length);
			}
		}
		
		public int[] toArray() {
			int[] copy = new int[p];
			System.arraycopy(list, 0, copy, 0, p);
			return copy;
		}
	}

	// -------------------------------------------------------
	// helper
	// -------------------------------------------------------

	void skipWhiteSpace() {
		while (p < n && Character.isWhitespace(buffer[p])) {
			++p;
		}
	}

	void readStartOfMatrix() {
		if (p < n && buffer[p] == '[') {
			p++;
		} else {

		}
	}

	void readStartOfRow() {
		if (p < n && buffer[p] == '[') {
			p++;
		} else {

		}
	}
	
	void readEndOfRow() {
		if (p < n && buffer[p] == ']') {
			p++;
		} else {

		}
	}
	
	void readEndOfMatrix() {
		if (p < n && buffer[p] == ']') {
			p++;
		} else {

		}
	}
	
	boolean hasMoreRowIfHasThenSkipRowSeperator() {
		if (p < n && buffer[p] == ',') {
			++p;
			return true;
		} else {
			return false;
		}
	}

	boolean hasMoreItemIfHasThenSkipItemSeperator() {
		if (p < n && buffer[p] == ',') {
			++p;
			return true;
		} else {
			return false;
		}
	}
	
	int readInteger() {
		boolean negative = false;
		if (buffer[p] == '-') {
			++p;
			negative = true;
			
		}
		int k = 0;
		while (p < n && Character.isDigit(buffer[p])) {
			k = 10 * k + (buffer[p] - '0');
			++p;
		}
		return negative ? -k : k;
	}
}
