package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P468 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.validIPAddress("172.16.254.1"), equalTo("IPv4"));
		assertThat(solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"), equalTo("IPv6"));
		assertThat(solution.validIPAddress("256.256.256.256"), equalTo("Neither"));
		assertThat(solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"), equalTo("Neither"));
	}
	
	class Solution {
	    public String validIPAddress(String IP) {
	        if (count(IP, '.') == 3) {
	        	String[] parts = IP.split("\\.");
	        	if (parts.length == 4 && isValidIpv4Address(parts)) {
	        		return "IPv4";
	        	} else {
	        		return "Neither";
	        	}
	        }
	        
	        if (count(IP, ':') == 7) {
	        	String[] parts = IP.split(":");
	        	if (parts.length == 8 && isValidIpv6Address(parts)) {
	        		return "IPv6";
	        	} else {
	        		return "Neither";
	        	}
	        }
	        
	        return "Neither";
	    }
	    
	    int count(String s, char c) {
	    	int k = 0;
	    	for (int i = 0; i < s.length(); ++i) {
	    		if (s.charAt(i) == c) {
	    			k++;
	    		}
	    	}
	    	return k;
	    }
	    
	    boolean isValidIpv4Address(String[] parts) {
	    	for (String part : parts) {
	    		int k = parseDec(part);
	    		if (k < 0 || k > 255) {
	    			return false;
	    		}
	    	}
	    	return true;
	    }
	    
	    boolean isValidIpv6Address(String[] parts) {
	    	for (String part : parts) {
	    		int k = parseHex(part);
	    		if (k < 0) {
	    			return false;
	    		}
	    	}
	    	return true;
	    }
	    
	    int parseDec(String dec) {
	    	if (dec == null) {
	    		return -1;
	    	}
	    	
	    	int n = dec.length();
	    	if (n == 0) {
	    		return -1;
	    	}
	    	
	    	char c = dec.charAt(0);
	    	if (n == 1) {
	    		return Character.isDigit(c) ? c - '0' : -1;
	    	}
	    	
	    	if (c == '0') {
	    		return -1;
	    	}
	    	
	    	int s = c - '0';
	    	for (int i = 1; i < n; ++i) {
	    		s = s*10 + (dec.charAt(i) - '0');
	    	}
	    	return s;
	    }
	    
	    int parseHex(String hex) {
	    	if (hex == null || hex.length() == 0) {
	    		return -1;
	    	}
	    	if (hex.length() > 4) {
	    		return -1;
	    	}
	    	
	    	int s = 0;
	    	for (char c : hex.toCharArray()) {
	    		if (Character.isDigit(c)) {
	    			s = s * 16 + (c - '0');
	    		} else if (Character.isUpperCase(c)) {
	    			if (c >= 'A' && c <= 'F') {
	    				s = s * 16 + (10 + c - 'A');
	    			} else {
	    				return -1;
	    			}
	    		} else if (Character.isLowerCase(c)) {
	    			if (c >= 'a' && c <= 'f') {
	    				s = s * 16 + (10 + c - 'a');
	    			} else {
	    				return -1;
	    			}
	    		} else {
	    			return -1;
	    		}
	    	}
	    	return s;
	    }
	}

}
