A, B, C = map(int,input().split())

one = B - A
two = C - B

if one >= two:
    print(one-1)
else:
    print(two-1)
