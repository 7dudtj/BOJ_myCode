self = [1]*11000

for i in range(1,10):
    self[2*i-1] = 0
for j in range(10,100):
    self[j+int(str(j)[0])+int(str(j)[1])-1] = 0
for k in range(100,1000):
    self[k+int(str(k)[0])+int(str(k)[1])+int(str(k)[2])-1] = 0
for  m in range(1000,10000):
    self[m+int(str(m)[0])+int(str(m)[1])+int(str(m)[2])+int(str(m)[3])-1] = 0

for n in range(10000):
    if self[n] == 1:
        print(n+1)
