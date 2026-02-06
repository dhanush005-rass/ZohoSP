def remvow(pswd):
    notvalide="abcdefghijklmnopqrstuvwxyzAEIOU"
    res=[]
    for i in range (len(pswd)):
        if pswd[i] not in notvalide:
            res.append(pswd[i])
    ans="".join(res)
    return ans
res=remvow("MyName")
print(res)