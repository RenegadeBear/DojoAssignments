z = [19,2,54,-2,7,12,98,32,10,-3,6]
newz = []
count = 0
z.sort()
print (z)
while count <= len(z)/2+1:
    newz.append(z[0])
    z.pop(0)
    count +=1
print (z)
print (newz)
z.insert(0,newz)
print (z)

