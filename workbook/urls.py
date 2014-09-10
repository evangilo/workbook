from django.conf.urls import patterns, include, url

from django.contrib import admin
admin.autodiscover()

urlpatterns = patterns('',
    # Apps URLs
    url('', include('social.apps.django_app.urls', namespace='social')),
    url('', include('django.contrib.auth.urls', namespace='auth')),
    url(r'', include('servicos.urls')),
    url(r'^admin/', include(admin.site.urls)),
    url(r'^select2/', include('django_select2.urls')),
)
