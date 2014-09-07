from django.contrib import admin
from .models import Estado, Cidade
from .models import Categoria, Avaliacao, Servico

admin.site.register(Categoria)
admin.site.register(Servico)
admin.site.register(Estado)
admin.site.register(Cidade)
