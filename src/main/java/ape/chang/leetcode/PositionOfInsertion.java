package ape.chang.leetcode;

public class PositionOfInsertion {
	
	/*
	 * A是一个排序好的数组，返回k在A中的插入位置
	 * k的插入位置是i <=> A[i-1] < k <= A[i]
	 * 返回值的范围是[0..n]
	 * 
	 */
	private static int poi(int[] A, int k) {
		return poi(new ArrayView(A), k);
	}
	
	private static int poi(IArrayView array, int k) {
		int n = array.length();
		if (array.get(n-1) < k) {
			return n;
		}
		
		int low = 0, high = n-1;
		while (low < high) {
			int middle = (low + high) / 2;
			int value = array.get(middle);
			if (value == k) {
				return middle;
			}
			
			if (value > k) {
				high = middle;
			} else {
				low = middle + 1;
			}
		}
		
		return low;
	}
	
	public static void main(String... args) {
		int[] A = new int[] {1, 2, 4, 5, 6};
		System.out.println(poi(A, 1));
		System.out.println(poi(A, 2));
		System.out.println(poi(A, 3));
		System.out.println(poi(A, 4));
		System.out.println(poi(A, 5));
		System.out.println(poi(A, 6));
		System.out.println(poi(A, 7));
	}

}
