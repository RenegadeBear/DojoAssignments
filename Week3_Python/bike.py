class Bike(object):
	def __init__(self, name, price, max_speed):
		self.name = name
		self.price = price
		self.max_speed = max_speed
		self.miles = 0
	def displayInfo(self):
		print ("Name: " + self.name)
		print ("Max speed: " + self.max_speed)
		print ("Price: {}".format(self.price))
		print ("Miles: {}".format(self.miles))
		return self
	def ride(self):
		print ("Riding")
		self.miles += 10
		return self
	def reverse(self):
		print ("Reversing")
		if self.miles > 0:
			self.miles -= 5
		return self

bike1 = Bike("bike1", 200, "25mph")
bike2 = Bike("bike2",100, "7mph")
bike3 = Bike("bike3",750, "45mph")

bike1.displayInfo()
bike1.ride().ride().ride().reverse().displayInfo()
bike2.ride().ride().reverse().reverse().displayInfo()
bike3.reverse().reverse().reverse().displayInfo()