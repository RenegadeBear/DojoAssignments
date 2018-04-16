class animal(object):
	def __init__(self,name, health):
		self.name = name
		self.health = health
	def walk(self):
		self.health -= 1
		return self
	def run(self):
		self.health -=5
		return self
	def displayHealth(self):
		print (self.health)
		return self
class dog(animal):
	def __init__(self, name, health):
		super(dog, self).__init__(name, health)
		self.health = 150
	def pet(self):
		self.health += 5
		return self
class dragon(animal):
	def __init__(self, name, health):
		super(dragon, self).__init__(name, health)
		self.health = 170
	def fly(self):
		self.health -= 10
		return self
	def displayHealth(self):
		super(dragon,self).displayHealth()
		print ("I am a Dragon")
		return self
class walrus(animal):
	def __init__(self, name, health):
		super(walrus, self).__init__(name, health)
		self.health = 120
	def swim(self):
		self.health -=3
		return self

animus = animal("animus", 100)

animus.walk().walk().walk().run().run().displayHealth()

doggo = dog("doggo", 1)

doggo.walk().walk().walk().run().run().pet().displayHealth()

drogon = dragon("drogon", 0)

drogon.fly().run().fly().displayHealth()

wally = walrus("wally", 25)

wally.swim().displayHealth()

# doggo.fly()
# wally.fly()
# wally.pet()