from django.shortcuts import render, redirect

# Create your views here.
def index(request):
    if ('item_count' not in request.session):
        request.session['item_count'] = 0
        print (request.session['item_count'])
    if ('total_purchase' not in request.session):
        request.session['total_purchase'] = 0
        print (request.session['total_purchase'])
    return render(request, "amadon_app/index.html")

def buy(request):
    print (request.POST)
    request.session['product_id'] = request.POST['product_id']
    print (request.session['product_id'])
    request.session['quantity'] = int(request.POST['quantity'])
    print (request.session['quantity'])
    if request.session['product_id'] == '1111':
        request.session['sale_amount'] = round(request.session['quantity'] * 19.99,2)
    elif request.session['product_id'] == '2222':
        request.session['sale_amount'] = round(request.session['quantity'] * 29.99,2)
    elif request.session['product_id'] == '3333':
        request.session['sale_amount'] = round(request.session['quantity'] * 4.99,2)
    elif request.session['product_id'] == '4444':
        request.session['sale_amount'] = round(request.session['quantity'] * 49.99,2)
    request.session['item_count'] += (request.session['quantity'])
    request.session['total_purchase'] += round(request.session['sale_amount'],2)
    return redirect('amadon/checkout')

def checkout(request):
    return render(request, "amadon_app/checkout.html")

def back(request):
    return redirect('/')

def reset(request):
    request.session.clear()
    return redirect('/')
