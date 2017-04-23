package ape.chang.leetcode;

import java.util.Objects;

public class MatrixColumnView implements IArrayView {
	
	private int[][] matrix;
	private int column;
	
	public MatrixColumnView(int[][] matrix, int column) {
		this.matrix = Objects.requireNonNull(matrix);
		this.column = column;
	}

	public int length() {
		return matrix.length;
	}

	public int get(int index) {
		return matrix[index][column];
	}

}
