package ape.chang.leetcode;

public class NextN {
	
	static class DigitSet {
		
		private boolean[] set = new boolean[10];
		
		public boolean contains(int i) {
			return i >= 0 && i <= 9 && set[i];
		}
		
		public void add(int i) {
			if (i >= 0 && i <= 9) {
				set[i] = true;
			}
		}
		
		public void remove(int i) {
			if (i >= 0 && i <= 9) {
				set[i] = false;
			}
		}
	}
	
	@SuppressWarnings("serial")
	static class IndicationException extends RuntimeException {
		private IndicationException() {
			super();
		}
		
		@Override
		public synchronized Throwable fillInStackTrace() {
			return this;
		}
		
		public static IndicationException SUCCESS = new IndicationException();
		public static IndicationException FAILURE = new IndicationException();
	}
	
	static final String X = "1023456789";
	
	/*
	 * n是一个正整数，返回大于n的，各个位数数字不同的，最小的数
	 */
	public int next(int n) {
		int[] d = new int[11];
		int k = 0;
		++n;
		while (n != 0 && k < 11) {
			d[k] = n % 10;
			n = n / 10;
			k++;
		}
		
		try {
			backtrack(d, k-1, new DigitSet());
			
			return Integer.parseInt(X.substring(0, k+1));
		} catch (IndicationException e) {
			// 
			n = 0;
			while (k >= 0) {
				n = 10 * n + d[k];
				k--;
			}
			
			return n;
		}
	}
	
	// backtrack
	private void backtrack(int[] d, int p, DigitSet set) {
		if (p == -1) {
			throw IndicationException.SUCCESS;
		}
		
		do {
			int k = d[p];
			if (set.contains(k)) {
				// do nothing
			} else {
				set.add(k);
				
				backtrack(d, p-1, set);
				
				// 每次加1之后，需要把低位的数字变成0
				for (int i = 0; i < p; ++i) {
					d[i] = 0;
				}
				
				set.remove(k);
			}
		} while (++d[p] < 10);
		
	}
	
	public static void main(String... args) {
		NextN nextN = new NextN();
		System.out.println(nextN.next(1024));
		System.out.println(nextN.next(98765));
	}

}
