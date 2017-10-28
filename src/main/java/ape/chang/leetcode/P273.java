package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P273 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.numberToWords(123), equalTo("One Hundred Twenty Three"));
		assertThat(solution.numberToWords(12345), equalTo("Twelve Thousand Three Hundred Forty Five"));
		assertThat(solution.numberToWords(1234567), equalTo("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"));
	}
	
	class Solution {
	    public String numberToWords(int n) {
	    	if (n == 0) {
	    		return "Zero";
	    	}
	    	
	    	StringBuilder sb = new StringBuilder();
	    	int b = n / 1000000000;
	    	if (b > 0) {
	    		sb.append(speak(b)).append(" Billion");
	    	}
	    	n %= 1000000000;
	    	int m = n / 1000000;
	    	if (m > 0) {
	    		if (b > 0) {
	    			sb.append(" ");
	    		}
	    		sb.append(speak(m)).append(" Million");
	    	}
	    	n %= 1000000;
	    	int t = n / 1000;
	    	if (t > 0) {
	    		if (b > 0 || m > 0) {
	    			sb.append(" ");
	    		}
	    		sb.append(speak(t)).append(" Thousand");
	    	}
	    	n %= 1000;
	    	if (n > 0) {
	    		if (b > 0 || m > 0 || t > 0) {
	    			sb.append(" ");
	    		}
	    		sb.append(speak(n));
	    	}
	    	return sb.toString();
	    }
	    
	    public String speak(int n) {
	    	StringBuilder sb = new StringBuilder();
	    	int h = n / 100;
	    	if (h > 0) {
	    		sb.append(sayIt(h)).append(" Hundred");
	    	}
	    	n %= 100;
	    	int t = n / 10;
	    	if (t > 0) {
	    		if (h > 0) {
	    			sb.append(" ");
	    		}
	    		
	    		if (t == 1) {
	    			sb.append(sayTen(n));
	    		} else {
	    			sb.append(sayTens(t));
	    			if (n%10 != 0) {
	    				sb.append(" ").append(sayIt(n%10));
	    			}
	    		}
	    	} else {
	    		if (n > 0) {
	    			if (h > 0) {
		    			sb.append(" ");
		    		}
	    			sb.append(sayIt(n));
	    		}
	    	}
	    	return sb.toString();
	    }
	    
	    String sayTens(int k) {
	    	switch (k) {
			case 2:
				return "Twenty";
			case 3:
				return "Thirty";
			case 4:
				return "Forty";
			case 5:
				return "Fifty";
			case 6:
				return "Sixty";
			case 7:
				return "Seventy";
			case 8:
				return "Eighty";
			case 9:
				return "Ninety";
				

			default:
				throw new IllegalArgumentException();
			}
	    }
	    
	    String sayTen(int k) {
	    	switch (k) {
			case 10:
				return "Ten";
			case 11:
				return "Eleven";
			case 12:
				return "Twelve";
			case 13:
				return "Thirteen";
			case 14:
				return "Fourteen";
			case 15:
				return "Fifteen";
			case 16:
				return "Sixteen";
			case 17:
				return "Seventeen";
			case 18:
				return "Eighteen";
			case 19:
				return "Nineteen";
				

			default:
				throw new IllegalArgumentException();
			}
	    }
	    
	    String sayIt(int k) {
	    	switch (k) {
			case 1:
				return "One";
			case 2:
				return "Two";
			case 3:
				return "Three";
			case 4:
				return "Four";
			case 5:
				return "Five";
			case 6:
				return "Six";
			case 7:
				return "Seven";
			case 8:
				return "Eight";
			case 9:
				return "Nine";
			default:
				throw new IllegalArgumentException();
			}
	    }
	}

}
