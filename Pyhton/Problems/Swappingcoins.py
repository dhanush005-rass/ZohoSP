def swapcoins(N, Binstr, cost, swapcost, flipcost):
    lst = list(Binstr)

    # Prefer swaps if cheaper and cost permits
    if swapcost < flipcost:
        for i in range(N):
            for j in range(N - 1, i, -1):
                # Swap only if lst[i] is '1' and lst[j] is '0'
                if lst[i] == '1' and lst[j] == '0' and cost >= swapcost:
                    lst[i], lst[j] = lst[j], lst[i]
                    cost -= swapcost
                # Stop if no coins left
                if cost < swapcost:
                    break

    # Then, flip if cheaper and cost permits
    for i in range(N):
        if lst[i] == '1' and cost >= flipcost:
            lst[i] = '0'
            cost -= flipcost
        # Stop if not enough coins
        if cost < flipcost:
            break

    Binstr = ''.join(lst)
    return int(Binstr, 2) % (10 ** 9 + 7)
N = 6
Binstr = "111011"
cost = 7
swapcost = 1
flipcost = 3

result = swapcoins(N, Binstr, cost, swapcost, flipcost)
print(result)  # Should match sample outputs, e.g., 7

N = 4
Binstr = "1111"
cost = 7
swapcost = 1
flipcost = 2

result = swapcoins(N, Binstr, cost, swapcost, flipcost)
print(result)

N = 6
Binstr = "111011"
cost = 7
swapcost = 3
flipcost = 2

result = swapcoins(N, Binstr, cost, swapcost, flipcost)
print(result)