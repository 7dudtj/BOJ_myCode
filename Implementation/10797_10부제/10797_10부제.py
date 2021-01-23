date = input()
a = input()
A = a.split()
count = 0

for i in range(len(A)):
    if date == A[i]:
        count += 1
    else:
        None

print(count)
