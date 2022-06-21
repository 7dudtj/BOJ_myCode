# 이분탐색 함수
def doBinarySearch(data, target):
    # left, mid, right 값 초기설정
    mid = 0
    left = 0
    right = len(data)-1

    # 이분탐색 진행
    while (left <= right):
        mid = (left+right)//2

        # 답을 찾은 경우
        if (target == data[mid]):
            return 1
        # target이 data[mid]보다 작은 경우
        if (target < data[mid]):
            right = mid - 1
        # target이 data[mid]보다 큰 경우
        else:
            left = mid + 1
    
    # 답을 찾지 못한 경우
    return 0


# N을 입력받으세요
N = int(input())

# N개의 정수를 입력받아 리스트에 저장해주세요
data = list(map(int, input().split()))

# N개의 정수를 오름차순으로 정렬해주세요
data.sort()

# M을 입력받으세요
M = int(input())

# M개의 정수를 입력받아 리스트에 저장해주세요
query = list(map(int, input().split()))

# M개의 수에 대해서 조사를 진행합니다
# 시간복잡도를 감안하여 전체탐색이 아닌 이분탐색을 합니다
for i in range(M):
    target = query[i] # target: 탐색하고자 하는 값
    answer = doBinarySearch(data, target) # 이분탐색 함수
    print(answer) # 탐색한 값의 존재 여부를 출력합니다