N = int(input())

if N%5 == 0:
    A = int(N/5)
    print(A)
elif N%5 == 1:
    A = int((N-6)/5 + 2)
    print(A)
elif N%5 == 2:
    if N == 7:
        print('-1')
    else:
        A = int((N-12)/5 + 4)
        print(A)
elif N%5 == 3:
    A = int((N-3)/5 + 1)
    print(A)
elif N%5 == 4:
    if N == 4:
        print('-1')
    else:
        A = int((N-9)/5 + 3)
        print(A)
