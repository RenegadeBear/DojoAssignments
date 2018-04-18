# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import render, redirect

def index (req):
    return render(req, 'survey_app/index.html')

# Create your views here.
def process(req):
    for key in req.POST:
        req.session[key] = req.POST[key]
    # print req.POST
    return redirect('/results')

def results(req):
    return render(req, "survey_app/results.html")