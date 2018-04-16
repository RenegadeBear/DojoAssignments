class Product(object):
	def __init__(self,price,item_name,weight,brand):
		self.price = price
		self.item_name = item_name
		self.weight = weight
		self.brand = brand
		self.status = "for sale"
	def sell(self):
		self.status = "sold"
		return self
	def itemReturn(self,reason):
		if (reason == "defective"):
			self.status = "defective"
			self.price = 0
		elif (reason == "unopen"):
			self.status = "for sale"
		elif (reason == "open"):
			self.status = "for sale"
			self.price *= 0.8
		return self
	def displayInfo(self):
		print ("Item name: " + self.item_name)
		print ("Price: {}".format(self.price))
		print ("Weight: " + self.weight)
		print ("Brand: " + self.brand)
		print ("Status: " + self.status)
		return self
	def addTax(self,tax):
		print ("Price with tax=  {}".format(self.price*(1+tax)))
		return self

apple = Product(2,"apple","0.3lb","gala")
banana = Product(1,"banana","1lb","chiquita")
orange = Product(3,"orange","0.75lb","sunkist")

# apple.displayInfo()
# banana.displayInfo()
# orange.displayInfo()

orange.sell().displayInfo().itemReturn('defective').displayInfo()

banana.addTax(0.1).displayInfo().sell().displayInfo().itemReturn('unopen').displayInfo()




