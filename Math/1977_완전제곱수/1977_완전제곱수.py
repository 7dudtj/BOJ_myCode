M = int(input())
N = int(input())
perf = []

for i in range(1,101):
    if M <= i**2 <= N:
        perf.append(i**2)
    else:
        None

if len(perf) != 0:    
    print(sum(perf))
    print(perf[0])
else:
    print(-1)
