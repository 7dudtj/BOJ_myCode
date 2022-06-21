E, S, M = map(int,input().split())

for i in range (1, 7981):
    e = i%15
    s = i%28
    m = i%19
    if e == 0:
        e = 15
    else:
        a = 0
        
    if s == 0:
        s = 28
    else:
        a = 0
        
    if m == 0:
        m = 19
    else:
        a = 0
        
    if (e==E and s==S and m==M):
        break
    else:
        a = 0

print(i)
