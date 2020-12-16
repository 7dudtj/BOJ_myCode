ao, ai = map(int,input().split())
bo, bi = map(int,input().split())
co, ci = map(int,input().split())
do, di = map(int,input().split())

atob = ai
btoc = ai - bo + bi
ctod = do

Mani = []

Mani.append(atob)
Mani.append(btoc)
Mani.append(ctod)

Mani.sort()
print(Mani[2])
