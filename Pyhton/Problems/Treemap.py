def orderdict(lst):
    frequency = {}

    # Count frequencies
    for item in lst:
        frequency[item] = frequency.get(item, 0) + 1

    # Create a sorted dictionary by key
    sorted_frequency = dict(sorted(frequency.items()))

    return sorted_frequency
lst = [5, 3, 1, 3, 5, 2, 1, 5]
result = orderdict(lst)
print(result)
