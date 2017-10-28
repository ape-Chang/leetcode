package ape.chang.primitives;

public class IntDAG {
	// 
	class Node {
		int inDegree;
		IntList nextAdjecent = new IntList();
		int outDegree;
		IntList prevAdjecent = new IntList();
		
		void addNext(int to) {
			++inDegree;
			nextAdjecent.add(to);
		}
		
		void addPrev(int from) {
			++outDegree;
			prevAdjecent.add(from);
		}
	}
	
	Node[] nodes;
	
	public IntDAG(int n) {
		nodes = new Node[n];
		for (int i = 0; i < n; ++i) {
			nodes[i] = new Node();
		}
	}
	
	public void addEdge(int from, int to) {
		if (from >= nodes.length || from < 0 || to >= nodes.length || to < 0) {
			throw new IllegalArgumentException();
		}
		nodes[from].addNext(to);
		nodes[to].addPrev(from);
	}
	
	// topology sort
	public int[] sort() {
		int n = nodes.length;
		int[] deg = new int[n];
		IntQueue queue = new IntQueue();
		for (int i = 0; i < n; ++i) {
			deg[i] = nodes[i].inDegree;
			if (deg[i] == 0) {
				queue.enqueue(i);
			}
		}
		// there is a cycle
		if (queue.isEmpty()) {
			throw new IllegalStateException();
		}
		// 
		int[] sorted = new int[n];
		int p = 0;
		while (!queue.isEmpty()) {
			int x = queue.dequeue();
			sorted[p++] = x;
			IntList adj = nodes[x].nextAdjecent; 
			if (!adj.isEmpty()) {
				for (int i = 0; i < adj.size(); ++i) {
					int k = adj.get(i);
					if (--deg[k] == 0) {
						queue.enqueue(k);
					}
				}
			}
		}
		// there is a cycle
		if (p < n) {
			throw new IllegalStateException();
		}
		return sorted;
	}
	
	// length of longest path
	public int maxDistance() {
		int n = nodes.length;
		int[] dist = new int[n];
		for (int i = 1; i < n; ++i) {
			dist[i] = 1;
		}
		int max = 0;
		for (int i : sort()) { // use topology sort
			IntList adj = nodes[i].prevAdjecent;
			if (!adj.isEmpty()) {
				for (int j = 0; j < adj.size(); ++j) {
					dist[i] = Math.max(dist[i], dist[adj.get(j)]);
				}
			}
			max = Math.max(max, dist[i]);
		}
		return max;
	}
	
	// --------------------------------------------
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		if (nodes.length > 0) {
			sb.append("\n");
			for (int i = 0; i < nodes.length; ++i) {
				sb.append("\t");
				sb.append(i).append("->");
				sb.append(nodes[i].nextAdjecent);
				sb.append("\n");
			}
		}
		sb.append("}");
		return sb.toString();
	}
	
}
