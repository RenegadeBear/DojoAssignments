# students = [
#      {'first_name':  'Michael', 'last_name' : 'Jordan'},
#      {'first_name' : 'John', 'last_name' : 'Rosales'},
#      {'first_name' : 'Mark', 'last_name' : 'Guillen'},
#      {'first_name' : 'KB', 'last_name' : 'Tonel'}
# ]

# def studentList():
# 	for idx in range(len(students)):
# 		print ((students[idx]["first_name"])+" "+(students[idx]["last_name"]))

# studentList()

# users = {
#  'Students': [
#      {'first_name':  'Michael', 'last_name' : 'Jordan'},
#      {'first_name' : 'John', 'last_name' : 'Rosales'},
#      {'first_name' : 'Mark', 'last_name' : 'Guillen'},
#      {'first_name' : 'KB', 'last_name' : 'Tonel'}
#   ],
#  'Instructors': [
#      {'first_name' : 'Michael', 'last_name' : 'Choi'},
#      {'first_name' : 'Martin', 'last_name' : 'Puryear'}
#   ]
#  }

# def userList():
#  	for idx in range(len(users)):
#  		newrow = ""
#  		newrow += idx+1 + " - "+(users[idx[seq]])
#  		print (newrow)

# userList()


class User(object):
	name = "Anna"
anna = User()
print ("anna's name: ", anna.name)
User.name = "Bob"
print ("anna's name after change:", anna.name)
bob = User()
print ("bob's name:", bob.name)