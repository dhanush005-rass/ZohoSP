class LFU:
    def __init__(self, size):
        self.size = size
        self.cache = {}      # key -> value
        self.freq = {}       # key -> frequency

    def get(self, key):
        if key in self.cache:
            self.freq[key] += 1
            return self.cache[key]
        return -1  # Not found

    def put(self, key, value):
        if self.size <= 0:
            return

        # If key exists, update value and frequency
        if key in self.cache:
            self.cache[key] = value
            self.freq[key] += 1
            return

        # If cache is full, remove the LFU entry
        if len(self.cache) >= self.size:
            min_freq = min(self.freq.values())
            lfu_keys = [k for k, f in self.freq.items() if f == min_freq]
            # Remove the oldest key among LFU keys (could use OrderedDict for true LRU)
            del_key = lfu_keys[0]
            del self.cache[del_key]
            del self.freq[del_key]

        # Insert new key
        self.cache[key] = value
        self.freq[key] = 1

def test_LFU():
    # Create LFU cache with capacity 2
    lfu = LFU(2)

    # Test 1: Put two items and get them
    lfu.put(1, 'A')   # cache: {1:'A'}
    lfu.put(2, 'B')   # cache: {1:'A', 2:'B'}
    print("Test 1.1:", "Pass" if lfu.get(1) == 'A' else "Fail")   # returns 'A'
    print("Test 1.2:", "Pass" if lfu.get(2) == 'B' else "Fail")   # returns 'B'

    # Test 2: Frequency update and eviction
    lfu.get(1)         # freq[1] = 2 now
    lfu.put(3, 'C')    # Evict key 2 (freq 1), cache: {1:'A', 3:'C'}
    print("Test 2.1:", "Pass" if lfu.get(2) == -1 else "Fail")    # returns -1 (not found)
    print("Test 2.2:", "Pass" if lfu.get(3) == 'C' else "Fail")   # returns 'C'
    print("Test 2.3:", "Pass" if lfu.get(1) == 'A' else "Fail")   # returns 'A'

    # Test 3: Further eviction
    lfu.put(4, 'D')    # Evict key 3 (freq 1), cache: {1:'A', 4:'D'}
    print("Test 3.1:", "Pass" if lfu.get(3) == -1 else "Fail")    # returns -1 (not found)
    print("Test 3.2:", "Pass" if lfu.get(4) == 'D' else "Fail")   # returns 'D'
    print("Test 3.3:", "Pass" if lfu.get(1) == 'A' else "Fail")   # returns 'A'

    print("All tests complete.")

test_LFU()