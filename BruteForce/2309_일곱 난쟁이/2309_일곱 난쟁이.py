# 아홉 난쟁이의 키를 받아서 리스트에 저장하세요
dwarf = []
for _ in range(9):
    height = int(input())
    dwarf.append(height)

# 아홉 난쟁이의 키의 합을 구하세요
sumOfHeight = 0
for i in range(9):
    sumOfHeight += dwarf[i]

# 가짜 난쟁이 2명을 찾아주세요
oneIdx = -1
twoIdx = -1
for i in range(0, 8):
    for j in range(1, 9):
        # 가짜 난쟁이 2명을 찾은 경우
        if (dwarf[i]+dwarf[j] == sumOfHeight-100):
            # 두 난쟁이의 위치를 저장해주세요
            oneIdx = i
            twoIdx = j

# 가짜 난쟁이의 키를 리스트에서 0으로 만들어주세요
dwarf[oneIdx] = 0
dwarf[twoIdx] = 0

# 난쟁이의 키를 오름차순으로 정렬해주세요
dwarf.sort()

# 진짜 난쟁이 7명의 키를 출력해주세요
for i in range(2, 9):
    print(dwarf[i])
