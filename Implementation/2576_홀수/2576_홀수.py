a = int(input())
b = int(input())
c = int(input())
d = int(input())
e = int(input())
f = int(input())
g = int(input())
h = int(input())
i = int(input())

A = []

A.append(a)
A.append(b)
A.append(c)
A.append(d)
A.append(e)
A.append(f)
A.append(g)
A.append(h)
A.append(i)


B = sorted(A)

maxnum = B[8]

for k in range(len(A)):
    if A[k] == maxnum:
        count = k+1
        break
    else:
        None

print(maxnum)
print(count)
