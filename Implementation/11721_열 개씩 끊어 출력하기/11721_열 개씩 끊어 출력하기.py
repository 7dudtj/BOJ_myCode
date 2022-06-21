a = input()
N = len(a)
for i in range(0,N):
    if i%10 == 0:
        if i == 0:
            print(a[0],end='')
        else:
            print()
            print(a[i],end='')       
    else:
        print(a[i],end='')
