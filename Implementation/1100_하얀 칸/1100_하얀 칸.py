A = []
Sum = 0

for i in range(8):
    shuttle = input()
    A.append(shuttle)

for j in range(0,7,2):
    if A[j][0] == 'F':
        Sum += 1
    if A[j][2] == 'F':
        Sum += 1
    if A[j][4] == 'F':
        Sum += 1
    if A[j][6] == 'F':
        Sum += 1
    else:
        Sum = Sum

for k in range(1,8,2):
    if A[k][1] == 'F':
        Sum += 1
    if A[k][3] == 'F':
        Sum += 1
    if A[k][5] == 'F':
        Sum += 1
    if A[k][7] == 'F':
        Sum += 1
    else:
        Sum = Sum

print(Sum)
