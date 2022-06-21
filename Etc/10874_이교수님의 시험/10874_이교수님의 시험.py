N = int(input())
Answer = []

for i in range(N):
    answer = input()
    if answer == '1 2 3 4 5 1 2 3 4 5':
        Answer.append(i+1)
    else:
        None

for j in range(len(Answer)):
    print(Answer[j])
