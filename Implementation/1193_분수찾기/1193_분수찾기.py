X = int(input())

Sum = 0
i = 0

while X > Sum:
    i += 1
    Sum = Sum + i
    

group_num = i
at_count = i-Sum+X

if group_num % 2 == 0:
    numerator = at_count
    denominator = group_num + 1 - numerator
else:
    denominator = at_count
    numerator = group_num + 1 - denominator

print(str(numerator)+'/'+str(denominator))
