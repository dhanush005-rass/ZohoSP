def insertion_sort(lst):
    for i in range (len(lst)):
        for j in range(i, 0, -1):
            if lst[j] < lst[j-1]:
                lst[j], lst[j-1] = lst[j-1], lst[j]
            else:
                break
    return lst
print(insertion_sort([5,2,9,1,7]))