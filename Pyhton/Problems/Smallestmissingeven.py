def smallestmissingeven(lst):
    lst_set = set(lst)
    i = 0
    while True:
        if i not in lst_set:
            return i
        i += 2
print(smallestmissingeven([0, 2, 4, 6, 8]))    # Output: 10
print(smallestmissingeven([0, 2, 6, 8]))       # Output: 4
print(smallestmissingeven([1, 3, 5]))          # Output: 0
