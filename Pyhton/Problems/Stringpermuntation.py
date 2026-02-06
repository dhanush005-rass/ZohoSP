def permuntation(str,ans):
    digits='0123456789'
    if (len(str)==0):
        if (ans[0] in digits):
            return 1
    count = 0
    for i in range (len(str)):
        remaining=str[0:i]+str[i+1:]
        count+=permuntation(remaining,ans+str[i])
    return count
print(permuntation('d2005',''))
