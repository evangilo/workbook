# -*- coding: utf-8 -*-
from django.forms.models import modelform_factory
from django.shortcuts import render_to_response
from django.template import RequestContext
from django.http import HttpResponseRedirect
from servicos.models import Categoria

CategoriaForm = modelform_factory(Categoria)


def lista(request):
    categoria = Categoria.objects.all()
    return render_to_response('categoria/lista.html', {'itens': categoria})


def adiciona(request):
    if request.method == 'POST':
        form = CategoriaForm(request.POST, request.FILES)
        if form.is_valid():
            form.save()
            return HttpResponseRedirect("/categoria")
    else:
        form = CategoriaForm()
    return render_to_response('categoria/form.html', {'form': form},
                              context_instance=RequestContext(request))


def excluir(request, id):
    categoria = Categoria.objects.get(pk=id)
    if request.method == "POST":
        categoria.delete()
        return HttpResponseRedirect('/categoria')

    context = RequestContext(request, {'categoria': categoria})
    return render_to_response('categoria/delete.html', context)


def editar(request, id):
    categoria = Categoria.objects.get(pk=id)

    if request.method == 'POST':
        form = CategoriaForm(request.POST, instance=categoria)

        if form.is_valid():
            form.save()
            return HttpResponseRedirect('categoria/')

    else:
        form = CategoriaForm(instance=categoria)

    context = RequestContext(request, {'form': form, 'id': id})
    return render_to_response('categoria/form.html', context)
