def twosum(lst, target):
    comp = {}  # Stores value needed to reach target as key and its index as value

    for i, num in enumerate(lst):
        if num in comp:
            # Found a pair where num + (target - num) == target
            return [comp[num], i]
        # Store the complement needed to reach the target
        comp[target - num] = i

    return []  # Return empty list if no solution found
lst = [2, 7, 11, 15]
target = 9

print(twosum(lst, target))  # Output: [0, 1]
