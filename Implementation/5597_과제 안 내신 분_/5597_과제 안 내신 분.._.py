A = [0]*30

for i in range(28):
    a = int(input())
    A[a-1] = 1

for k in range(30):
    if A[k] == 0:
        print(k+1)
