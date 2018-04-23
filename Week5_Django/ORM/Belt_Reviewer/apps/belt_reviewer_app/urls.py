from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('books', views.books),
    path('register', views.register),
    path('login', views.login),
    path('add', views.add),
    path('add_review', views.add_review),
    path('show/<id>', views.show),
    path('profile/<id>', views.profile),
    path('logout', views.logout),
]