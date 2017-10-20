package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P593 {
	
	@Test
	public void test() {
		Solution solution = new Solution();
		assertThat(true, equalTo(solution.validSquare(
				new int[]{0,0}, 
				new int[]{1,1}, 
				new int[]{1,0}, 
				new int[]{0,1})));
		assertThat(true, equalTo(solution.validSquare(
				new int[]{1,0}, 
				new int[]{0,1}, 
				new int[]{0, -1}, 
				new int[]{-1, 0})));
		assertThat(false, equalTo(solution.validSquare(
				new int[]{1,1}, 
				new int[]{5,3}, 
				new int[]{3,5}, 
				new int[]{7,7})));
	}

	class Solution {
	    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
	    	Point a = of(p1), b = of(p2), c = of(p3), d = of(p4);
	    	if (a.equals(b) || a.equals(c) || a.equals(d) || 
	    			b.equals(c) || b.equals(d) || c.equals(d)) {
	    		return false;
	    	}
	    	
	    	Vector ab = of(a, b);
	    	Vector ac = of(a, c);
	    	Vector cd = of(c, d);
	    	Vector bd = of(b, d);
	    	Vector ad = of(a, d);
	    	Vector bc = of(b, c);
	    	return (ab.perpendicularTo(cd) && ac.perpendicularTo(ad)) || 
	    			(ac.perpendicularTo(bd) && ab.perpendicularTo(ad)) ||
	    			(ad.perpendicularTo(bc) && ac.perpendicularTo(ab));
	    }
	    
	    Vector of(Point p, Point q) {
	    	Vector v = new Vector();
	    	v.x = p.x - q.x;
	    	v.y = p.y - q.y;
	    	return v;
	    }
	    
	    Point of(int[] v) {
	    	Point p = new Point();
	    	p.x = v[0];
	    	p.y = v[1];
	    	return p;
	    }
	    
	    class Vector {
	    	int x, y;
	    	
	    	public boolean parallelWith(Vector v) {
	    		return this.x * v.y == this.y * v.x;
	    	}
	    	
	    	public boolean perpendicularTo(Vector v) {
	    		return this.x * v.x + this.y * v.y == 0;
	    	}
	    	
	    	@Override
	    	public String toString() {
	    		return String.format("[%d, %d]", x, y);
	    	}
	    }
	    
	    class Point {
	    	int x, y;
	    	
	    	@Override
	    	public boolean equals(Object o) {
	    		if (o instanceof Point) {
	    			Point p = (Point) o;
	    			return p.x == x && p.y == y;
	    		}
	    		return false;
	    	}
	    }
	}
	
}
