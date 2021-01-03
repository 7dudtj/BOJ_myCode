a = input()
A = a.split()
b = input()
B = b.split()
c = input()
C = c.split()
d = input()
D = d.split()
e = input()
E = e.split()

SumA = 0
SumB = 0
SumC = 0
SumD = 0
SumE = 0

List = []


for i in range(len(A)):
    SumA = SumA + int(A[i])

for j in range(len(B)):
    SumB = SumB + int(B[j])

for k in range(len(C)):
    SumC = SumC + int(C[k])

for m in range(len(D)):
    SumD = SumD + int(D[m])

for n in range(len(E)):
    SumE = SumE + int(E[n])


List.append(SumA)
List.append(SumB)
List.append(SumC)
List.append(SumD)
List.append(SumE)

maxnum = max(List)
winner = List.index(maxnum)



print(winner+1, maxnum)
