# 빠르게 입력 받기
import sys
input = sys.stdin.readline

# N을 입력받으세요
N = int(input())

# stack list를 생성하세요
stack = []

# N개의 입력을 받아 처리하세요
for _ in range(N):
    # 막대의 높이를 받으세요
    bar = int(input())

    # 스택을 활용하세요
    while stack and stack[-1] <= bar:
        stack.pop()
    stack.append(bar)

# 스택에 남아있는 막대의 수를 출력하세요
print(len(stack))