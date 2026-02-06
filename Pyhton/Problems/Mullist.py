def mul(lst):
    mul=1
    if(len(lst)==0):
        return 1
    for i in range (len(lst)):
        mul*=lst[i]
    return mul

def mullis(lst):
    res=[0]*len(lst)
    for i in range (len(lst)):
        res[i]=(mul(lst[:i])*mul(lst[i+1:]))
    return res

result=mullis([1,2,3,4])
print(result)