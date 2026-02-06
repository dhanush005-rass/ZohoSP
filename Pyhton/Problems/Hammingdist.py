def hammingdist(num1,num2):
    list1 = [0] * 16
    list2 = [0] * 16
    dist=0
    for i in range(len(list1)-1,-1,-1):
        list1[i]=num1%2
        num1 = num1//2
        list2[i] = num2 % 2
        num2 = num2 // 2
    for i in range(len(list1)):
        if(list1[i]!=list2[i]):
            dist+=1
    return dist
num1 = 10   # Binary: 0000 0000 0000 1010
num2 = 15   # Binary: 0000 0000 0000 1111

print(hammingdist(num1, num2))  # Output: 2
