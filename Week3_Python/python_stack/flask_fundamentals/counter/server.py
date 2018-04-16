from flask import Flask, render_template, redirect, request, session

app = Flask(__name__)

app.secret_key = 'countSecret'
global counter
counter = 0

@app.route("/")
def root():
	global counter
	counter += 1
	return render_template("root.html", counter=counter)

@app.route("/plusTwo", methods=["POST"])
def plusTwo():
	session['data'] = request.form
	print (session['data'].values)
	global counter
	for incr in session['data'].values():
		if incr == 'twoMore':
			counter +=2
			print (counter)
	return render_template("root.html", counter=counter)

@app.route("/reset", methods=["POST"])
def reset():
	session['data'] = request.form
	print (session['data'].values)
	global counter
	for incr in (session['data'].values()):
		if incr == 'backToZero':
			counter = 1
			print (counter)
	return render_template("root.html", counter=counter)

app.run(debug=True)
