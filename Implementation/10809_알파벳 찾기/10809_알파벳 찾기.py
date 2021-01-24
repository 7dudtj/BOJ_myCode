S = input()

s = len(S)

A = [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
     -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]

for i in range(s-1,-1,-1):
    if S[i] == 'a':
        A[0] = i
    else:
        a = 0
    if S[i] == 'b':
        A[1] = i
    else:
        a = 0
    if S[i] == 'c':
        A[2] = i
    else:
        a = 0
    if S[i] == 'd':
        A[3] = i
    else:
        a = 0
    if S[i] == 'e':
        A[4] = i
    else:
        a = 0
    if S[i] == 'f':
        A[5] = i
    else:
        a = 0
    if S[i] == 'g':
        A[6] = i
    else:
        a = 0
    if S[i] == 'h':
        A[7] = i
    else:
        a = 0
    if S[i] == 'i':
        A[8] = i
    else:
        a = 0
    if S[i] == 'j':
        A[9] = i
    else:
        a = 0
    if S[i] == 'k':
        A[10] = i
    else:
        a = 0
    if S[i] == 'l':
        A[11] = i
    else:
        a = 0
    if S[i] == 'm':
        A[12] = i
    else:
        a = 0
    if S[i] == 'n':
        A[13] = i
    else:
        a = 0
    if S[i] == 'o':
        A[14] = i
    else:
        a = 0
    if S[i] == 'p':
        A[15] = i
    else:
        a = 0
    if S[i] == 'q':
        A[16] = i
    else:
        a = 0
    if S[i] == 'r':
        A[17] = i
    else:
        a = 0
    if S[i] == 's':
        A[18] = i
    else:
        a = 0
    if S[i] == 't':
        A[19] = i
    else:
        a = 0
    if S[i] == 'u':
        A[20] = i
    else:
        a = 0
    if S[i] == 'v':
        A[21] = i
    else:
        a = 0
    if S[i] == 'w':
        A[22] = i
    else:
        a = 0
    if S[i] == 'x':
        A[23] = i
    else:
        a = 0
    if S[i] == 'y':
        A[24] = i
    else:
        a = 0
    if S[i] == 'z':
        A[25] = i
    else:
        a = 0

for k in range(len(A)):
    print(A[k], end = ' ')
