def squar(num):
    sqnum=0
    while num!=0:
        temp=num%10
        sqnum+=(temp*temp)
        num=num//10
    return sqnum

def happynumber(num):
    listvist=set()
    sqnum=0
    while (num!=1):
        num=squar(num)
        if num in listvist:
            return False
        listvist.add(num)
    return True

print(happynumber(19))  # Output: True, because 19 is a happy number
print(happynumber(20))  # Output: False
