list_oneA = [1,2,5,6,2]
list_twoA = [1,2,5,6,2]

list_oneB = [1,2,5,6,5]
list_twoB = [1,2,5,6,5,3]

list_oneC = [1,2,5,6,5,16]
list_twoC = [1,2,5,6,5]

list_oneD = ['celery','carrots','bread','milk']
list_twoD = ['celery','carrots','bread','cream']

def compareLists(list_one,list_two):
	count = 0
	if len(list_one)!=len(list_two):
		print "The lists are not the same."
	elif len(list_one)==len(list_two):
		for i in range(len(list_one)) and range(len(list_two)):
			if(list_one[i])==(list_two[i]):
				count +=1
		if count == len(list_one):
			print "The lists are the same."
		else:
			print "The lists are not the same."	

compareLists(list_oneA, list_twoA)
compareLists(list_oneB, list_twoB)
compareLists(list_oneC, list_twoC)
compareLists(list_oneD, list_twoD)