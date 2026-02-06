def firwrtorep(lst):
    freq={}
    for i in lst:
        freq[i]=freq.get(i,0)+1
    for i in lst:
        val=freq.get(i)
        if val>1:
            return i
    return 0
print(firwrtorep([1,3,4,0,6,7,0,3,7]))