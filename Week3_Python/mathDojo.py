class MathDojo(object):
	sumof = 0
	def __init__(self):
		self.sumof = 0
	def add(self,*args):
		for i in range(len(args)):
			if (type(args[i]) == list):
				for x in range(len(args[i])):
					self.sumof += args[i][x]
			elif (type(args[i]) == int):
				self.sumof += args[i]
			elif (type(args[i]) == tuple):
				tuplist = list(args[i])
				# print (tuplist, type(tuplist))
				for z in range(len(tuplist)):
					self.sumof += tuplist[z]
				#don't go down the map rabbit hole!! converts to type map, which has to be converted back.. just create a list and sum the list as above^
				# newlist = map(sum, args[i])
				# print (newlist)
				# print (type(newlist))
				# newlist = str(newlist)
				# print (newlist, type(newlist))
				# value = int(newlist)
				# print (value)
				# for x in range(len(newlist)):
				# self.sumof += map(sum, args[i])
		return self
	def subtract(self, *args):
		for i in range(len(args)):
			if (type(args[i]) == list):	
				for x in range(len(args[i])):
					self.sumof -= args[i][x]
			elif (type(args[i]) == int):
				self.sumof -= args[i]
			elif (type(args[i]) == tuple):
				tuplist = list(args[i])
				for z in range(len(tuplist)):
					self.sumof -= tuplist[z]
		return self 
	def result(self):
		print (self.sumof)
		self.sumof = 0
		return self

md = MathDojo()

md.add(2).add(2,5).subtract(3,2).result()
# print(md.sumof)

# md1 = MathDojo()

md.add([1], 3,4).add([3,5,7,8], [2,4.3,1.25]).subtract(2, [2,3], [1.1,2.3]).result()
# print (md1.sumof)

md.add((1,2),3).subtract((4,7),2).add(100,[75,25]).result()





