a = input()



List = []


for i in range(len(a)):
    List.append(a[i])


if len(List) == 1:
    print(1)
    exit()
else:
    None


if len(List)%2 == 1:
    center = len(List)//2
    del List[center]
else:
    None


s = len(List)
count = s//2


for j in range(count):
    if List[0] == List[len(List)-1]:
        del List[0]
        del List[len(List)-1]
    else:
        List = [1]
        break
    
if len(List) == 0:
    print(1)
else:
    print(0) 
