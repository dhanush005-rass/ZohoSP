def pivotele(lst):
    for i in range(len(lst)):
        lsum = sum(lst[:i])
        rsum = sum(lst[i+1:])
        if lsum == rsum:
            return i
    return -1
arr = [1, 7, 3, 6, 5, 6]
print(pivotele(arr))  # Output: 3 (because 1+7+3 == 5+6)
