a = input()

while len(a) < 6:
    a = '0'+a


   




if a[0] == 'A':
    num1 = 10*pow(16,5)
elif a[0] == 'B':
    num1 = 11*pow(16,5)
elif a[0] == 'C':
    num1 = 12*pow(16,5)
elif a[0] == 'D':
    num1 = 13*pow(16,5)
elif a[0] == 'E':
    num1 = 14*pow(16,5)
elif a[0] == 'F':
    num1 = 15*pow(16,5)
else:
    num1 = int(a[0])*pow(16,5)


if a[1] == 'A':
    num2 = 10*pow(16,4)
elif a[1] == 'B':
    num2 = 11*pow(16,4)
elif a[1] == 'C':
    num2 = 12*pow(16,4)
elif a[1] == 'D':
    num2 = 13*pow(16,4)
elif a[1] == 'E':
    num2 = 14*pow(16,4)
elif a[1] == 'F':
    num2 = 15*pow(16,4)
else:
    num2 = int(a[1])*pow(16,4)


if a[2] == 'A':
    num3 = 10*pow(16,3)
elif a[2] == 'B':
    num3 = 11*pow(16,3)
elif a[2] == 'C':
    num3 = 12*pow(16,3)
elif a[2] == 'D':
    num3 = 13*pow(16,3)
elif a[2] == 'E':
    num3 = 14*pow(16,3)
elif a[2] == 'F':
    num3 = 15*pow(16,3)
else:
    num3 = int(a[2])*pow(16,3)


if a[3] == 'A':
    num4 = 10*pow(16,2)
elif a[3] == 'B':
    num4 = 11*pow(16,2)
elif a[3] == 'C':
    num4 = 12*pow(16,2)
elif a[3] == 'D':
    num4 = 13*pow(16,2)
elif a[3] == 'E':
    num4 = 14*pow(16,2)
elif a[3] == 'F':
    num4 = 15*pow(16,2)
else:
    num4 = int(a[3])*pow(16,2)
    

if a[4] == 'A':
    num5 = 10*pow(16,1)
elif a[4] == 'B':
    num5 = 11*pow(16,1)
elif a[4] == 'C':
    num5 = 12*pow(16,1)
elif a[4] == 'D':
    num5 = 13*pow(16,1)
elif a[4] == 'E':
    num5 = 14*pow(16,1)
elif a[4] == 'F':
    num5 = 15*pow(16,1)
else:
    num5 = int(a[4])*pow(16,1)


if a[5] == 'A':
    num6 = 10*pow(16,0)
elif a[5] == 'B':
    num6 = 11*pow(16,0)
elif a[5] == 'C':
    num6 = 12*pow(16,0)
elif a[5] == 'D':
    num6 = 13*pow(16,0)
elif a[5] == 'E':
    num6 = 14*pow(16,0)
elif a[5] == 'F':
    num6 = 15*pow(16,0)
else:
    num6 = int(a[5])*pow(16,0)
    
    
ten = num1 + num2 + num3 + num4 + num5 + num6
print(ten)
