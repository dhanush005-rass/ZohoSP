def maxpeptr(n,x,lst):
    lst=sorted(lst)
    total_weight=0
    count=0
    i=0
    while total_weight<x:
        total_weight+=lst[i]
        count+=1
        i+=1
    return count
print(maxpeptr(5,100,[20, 50, 30, 40, 10]))
print(maxpeptr(3,50,[60,20,30]))

