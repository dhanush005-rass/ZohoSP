def freqlst(lst):
    freq = {}
    for item in lst:
        freq[item] = freq.get(item, 0) + 1
    lst.clear()
    for key, value in freq.items():
        lst.append(key)
        if (value>1):
            lst.append(value)
    return lst
print(freqlst(['a','a','b','b','b','c','d','d']))
