package ape.chang.primitives;

import ape.chang.misc.Util;

public class IntDAG {
	// 
	class Node {
		int inDegree;
		IntList nextAdjecent = new IntList();
		int outDegree;
		IntList prevAdjecent = new IntList();
		int label;
		
		public Node(int label) {
			this.label = label;
		}
		
		void addNext(int to) {
			++outDegree;
			nextAdjecent.add(to);
		}
		
		void addPrev(int from) {
			++inDegree;
			prevAdjecent.add(from);
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder().append("[");
			if (!prevAdjecent.isEmpty()) {
				sb.append(prevAdjecent).append("->");
			}
			sb.append(label);
			if (!nextAdjecent.isEmpty()) {
				sb.append("->").append(nextAdjecent);
			}
			return sb.append("]").toString();
		}
	}
	
	Node[] nodes;
	
	public IntDAG(int n) {
		nodes = new Node[n];
		for (int i = 0; i < n; ++i) {
			nodes[i] = new Node(i);
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
		for (int i = 0; i < n; ++i) {
			dist[i] = 1;
		}
		int max = 0;
		for (int i : sort()) { // use topology sort
			IntList adj = nodes[i].prevAdjecent;
			if (!adj.isEmpty()) {
				for (int j = 0; j < adj.size(); ++j) {
					dist[i] = Math.max(dist[i], dist[adj.get(j)] + 1);
				}
			}
			max = Math.max(max, dist[i]);
		}
		return max;
	}
	
	// --------------------------------------------
	
	@Override
	public String toString() {
		return new StringBuilder().append("{").append(Util.join(nodes)).append("}").toString();
	}
	
}
