from flask import Flask, render_template, redirect, request

app = Flask(__name__)
app.secret_key = "Jonathan is awesome!"

MYLIST = [
		{"id": 0, "name": "Leonardo", "color": "blue"},
		{"id": 1, "name": "Michelangelo", "color": "orange"},
		{"id": 2, "name": "Raphael", "color": "red"},
		{"id": 3, "name": "Donatello", "color": "purple"}
	]

@app.route("/")
def default():
	return render_template("default.html")

@app.route("/ninjas")
def ninjas():
	return render_template("ninjas.html")

@app.route("/ninjas/<color>")
def color(color):
	return render_template("color.html",color=color)
		
app.run(debug=True)