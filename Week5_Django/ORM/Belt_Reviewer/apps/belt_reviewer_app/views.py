from django.shortcuts import render, redirect
from .models import Users, Books, Authors, Reviews
from django.contrib import messages
from django.db.models import Count

# Create your views here.
def index(req):
    return render(req, "belt_reviewer_app/index.html")

def register(req):
    check = Users.objects.register(
        req.POST["first_name"],
        req.POST["last_name"],
        req.POST["username"],
        req.POST["email"],
        req.POST["password"],
        req.POST["confirm"]
    )
    if not check["valid"]:
        for error in check["errors"]:
            messages.add_message(req, messages.ERROR, error)
        return redirect("/")
    else:
        req.session['user_id'] = check["user"].id
        messages.add_message(req, messages.SUCCESS, "Welcome to Book Reviews, {}".format(req.POST["username"]))
        return redirect("/books")

def login(req):
    check = Users.objects.login(
        req.POST["email"],
        req.POST["password"]
    )

    if not check["valid"]:
        for error in check["errors"]:
            messages.add_message(req, messages.ERROR, error)
        return redirect("/")
    else:
        req.session["user_id"] = check["user"].id
        req.session['status'] = "logged_in"
        # messages.add_message(req, messages.SUCCESS, "Welcome back, {}".format(check["user"].username))
        return redirect("/books")
    

def books(req):
    user = Users.objects.get(id=req.session["user_id"])
    user_reviews = Reviews.objects.filter(rated_by=req.session["user_id"])
    other_reviews = Reviews.objects.all().exclude(rated_by=req.session["user_id"])
    # .values("of_book").annotate(dcount=Count('of_book'))
    data = {
        "user": user,
        "user_reviews": user_reviews,
        "other_reviews": other_reviews
    }
    return render(req, "belt_reviewer_app/books.html", data)

def add(req):
    return render(req, "belt_reviewer_app/add.html", {"authors": Authors.objects.all()})

def add_review(req):
    print (req.POST)
    check_author1 = req.POST["new_author"]
    if len(req.POST['new_author']) > 0:
        check_author = Authors.objects.add_author(
            req.POST["new_author"]
        )
        req.session["author"]=Authors.objects.last().id
    else:
        req.session["author"]=req.POST["author"]
    req.session["user_id"] = int(req.session["user_id"])
    print (req.session["author"], req.session["user_id"])
    
    check_book = Books.objects.add_book(
        req.POST["title"],
        req.session["author"],
        req.session["user_id"]
     )
    print (check_book)
    req.session["book"]=Books.objects.last().id
    return redirect('/add')
    check_review = Reviews.objects.add_review(
        req.session["book"],
        req.POST["rating"],
        req.POST["review"],
        req.session["user_id"],
    )
    print (check_review)

    return redirect('/show')

def show(req, id):
    book = Books.objects.get(id=id)
    book_reviews = Reviews.objects.filter(of_book_id=id)
    user = int(req.session['user_id'])
    data = {
        "book":book,
        "book_reviews":book_reviews,
        "user": user,
    }
    return render(req, "belt_reviewer_app/show.html", data)

def profile(req, id):
    user = Users.objects.get(id=id)
    user_reviews = Reviews.objects.filter(rated_by=req.session["user_id"])
    books_reviewed = Reviews.objects.filter(rated_by=req.session["user_id"]).count()
    print (books_reviewed)
    data = {
        "user": user,
        "user_reviews": user_reviews,
        "books_reviewed": books_reviewed
    }
    return render(req, "belt_reviewer_app/profile.html", data)

def logout(req):
    req.session.clear()
    return redirect('/')
