# import libraries
from collections import deque
import sys
input = sys.stdin.readline

# dfs 함수를 만드세요
def dfs(v):
    visited[v] = True
    print(v, end=" ")
    for i in graph[v]:
        if not visited[i]:
            dfs(i)

# bfs 함수를 만드세요
def bfs(s):
    queue = deque()
    queue.append(s)
    visited[s] = True

    while queue:
        v = queue.popleft()
        print(v, end=" ")
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

# N, M, V를 입력받으세요
N, M, V = map(int, input().split())

# graph list를 선언하고, 간선을 입력받아 그래프를 만드세요
graph = [[] for _ in range(N+1)]
for _ in range(M):
    node1, node2 = map(int, input().split())
    graph[node1].append(node2)
    graph[node2].append(node1)

# graph를 오름차순으로 정렬하세요
# Hint: graph[1]부터 graph[N]까지 각각 오름차순 정렬
for i in range(1, N+1):
    graph[i].sort()

# dfs에 사용될 visited list를 만들고 dfs를 수행하세요
visited = [False for _ in range(N+1)]
dfs(V)

# 줄 넘김
print() 

# bfs에 사용될 visited list를 만들고 bfs를 수행하세요
visited = [False for _ in range(N+1)]
bfs(V)