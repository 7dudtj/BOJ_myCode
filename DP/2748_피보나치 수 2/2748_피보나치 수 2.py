# n을 입력받으세요
n = int(input())

# dp를 수행할 배열을 만드세요
dp = [0 for _ in range(n+1)]

# 초기값을 설정해주세요
# Hint: dp[0] = 0, dp[1] = 1
dp[1] = 1

# dp를 수행하세요
for i in range(2, n+1):
    dp[i] = dp[i-1] + dp[i-2]

# n번째 피보나치 수를 출력하세요
print(dp[-1])