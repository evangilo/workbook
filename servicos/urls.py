from django.conf.urls import patterns, url


urlpatterns = patterns(
    'servicos.views',
    url(r'^$', 'views.home', name='home'),

    url(r'categoria/adicionar$', 'categoria.adiciona',
        name='categorias_adicionar'),
    url(r'categoria/$', 'categoria.lista',
        name='categorias_lista'),
    url(r'categoria/excluir/(?P<id>\d+)$', 'categoria.excluir',
        name='categorias_excluir'),
    url(r'categoria/editar/(?P<id>\d+)$', 'categoria.editar',
        name='categorias_editar'),

    url(r'servico/adicionar$', 'servico.adiciona',
        name='servicos_adicionar'),

    url(r'servico/$', 'servico.lista',
        name='servicos_lista'),

    url(r'servico/excluir/(?P<id>\d+)$', 'servico.excluir',
        name='servicos_excluir'),

    url(r'servico/editar/(?P<id>\d+)$', 'servico.editar',
        name='servicos_editar'),

    url(r'avaliacao/comentarios/(?P<id>\d+)$', 'avaliacao.Comentarios',
        name='comentarios'),

    url(r'servico/descricao_servico/(?P<id>\d+)$', 'servico.Descricao_servico',
        name='servico_detalhes'),

    url(r'avaliacao/adicionar$', 'avaliacao.adiciona',
        name='avaliacoes_adicionar'),

     url(r'avaliacao/$', 'avaliacao.lista',
        name='avaliacoes_lista'),
    
     url(r'avaliacao/excluir/(?P<id>\d+)$', 'avaliacao.excluir',
        name='avaliacoes_excluir'),

    url(r'avaliacao/editar/(?P<id>\d+)$', 'avaliacao.editar',
        name='avaliacoes_editar'),
 
)
