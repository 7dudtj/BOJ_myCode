# N과 K를 받으세요
N, K = map(int,input().split())

# N명의 사람을 담은 배열을 만드세요
arr = [i for i in range(1,N+1)] 

# 제거된 사람을 담는 answer 배열을 만드세요
answer = []

# 제거될 사람의 index를 선언하세요
idx = 0

# N명을 제거하세요
for i in range(N):
    # idx 값을 K-1 늘리세요
    idx += (K-1)

    # idx가 arr 배열 크기를 넘어선 경우
    if idx >= len(arr):
        idx %= len(arr)

    # 한 사람을 제거하세요
    answer.append(str(arr[idx]))
    arr.pop(idx)

# 요세푸스 순열을 출력하세요
print("<",', '.join(answer),">", sep="")