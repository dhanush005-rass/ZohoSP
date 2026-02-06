package problem;
import java.util.*;

/*
 * LRUCache Class
 * 
 * Implements a Least Recently Used (LRU) cache.
 * When the cache exceeds its capacity, it evicts the least recently used key.
 * Each get or put operation updates the usage order.
 * 
 * Data Structures Used:
 * - HashMap: For O(1) access to key-value pairs.
 * - LinkedList: For tracking usage order (most recent at end).
 */
class LRUCache {

    // Maximum number of entries the cache can hold
    private int size;

    // Stores key-value pairs
    private Map<Integer, Integer> cache;

    // Stores usage order of keys: least recently used at front, most recent at end
    private LinkedList<Integer> useageorder;

    /*
     * Constructor to initialize LRUCache with given capacity
     */
    public LRUCache(int size) {
        this.size = size;
        this.cache = new HashMap<>();
        this.useageorder = new LinkedList<>();
    }

    /*
     * get(key): Return the value of the key if present; otherwise return -1.
     * Also updates the usage order by moving the key to the end (most recently used).
     */
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1; // Key not found
        }

        // Key accessed: update its position to the most recently used
        useageorder.remove((Integer) key); // Remove old position (avoid treating as index)
        useageorder.addLast(key);          // Add to end (most recent)
        return cache.get(key);             // Return value from cache
    }

    /*
     * put(key, value): Add or update the key-value pair in cache.
     * If key exists, update its value and usage.
     * If key doesn't exist and cache is full, evict the least recently used key.
     */
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Key exists: remove it from usage list (will re-add below)
            useageorder.remove((Integer) key);
        } else {
            // Key doesn't exist
            if (cache.size() >= size) {
                // Cache is full: evict the least recently used key
                int lru = useageorder.removeFirst(); // Get and remove the first (least recently used)
                cache.remove(lru);                   // Remove from cache
            }
        }

        // Add or update key-value in cache and mark it as most recently used
        cache.put(key, value);
        useageorder.addLast(key); // Add key to end of usage list
    }

    /*
     * Main class for testing LRUCache functionality.
     * Demonstrates insertion, retrieval, and eviction based on LRU policy.
     */
    public class Main {
        public static void main(String[] args) {
            // Create LRUCache with capacity 2
            LRUCache cache = new LRUCache(2);

            cache.put(1, 100); // Cache: [1]
            cache.put(2, 200); // Cache: [1, 2]

            System.out.println(cache.get(1)); // Output: 100, Cache becomes: [2, 1]

            cache.put(3, 300); // Cache full: evict LRU (2), Cache: [1, 3]

            System.out.println(cache.get(2)); // Output: -1 (2 was evicted)
            System.out.println(cache.get(3)); // Output: 300
        }
    }
}
