N = int(input())
a = input()
A = a.split()

nums = 0
for i in range(N):
    if A[i] == '1':
        nums = nums
    else:
        count = 0
        for j in range(1,int(A[i])+1):
            if int(A[i])%j == 0:
                count += 1
            else:
                count = count
        if count == 2:
            nums += 1
        else:
            nums = nums
print(nums)    
