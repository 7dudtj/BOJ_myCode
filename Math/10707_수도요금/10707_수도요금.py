A = int(input())
B = int(input())
C = int(input())
D = int(input())
E = int(input())

X = A*E
Y = 0
if (E <= C):
    Y = B
else:
    Y = B + D * (E - C)

if (X >= Y):
    print(Y)
else:
    print(X)
