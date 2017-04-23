package ape.chang.leetcode;

public class BinarySearchInMatrix {
	
	/*
	 * 二维的binary search
	 */
	public boolean search(int[][] matrix, int key) {
		int fromRow = 0, toRow = matrix.length - 1, fromColumn = 0, toColumn = matrix[0].length - 1;
		
		if (matrix[toRow][toColumn] < key || matrix[fromRow][fromColumn] > key) {
			return false;
		}
		
		int prev = matrix[fromRow][toColumn];
		while (true) {
			fromRow = poiOfColumn(matrix, toColumn, fromRow, toRow, key);
			toColumn = poiOfRow(matrix, fromRow, fromColumn, toColumn, key);
			if (matrix[fromRow][toColumn] == prev) {
				break;
			} else {
				prev = matrix[fromRow][toColumn];
			}
		}
		return prev == key;
	}
	
	/*
	 * 插入位置
	 * 
	 */
	private int poiOfColumn(int[][] matrix, int column, int low, int high, int key) {
//		if (matrix[high][column] < key) {
//			return high + 1;
//		}
		
		while (low < high) {
			int middle = (low + high) / 2;
			int value = matrix[middle][column];
			if (value == key) {
				return middle;
			}
			
			if (value > key) {
				high = middle;
			} else {
				low = middle + 1;
			}
		}
		
		return low;
	}
	
	private int poiOfRow(int[][] matrix, int row, int low, int high, int key) {
//		if (matrix[row][high] < key) {
//			return high + 1;
//		}
		
		while (low < high) {
			int middle = (low + high) / 2;
			int value = matrix[row][middle];
			if (value == key) {
				return middle;
			}
			
			if (value > key) {
				high = middle;
			} else {
				low = middle + 1;
			}
		}
		
		return low;
	}
	
	public static void main(String... args) {
		int[][] A = new int[][] {{1, 2, 3}, {4, 5, 6}, {8, 9, 11}};
		BinarySearchInMatrix bs = new BinarySearchInMatrix();
		System.out.println(bs.search(A, 1));
		System.out.println(bs.search(A, 2));
		System.out.println(bs.search(A, 3));
		System.out.println(bs.search(A, 4));
		System.out.println(bs.search(A, 5));
		System.out.println(bs.search(A, 6));
		System.out.println(bs.search(A, 7));
		System.out.println(bs.search(A, 8));
		System.out.println(bs.search(A, 9));
		System.out.println(bs.search(A, 10));
		System.out.println(bs.search(A, 11));
		System.out.println(bs.search(A, 12));
		System.out.println(bs.search(A, 13));
	}

}
