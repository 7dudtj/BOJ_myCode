import sys

N = input()
M = N
a = 0
if int(N) == 0:
    print('1')
    sys.exit()

i = 0
while a != int(N):
    L = len(N)
    i += 1
    if L == 1:
        n = '0'+N
    elif L == 2:
        n = N
    
    Sum = int(n[0]) + int(n[1])
    Sum = str(Sum)

    if len(Sum) == 1:
        Sum = '0'+str(Sum)
    elif len(Sum) == 2:
        Sum = str(Sum)

    new = str(n[1]) + str(Sum[1])

    if int(new) == int(M):
        break
    else:
        N = new

print(i)
