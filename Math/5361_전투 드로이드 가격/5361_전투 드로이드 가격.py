T = int(input())

for i in range(T):
    A, B, C, D, E = map(int,input().split())
    total = A*350.34 + B*230.90 + C*190.55 + D*125.30 + E*180.90
    Total = format(total,'.2f')
    print('$'+str(Total))
