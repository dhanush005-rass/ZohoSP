def mergsort(lst):
    if len(lst) <= 1:  # base case
        return lst
    middle = len(lst) // 2
    left = mergsort(lst[:middle])  # recursively sort left
    right = mergsort(lst[middle:])  # recursively sort right
    return merg(left, right)
def merg(left, right):
    joined = [0] * (len(left) + len(right))
    i = j = k = 0
    # merge while both halves have elements
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            joined[k] = left[i]
            i += 1
        else:
            joined[k] = right[j]
            j += 1
        k += 1
    # copy leftovers from left
    while i < len(left):
        joined[k] = left[i]
        i += 1
        k += 1
    # copy leftovers from right
    while j < len(right):
        joined[k] = right[j]
        j += 1
        k += 1
    return joined
print(mergsort([38, 27, 43, 3, 9, 82, 10]))
# Output: [3, 9, 10, 27, 38, 43, 82]
