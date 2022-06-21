# set needed variables
from itertools import count


n = int(input())
graph = []
num = []
dx = [0,1,0,-1]
dy = [-1,0,1,0]

# get graph
for _ in range(n):
    graph.append(list(map(int, input())))

# dfs function
def dfs(x, y):
    if x < 0 or x >= n or y < 0 or y >= n:
        return False
    
    if graph[x][y] == 1:
        global count
        count += 1
        graph[x][y] = 0
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            dfs(nx, ny)
        return True
    return False

# calculate answer
count = 0
answer = 0
for i in range(n):
    for j in range(n):
        if dfs(i,j) == True:
            num.append(count)
            answer += 1
            count = 0

# sort answer
num.sort()

# print answer
print(answer)
for i in range(len(num)):
    print(num[i])