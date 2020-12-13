def intro():
    for i in range(N):
        A[i] = int(A[i])

def renew():
    for k in range(0,N):
        A[k] = A[k]/Max*100
        
        


N = int(input())
a = input()
A = a.split()
intro()
A.sort()
L = len(A)
Max = A[L-1]
renew()

Sum = 0
for j in range(0,N):
    Sum = Sum + A[j]

mean = Sum/N

print(format(mean,'.2f'))
