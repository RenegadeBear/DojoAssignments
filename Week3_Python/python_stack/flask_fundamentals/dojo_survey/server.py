from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)
app.secret_key = "Jonathan is awesome!"
@app.route("/")
def home():
  return render_template("home.html")

@app.route("/process", methods=["POST"])
def process():
	session["data"] = request.form
	print (request.form)
	return redirect("/result")

@app.route("/result")
def result():
	return render_template("result.html", data = session["data"])

app.run(debug=True)