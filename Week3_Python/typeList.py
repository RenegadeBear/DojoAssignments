#input
l = ['magical unicorns',19,'hello',98.98,'world']
#output
#"The list you entered is of mixed type"
#"String: magical unicorns hello world"
#"Sum: 117.98"

# input
l1 = [2,3,1,7,4,12]
#output
# "The list you entered is of integer type"
# "Sum: 29"

# input
l2 = ['magical','unicorns']
#output
# "The list you entered is of string type"
# "String: magical unicorns"

# def analyzeList(given):
# 	mysum = 0
# 	phrase = ""
# 	for i in range(len(given)-1):
# 		# print type(given[i])
# 		if type(given[i])!=type(given[i+1]):
# 			print "The list you entered is of mixed type."
# 		elif type(given[i])==type(given[i+1]):
# 			print "The list you entered is of", type(given[i]),"."
# 		if type(given[i])== int:
# 			mysum += given[i]
# 		elif type(given[i])==str:
# 			phrase +=(given[i])
# 	print "String:", phrase
# 	print "Sum:", mysum

# analyzeList(l)
# analyzeList(l1)
# analyzeList(l2)

def listAnalysis(given):
	mysum = 0
	phrase = ""
	for i in range(len(given)):
		if type(given[i]) == int:
			mysum += given[i]
		elif type(given[i])== str:
			phrase +=(given[i])
	if mysum == 0:
		print ("The list you entered is of string type.")
	elif phrase == "":
		print ("The list you entered is of integer type.")
	else:
		print ("The list you entered is of mixed type.")
	print ("String:", phrase)
	print ("Sum:", mysum)

listAnalysis(l)
listAnalysis(l1)
listAnalysis(l2)


