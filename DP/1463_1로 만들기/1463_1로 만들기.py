# N을 입력받으세요
N = int(input())

# dp를 수행할 배열을 만드세요
# dp[0] = 0 (사용 안함)
# dp[1] = 0 : 초기값
dp = [0 for _ in range(N+1)]

# dp를 수행하세요
for i in range(2, N+1):
    dp[i] = dp[i-1] + 1
    if (i%3 == 0):
        dp[i] = min(dp[i], dp[i//3]+1)
    if (i%2 == 0):
        dp[i] = min(dp[i], dp[i//2]+1)

# 연산을 사용하는 횟수의 최솟값을 출력하세요
print(dp[-1])