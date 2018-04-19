from django.db import models

# Create your models here.

class Dojos(models.Model):
    name = models.CharField(max_length=255)
    city = models.CharField(max_length=255)
    state = models.CharField(max_length=2)
    desc = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    def __repr__(self):
        return "Dojos object({}) {}, {}, {}: {}>".format(self.id, self.name, self.city, self.state, self.desc)


class Ninjas(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    dojo = models.ForeignKey(Dojos, related_name="dojo", on_delete=models.CASCADE,)
    def __repr__(self):
        return "Ninjas object({}) {} {} - {}>".format(self.id, self.first_name, self.last_name, self.dojo)