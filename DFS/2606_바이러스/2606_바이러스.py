# 2606번 DFS로 풀어보기

# 빠르게 입력받기
import sys
input = sys.stdin.readline

# dfs 함수를 만드세요
def dfs(graph, v, visited):
    global count
    visited[v] = True
    for i in graph[v]:
        if not visited[i]:
            count += 1
            dfs(graph, i, visited)

# 컴퓨터의 수를 N으로 받으세요
N = int(input())

# 연결되어있는 컴퓨터의 쌍의 수를 M으로 받으세요
M = int(input())
 
# graph list 선언하세요
graph = [[] for _ in range(N + 1)]

# visited list 선언하세요
visited = [False] * (N + 1)

# count 변수를 선언하세요 (global variable)
count = 0
 
# 연결되어있는 컴퓨터의 쌍을 입력받아서 그래프를 만드세요
for _ in range(M):
    node1, node2 = map(int, input().split())
    graph[node1].append(node2)
    graph[node2].append(node1)

# dfs를 수행하세요
dfs(graph, 1, visited)

# 결과를 출력하세요
print(count)