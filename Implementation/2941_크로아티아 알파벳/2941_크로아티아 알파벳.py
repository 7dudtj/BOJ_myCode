N = input()
Sum = 0
while True:
    if N[0:2] == 'c=' or N[0:2] == 'c-' or N[0:2] == 'd-' or\
       N[0:2] == 'lj' or N[0:2] == 'nj' or N[0:2] == 's=' or\
       N[0:2] == 'z=':
        N = N[2:len(N)]
        Sum = Sum + 1
        if len(N) == 0:
            break
        else:
            None
    elif N[0:3] == 'dz=':
        N = N[3:len(N)]
        Sum = Sum + 1
        if len(N) == 0:
            break
        else:
            None
    else:
        N = N[1:len(N)]
        Sum = Sum + 1
        if len(N) == 0:
            break
        else:
            None
print(Sum)
