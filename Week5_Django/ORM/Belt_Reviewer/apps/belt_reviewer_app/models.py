from django.db import models
from django.core.validators import MaxValueValidator, MinValueValidator
import re
import bcrypt

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9.+_-]+\.[a-zA-Z]+$')

# Create your models here.
class UsersManager(models.Manager):
    def register(self, first_name, last_name, username, email, password, confirm):
        errors = []
        if len(first_name) < 2:
            errors.append("First name must be 2 characters or more")
        if len(last_name) < 2:
            errors.append("Last name must be 2 characters or more")
        if len(username) < 2:
            errors.append("Username must be 2 characters or more")
        if len(email) < 1:
            errors.append("Email is required")
        elif not EMAIL_REGEX.match(email):
            errors.append("Invalid email")
        else:
            usersMatchingEmail = Users.objects.filter(email=email)
            if len(usersMatchingEmail) > 0:
                errors.append("Email already in use")
        if len(password) < 1:
                errors.append("Password is required")
        elif len(password) < 8:
            errors.append("Password must be 8 characters or more")
        if len(confirm) < 1:
            errors.append("Confirm Password is required")
        elif password != confirm:
            errors.append("Confirm Password must match Password")

        response = {
            "errors": errors,
            "valid": True,
            "user": None 
        }

        if len(errors) > 0:
            response["valid"] = False
            response["errors"] = errors
        else:
            response["user"] = Users.objects.create(
                first_name=first_name,
                last_name=last_name,
                username=username,
                email=email.lower(),
                password=bcrypt.hashpw(password.encode('utf-8'), bcrypt.gensalt()).decode('utf-8'),
            )
        return response

    def login(self, email, password):
        errors = []
        if len(email) < 1:
            errors.append("Email is required")
        elif not EMAIL_REGEX.match(email):
            errors.append("Invalid email")
        else:
            usersMatchingEmail = Users.objects.filter(email=email)
            if len(usersMatchingEmail) == 0:
                errors.append("Unknown email")

        if len(password) < 1:
            errors.append("Password is required")
        elif len(password) < 8:
            errors.append("Password must be 8 characters or more")

        response = {
            "errors": errors,
            "valid": True,
            "user": None 
        }

        if len(errors) == 0:
            if bcrypt.checkpw(password.encode('utf-8'), usersMatchingEmail[0].password.encode()):
                response["user"] = usersMatchingEmail[0]
            else:
                errors.append("Incorrect password")

        if len(errors) > 0:
            response["errors"] = errors
            response["valid"] = False

        return response
        

class Users(models.Model):
    first_name=models.CharField(max_length=255)
    last_name=models.CharField(max_length=255)
    username=models.CharField(max_length=255)
    email=models.CharField(max_length=255)
    password=models.CharField(max_length=255)
    created_at=models.DateTimeField(auto_now_add=True)
    updated_at=models.DateTimeField(auto_now=True)
    objects=UsersManager()
    def __repr__(self):
        return "Users Object({}) {} {}>".format(self.id, self.first_name, self.last_name)

class AuthorsManager(models.Manager):
    def add_author(self, author):
        errors = []
        if len(author) < 2:
            errors.append("Author name must be 2 characters or more")
        response = {
            "errors": errors,
            "valid": True,
            "user": None 
        }
        if len(errors)>0:
            response["errors"]= errors
            response["valid"]= False
        else:
            response["user"] = Authors.objects.create(
                author=author,
            )            
        return response

class Authors(models.Model):
    author=models.CharField(max_length=255)
    created_at=models.DateTimeField(auto_now_add=True)
    updated_at=models.DateTimeField(auto_now=True)
    objects=AuthorsManager()
    def __repr__(self):
        return "Authors Object({}) {}>".format(self.id,self.author)

class BooksManager(models.Manager):
    def add_book(self, title, author, user_id):
        # print (title, work_by, loaded_by)
        errors=[]
        bookMatchingTitle = Books.objects.filter(title=title)
        if len(bookMatchingTitle) > 0:
            errors.append("Book already created, please proceed to add Review.")
        if (errors):
            return {"valid": False, "errors":errors}
        else:
            Books.objects.create(
                title=title,
                work_by_id=author).loaded_by.add(Users.objects.get(id=user_id))
        return {"valid":True, "errors":errors}
         
class Books(models.Model):
    title=models.CharField(max_length=255)
    created_at=models.DateTimeField(auto_now_add=True)
    updated_at=models.DateTimeField(auto_now=True)
    loaded_by=models.ManyToManyField(Users, related_name="loaded_book")
    objects=BooksManager()
    work_by=models.ForeignKey(Authors,on_delete=models.CASCADE, related_name='works')

class ReviewsManager(models.Manager):
    def add_review(self, rating, review, rated_by_id, of_book_id):
        errors=[]
        if len(review) > 1:
            errors.append("Text description of review must be provided.")
        if len(errors >0):
            return {"valid":False, "errors":errors}
        else:
            Review.objects.create(
                rating=rating,
                review=review,
                rated_by_id=user_id,
                of_book_id=book,
            )
            return {"valid":True, "errors":errors}

class Reviews(models.Model):
    rating=models.IntegerField(validators=[MaxValueValidator(5),MinValueValidator(1)])
    review=models.TextField()
    created_at=models.DateTimeField(auto_now_add=True)
    updated_at=models.DateTimeField(auto_now=True)
    objects=ReviewsManager()
    rated_by=models.ForeignKey(Users,on_delete=models.CASCADE,related_name="user_review")
    of_book=models.ForeignKey(Books, on_delete=models.CASCADE,related_name="review_of")
    def __repr__(self):
        return "Reviews Object({}) Rating:{} Book:{} Description:{}".format(self.id, self.rating, self.of_book, self.review)

