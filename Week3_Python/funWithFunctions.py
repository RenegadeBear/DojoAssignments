
def oddEven(start, finish):
	for i in range(start,finish+1):
		print "Number is", i,"."
		if i % 2 != 0:
			print "This is an odd number."
		elif i % 2 == 0:
			print "This is an even number."

# oddEven(1,2000)


a = [2,4,10,16]
b=[]
def multiply(a,multi):
	for i in range(len(a)):
		b.append(a[i] * multi)
	print a
	print b

multiply(a,5)

# def layered_multiples(arr):
# 	new_array = []
# 	for i in range(len())

# x = layered_multiples(multiply([2,4,5],3))

# print x

