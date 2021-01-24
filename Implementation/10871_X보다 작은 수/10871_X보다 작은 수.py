N, X = map(int,input().split())
L = []
T = []
F = []

A = input()

for i in range(N):
    a = 0
    j = 0
    if i == N-1:
        L.append(A)
        break
    while A[j] != ' ':
        j += 1    
    a = A[:j]
    A = A[j+1:]
    L.append(a)

for k in range(len(L)):
    if int(L[k]) < X:
        T.append(L[k])

for n in range(len(T)):
    nn = int(T[n])
    F.append(nn)

for p in range(len(F)):
    print(str(F[p])+' ', end = '')
