from django.shortcuts import render, HttpResponse, redirect
from django.utils.crypto import get_random_string

# Create your views here.
def index(request):
    if ('count' not in request.session):
        request.session['count'] = 0
        request.session['randword'] = get_random_string(length=14)
    return render(request, "random_word/index.html")

def submit(request, methods=["POST"]):
    if request.POST['action'] == "generate":
        request.session['count'] += 1
        request.session['randword'] = get_random_string(length=14)
    return redirect('/')

def reset(request, methods=["POST"]):
    if request.POST['action'] == "reset":
        request.session.clear()
    return redirect('/')
