# -*- coding: utf-8 -*-
from django.shortcuts import render_to_response
from django.template import RequestContext
from django.http import HttpResponseRedirect
from ..forms import ServicoForm
from servicos.models import Servico
from django.db.models import Q


def descrever_servico(request, id):
    servico = Servico.objects.filter()
    return render_to_response('detalhes_servico/descricao_servico.html',
                              {'itens': servico})


def listar(request):
    servicos = Servico.objects.all()
    q = request.GET.get('q', '')
    if q != '':
        servicos = servicos.filter(Q(titulo__icontains=q) |
                                   Q(descricao__icontains=q) |
                                   Q(categorias__nome__icontains=q)).distinct()
    return render_to_response('servico/lista.html', {'itens': servicos})


def adicionar(request):
    if request.method == 'POST':
        form = ServicoForm(request.POST, request.FILES)
        if form.is_valid():
            servico = form.save(commit=False)
            servico.usuario = request.user
            servico.save()
            return HttpResponseRedirect("/")
    else:
        form = ServicoForm()
    return render_to_response('servico/form.html', {'form': form},
                              context_instance=RequestContext(request))


def excluir(request, id):
    servico = Servico.objects.get(pk=id)
    if request.method == "POST":
        servico.delete()
        return HttpResponseRedirect('/')

    context = RequestContext(request, {'servico': servico})
    return render_to_response('servico/delete.html', context)


def editar(request, id):
    servico = Servico.objects.get(pk=id)

    if request.method == 'POST':
        form = ServicoForm(request.POST, instance=servico)

        if form.is_valid():
            form.save()
            return HttpResponseRedirect('/')

    else:
        form = ServicoForm(instance=servico)

    context = RequestContext(request, {'form': form, 'id': id})
    return render_to_response('servico/form.html', context)


def listar_servicos_usuario(request):
    servicos = Servico.objects.all().filter(Q(usuario=request.user))
    return render_to_response('detalhes_servico/descricao_servico.html',
                              {'itens': servicos})