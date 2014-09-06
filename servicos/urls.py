# -*- coding: utf-8 -*-
from django.conf.urls import patterns, url

urlpatterns = patterns(
    'servicos.views',
    url(r'^$', 'views.home', name='home'),

    # categorias
    url(r'categoria/$', 'categoria.listar',
        name='categoria_listar'),
    url(r'categoria/adicionar/$', 'categoria.adicionar',
        name='categoria_adicionar'),
    url(r'categoria/editar/(?P<id>\d+)/$', 'categoria.editar',
        name='categoria_editar'),
    url(r'categoria/excluir/(?P<id>\d+)/$', 'categoria.excluir',
        name='categoria_excluir'),

    # serviços
    url(r'servico/$', 'servico.listar',
        name='servico_listar'),
    url(r'servico/Descricao_servico/$', 'servico.Descricao_servico',
        name='servico_detalhes'),
    url(r'servico/adicionar/$', 'servico.adicionar',
        name='servico_adicionar'),
    url(r'servico/editar/(?P<id>\d+)/$', 'servico.editar',
        name='servico_editar'),
    url(r'servico/excluir/(?P<id>\d+)/$', 'servico.excluir',
        name='servico_excluir'),

    # avaliações
    url(r'avaliacao/$', 'avaliacao.listar',
        name='avaliacao_listar'),
    url(r'avaliacao/adicionar/$', 'avaliacao.adicionar',
        name='avaliacao_adicionar'),
    url(r'avaliacao/editar/(?P<id>\d+)/$', 'avaliacao.editar',
        name='avaliacao_editar'),
    url(r'avaliacao/excluir/(?P<id>\d+)/$', 'avaliacao.excluir',
        name='avaliacao_excluir'),
)
