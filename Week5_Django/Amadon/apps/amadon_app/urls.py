from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('amadon/buy', views.buy),
    path('amadon/amadon/checkout', views.checkout),
    path('back', views.back),
    path('reset', views.reset),
]