import os, binascii # include this at the top of your file
salt = binascii.b2a_hex(os.urandom(15))

@app.route('/users/create', methods=['POST'])
def create_user():
    username = request.form['username']
    email = request.form['email']
    password = request.form['password']
    salt =  binascii.b2a_hex(os.urandom(15))
    hashed_pw = md5.new(password + salt).hexdigest()
    insert_query = "INSERT INTO users (username, email, password, salt, created_at, updated_at)
        VALUES (:username, :email, :hashed_pw, :salt, NOW(), NOW())"
    query_data = { 'username': username, 'email': email, 'hashed_pw': hashed_pw, 'salt': salt}
    mysql.query_db(insert_query, query_data)

@app.route('/users/authenticate', methods=['POST'])
def authenticate():
    email = request.form['email']
    password = request.form['password']
    user_query = "SELECT * FROM users WHERE users.email = :email LIMIT 1"
    query_data = {'email': email}
    user = mysql.query_db(user_query, query_data)
    if len(user) != 0:
    encrypted_password = md5.new(password + user[0]['salt']).hexdigest()
    if user[0]['password'] == encrypted_password:
    # this means we have a successful login!
    else:
        # invalid password!
    else:
    # invalid email!