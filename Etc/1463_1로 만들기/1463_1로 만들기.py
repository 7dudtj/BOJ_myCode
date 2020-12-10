import sys

N = int(input())

q = []
dist = 0

q.append([N,dist])

while len(q) != 0:
    for i in range(len(q)):
        if q[i][1] == dist:
            if q[i][0]%3 == 0:
                s1 = [q[i][0]/3,dist+1]
                q.append(s1)
            if q[i][0]%2 == 0:
                s2 = [q[i][0]/2,dist+1]
                q.append(s2)
            s3 = [q[i][0]-1,dist+1]
            q.append(s3)
        else:
            None
    dist += 1          
    for j in range(len(q)):
        if q[j][0] == 1:
            print(q[j][1])
            sys.exit()
        else:
            None
    for k in range(len(q)):
        if q[k][1] == dist:
            a = k
            break
        else:
            None
    q = q[k:]
