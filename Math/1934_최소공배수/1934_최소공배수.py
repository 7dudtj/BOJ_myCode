T = int(input())

for i in range(T):
    A, B = map(int,input().split())
    if A >= B:
        M = A
        N = B
    elif A < B:
        M = B
        N = A
    go = True    
    while go:
        if M % N == 0:
            GCD = N
            go = False
        else:
            R = M % N
            M = N
            N = R

    a = A // GCD        
    b = B // GCD
    answer = GCD * a * b
    print(answer)
