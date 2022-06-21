import sys

n = int(input())

fib0 = 0
fib1 = 1

i = 1

if n == 0:
    print(0)
    sys.exit()

elif n == 1:
    print(1)
    sys.exit()

elif n >= 2:
    while i != n:
        i += 1
        fib = fib0 + fib1
        fib0 = fib1
        fib1 = fib
    print(fib)
