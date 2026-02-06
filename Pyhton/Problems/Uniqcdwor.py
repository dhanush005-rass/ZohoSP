def countunisub(string):
    string = string.upper()
    lst=[]
    substr=''
    i=0
    while i<len(string):
        if i+3>len(string):
            break
        substr=string[i:i+3]
        lst.append(substr)
        i+=3
    print(lst)
    return len(lst)
print(countunisub('abcdefghij'))
