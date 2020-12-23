T = int(input())

for i in range(T):
    A, B = map(str,input().split())
    A = int(A)
    s = len(B)
    for k in range(s):
        print(B[k]*A,end='')
    print()
