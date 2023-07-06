T = int(input())

for i in range(T):
    A = input()
    if len(A)%2 == 0:
        word1 = ''
        for j in range(0,len(A),2):
            word1 = word1 + str(A[j])
        print(word1)    
        word2 = ''
        for k in range(1,len(A),2):
            word2 = word2 + str(A[k])
        print(word2)    
    else:
        if len(A) == 1:
            print(A)
            print(A)
        else:
            word1 = ''
            for m in range(0,len(A),2):
                word1 = word1 + str(A[m])
            for mm in range(1,len(A),2):
                word1 = word1 + str(A[mm])
            print(word1)
            word2 = ''
            for n in range(1,len(A),2):
                word2 = word2 + str(A[n])
            for nn in range(0,len(A),2):
                word2 = word2 + str(A[nn])
            print(word2)