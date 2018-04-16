sI = 45
mI = 100
bI = 455
eI = 0
spI = -23
sS = "Rubber baby buggy bumpers"
mS = "Experience is simply the name we give our mistakes"
bS = "Tell me and I forget. Teach me and I remember. Involve me and I learn."
eS = ""
aL = [1,7,4,21]
mL = [3,5,7,34,3,2,113,65,8,89]
lL = [4,34,22,68,9,13,3,5,7,9,2,12,45,923]
eL = []
spL = ['name','address','phone number','social security number']

#Integer
# def bigNumber(given):
# 	if given >=100:
# 		print "That's a big number"
# 	elif given < 100:
# 		print "That's a small number"

# #String
# def sentLength(given):
# 	if len(given) >= 50:
# 		print "Long sentence."
# 	elif len(given) < 50:
# 		print "Short sentence."

# #List
# def listSize(given):
# 	if len(given)>=10:
# 		print "Big list!"
# 	elif len(given)<10:
# 		print "Short list."

# bigNumber(sI)
# bigNumber(mI)
# bigNumber(bI)
# bigNumber(eI)
# bigNumber(spI)
# sentLength(sS)
# sentLength(mS)
# sentLength(bS)
# sentLength(eS)
# listSize(aL)
# listSize(mL)
# listSize(lL)
# listSize(eL)
# listSize(spL)


def typeFilter(given):
	if type(given) == int:
		if given >=100:
			print ("That's a big number")
		elif given < 100:
			print ("That's a small number")
	elif type(given) == str:
		if len(given) >= 50:
			print ("Long sentence.")
		elif len(given) < 50:
			print ("Short sentence.")
	elif type(given) == list:
		if len(given)>=10:
			print ("Big list!")
		elif len(given)<10:
			print ("Short list.")

typeFilter(sI)
typeFilter(mI)
typeFilter(bI)
typeFilter(eI)
typeFilter(spI)
typeFilter(sS)
typeFilter(mS)
typeFilter(bS)
typeFilter(eS)
typeFilter(aL)
typeFilter(mL)
typeFilter(lL)
typeFilter(eL)
typeFilter(spL)