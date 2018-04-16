from django.shortcuts import render, HttpResponse, redirect

# Create your views here.

def index(request):
    response = "blog, blog, blog"
    return HttpResponse(response)

def new(request):
    response = "future blog + future blog"
    return HttpResponse(response)

def create(request):
    return redirect("/")

def show(request, number):
    response = "Placeholder to display blog " + number +"."
    return HttpResponse(response)

def edit(request, number):
    response = "Placeholder to edit blog " + number +"."
    return HttpResponse(response)

def destroy(request, number):
    response = "hello???"
    return redirect ('/')