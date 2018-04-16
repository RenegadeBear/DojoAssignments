"""
class Student(object):
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.numberOfBelts = 0
    def addBelt(self):
        self.numberOfBelts += 1
        return self
    def say(self, thing):
        print self.name, "says", thing
        return self

student1 = Student("Hasan", "hasan_is_beastly@gmail.com")
student1.say("tacocat of phi")
print student1

student2 = Student("Inti", "inti@gmail.com")
student2.say("pushups now!")
print student2

student2.addBelt().addBelt()
print student2.numberOfBelts

student1.numberOfBelts = "20 billion"
print student1.numberOfBelts
"""

"""
class Person(object):
    def __init__(self, name, email):
        self.name = name
        self.email = email
        print "I am coming the Person class!"
    def say(self, thing):
        print self.name, "says", thing

class Student(Person):
    def __init__(self, name, email, phone):
        super(Student, self).__init__(name, email)
        self.phone = phone
        self.numberOfBelts = 0
        print "I am coming from the Student class"
    def addBelt(self):
        self.numberOfBelts += 1
        return self
    def show(self):
        print self.name, "has", self.numberOfBelts, "belt(s)"
        return self
    def say(self, thing):
        super(Student, self).say(thing)
        print "Something else"

tim = Person("Tim", "tchen@codingdojo.com")
tim.say("I don't know")
# print tim.phone

rachel = Student("Rachel", "rachel@gmail.com", "1234567")
rachel.say("UFO Tofu")
print rachel.name, rachel.email, rachel.numberOfBelts, rachel.phone
"""

"""
from datetime import datetime
print datetime.now()
print datetime.now().strftime("%m/%d/%Y")

from random import random, randrange
print random()
print randrange(1,11)
"""

def testingArgs(*args):
    print args
    for arg in args:
        print arg

testingArgs("hello", 2, False)

def testingKwargs(**kwargs):
    print kwargs
    for kw in kwargs:
        print kw, kwargs[kw]

testingKwargs(color="red", number=6, price="$5.99")