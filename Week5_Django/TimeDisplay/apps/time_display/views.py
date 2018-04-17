from django.shortcuts import render, HttpResponse, redirect
from time import gmtime, strftime, localtime

# Create your views here.

def index(request):
    context = {
    "time": strftime("%b %d, %Y %I:%M %p", localtime())
    }
    return render(request, "time_display/index.html", context)


