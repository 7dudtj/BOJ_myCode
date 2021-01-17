N = input()
Sum = 0

for i in range(len(N)):
    if N[i] == 'A' or N[i] == 'B' or N[i] == 'C':
        Sum = Sum + 3
    elif N[i] == 'D' or N[i] == 'E' or N[i] == 'F':
        Sum = Sum + 4
    elif N[i] == 'G' or N[i] == 'H' or N[i] == 'I':
        Sum = Sum + 5
    elif N[i] == 'J' or N[i] == 'K' or N[i] == 'L':
        Sum = Sum + 6
    elif N[i] == 'M' or N[i] == 'N' or N[i] == 'O':
        Sum = Sum + 7
    elif N[i] == 'P' or N[i] == 'Q' or N[i] == 'R' or N[i] == 'S':
        Sum = Sum + 8
    elif N[i] == 'T' or N[i] == 'U' or N[i] == 'V':
        Sum = Sum + 9
    elif N[i] == 'W' or N[i] == 'X' or N[i] == 'Y' or N[i] == 'Z':
        Sum = Sum + 10


print(Sum)
