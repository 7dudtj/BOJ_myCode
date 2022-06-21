A, B = map(int,input().split())

if A >= B:
    M = A
    N = B
else:
    M = B
    N = A

go = True

while go:
    R = M%N
    if R == 0:
        GCD = N
        go = False
    else:
        M = N
        N = R
        go = True

a = A/GCD
b = B/GCD

small = GCD*a*b

print(GCD)
print(int(small))
