def reversevow(s):
    liststr = list(s)
    vowels = "aeiouAEIOU"
    left = 0
    right = len(liststr) - 1

    while left < right:
        # Move left forward until a vowel is found
        while left < right and liststr[left] not in vowels:
            left += 1

        # Move right backward until a vowel is found
        while left < right and liststr[right] not in vowels:
            right -= 1

        # Swap the vowels
        liststr[left], liststr[right] = liststr[right], liststr[left]

        # Move pointers inward
        left += 1
        right -= 1

    return ''.join(liststr)
print(reversevow("hello"))     # Output: "holle"
print(reversevow("leetcode"))  # Output: "leotcede"
