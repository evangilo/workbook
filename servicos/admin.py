from django.contrib import admin
from servicos.models import Categoria, Estado, Cidade


# Register your models here.
admin.site.register(Categoria)
admin.site.register(Estado)
admin.site.register(Cidade)