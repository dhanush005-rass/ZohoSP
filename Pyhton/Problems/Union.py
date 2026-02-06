def union(arr1,arr2):
    res=[]
    for x in arr1:
        if x in arr2:
            res.append(x)
    return res
print(union([3,30,34,9],[2,30,34,7]))