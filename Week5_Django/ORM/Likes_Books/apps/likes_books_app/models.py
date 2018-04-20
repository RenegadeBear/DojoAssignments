from django.db import models

# Create your models here.
class Users(models.Model):
    first_name=models.CharField(max_length=255)
    last_name=models.CharField(max_length=255)
    email=models.CharField(max_length=255)
    created_at=models.DateTimeField(auto_now_add=True)
    updated_at=models.DateTimeField(auto_now=True)
    def __repr__(self):
        return "Users Object({}) {} {}>".format(self.id, self.first_name, self.last_name)

class Books(models.Model):
    title=models.CharField(max_length=255)
    desc=models.CharField(max_length=255)
    created_at=models.DateTimeField(auto_now_add=True)
    updated_at=models.DateTimeField(auto_now=True)
    uploader=models.ForeignKey(Users, related_name="uploaded_books", on_delete=models.CASCADE)
    liked_users=models.ManyToManyField(Users, related_name="liked_books")
    def __repr__(self):
        return "Books Object({}) {}>".format(self.id, self.title)
