from django.conf.urls import patterns, url


urlpatterns = patterns(
    'servicos.views',
    url(r'^$', 'servico.listar', name='home'),

    url(r'categoria/adicionar$', 'categoria.adicionar',
        name='categoria_adicionar'),
    url(r'categoria/$', 'categoria.listar',
        name='categoria_listar'),
    url(r'categoria/excluir/(?P<id>\d+)$', 'categoria.excluir',
        name='categoria_excluir'),
    url(r'categoria/editar/(?P<id>\d+)$', 'categoria.editar',
        name='categoria_editar'),

    url(r'servico/adicionar$', 'servico.adicionar',
        name='servico_adicionar'),
    url(r'servico/excluir/(?P<id>\d+)$', 'servico.excluir',
        name='servico_excluir'),
    url(r'servico/editar/(?P<id>\d+)$', 'servico.editar',
        name='servico_editar'),
    url(r'meus_servicos/', 'servico.listar_servicos_usuario', name='meus_servicos'),

    url(r'avaliacao/comentarios/(?P<id>\d+)$', 'avaliacao.Comentarios',
        name='comentarios'),
    url(r'servico/descricao_servico/(?P<id>\d+)$', 'servico.descrever_servico',
        name='servico_detalhes'),

    url(r'avaliacao/adicionar$', 'avaliacao.adicionar',
        name='avaliacao_adicionar'),
    url(r'avaliacao/$', 'avaliacao.listar',
        name='avaliacao_listar'),
    url(r'avaliacao/excluir/(?P<id>\d+)$', 'avaliacao.excluir',
        name='avaliacao_excluir'),
    url(r'avaliacao/editar/(?P<id>\d+)$', 'avaliacao.editar',
        name='avaliacao_editar'),
)
