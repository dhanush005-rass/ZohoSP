def count_mini_boxes(x, lst):
    N = len(lst)
    left = 0
    right = N - 1
    count = 0
    while left <= right:
        if lst[left] + lst[right] <= x:
            # All subarrays from left to right are valid
            count += (right - left + 1)
            left += 1
        else:
            # Sum too big, try smaller largest number
            right -= 1
    return count
print(count_mini_boxes(5, [1, 2, 3, 4, 5]))