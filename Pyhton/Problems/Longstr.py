def longstr(str):
    str=str.lower()
    words=str.split()
    vow="aeiou"
    for word in words:
        if(word[0] in vow and len(word)%2==0):
            return word
    return None
result=longstr("The Quick Brown Fox Jumps Over The Wall")
print(result)