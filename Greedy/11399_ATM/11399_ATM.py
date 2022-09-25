T = int(input())
a = input()
A = a.split()
for i in range(T):
    A[i] = int(A[i])
A.sort()
Sum = 0
for k in range(T):
    Sum = Sum + (T-k)*A[k]
print(Sum)
