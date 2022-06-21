N = input()
initial = []
initial.append(N[0])
while '-' in N:
    i = 0
    A = 0
    while N[i] != '-':
        i += 1
    A = N[i+1:]
    initial.append(A[0])
    N = A
for j in range(len(initial)):
    print(initial[j], end='')
