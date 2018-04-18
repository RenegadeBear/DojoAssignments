from django.shortcuts import render, redirect, HttpResponse
from time import strftime, localtime

# Create your views here.
def index(request):
    if ('activity' not in request.session):
        request.session['activity'] = []
    return render(request, 'session_words_app/index.html')

def add_word(request):
    print(request.POST)
    request.session['message']=request.POST['new_word']
    if ('color' not in request.POST):
        request.session['fontcolor'] = 'black'
    elif (request.POST['color'] == 'red'):
        request.session['fontcolor'] = 'red'
    elif (request.POST['color'] == 'blue'):
        request.session['fontcolor'] = 'blue'
    elif (request.POST['color'] == 'green'):
        request.session['fontcolor'] = 'green'

    
    if ('checkbox' in request.POST):
        request.session['fontsize'] = '24px'
    else:
        request.session['fontsize'] = '16px'
    # print (request.session['fontsize'])
    request.session['timestamp']=strftime("%I:%M %p %b %d, %Y", localtime())
    request.session.modified = True
    request.session['msg']='<p style="font-size:'+request.session['fontsize']+'; color: '+request.session['fontcolor']+';">'+request.session['message']+'</p><p>- added on '+request.session['timestamp']+'</p>'
    request.session['activity'].append(request.session['msg'])
    return redirect('/')

def clear(request):
    request.session.clear()
    return redirect('/')
