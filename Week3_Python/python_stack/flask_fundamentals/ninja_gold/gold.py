from flask import Flask, render_template, redirect, request, session
from random import randint
from datetime import datetime

app = Flask(__name__)

app.secret_key = "topSecret"


@app.route("/")
def home():
	if 'yourGold' not in session:
		session['yourGold'] = 0
		yourGold = int(session['yourGold'])
		print (yourGold)
	if 'activity' not in session:
		session['activity'] = []
	return render_template("ninjamoney.html")


@app.route("/process_money",methods=["POST"])
def process_money():
	yourGold = int(session['yourGold'])
	print (request.form)
	print (yourGold)
	when = datetime.now().strftime('%Y-%m-%d,%H-%M')
	print (when)
	if request.form['place'] == "farm":
		earnings = randint(10,20)
		msg = ("Earned {} golds from the {}!".format(earnings,request.form['place']), when)
		session['activity'].append(msg)
	elif request.form['place'] == "cave":
		earnings = randint(5,10)
		msg = ("Earned {} golds from the {}!".format(earnings,request.form['place']), when)
		session['activity'].append(msg)	
	elif request.form['place'] == "house":
		earnings = randint(2,5)
		msg = ("Earned {} golds from the {}!".format(earnings,request.form['place']), when)
		session['activity'].append(msg)
	elif request.form['place'] == "casino":
		earnings = randint(0,50)
		win = randint(0,1)
		if win == 0:
			earnings *= -1
			msg = ("Entered a {} and lost {} golds... Ouch!!".format(request.form['place'],earnings), when)
			session['activity'].append(msg)
		elif win == 1:
			earnings *= 1
			msg = ("Earned {} golds from the {}!".format(earnings,request.form['place']), when)
			session['activity'].append(msg)
	else:
		print ("words")

	print (earnings)
	yourGold += earnings
	session['yourGold'] = yourGold
	print (yourGold)
	print (session['yourGold'])
	return redirect('/')

app.run (debug=True)


