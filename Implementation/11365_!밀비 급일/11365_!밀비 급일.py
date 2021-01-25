import sys
N = input()
while N != 'END':
    for i in range(len(N)-1,-1,-1):
        print(N[i], end='')
    print()    
    N = input()
sys.exit()
