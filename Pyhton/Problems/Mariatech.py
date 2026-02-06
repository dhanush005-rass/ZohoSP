def maria(a,x):
    lst=[]
    for i in range(1,a+1):
        lst.append(i)
    lst.append(lst[0])
    b=[0]*(len(lst)-1)
    for i in range (len(lst)-1):
        b[i]=lst[i]+lst[i+1]
    ct=0
    for num in b:
        if num%x==0:
            ct+=num
    return ct
print(maria(5,3))
print(maria(4,5))