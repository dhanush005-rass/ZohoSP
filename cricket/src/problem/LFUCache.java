package problem;
import java.util.*;

public class LFUCache {

    // Inner class representing a custom LRUCache with LFU behavior
    class LRUCache {

        private int size; // Maximum capacity of the cache
        private Map<Integer, Integer> cache;       // Stores key -> value
        private Map<Integer, Integer> freqorder;   // Stores key -> frequency of use

        public LRUCache(int size) {
            this.size = size;
            this.cache = new HashMap<>();
            this.freqorder = new TreeMap<>();
        }

        // Get the value for the key, if it exists. Also update its frequency.
        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }

            // Increase usage frequency
            freqorder.put(key, freqorder.getOrDefault(key, 0) + 1);
            return cache.get(key);
        }

        // Insert or update the key-value pair in the cache
        public void put(int key, int value) {
            // If key already exists, just update the value and frequency
            if (cache.containsKey(key)) {
                cache.put(key, value);
                freqorder.put(key, freqorder.getOrDefault(key, 0) + 1);
                return;
            }

            // If cache is full and key doesn't already exist, evict the LFU key
            if (cache.size() >= size) {
                int lfu = getLFUKey(); // Find least frequently used key
                cache.remove(lfu);     // Remove it from cache
                freqorder.remove(lfu); // Remove it from frequency map
            }

            // Insert the new key-value pair and set its frequency to 1
            cache.put(key, value);
            freqorder.put(key, 1);
        }

        // Helper function to find the key with the least frequency
        // If tie, returns the smallest key
        private int getLFUKey() {
            int minFreq = Collections.min(freqorder.values());
            int lfuKey = Integer.MAX_VALUE;

            for (Map.Entry<Integer, Integer> entry : freqorder.entrySet()) {
                if (entry.getValue() == minFreq) {
                    lfuKey = Math.min(lfuKey, entry.getKey());
                }
            }

            return lfuKey;
        }
    }

    // Static method to process operations on the LFU cache
    public static void solve(int N, int Q, List<int[]> operations) {
        LFUCache outer = new LFUCache();
        LRUCache cache = outer.new LRUCache(N); // Create cache with capacity N

        List<Integer> result = new ArrayList<>();

        // Process each operation
        for (int[] op : operations) {
            if (op[0] == 1) {
                // Type 1: Get the value of key
                int val = cache.get(op[1]);
                result.add(val);
            } else if (op[0] == 2) {
                // Type 2: Put the key-value pair
                cache.put(op[1], op[2]);
            }
        }

        // Print all results of get operations
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) System.out.print(" ");
        }
        System.out.println(); // End with newline
    }

    // Sample main method for testing
    public static void main(String[] args) {
        int N = 2; // Cache capacity
        int Q = 5; // Number of operations

        // Operations in format [type, key, value or -1]
        List<int[]> operations = new ArrayList<>();
        operations.add(new int[]{1, 2, -1});  // Get 2 -> -1 (not found)
        operations.add(new int[]{2, 1, 3});   // Put 1 -> 3
        operations.add(new int[]{2, 2, 4});   // Put 2 -> 4
        operations.add(new int[]{2, 4, 5});   // Put 4 -> 5 (evict LFU key 1)
        operations.add(new int[]{1, 2, -1});  // Get 2 -> 4

        // Call the solve method to execute operations
        solve(N, Q, operations);  // Expected Output: -1 4
    }
}
