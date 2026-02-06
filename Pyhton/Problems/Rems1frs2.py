def rems2frs1(str1,str2):
    lst=[]
    str1=str1.lower()
    str2=str2.lower()
    for i in range (len(str1)):
        if(str1[i] not in str2):
            lst.append(str1[i])
    str1="".join(lst)
    return str1
print(rems2frs1("Dhanush","Dhanush"))