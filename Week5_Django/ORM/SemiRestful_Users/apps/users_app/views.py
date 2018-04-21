from django.shortcuts import render, redirect, HttpResponse
from .models import Users, UsersManager
from django.contrib import messages

# Create your views here.
def index(req):
    return render(req, "users_app/index.html", {"usertable": Users.objects.all()})


def show(req, id):
    return render(req, "users_app/show.html", {"userdata": Users.objects.filter(id=id).first()})

def delete(req, id):
    Users.objects.get(id=id).delete()
    return redirect('/')

def new(req):
    return render(req, "users_app/new.html")

def create(req):
    print (req.POST)
    review = Users.objects.addUser(
        req.POST['first_name'],
        req.POST['last_name'],
        req.POST['email'],
    )
    if not review['valid']:
        for error in review['errors']:
            messages.add_message(req, messages.ERROR, error)
            return redirect('/new')
    else:
        messages.add_message(req, messages.SUCCESS, "User {} {} added successfully".format(req.POST['first_name'],req.POST['last_name']))
        return redirect('/new')

def edit(req, id):
    return render(req, "users_app/edit.html", {"userdata": Users.objects.filter(id=id).first()})

def update(req, id):
    # review = Users.objects.filter(id=id).update(
    #     first_name=req.POST['first_name'],
    #     last_name=req.POST['last_name'],
    #     email=req.POST['email'], 
    # )
    review = Users.objects.editUser(
        id=id,
        first_name=req.POST['first_name'],
        last_name=req.POST['last_name'],
        email=req.POST['email'], 
    )
    if not review['valid']:
        for error in review['errors']:
            messages.add_message(req, messages.ERROR, error)
        return render(req, "users_app/edit.html", {"userdata": Users.objects.filter(id=id).first()})
    else:
        messages.add_message(req, messages.SUCCESS, "User {} {} updated successfully".format(req.POST['first_name'],req.POST['last_name']))
        return render(req, "users_app/edit.html", {"userdata": Users.objects.filter(id=id).first()})

