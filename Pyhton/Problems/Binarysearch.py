def binser(lst,num):
    lst=sorted(lst)
    start=0
    end=len(lst)-1
    mid=0
    while start<end:
        mid=(start+end)//2
        if(lst[mid]==num):
            return mid
        elif(num<lst[mid]):
            end=mid-1
        else:
            start=mid+1
    return -1
print(binser([5, 2, 9, 1, 7], 7))  # Output: 3 (sorted list is [1,2,5,7,9])
print(binser([5, 2, 9, 1, 7], 4)) 