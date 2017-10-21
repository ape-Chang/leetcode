package ape.chang.leetcode;

public class TestParameterParseSupport {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
		
		@Override
		public String toString() {
			return print(this);
		}
		
		@Override
		public boolean equals(Object o) {
			if (o == null) {
				return false;
			}
			
			if (o instanceof TreeNode) {
				TreeNode n = (TreeNode) o;
				return val == n.val && 
						(left == null ? n.left == null : left.equals(n.left)) &&
						(right == null ? n.right == null : right.equals(n.right));
			}
			
			return false;
		}
	}

	enum Type {
		KEY, START_OF_TREE, SEPERATOR, END_OF_TREE
	}

	static class Token {
		Type type;
		String value;

		public Token() {
		}

		public Token(Type type, String value) {
			this.type = type;
			this.value = value;
		}

		public Token(Type type) {
			// we do not care about the value
			this.type = type;
		}
	}

	static class Tokenizer {
		String program;
		int p;

		Tokenizer(String program) {
			this.program = program;
		}

		Token next() {
			skipWhiteSpace();

			Token token;
			char c = program.charAt(p);
			switch (c) {
			case '(':
				++p;
				token = new Token(Type.START_OF_TREE);
				break;
			case ')':
				++p;
				token = new Token(Type.END_OF_TREE);
				break;
			case ',':
				++p;
				token = new Token(Type.SEPERATOR);
				break;
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				int q = p;
				for (; p < program.length() && Character.isDigit(c); c = program.charAt(++p)) {

				}
				token = new Token(Type.KEY, program.substring(q, p));
				break;

			default:
				throw new IllegalStateException();
			}

			skipWhiteSpace();
			return token;
		}

		void skipWhiteSpace() {
			while (p < program.length() && Character.isWhitespace(program.charAt(p))) {
				++p;
			}
		}

		boolean hasMore() {
			return p < program.length();
		}
	}

	class Parser {

		Tokenizer tokenizer;

		TreeNode parse(String program) {
			tokenizer = new Tokenizer(program);
			return parseNode();
		}

		TreeNode parseNode() {
			tokenizer.next(); // start of tree, maybe empty tree, or not empty
								// tree, read one token ahead
			Token ambiguous = tokenizer.next();
			if (ambiguous.type == Type.END_OF_TREE) {
				return null;
			} else {
				Token key = ambiguous;
				tokenizer.next(); // separator of key and left child
				TreeNode left = parseNode();
				tokenizer.next(); // separator of left child and right child
				TreeNode right = parseNode();
				tokenizer.next(); // end of tree

				TreeNode root = new TreeNode(Integer.parseInt(key.value));
				root.left = left;
				root.right = right;
				return root;
			}
		}

	}

	/**
	 * kind of like s-expression
	 * 
	 * node -> () node -> (key, node, node) key -> [0-9]+
	 */
	String print(TreeNode root) {
		if (root == null) {
			return "()";
		}

		return String.format("(%s, %s, %s)", root.val, print(root.left), print(root.right));
	}

	TreeNode parse(String expr) {
		return new Parser().parse(expr);
	}

}
