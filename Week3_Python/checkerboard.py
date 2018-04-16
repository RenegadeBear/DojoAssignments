
def makeBoard(rows,columns):
	count = 1
	counta =1
	alist = []
	space = " "
	star = "*"
 	while count <= columns/2
 		alist += star
 		count +=1
 	while counta <= rows:
 		if counta %2 != 0:
 			print space+space.join(alist)
 		elif counta %2 == 0:
 			print space.join(alist)
		counta +=1

makeBoard(10,10)
