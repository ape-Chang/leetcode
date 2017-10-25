package ape.chang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P535 {
	
	public class Codec {
		
		Map<String, String> map = new HashMap<String, String>();

	    // Encodes a URL to a shortened URL.
	    public String encode(String longUrl) {
	    	long index = (longUrl.hashCode() << 16) & (System.currentTimeMillis());
	    	String str = String.valueOf(index);
	    	map.put(str, longUrl);
	    	return str;
	    }

	    // Decodes a shortened URL to its original URL.
	    public String decode(String shortUrl) {
	    	return map.get(shortUrl);
	    }
	    
	}

}
