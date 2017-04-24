package ape.chang.leetcode;

public class Scratch {
	
	public static void main(String[] args) {
		int[][] matrix = Parameter.from("[[0,1,0,0],  [1,1,1,0],  [0,1,0,0],  [1,1,0,0]]").toMatrix();
		System.out.println(matrix.length);
		System.out.println(matrix[0].length);
	}

}
