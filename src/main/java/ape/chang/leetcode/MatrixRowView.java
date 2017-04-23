package ape.chang.leetcode;

import java.util.Objects;

public class MatrixRowView implements IArrayView {
	
	private int[][] matrix;
	private int row;
	
	public MatrixRowView(int[][] matrix, int row) {
		this.matrix = Objects.requireNonNull(matrix);
		this.row = row;
	}
	
	public int length() {
		return matrix[row].length;
	}

	public int get(int index) {
		return matrix[row][index];
	}

}
