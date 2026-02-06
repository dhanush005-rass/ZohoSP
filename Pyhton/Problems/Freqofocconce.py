def freofoconce(numbers,target):
    frequency={}
    for number in numbers:
        if(number in frequency):
            frequency[number]+=1
        else:
            frequency[number]=1
    for key,value in frequency.items():
        if(value==target):
            return key
    return None
list=[1,2,2,3,3,3,4,4,4,4]
result=freofoconce(list,3)
print(result)