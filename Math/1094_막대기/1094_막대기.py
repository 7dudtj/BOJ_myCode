A = [64]
X = int(input())
play = True
Sum = 64

while play:
    if Sum > X:
        small_len = A[0]
        divide_len = A[0]/2
        del A[0]
        A.append(divide_len)
        A.append(divide_len)
        A.sort()
        Sum = sum(A)
        new_Sum = Sum - A[0]
        if new_Sum >= X:
            del A[0]
        else:
            None
        Sum = sum(A)
        if Sum == X:
            play = False
        else:
            play = True
    else:
        play = False

print(len(A))
