def stoneMoves(a, b, c):
    x, y, z = sorted([a, b, c])
    gap1 = y - x
    gap2 = z - y
    # Minimum moves
    if gap1 == 1 and gap2 == 1:
        min_moves = 0
    elif gap1 <= 2 or gap2 <= 2:
        min_moves = 1
    else:
        min_moves = 2
    # Maximum moves
    max_moves = z - x - 2
    return [min_moves, max_moves]
print(stoneMoves(1, 2, 3))  # [0, 0]
print(stoneMoves(1, 2, 5))  # [1, 2]
print(stoneMoves(4, 1, 7))  # [2, 4]
