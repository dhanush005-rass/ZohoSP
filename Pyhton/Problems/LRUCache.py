class LRU:
    def __init__(self, size):
        self.__size = size
        self.__useageorder = []  # Keeps track of key usage order
        self.__cache = {}        # Stores key-value pairs

    def get(self, key):
        if key in self.__useageorder:
            self.__useageorder.remove(key)
            self.__useageorder.append(key)  # Mark as most recently used
            return self.__cache[key]
        else:
            return None

    def put(self, key, value):
        if key in self.__useageorder:
            self.__useageorder.remove(key)
        elif len(self.__cache) >= self.__size:
            # Evict least recently used key (front of the list)
            lru_key = self.__useageorder.pop(0)
            del self.__cache[lru_key]

        # Insert or update key
        self.__useageorder.append(key)
        self.__cache[key] = value
cache = LRU(2)
cache.put('a', 1)
cache.put('b', 2)
print(cache.get('a'))  # Output: 1
cache.put('c', 3)      # Evicts 'b' (least recently used)
print(cache.get('b'))  # Output: None
