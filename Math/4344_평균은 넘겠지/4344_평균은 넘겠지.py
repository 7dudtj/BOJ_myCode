def intro():
    for i in range(len(A)):
        A[i] = int(A[i])


C = int(input())
for i in range(C):
    a = input()
    A = a.split()
    intro()
    N = A[0]
    del A[0]
    Sum = 0
    for k in range(len(A)):
        Sum = Sum + A[k]
    Mean = Sum/len(A)
    M = []
    for j in range(len(A)):
        if A[j] > Mean:
            M.append(A[j])
    percentage = len(M)/len(A)*100
    print(format(percentage,'.3f')+'%')
