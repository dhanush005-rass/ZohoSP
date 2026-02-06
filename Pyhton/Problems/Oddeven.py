def oddeven(lst):
    for i in range(0, len(lst)-2, 2):
        if lst[i] > lst[i+2]:
            lst[i], lst[i+2] = lst[i+2], lst[i]
    for i in range(1, len(lst)-2, 2):
        if lst[i] < lst[i+2]:
            lst[i], lst[i+2] = lst[i+2], lst[i]
lst = [5, 2, 9, 0, 6, 8, 3]
oddeven(lst)
print(lst)
