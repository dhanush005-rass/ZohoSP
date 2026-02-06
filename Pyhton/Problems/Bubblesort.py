def bubble_sort(lst):
    for i in range(1,len(lst)):
        for j in range(len(lst)-i):
            if lst[j]>lst[j+1]:
                lst[j],lst[j+1]=lst[j+1],lst[j]
    return lst
print(bubble_sort([5,2,9,1,7]))
