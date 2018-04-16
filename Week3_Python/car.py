class Car(object):
	def __init__(self,name,price,speed,fuel,mileage):
		self.name = name
		self.price = price
		self.speed = speed
		self.fuel = fuel
		self.mileage = mileage
		# def calcTax(): 
		#thought i needed a function to calculate tax, but i don't! 
		if(self.price > 10000):
			self.tax = 0.15
		elif(self.price <= 10000):
			self.tax = 0.12
		# self.tax = calcTax()
	def display_all(self):
	# 	print ("Name: " + self.name)
	# 	print ("Price: ${}".format(self.price))
	# 	print ("Speed: " + self.speed)
	# 	print ("Fuel: " + self.fuel)
	# 	print ("Mileage:" + self.mileage)
	# 	print ("Tax: {}".format(self.tax))
		print ("Name: " + self.name + "  Price: ${}".format(self.price) + "  Speed: " + self.speed + "  Fuel: " + self.fuel + "  Mileage: " + self.mileage + "  Tax: {}".format(self.tax))
		return self

car1 = Car("car1", 2000, "35mph", "Full", "15mpg")
car2 = Car("car2", 2000, "5mph", "Not Full", "105mpg")
car3 = Car("car3", 2000, "15mph", "Kind of Full", "95mpg")
car4 = Car("car4", 2000, "25mph", "Full", "25pmg")
car5 = Car("car5", 2000, "45mph", "Empty", "25mpg")
car6 = Car("car6", 20000000, "35mph", "Empty", "15mpg")

car1.display_all()
car2.display_all()
car3.display_all()
car4.display_all()
car5.display_all()
car6.display_all()
