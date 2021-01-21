def sumott(n):
    if n == 1:
        return 1
    elif n == 2:
        return 2
    elif n == 3:
        return 4
    elif n == 4:
        return 7
    elif n == 5:
        return 13
    elif n == 6:
        return 24
    elif n == 7:
        return 44
    elif n == 8:
        return 81
    elif n == 9:
        return 149
    elif n == 10:
        return 274


T = int(input())

for i in range(T):
    a = int(input())
    print(sumott(a))
