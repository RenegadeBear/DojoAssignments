from random import *

def coinToss():
	heads = 0
	tails = 0
	for idx in range(0,5000):
		flip = random()
		# print flip

		chance = ""
		if round(flip) == 0:
			heads +=1
			chance = "head"
		elif round(flip) == 1:
			tails +=1
			chance = "tail"
		print "Attempt #"+str(idx+1)+" Throwing a coin... It's a "+chance+"! ... Got "+str(heads)+" head(s) so far and "+str(tails)+" tail(s) so far"
	print "Ending the program, thank you!"
coinToss()