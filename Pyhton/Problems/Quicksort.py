def quicksort(lst, low, high):
    if low >= high:
        return

    pivot = lst[(low + high) // 2]  # choose middle element as pivot
    i, j = low, high

    while i <= j:
        while lst[i] < pivot:
            i += 1
        while lst[j] > pivot:
            j -= 1
        if i <= j:
            lst[i], lst[j] = lst[j], lst[i]
            i += 1
            j -= 1

    # Recursive calls
    quicksort(lst, low, j)
    quicksort(lst, i, high)
arr = [10, 7, 8, 9, 1, 5]
quicksort(arr, 0, len(arr) - 1)
print(arr)
# Output: [1, 5, 7, 8, 9, 10]
