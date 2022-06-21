A, B, C = map(int, input().split())

if (A == B and B == C):
    print(B)
elif (A == B and A != C):
    if A > C:
        print(A)
    else:
        print(A)
elif (A == C and A != B):
    if A > B:
        print(A)
    else:
        print(A)
elif (C == B and C != A):
    if C > A:
        print(C)
    else:
        print(C)
elif (A != B and B != C and A != C):
    K = []
    K.append(A)
    K.append(B)
    K.append(C)
    K.sort()
    print(K[1])
