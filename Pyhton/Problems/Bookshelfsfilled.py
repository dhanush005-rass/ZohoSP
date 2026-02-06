def fullbs(numst, shlsz, lstbk):
    carrybk = 0
    fullself = 0
    for books in lstbk:
        total_books = books + carrybk
        full_shelves = total_books // shlsz
        fullself += full_shelves
        carrybk = total_books % shlsz  # leftover for next student
    # leftover after last student is discarded
    return fullself
# Test
print(fullbs(3, 5, [4, 7, 2]))  # Output: 2
