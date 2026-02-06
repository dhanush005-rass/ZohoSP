def uniqnoocc(lst):
    freq = {}

    # Count frequencies
    for item in lst:
        freq[item] = freq.get(item, 0) + 1
    print(freq)
    # List of occurrences
    occls = list(freq.values())
    print(occls)
    # Check if all occurrences are unique
    return len(occls) == len(set(occls))
print(uniqnoocc([1, 2, 2, 3, 3, 3]))   # True (occurrences are [1,2,3])
print(uniqnoocc([1, 2, 2, 3, 3]))      # False (occurrences are [1,2,2])
