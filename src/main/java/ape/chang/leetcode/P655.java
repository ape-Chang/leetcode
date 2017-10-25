package ape.chang.leetcode;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

public class P655 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.printTree(Parsers.parseTree("(1, (2, (), ()), ())")), equalTo(
				asList(
					asList("", "1", ""),
					asList("2", "", ""))));
		
		assertThat(solution.printTree(Parsers.parseTree("(1, (2, (), (4, (), ())), (3, (), ()))")), equalTo(
				asList(
					asList("", "", "", "1", "", "", ""),
					asList("", "2", "", "", "", "3", ""),
					asList("", "", "4", "", "", "", ""))));
		
		assertThat(solution.printTree(Parsers.parseTree("(1, (2, (3, (4, (), ()), ()), ()), (5, (), ()))")), equalTo(
				asList(
					asList("",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""),
					asList("",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""),
					asList("",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""),
					asList("4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""))));
	}

	class Solution {
		public List<List<String>> printTree(TreeNode root) {
			int height = height(root);
			List<List<String>> presentationOfTree = new ArrayList<List<String>>();
			List<TreeNode> nodesOfThisLevel = new ArrayList<TreeNode>();
			nodesOfThisLevel.add(root);
			int length = (1 << height) - 1;
			List<String> empty = getEmptyListOfLength(length);
			for (int depth = 1; depth <= height; ++depth) {
				int step = 1 << (height - depth);
				List<String> copy = new ArrayList<String>(empty);
				List<TreeNode> nodesOfNextLevel = new ArrayList<TreeNode>();
				for (int i = 0, n = nodesOfThisLevel.size(); i < n; ++i) {
					TreeNode node = nodesOfThisLevel.get(i);
					if (node == null) {
						nodesOfNextLevel.add(null);
						nodesOfNextLevel.add(null);
					} else {
						nodesOfNextLevel.add(node.left);
						nodesOfNextLevel.add(node.right);
						copy.set((2*i + 1) * step - 1, String.valueOf(node.val));
						
					}
				}
				nodesOfThisLevel = nodesOfNextLevel;
				presentationOfTree.add(copy);
			}
			return presentationOfTree;
		}
		
		public List<String> getEmptyListOfLength(int length) {
			List<String> list = new ArrayList<String>();
			while (length-- > 0) {
				list.add("");
			}
			return list;
		}

		
		public int height(TreeNode root) {
			int h = 0;
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				int n = queue.size();
				while (n-- > 0) {
					TreeNode node = queue.poll();
					if (node.left != null) {
						queue.offer(node.left);
					}
					if (node.right != null) {
						queue.offer(node.right);
					}
				}
				
				++h;
			}
			return h;
		}
	}

}
