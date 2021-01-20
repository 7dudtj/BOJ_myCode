N = input()
Sum = 10

for i in range(len(N) - 1):
    if N[i] == N[i+1]:
        Sum = Sum + 5
    else:
        Sum = Sum + 10

print(Sum)
