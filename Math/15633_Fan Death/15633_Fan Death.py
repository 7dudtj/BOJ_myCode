n = int(input())
List = []
Sum = 0

for i in range(1,n+1):
    if n%i == 0:
        List.append(i)

for k in range(len(List)):
    Sum = Sum + List[k]

Answer = Sum*5 - 24

print(Answer)
