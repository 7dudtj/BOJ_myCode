T = int(input())
A = []
for i in range(T):
    a = 0
    a = int(input())
    A.append(a)

A.sort()

for k in range(T):
    print(A[k])
