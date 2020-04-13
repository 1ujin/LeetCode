package algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Twitter {
    private class Tweet {
        int tweetId, time;
        
        public Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }
    
    int time = 0;
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, Queue<Tweet>> tweetMap;
    
    /** Initialize your data structure here. */
    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, time++);
        tweetMap.compute(userId, (k, v) -> {
            if (v == null)
                v = new PriorityQueue<>((a, b) -> b.time - a.time);
            v.offer(tweet);
            return v;
        });
    }
    
    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item
     * in the news feed must be posted by users who the user followed or by the
     * user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        Queue<Tweet> news = new PriorityQueue<>((a, b) -> a.time - b.time);
        if (tweetMap.containsKey(userId)) {
            Queue<Tweet> queue = new PriorityQueue<>(tweetMap.get(userId));
            while (!queue.isEmpty()) {
                news.offer(queue.poll());
                if (news.size() > 10)
                    news.poll();
            }
        }
        if (followMap.containsKey(userId)) {
            for (Integer id : followMap.get(userId)) {
                if (tweetMap.containsKey(id)) {
                    int i = 0;
                    Queue<Tweet> queue = new PriorityQueue<>(tweetMap.get(id));
                    while (i++ < 10 && !queue.isEmpty()) {
                        news.offer(queue.poll());
                        if (news.size() > 10)
                            news.poll();
                    }
                }
            }
        }
        List<Integer> result = new LinkedList<>();
        while (!news.isEmpty())
            result.add(0, news.poll().tweetId);
        return result;
    }
    
    /**
     * Follower follows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        followMap.compute(followerId, (k, v) -> {
            if (v == null)
                v = new HashSet<>();
            v.add(followeeId);
            return v;
        });
    }
    
    /**
     * Follower unfollows a followee. If the operation is invalid, it should be
     * a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        followMap.computeIfPresent(followerId, (k, v) -> {
            v.remove(followeeId);
            return v;
        });
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 5);
        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        System.out.println(twitter.getNewsFeed(1));
        // 用户1关注了用户2.
        twitter.follow(1, 2);
        // 用户2发送了一个新推文 (推文id = 6).
        twitter.postTweet(2, 6);
        // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
        // 推文id6应当在推文id5之前，因为它是在5之后发送的.
        System.out.println(twitter.getNewsFeed(1));
        // 用户1取消关注了用户2.
        twitter.unfollow(1, 2);
        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        // 因为用户1已经不再关注用户2.
        System.out.println(twitter.getNewsFeed(1));
    }

}
