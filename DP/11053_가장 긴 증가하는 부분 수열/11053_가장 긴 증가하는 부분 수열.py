# N을 입력받으세요
N = int(input())

# N개의 정수롤 구성된 수열 A를 리스트로 받으세요
A = list(map(int, input().split()))

# dp를 수행할 배열을 만드세요
# Hint: 모든 초기값은 1
dp = [1 for _ in range(N)]

# dp를 수행하세요
for i in range(1, N):
    for j in range(0, i):
        if A[j] < A[i]:
            dp[i] = max(dp[i], dp[j]+1)

# 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력하세요
print(max(dp))