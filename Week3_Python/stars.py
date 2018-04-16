
x = [4, 6, 1, 3, 5, 7, 25]

def draw_stars():

	for i in range(len(x)):
		row = ""
		# print x[i]
		if x[i] > 0:
			for z in range (0, x[i]):
				row += "*"
			x[i]-1
		print row

draw_stars()

y = [4, "Tom", 1, "Michael", 5, 7, "Jimmy Smith"]

def draw_starsMod():

	for i in range(len(y)):
		row = ""
		tic = 0
		# print y[i]
		if type(y[i]) == int and y[i] > 0:
			for z in range (0, y[i]):
				row += "*"
			y[i]-1
		elif type(y[i]) == str:
			tic = len(y[i])
			for w in range (0,tic):
				# print y[i][0]
				row += (y[i][0]).lower()
		print row

draw_starsMod()