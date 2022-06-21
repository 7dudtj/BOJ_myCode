N = int(input())

a = input()
A = a.split()

for i in range(len(A)):
    A[i] = int(A[i])

A.sort()

minnum = A[0]
maxnum = A[len(A)-1]

print(minnum, maxnum)
