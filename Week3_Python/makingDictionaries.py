import itertools

name = ["Anna", "Eli", "Pariece", "Brendan", "Amy", "Shane", "Oscar"]
favorite_animal = ["horse", "cat", "spider", "giraffe", "ticks", "dolphins", "llamas"]

def make_dict(list1, list2):
  new_dict = {name: favorite_animal for name, favorite_animal in zip(name,favorite_animal)}
  # print new_dict
  # your code here
  print (new_dict)


make_dict('name','favorite_animal')