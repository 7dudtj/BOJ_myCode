burger = []
drink = []

a = int(input())
burger.append(a)
b = int(input())
burger.append(b)
c = int(input())
burger.append(c)
d = int(input())
drink.append(d)
e = int(input())
drink.append(e)

burger.sort()
drink.sort()

print(burger[0] + drink[0] - 50)
