def subwoop(a, b):
    MASK = 0xFFFFFFFF
    MAX_INT = 0x7FFFFFFF

    while b != 0:
        borrow = ((~a & b) << 1) & MASK
        a = (a ^ b) & MASK
        b = borrow

    # convert back to signed int
    return a if a <= MAX_INT else ~(a ^ MASK)


print(subwoop(1, 2))  # -1
print(subwoop(10, 30))  # 7
print(subwoop(5, 8))  # -3
