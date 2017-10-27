package ape.chang.primitives;

public class IntDisjointSet {
	
	int[] parent;
	
	// The API
	
	public IntDisjointSet(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException();
		}
		
		parent = new int[n];
		for (int i = 0; i < n; ++i) {
			parent[i] = i;
		}
	}
	
	public void union(int x, int y) {
		int n = parent.length;
		if (x < 0 || x >= n || y < 0 || y >= n) {
			throw new IllegalArgumentException();
		}
		
		parent[find(x)] = find(y);
	}
	
	public int find(int x) {
		int n = parent.length;
		if (x < 0 || x >= n) {
			throw new IllegalArgumentException();
		}
		
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < parent.length; ++i) {
			sb.append(find(i)).append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

}
