S = input()

List = [0]*26

for i in range(len(S)):
    List[ord(S[i]) - 97] = List[ord(S[i]) - 97] + 1

for k in range(len(List)):
    print(str(List[k])+' ',end='')
