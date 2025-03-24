package others;

import java.util.*;
import leetcode.helper.*;


class LRUCacheWithExpiration {

    private final int capacity;
    private final long ttl; // Time-to-live (in milliseconds)
    private final Map<Integer, Integer> cache;
    private final PriorityQueue<Entry> expirationQueue;

    public LRUCacheWithExpiration(int capacity, long ttl) {
        this.capacity = capacity;
        this.ttl = ttl;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true); // LRU enabled
        this.expirationQueue = new PriorityQueue<>(Comparator.comparingLong(e -> e.expireTime));
    }

    public int get(int key) {
        removeExpiredKeys(); // Cleanup expired keys before access
        if (!cache.containsKey(key)) return -1;
        return cache.get(key);
    }

    public void put(int key, int value) {
        removeExpiredKeys(); // Cleanup expired keys before insertion

        if (cache.size() >= capacity) {
            evictLRU();
        }

        cache.put(key, value);
        expirationQueue.offer(new Entry(key, System.currentTimeMillis() + ttl));
    }

    private void removeExpiredKeys() {
        long now = System.currentTimeMillis();
        while (!expirationQueue.isEmpty() && expirationQueue.peek().expireTime <= now) {
            Entry expired = expirationQueue.poll();
            cache.remove(expired.key); // Remove expired key from LRU cache
        }
    }

    private void evictLRU() {
        Iterator<Integer> it = cache.keySet().iterator();
        if (it.hasNext()) {
            int lruKey = it.next();
            cache.remove(lruKey);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LRUCacheWithExpiration cache = new LRUCacheWithExpiration(2, 3000); // 3 seconds TTL

        cache.put(1, 10);
        cache.put(2, 20);
        System.out.println(cache.get(1)); // Output: 10 (exists)

        Thread.sleep(4000); // Wait for expiration

        System.out.println(cache.get(1)); // Output: -1 (expired)
        cache.put(3, 30); // Adds a new entry
        System.out.println(cache.get(2)); // Output: -1 (expired)
        System.out.println(cache.get(3)); // Output: 30 (exists)
    }
}
