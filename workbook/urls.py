from django.conf.urls import patterns, include, url

from django.contrib import admin
admin.autodiscover()

urlpatterns = patterns('',
    # Examples:
    # url(r'^$', 'workbook.views.home', name='home'),
    # url(r'^blog/', include('blog.urls')),
    url('', include('social.apps.django_app.urls', namespace='social')),
    url('', include('django.contrib.auth.urls', namespace='auth')),
    url(r'^$', 'servicos.views.views.home', name='home'),
    url(r'^admin/', include(admin.site.urls)),
    url(r'categoria/adiciona$', 'servicos.views.categoria.adiciona'),
    url(r'categoria/$', 'servicos.views.categoria.lista', name='categorias_lista'),
    url(r'categoria/excluir/(?P<id>\d+)$', 'servicos.views.categoria.excluir', name='categorias_excluir'),
    url(r'categoria/editar/(?P<id>\d+)$', 'servicos.views.categoria.editar', name='categorias_editar'),
    url(r'servico/adiciona$', 'servicos.views.servico.adiciona'),
    url(r'servico/$', 'servicos.views.servico.lista', name='servicos_lista'),
    url(r'servico/excluir/(?P<id>\d+)$', 'servicos.views.servico.excluir', name='servicos_excluir'),
    url(r'servico/editar/(?P<id>\d+)$', 'servicos.views.servico.editar', name='servicos_editar'),
    url(r'servico/Descricao_servico', 'servicos.views.servico.Descricao_servico', name='Descricao_servico'),

)
