from hashlib import md5 as _md5
# imports the md5 module to generate a hash
password = 'password'
# encrypt the password we provided as 32 character string
hashed_password = _md5.new(password).hexdigest()
print (hashed_password) 
#this will show you the hashed value
# 5f4dcc3b5aa765d61d8327deb882cf99 -> nice!

@app.route('/users/create', methods=['POST'])
def create_user():
     username = request.form['username']
     email = request.form['email']
     password = md5.new(request.form['password']).hexdigest()
     insert_query = "INSERT INTO users (username, email, password, created_at, updated_at) VALUES (:username,
     :email, :password, NOW(), NOW())"
     query_data = { 'username': username, 'email': email, 'password': password }
     mysql.query_db(insert_query, query_data)


