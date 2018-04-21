from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('new', views.new),
    path('show/<id>', views.show),
    path('edit/<id>', views.edit),
    path('delete/<id>', views.delete),
    path('create', views.create),
    path('update/<id>',views.update),
]