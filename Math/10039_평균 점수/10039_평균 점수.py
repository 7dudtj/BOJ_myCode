a = int(input())
b = int(input())
c = int(input())
d = int(input())
e = int(input())

A = [a,b,c,d,e]

for i in range(len(A)):
    if A[i] < 40:
        A[i] = 40
    else:
        None

print(int(sum(A)/5))
