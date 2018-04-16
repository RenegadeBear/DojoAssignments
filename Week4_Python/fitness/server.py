from flask import Flask, render_template, redirect, request
from mysqlconnection import MySQLConnector

app = Flask(__name__)

mysql = MySQLConnector(app, 'fitnessdb')

@app.route("/")
def index(): 
	return render_template('index.html', activities = mysql.query_db('SELECT * FROM fitness_activity'))

@app.route('/activity', methods=['POST'])
def activity():
	mysql.query_db('INSERT INTO fitness_activity(activities) VALUES ("{}")'.format(request.form['activities']))
	return redirect('/')

@app.route('/activity/<id>/edit')
def edit(id):
	activity = mysql.query_db('SELECT * FROM fitness_activity where id = {}'.format (id))
	activities = mysql.query_db('SELECT * FROM fitness_activity')
	print activity[0]
	return render_template('edit.html', activity=activity[0], activities=activities)

@app.route('/activity/<id>/update', methods=['POST'])
def update(id):
	query ="UPDATE fitness_activity SET activities='{}' WHERE id='{}'".format(request.form['activities'],id)
	mysql.query_db(query)
	return redirect('/')

@app.route("/activity/<id>/delete", methods=['POST'])
def delete(id):
	query ="DELETE FROM fitness_activity WHERE `id`='{}';".format(id)
	mysql.query_db(query)
	return redirect('/')
	

app.run(debug=True)