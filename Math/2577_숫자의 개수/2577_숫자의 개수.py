A = int(input())
B = int(input())
C = int(input())

answer = str(A*B*C)

List = [0]*10

for i in range(len(answer)):
    if answer[i] == '0':
        List[0] += 1
    elif answer[i] == '1':
        List[1] += 1
    elif answer[i] == '2':
        List[2] += 1
    elif answer[i] == '3':
        List[3] += 1
    elif answer[i] == '4':
        List[4] += 1
    elif answer[i] == '5':
        List[5] += 1
    elif answer[i] == '6':
        List[6] += 1
    elif answer[i] == '7':
        List[7] += 1
    elif answer[i] == '8':
        List[8] += 1
    elif answer[i] == '9':
        List[9] += 1

for k in range(10):
    print(List[k])
