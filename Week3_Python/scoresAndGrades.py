from random import *

def scoresGrades():
	for i in range(0,10):
		score = int(random()*40+60)
		msg = "Score: "+ str(score)+";"
		if score < 70:
			msg+= " Your grade is D."
		elif score <80:
			msg+= " Your grade is C."
		elif score <90:
			msg+= " Your grade is B."
		elif score <=100:
			msg+= " Your grade is A."
		print msg
		i +=1

scoresGrades()