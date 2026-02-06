def findleaders(lst):
    leadres=[]
    for i in range (len(lst)-1,-1,-1):
        if lst[i]>sum(lst[i+1:]):
            leadres.append(lst[i])
    return leadres[::-1]
result=findleaders([1,2,3,4,5,2])
print(result)
