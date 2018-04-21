from django.db import models
import re

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9.+_-]+\.[a-zA-Z]+$')
# Create your models here.

class UsersManager(models.Manager):
    def addUser(self, first_name, last_name, email):
        errors= []
        if len(first_name) < 1:
            errors.append("First name is required")
        if len(last_name) < 1:
            errors.append("Last name required")
        if len(email) < 1:
            errors.append("Email is required")
        elif not EMAIL_REGEX.match(email):
            errors.append("Invalid email")
        else:
            exist = Users.objects.filter(email=email)
            if len(exist) > 0:
                errors.append("Email already in use")
        if len(errors) > 0:
            return{"valid": False, "errors": errors}
        
        response = {
            "errors": errors,
            "valid": True,
            "user": None
        }

        if len(errors) > 0:
            response['valid'] = False
            response['errors'] = errors
        else:
            response['user'] = Users.objects.create(
                first_name=first_name,
                last_name=last_name,
                email=email.lower(),
            )
        
        return response

    def editUser(self, id, first_name, last_name, email):
        errors = []
        if len(first_name) < 1:
            errors.append("First name is required")
        if len(last_name) < 1:
            errors.append("Last name required")
        if len(email) < 1:
            errors.append("Email is required")
        elif not EMAIL_REGEX.match(email):
            errors.append("Invalid email")
        else:
            exist = Users.objects.filter(email=email)
            if len(exist) > 0:
                errors.append("Email already in use")
        if len(errors) > 0:
            return{"valid": False, "errors": errors}
        
        response = {
            "errors": errors,
            "valid": True,
            "user": None
        }

        if len(errors) > 0:
            response['valid'] = False
            response['errors'] = errors
        else:
            response['user'] = Users.objects.filter(id=id).update(
                first_name=first_name,
                last_name=last_name,
                email=email.lower(),    
            )
        return response


class Users(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = UsersManager()
    def __repr__(self):
        return "Users Object({}) {} {}>".format(self.id, self.first_name, self.last_name)