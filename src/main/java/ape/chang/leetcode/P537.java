package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P537 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.complexNumberMultiply("1+1i", "1+1i"), equalTo("0+2i"));
		assertThat(solution.complexNumberMultiply("1+-1i", "1+-1i"), equalTo("0+-2i"));
	}
	
	class Solution {
	    public String complexNumberMultiply(String a, String b) {
	        Complex x = of(a);
	        Complex y = of(b);
	        return x.multiply(y).toString();
	    }
	    
	    public Complex of(String expr) {
	    	Complex comp = new Complex();
	    	int indexOfPlus = expr.indexOf('+');
	    	comp.real = Integer.parseInt(expr.substring(0, indexOfPlus));
	    	comp.imaginary = Integer.parseInt(expr.substring(indexOfPlus+1, expr.length()-1));
    		return comp;
    	}
	    
	    class Complex {
	    	int real;
	    	int imaginary;
	    	public Complex multiply(Complex other) {
	    		Complex comp = new Complex();
	    		comp.real = real*other.real - imaginary*other.imaginary;
	    		comp.imaginary = real*other.imaginary + imaginary*other.real;
	    		return comp;
	    	}
	    	@Override
	    	public String toString() {
	    		return String.format("%d+%di", real, imaginary);
	    	}
	    }
	}

}
