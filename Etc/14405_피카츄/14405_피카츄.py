import sys

S = input()
go = True


while go:
    if len(S) == 0:
        print('YES')
        sys.exit()
    elif len(S) == 1:
        print('NO')
        sys.exit()
    elif len(S) == 2:
        if S == 'pi' or S == 'ka':
            S = ''
        else:
            print('NO')
            sys.exit()
    elif len(S) == 3:
        if S == 'chu':
            S = ''
        else:
            print('NO')
            sys.exit()
    elif len(S) >= 4:
        if S[0:2] == 'pi' or S[0:2] == 'ka':
            S = S[2:len(S)]
        elif S[0:3] == 'chu':
            S = S[3:len(S)]
        else:
            print('NO')
            sys.exit()
