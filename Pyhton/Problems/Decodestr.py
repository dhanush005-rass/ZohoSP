def decode(s):
    numstack=[]
    strstack=[]
    currentnum=0
    currentstr=''
    for char in s:
        if char.isdigit():
            currentnum=currentnum*10+int(char)
        elif char=='[':
            numstack.append(currentnum)
            strstack.append(currentstr)
            currentnum=0
            currentstr=''
        elif char==']':
            repeattimes=numstack.pop()
            prevtr=strstack.pop()
            currentstr=prevtr+currentstr*repeattimes
        else:
            currentstr+=char
    return currentstr

# Test the function
print(decode('3[a2[c]]'))  # Output: accaccacc
