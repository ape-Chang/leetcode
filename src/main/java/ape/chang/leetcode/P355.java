package ape.chang.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class P355 {
	
	class Twitter {
		// abstraction of tweet
	    private class Tweet implements Comparable<Tweet> {
	    	int tweetId;
	    	long id = getNextId();
	    	
	    	public Tweet(int tweetId) {
	    		this.tweetId = tweetId;
	    	}
	    	
			@Override
			public int compareTo(Tweet o) {
				return (int) (this.id - o.id);
			}
			
			@Override
			public boolean equals(Object o) {
				if (o == null || !(o instanceof Tweet)) {
					return false;
				}
				return this.tweetId == ((Tweet) o).tweetId;
			}
	    }
	    // global id allocator
	    long counter = 0;
	    long getNextId() {
	    	return counter++;
	    }
	    
		// TODO use linked list to store tweets
	    
		Map<Integer, List<Tweet>> userTweetsMap = new HashMap<>();
		Map<Integer, Set<Integer>> userFollowersMap = new HashMap<>();
		Map<Integer, TreeSet<Tweet>> userFeedsMap = new HashMap<>();

	    public Twitter() {
	        
	    }
	    
	    public void postTweet(int userId, int tweetId) {
	    	Tweet tweet = new Tweet(tweetId);
	    	// i'm assuming tweetId is increasing
	    	// append this tweet to my tweets store
	    	List<Tweet> tweets = userTweetsMap.get(userId);
	        if (tweets == null) {
	        	tweets = new ArrayList<>();
	        	userTweetsMap.put(userId, tweets);
	        }
	        tweets.add(tweet);
	        // append this tweet to my own feeds
	        TreeSet<Tweet> feeds;
	        feeds = userFeedsMap.get(userId);
	        if (feeds == null) {
	        	feeds = new TreeSet<>();
	        	userFeedsMap.put(userId, feeds);
	        }
	        feeds.add(tweet);
	        // append this tweet to followers' feeds
	        Set<Integer> followers = userFollowersMap.get(userId);
	        if (followers != null) {
	        	for (Integer follower : followers) {
	        		feeds = userFeedsMap.get(follower);
	        		if (feeds == null) {
	        			feeds = new TreeSet<>();
	        			userFeedsMap.put(follower, feeds);
	        		}
	        		feeds.add(tweet);
	        	}
	        }
	    }
	    
	    public List<Integer> getNewsFeed(int userId) {
	    	TreeSet<Tweet> feeds = userFeedsMap.get(userId);
	    	if (feeds == null || feeds.size() == 0) {
	    		return Collections.emptyList();
	    	}
	    	// make a copy
	    	List<Tweet> news = new ArrayList<>();
	    	Tweet ts = feeds.last();
	    	news.add(ts);
	    	for (int i = 1, n = Math.min(10, feeds.size()); i < n; ++i) {
	    		ts = feeds.lower(ts);
	    		news.add(ts);
	    	}
	    	// sort it 
	    	List<Integer> newsIds = new ArrayList<>(news.size());
	    	for (int i = 0; i < news.size(); ++i) {
	    		newsIds.add(news.get(i).tweetId);
	    	}
	        return newsIds;
	    }
	    
	    public void follow(int followerId, int followeeId) {
	    	// automatically follow self
	    	if (followeeId == followerId) {
	    		return;
	    	}
	    	
	        Set<Integer> followers = userFollowersMap.get(followeeId);
	        if (followers == null) {
	        	followers = new HashSet<>();
	        	userFollowersMap.put(followeeId, followers);
	        }
	        followers.add(followerId);
	        // add followee's tweets to follower's feed
	        List<Tweet> tweets = userTweetsMap.get(followeeId);
    		TreeSet<Tweet> feeds = userFeedsMap.get(followerId);
    		if (tweets != null) {
    			if (feeds == null) {
    				feeds = new TreeSet<>();
    				userFeedsMap.put(followerId, feeds);
    			}
    			for (Tweet tweet : tweets) {
    				feeds.add(tweet);
    			}
    		}
	    }
	    
	    public void unfollow(int followerId, int followeeId) {
	    	// can't unfollow self
	    	if (followeeId == followerId) {
	    		return;
	    	}
	    	
	    	Set<Integer> followers = userFollowersMap.get(followeeId);
	    	if (followers != null && followers.contains(followerId)) {
	    		followers.remove(followerId);
	    		// remove tweets from feeds
	    		List<Tweet> tweets = userTweetsMap.get(followeeId);
	    		TreeSet<Tweet> feeds = userFeedsMap.get(followerId);
	    		if (feeds != null && tweets != null) {
	    			for (Tweet tweet : tweets) {
	    				feeds.remove(tweet);
	    			}
	    		}
	    	}
	    }
	}

}
