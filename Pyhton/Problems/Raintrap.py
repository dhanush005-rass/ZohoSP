def raintrap(arr):
    length = len(arr)
    if length == 0:
        return 0

    left = [0] * length
    right = [0] * length

    # Fill left max array
    left[0] = arr[0]
    for i in range(1, length):
        left[i] = max(left[i - 1], arr[i])

    # Fill right max array
    right[length - 1] = arr[length - 1]
    for i in range(length - 2, -1, -1):
        right[i] = max(right[i + 1], arr[i])

    # Calculate trapped water
    total_water = 0
    for i in range(length):
        total_water += min(left[i], right[i]) - arr[i]

    return total_water
height = [0,1,0,2,1,0,1,3,2,1,2,1]
print(raintrap(height))  # Output: 6
