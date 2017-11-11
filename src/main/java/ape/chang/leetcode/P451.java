package ape.chang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P451 {

	class Solution {
		public String frequencySort(String s) {
			Map<Character, Node> map = new HashMap<>();
			for (char c : s.toCharArray()) {
				Node n = map.get(c);
				if (n == null) {
					map.put(c, n = new Node(c));
				}
				n.count++;
			}
			List<Node> nodes = new ArrayList<>(map.values());
			Collections.sort(nodes); // use variant of bucket sort
			char[] a = new char[s.length()];
			int p = 0;
			for  (Node node : nodes) {
				Arrays.fill(a, p, p+node.count, node.c);
				p += node.count;
			}
			return new String(a);
		}

		class Node implements Comparable<Node> {
			char c;
			int count;

			public Node(char c) {
				this.c = c;
			}

			@Override
			public int compareTo(Node o) {
				return o.count - count;
			}
		}
	}

}
