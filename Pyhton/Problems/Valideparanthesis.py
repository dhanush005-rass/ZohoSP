def validate(string):
    lst=[]
    for i in range(len(string)):
        if string[i] == '(' or string[i] == '[' or string[i] == '{':
            lst.append(string[i])
        if ((string[i]==']'and lst[-1]=='[')or (string[i]=='}'and lst[-1]=='{')or(string[i]==')'and lst[-1]=='(')):
            lst.pop()
    return "Valide" if lst==[] else "Not Valide"
print(validate('()[]{}'))
print(validate('({[)]}'))