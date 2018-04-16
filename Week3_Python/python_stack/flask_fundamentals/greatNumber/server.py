from flask import Flask, render_template, redirect, request, session
import random

app = Flask(__name__)

app.secret_key = 'superGreat'

@app.route("/")
def home():
	session['myNumber'] = random.randint(0,101)
	print (session['myNumber'])
	return render_template("home.html")

@app.route("/evaluate", methods=["POST"])
def evaluate():
	print (request.form['guess'])
	yourGuess = request.form['guess']
	print (yourGuess)
	if int(yourGuess) == session['myNumber']:
		return render_template('home.html', answer = ""+str(session['myNumber'])+" That's my number!", value = 'equal')
	elif int(yourGuess) > session['myNumber']:
		return render_template('home.html', answer = "Too high!", value = 'high')
	elif int(yourGuess) < session['myNumber']:
		return render_template('home.html', answer = "Too low!", value = 'low')

@app.route("/again", methods=["POST"])
def again():
	return redirect("/")

app.run(debug=True)