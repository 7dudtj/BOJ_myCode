N = int(input())

for i in range(N):
    name = input()
    A = name.split()
    A[0] = 'god'
    for j in range(len(A)):
        print(A[j], end = '')
    print()
