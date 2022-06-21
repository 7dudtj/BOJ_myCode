x, y = map(int,input().split())
a = 0
if x == 1:
    a = a + 0
elif x == 2:
    a = a + 31
elif x == 3:
    a = a + 59
elif x == 4:
    a = a + 90
elif x == 5:
    a = a + 120
elif x == 6:
    a = a + 151
elif x == 7:
    a = a + 181
elif x == 8:
    a = a + 212
elif x == 9:
    a = a + 243
elif x == 10:
    a = a + 273
elif x == 11:
    a = a + 304
elif x == 12:
    a = a + 334
A = a + y - 1

if A%7 == 0:
    print('MON')
elif A%7 == 1:
    print('TUE')
elif A%7 == 2:
    print('WED')
elif A%7 == 3:
    print('THU')
elif A%7 == 4:
    print('FRI')
elif A%7 == 5:
    print('SAT')
elif A%7 == 6:
    print('SUN')
