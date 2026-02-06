def missingnum(arr):
    n = len(arr)  # Since one number is missing from [0, 1, 2, ..., n]
    needed_sum = n * (n + 1) // 2  # Integer division is better here
    actual_sum = sum(arr)
    return needed_sum - actual_sum
print(missingnum([0, 1, 3]))  # Output: 2
print(missingnum([1, 2, 3, 4]))  # Output: 0
