A, B = map(int,input().split())

a = str(A)
b = str(B)

new_a1 = int(a[0])
new_a2 = int(a[1])
new_a3 = int(a[2])
new_a = new_a3 * 100 + new_a2 * 10 + new_a1 * 1

new_b1 = int(b[0])
new_b2 = int(b[1])
new_b3 = int(b[2])
new_b = new_b3 * 100 + new_b2 * 10 + new_b1 * 1

if new_a > new_b:
    print(new_a)
else:
    print(new_b)
