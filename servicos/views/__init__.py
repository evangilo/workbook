from django.shortcuts import render_to_response
from django.template.context import RequestContext
from .servico import *
from .categoria import *
from .avaliacao import *


def home(request):
    context = RequestContext(request, {'request': request, 'user': request.user})
    return render_to_response('home.html', context_instance=context)
