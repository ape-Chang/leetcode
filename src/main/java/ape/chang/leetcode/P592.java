package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P592 {
	
	@Test
	public void test() {
		Solution solution = new Solution();
		assertThat("2/1", equalTo(solution.fractionAddition("5/3+1/3")));
		assertThat("-1/6", equalTo(solution.fractionAddition("1/3-1/2")));
		assertThat("1/3", equalTo(solution.fractionAddition("-1/2+1/2+1/3")));
		assertThat("0/1", equalTo(solution.fractionAddition("-1/2+1/2")));
	}
	
	class Solution {
		
		private Fraction zero = new Fraction();
		
	    public String fractionAddition(String expression) {
	    	Tokenizer tokenizer = new Tokenizer(expression);
	    	Fraction result = tokenizer.nextFraction();
	    	while (tokenizer.hasMoreToken()) {
	    		char operator = tokenizer.nextOperator();
	    		Fraction operand = tokenizer.nextFraction();
	    		if (operator == '+') {
	    			result = result.add(operand);
	    		} else {
	    			result = result.add(operand);
	    		}
	    	}
	    	return result.toString();
	    }
	    
	    class Tokenizer {
	    	String expr;
	    	int p;
	    	public Tokenizer(String expr) {
	    		this.expr = expr.trim();
	    	}
	    	
	    	public Fraction nextFraction() {
	    		int i = p;
	    		char c;
	    		// this part is only for leading '-'
	    		while (p < expr.length()) {
	    			c = expr.charAt(p);
	    			if (Character.isDigit(c)) {
	    				break;
	    			}
	    			++p;
	    		}
	    		
	    		while (p < expr.length()) {
	    			c = expr.charAt(p);
	    			if (!Character.isDigit(c) && c != '/') {
	    				break;
	    			}
	    			p++;
	    		}
	    		
	    		skipWhiteSpace();
	    		Fraction frac = new Fraction();
	    		frac.parse(expr.substring(i, p));
	    		return frac;
	    	}
	    	
	    	private void skipWhiteSpace() {
	    		while (p < expr.length() && Character.isWhitespace(expr.charAt(p))) {
	    			++p;
	    		}
	    	}
	    	
	    	public char nextOperator() {
	    		char operator = expr.charAt(p);
	    		skipWhiteSpace();
	    		return operator;
	    	}
	    	
	    	public boolean hasMoreToken() {
	    		return p < expr.length();
	    	}
	    }
	    
	    class Fraction {
	    	int sign = 1;
	    	int numerator = 0; // 分子
	    	int denominator = 1; // 分母
	    	
	    	public void parse(String expr) {
	    		expr = expr.trim();
	    		if (expr != null && expr.length() > 0) {
	    			if (expr.charAt(0) == '-') {
	    				this.sign = -1;
	    				expr = expr.substring(1);
	    			}
	    			String[] parts = expr.split("/");
	    			numerator = Integer.parseInt(parts[0]);
	    			denominator = Integer.parseInt(parts[1]);
	    		}
	    	}
	    	
	    	public Fraction add(Fraction other) {
	    		// 处理0
	    		if (this.equals(zero)) {
	    			return other;
	    		}
	    		if (other.equals(zero)) {
	    			return this;
	    		}
	    		
	    		Fraction sum = new Fraction();
	    		int num = this.numerator * this.sign * other.denominator + 
	    				other.numerator * other.sign * this.denominator;
	    		int den = this.denominator * other.denominator;
	    		
	    		if (num == 0) {
	    			sum.numerator =  0;
	    			sum.denominator = 1;
	    		} else {
	    			if (num < 0) {
	    				sum.sign = -1;
	    				num = -num;
	    			}
	    			int d = gcd(num, den);
	    			sum.denominator = den / d;
	    			sum.numerator = num / d;
	    		}
	    		
	    		return sum;
	    	}
	    	
	    	public Fraction subtract(Fraction other) {
	    		Fraction diff = new Fraction();
	    		int num = this.numerator * this.sign * other.denominator - 
	    				other.numerator * other.sign * this.denominator;
	    		int den = this.denominator * other.denominator;
	    		
	    		if (num == 0) {
	    			diff.numerator = diff.denominator = 0;
	    		} else {
	    			if (num < 0) {
	    				diff.sign = -1;
	    				num = -num;
	    			}
	    			int d = gcd(num, den);
	    			diff.denominator = den / d;
	    			diff.numerator = num / d;
	    		}
	    		return diff;
	    	}
	    	
	    	private int gcd(int a, int b) {
	    		int c;
	    		if (a < b) {
	    			c = a;
	    			a = b;
	    			b = c;
	    		}
	    		
	    		while (a != 0 && b != 0) {
	    			c = b;
	    			b = a % b;
	    			a = c;
	    		}
	    		return a + b;
	    	}
	    	
	    	@Override
	    	public boolean equals(Object o) {
	    		if (o instanceof Fraction) {
	    			Fraction f = (Fraction) o;
	    			return this.sign == f.sign && this.denominator == f.denominator && this.numerator == f.numerator;
	    		}
	    		return false;
	    	};
	    	
	    	@Override
	    	public String toString() {
	    		return (sign > 0 ? "" : "-") + numerator + "/" + denominator;
	    	}
	    }
	}

}
