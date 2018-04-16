from flask import Flask, render_template, redirect, request, session

app = Flask(__name__)
app.secret_key = "I can't believe this key is so secret"

MYLIST = [
		{"id": 0, "name": "brownies", "price": "$100", "quantity": 3},
		{"id": 1, "name": "rice crispy treats", "price": "$200", "quantity": 5},
		{"id": 2, "name": "Infused Butter", "price": "$50", "quantity": 1},
		{"id": 3, "name": '"discount brownies"', "price": "$1", "quantity": 0},
		{"id": 4, "name": "water", "price": "$1.50", "quantity": 3000},
	]

@app.route("/")
def index():
	return render_template("index.html")

@app.route("/process", methods=["POST"])
def process():
	session["data"] = request.form
	return redirect("/results")
	# return render_template("results.html", data = request.form)

@app.route("/results")
def results():
	return render_template("results.html", data = session["data"])

@app.route("/test")
def test():
	return render_template("test.html", products = MYLIST)

@app.route("/buy/<product_id>")
def buy(product_id):
	print (MYLIST[int(product_id)])
	return redirect("/test")

app.run(debug=True)