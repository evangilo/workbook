# -*- coding: utf-8 -*-
from servicos.models import Servico
from django.shortcuts import render
from django.forms.models import modelform_factory
from django.shortcuts import render_to_response
from django.template import RequestContext
from django.http import HttpResponseRedirect

def lista(request):
	servico = Servico.objects.all()
	return render_to_response('servico/lista.html', {'itens': servico})

ServicoForm = modelform_factory(Servico)

def adiciona(request):
	if request.method == 'POST':
		form = ServicoForm(request.POST, request.FILES)
		if form.is_valid():
			form.save()
			return HttpResponseRedirect("/servico")
	else:
		form = ServicoForm()
	return render_to_response('servico/form.html', {'form': form},context_instance=RequestContext(request))

def excluir(request, id):
	servico = Servico.objects.get(pk=id)
	if request.method == "POST":
		servico.delete()
		return HttpResponseRedirect('/servico')

	context = RequestContext(request, {'servico': servico})
	return render_to_response('servico/delete.html', context)

def editar(request, id):
	servico = Servico.objects.get(pk=id)

	if request.method == 'POST':
		form = ServicoForm(request.POST, instance=servico)
		
		if form.is_valid():
			form.save()
			return HttpResponseRedirect('servico/')

	else:
		form = ServicoForm(instance=servico)
			
	context = RequestContext(request, {'form': form, 'id': id})
	return render_to_response('servico/form.html', context)
