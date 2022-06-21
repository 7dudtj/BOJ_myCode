# import libraries
import sys
from collections import deque

# set input
input = sys.stdin.readline

# get n and m
n,m = map(int, input().split())

# bfs function
def bfs(start):
    count = 1
    queue = deque([start])
    visited = [False for _ in range(n+1)]
    visited[start] = True

    while queue:
        tmp = queue.popleft()

        for node in mymap[tmp]:
            if not visited[node]:
                visited[node] = True
                count += 1
                queue.append(node)

    return count

# make map
mymap = [[] for _ in range(n+1)]

# get map
for _ in range(m):
    a,b = map(int, input().split())
    mymap[b].append(a)

# find answer
max = 1
answer = []
for i in range(1, n+1):
    count = bfs(i)
    if count > max:
        max = count
        answer.clear()
        answer.append(i)
    elif count == max:
        answer.append(i)

# print answer
print(*answer)