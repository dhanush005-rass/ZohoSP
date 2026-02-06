def kadens(lst):
    current_sum = 0
    max_sum = float('-inf')  # To handle all negative numbers case
    for num in lst:
        current_sum += num
        max_sum = max(max_sum, current_sum)
        if current_sum < 0:
            current_sum = 0

    return max_sum
arr = [-2, -3, 4, -1, -2, 1, 5, -3]
print(kadens(arr))  # Output: 7 (subarray [4, -1, -2, 1, 5])
