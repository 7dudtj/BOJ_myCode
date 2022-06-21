# T를 받으세요
T = int(input())

# T회 반복
for i in range(T):
    # stack list를 선언하고 입력 한 줄을 받으세요
    stack = []
    ps = input()
    
    # 입력에 대한 연산
    for item in ps:
        # stack이 비지 않았을때
        if stack:
            # item: "("
            if item =='(':
                stack.append(item)
            # item: ")"
            else:
                if stack[-1]=='(':
                    stack.pop()
                else:
                    stack.append(item)
        # stack이 비었을때
        else:
            stack.append(item)

    # 한 줄에 대한 결과 출력
    if stack:
        print("NO")
    else:
        print("YES")