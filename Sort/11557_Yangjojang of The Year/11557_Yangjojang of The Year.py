# 테스트케이스의 수를 입력받으세요
T = int(input())

# 테스트케이스를 T번 수행
for _ in range(T):
    # 문제풀이를 위한 데이터 설정
    dic = {}
    max = 0

    # 학교의 수를 입력받으세요
    N = int(input())

    # 학교와 술 소비량 정보를 입력받으세요
    for i in range(N):
        S, L = input().split()

        # 입력받은 정보를 dictionary에 저장하세요
        # Hint: key: L, value: S
        dic[int(L)] = S

    # dictionary에서 key를 기준으로 오름차순 정렬하세요
    sortedDic = sorted(dic.items())

    # 술 소비가 가장 많은 학교의 이름을 출력하세요
    print(sortedDic[-1][1])