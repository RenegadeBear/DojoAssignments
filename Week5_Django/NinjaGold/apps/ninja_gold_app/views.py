from django.shortcuts import render, redirect, HttpResponse
from random import randint
from datetime import datetime

# Create your views here.

def index(request):
    if('yourGold' not in request.session):
        request.session['yourGold'] = 0
    if ('activity' not in request.session):
        request.session['activity'] = []
    # activity_list = request.session['activity']
    return render(request, "ninja_gold_app/index.html")

def process_money(request):
    print(request.POST)
    request.session['timestamp'] = datetime.now().strftime('%Y/%m/%d %H:%M')
    if request.POST['place'] == 'farm':
        request.session['place'] = 'farm'
        request.session['earnings'] = randint(10,20)
        request.session['msg'] = '<p style = "color:green;">Earned '+ str(request.session['earnings']) +' golds from the '+ request.session ['place']+'!'+ request.session["timestamp"]+'</p>'
        request.session['activity'].append(request.session['msg'])
        request.session['yourGold'] += request.session['earnings']
    elif request.POST['place'] == 'cave':
        request.session['place'] = 'cave'
        request.session['earnings'] = randint(5,10)
        request.session['msg'] = '<p style = "color:green;">Earned '+ str(request.session['earnings']) +' golds from the '+ request.session ['place']+'!'+ request.session["timestamp"]+'</p>'
        request.session['activity'].append(request.session['msg'])
        request.session['yourGold'] += request.session['earnings']
    elif request.POST['place'] == 'house':
        request.session['place'] = 'house'
        request.session['earnings'] = randint(2,5)
        request.session['msg'] = '<p style = "color:green;">Earned '+ str(request.session['earnings']) +' golds from the '+ request.session ['place']+'!'+ request.session["timestamp"]+'</p>'
        request.session['activity'].append(request.session['msg'])
        request.session['yourGold'] += request.session['earnings'] 
    elif request.POST['place'] == 'casino':
        request.session['place'] = 'casino'
        if request.session['yourGold'] < 50:
            print ("You don't have enough money to go to the Casino!")
        request.session['earnings'] = randint(0,50)
        request.session['win'] = randint(0,1)
        if request.session['win'] == 0:
            request.session['earnings'] *= -1
            request.session['msg'] = '<p style = "color:red;">Entered a casino and lost '+ str(request.session['earnings']) +' golds... Ouch!  ('+ request.session["timestamp"]+')</p>'
            request.session['activity'].append(request.session['msg'])
            request.session['yourGold'] += request.session['earnings']
        elif request.session['win'] != 0:
            request.session['msg'] = '<p style = "color:green;">Earned '+ str(request.session['earnings']) +' golds from the '+ request.session ['place']+'!  ('+ request.session["timestamp"]+')</p>'
            request.session['activity'].append(request.session['msg'])
            request.session['yourGold'] += request.session['earnings']
    return redirect('/index')

def reset(request):
    request.session.clear()
    return redirect('/')