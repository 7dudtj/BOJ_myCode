T = int(input())

for i in range(T):
    score = [0]*80
    a = input()
    A = len(a)
    for j in range(A):
        if a[j] == 'X':
            score[j] = 0
        else:
            if j == 0:
                score[0] = 1
            else:
                score[j] = score[j-1] + 1
    print(sum(score))
