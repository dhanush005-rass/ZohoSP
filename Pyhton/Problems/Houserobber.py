def maxmoney(lst):
    if not lst:
        return 0
    if len(lst) == 1:
        return lst[0]
    lst[1] = max(lst[0], lst[1])
    for i in range(2, len(lst)):
        lst[i] = max(lst[i-2] + lst[i], lst[i-1])
    return lst[-1]
result=maxmoney([6, 7, 1, 3, 8, 2, 4])
print(result)