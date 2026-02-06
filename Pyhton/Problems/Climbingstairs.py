def mincost(lst):
    first=lst[0]
    second=lst[1]
    if len(lst)<=2:
        return min(first,second)
    for i in range (2,len(lst)):
        current=lst[i]+min(first,second)
        first=second
        second=current
    return min(first,second)
res=mincost([10,15,20])
print(res)
