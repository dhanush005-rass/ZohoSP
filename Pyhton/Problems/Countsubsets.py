def findsubset(arr):
    count = 0
    start = 0  # Start index of the current subarray
    for i in range(len(arr)):
        if arr[i] < i - start:
            count += 1  # Close the current subarray
            start = i   # Start a new one

    return count + 1  # Add last subarray

def subset(arr):
    count = 0
    start = 0
    for i in range(len(arr)):
        if not arr[i] > i - start:
            count += 1
            start = i
    return count-1

arr = [6, 1, 6, 1, 3, 2, 6, 1]
print(findsubset(arr))
print(subset(arr))# Output: 3
