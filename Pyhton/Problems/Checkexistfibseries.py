def fibo(num):
    if num < 0:
        return False  # Negative numbers are not Fibonacci numbers

    first, second = 0, 1
    while first <= num:
        if first == num:
            return True
        first, second = second, first + second
    return False
print(fibo(8))   # True
print(fibo(10))  # False
print(fibo(21))  # True
