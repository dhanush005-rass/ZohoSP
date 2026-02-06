def weight(lst):
    fir=0
    sec=0
    val=0
    while len(lst) > 1:
        lst = sorted(lst)
        fir=lst.pop()
        sec=lst.pop()
        val=fir-sec
        lst.append(val)
    return lst[0]
print(weight([1,3,4,0,6,7,0,3,7]))
print(weight([10, 10]))
print(weight([5]))
print(weight([8, 3, 5, 1]))
print(weight([0, 0, 0]))
print(weight([1, 3, 4, 0, 6, 7, 0, 3, 7]))

