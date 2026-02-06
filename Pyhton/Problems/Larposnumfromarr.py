def larposnum(lst):
    ij=''
    ji=''
    strl=[]
    for i in range (len(lst)):
        for j in range (i+1,len(lst)):
            ij=str(lst[i])+str(lst[j])
            ji=str(lst[j])+str(lst[i])
            if ji>ij:
                lst[i],lst[j]=lst[j],lst[i]
    for x in lst:
        strl.append(str(x))
    return "".join(strl)
print(int(larposnum([3,30,34,9])))
