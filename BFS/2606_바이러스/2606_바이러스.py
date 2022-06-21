# 2606번 BFS로 풀어보기

# 빠르게 입력받기
import sys
input = sys.stdin.readline

# import deque
from collections import deque

# 컴퓨터의 수를 N으로 받으세요
N = int(input())

# 연결되어있는 컴퓨터의 쌍의 수를 M으로 받으세요
M = int(input())

# graph list 선언하세요
graph = [[] for _ in range(N + 1)]

# visited list 선언하세요
visited = [False] * (N + 1)

# count 변수를 선언하세요
count = 0

# 연결되어있는 컴퓨터의 쌍을 입력받아서 그래프를 만드세요
for _ in range(M):
    node1, node2 = map(int, input().split())
    graph[node1].append(node2)
    graph[node2].append(node1)

# queue를 선언하세요
queue = deque()

# 1번 컴퓨터를 방문하세요
queue.append(1)
visited[1] = True

# bfs를 수행하세요
while queue:
    v = queue.popleft()
    count += 1
    for i in graph[v]:
        if not visited[i]:
            queue.append(i)
            visited[i] = True

# 결과를 출력하세요
print(count-1)