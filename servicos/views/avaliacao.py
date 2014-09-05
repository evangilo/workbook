# -*- coding: utf-8 -*-
from servicos.models import Avaliacao
from django.shortcuts import render
from django.forms.models import modelform_factory
from django.shortcuts import render_to_response
from django.template import RequestContext
from django.http import HttpResponseRedirect


def lista(request):
	avaliacao = Avaliacao.objects.all()
	return render_to_response('avaliacao/lista.html', {'itens': avaliacao})

AvaliacaoForm = modelform_factory(Avaliacao)

def adiciona(request):
	if request.method == 'POST':
		form = AvaliacaoForm(request.POST, request.FILES)
		if form.is_valid():
			form.save()
			return HttpResponseRedirect("/avaliacao")
	else:
		form = AvaliacaoForm()
	return render_to_response('avaliacao/form.html', {'form': form},context_instance=RequestContext(request))

def excluir(request, id):
	avaliacao = Avaliacao.objects.get(pk=id)
	if request.method == "POST":
		avaliacao.delete()
		return HttpResponseRedirect('/avaliacao')

	context = RequestContext(request, {'avaliacao': avaliacao})
	return render_to_response('avaliacao/delete.html', context)

def editar(request, id):
	avaliacao = Avaliacao.objects.get(pk=id)

	if request.method == 'POST':
		form = AvaliacaoForm(request.POST, instance=avaliacao)
		
		if form.is_valid():
			form.save()
			return HttpResponseRedirect('avaliacao/')

	else:
		form = AvaliacaoForm(instance=avaliacao)
			
	context = RequestContext(request, {'form': form, 'id': id})
	return render_to_response('avaliacao/form.html', context)
