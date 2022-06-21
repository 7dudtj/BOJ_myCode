x, y, w, h = map(int,input().split())

if x >= w-x:
    a = w-x
else:
    a = x

if y >= h-y:
    b = h-y
else:
    b = y

if a >= b:
    print(b)
else:
    print(a)