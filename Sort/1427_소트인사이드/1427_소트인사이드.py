N = input()
List = []

for i in range(len(N)):
    List.append(N[i])

List.sort()

for k in range(len(List)-1,-1,-1):
    print(List[k], end = '')
