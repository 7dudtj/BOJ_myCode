import sys

Cap = []
UCPC = []
Final = []

N = input()

for i in range(len(N)):
    if N[i] in 'ABCDEFGHIJKLMNOPQRSTUVWXYZ':
        Cap.append(N[i])
    else:
        None

for j in range(len(Cap)):
    if Cap[j] in 'UCPC':
        UCPC.append(Cap[j])

if len(UCPC) < 4:
    print('I hate UCPC')
    sys.exit()
else:
    None

for k in range(len(UCPC)):
    if UCPC[k] == 'U':
        if k > len(UCPC)-4:
            print('I hate UCPC')
            sys.exit()
        else:
            Final.append('U')
            UCPC = UCPC[k+1:]
            break
    else:
        None

for m in range(len(UCPC)):
    if UCPC[m] == 'C':
        if m > len(UCPC)-3:
            print('I hate UCPC')
            sys.exit()
        else:
            Final.append('C')
            UCPC = UCPC[m+1:]
            break
    else:
        None
        
for n in range(len(UCPC)):
    if UCPC[n] == 'P':
        if n > len(UCPC)-2:
            print('I hate UCPC')
            sys.exit()
        else:
            Final.append('P')
            UCPC = UCPC[n+1:]
            break
    else:
        None

for h in range(len(UCPC)):
    if UCPC[h] == 'C':
        if h > len(UCPC)-1:
            print('I hate UCPC')
            sys.exit()
        else:
            Final.append('C')
            break
    else:
        None

if len(Final) != 4:
    print('I hate UCPC')
    sys.exit()
else:
    None

if Final[0] == 'U' and Final[1] == 'C' and Final[2] == 'P' and Final[3] == 'C':
    print('I love UCPC')
else:
    print('I hate UCPC')
