from sys import stdin

N = int(input())
List = []

for i in range(N):
    a = int(stdin.readline())
    List.append(a)

Sum = sum(List)
    

print(Sum - N + 1)
