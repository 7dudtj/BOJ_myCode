# N과 K를 받으세요
N, K = map(int, input().split())

# 전체탐색을 통해 약수를 찾으세요
num = 0
answer = 0
for i in range(1, N+1):
    if (N%i == 0): 
        num += 1
    if (num == K):
        answer = i
        break

# 정답을 출력하세요
print(answer)