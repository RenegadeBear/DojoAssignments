from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('add_word', views.add_word),
    path('clear', views.clear),
]