N = int(input("Enter The Size Of the List: "))
lst = [0] * N

for i in range(N):
    num = int(input(f"Enter The Number {i+1}: "))
    lst[i] = num

maxxor = 0
limit = N // 2

for i in range(N):
    sublst = lst[i:]
    if len(sublst) <= limit:
        xornum = 0
        for j in range(len(sublst)):
            xornum ^= sublst[j]
        if xornum > maxxor:
            maxxor = xornum

print(maxxor)
