from flask import Flask, render_template, request, redirect, session, flash
from mysqlconnection import MySQLConnector
from flask_bcrypt import Bcrypt

app = Flask(__name__)
app.secret_key = "Secret"
mysql = MySQLConnector(app, 'users')
bcrypt = Bcrypt(app)

@app.route("/")
def main():
    return(render_template('index.html'))

@app.route("/success")
def success():
    return(render_template('/success.html'))

@app.route("/register", methods=['POST'])
def register():
    register_valid = True
    check = (mysql.query_db("SELECT users.email FROM users where users.email= '{}'".format(request.form['E-mail'])))
    if len(request.form['First_Name']) < 2:
        flash("Your first name cannot be blank.")
        register_valid = False
    elif (request.form['First_Name'].isalpha()== False):
        flash("Your first name cannot contain non-alpha characters")
        register_valid = False
    elif len(request.form['Last_Name']) < 2:
        flash("Your last name cannot be blank.")
        register_valid = False
    elif (request.form['Last_Name'].isalpha()== False):
        flash("Your last name cannot contain non-alpha characters")
        register_valid = False
    elif len(request.form['E-mail']) < 6:
        register_valid = False
        flash("Your E-mail is invalid!!")
    elif len(request.form['Password']) < 8:
        flash("Password cannot be less than 8 characters")
        register_valid = False
    elif request.form['Password'] != request.form['confirmation']:
        flash("Passwords do not match.")
        register_valid = False
    elif (len(check) > 0):
        register_valid = False
        flash("This email is associated with an existing account")
    if (register_valid == True):    
        query = "INSERT INTO users (first_name, last_name, email, password, created_at, updated_at) VALUES (:first_name, :last_name, :email, :password, NOW(), NOW())"
        data = {
        'first_name': request.form['First_Name'],
        'last_name': request.form['Last_Name'],
        'email': request.form['E-mail'],
        'password': bcrypt.generate_password_hash(request.form['Password'])
        }
        mysql.query_db(query, data)
        flash("you're in")
        return redirect("/success")
    # flash("you're in")
    # return redirect("/")
    else:
        return redirect("/")

@app.route("/login", methods=['POST'])
def create():
    # hashedpw = bcrypt.generate_password_hash(request.form['Password']
    check = (mysql.query_db("SELECT users.password FROM users where users.email= '{}'".format(request.form['E-mail'])))
    print (check)
    if (len(check) == 0):
        flash("No account found with this email.")
        return redirect("/")
    elif ((bcrypt.check_password_hash(check[0]['password'], request.form['Password'])) == True):
        return redirect("/success")
    # print (bcryptpw)
    else:  
        flash("Incorrect password provided.")
        return redirect("/")

# @app.route("/success")
# def success():
#     return render_template("success.html")

app.run(debug=True)