from django.contrib import admin

# Register your models here.
from servicos.models import Estado, Cidade

admin.site.register(Estado)
admin.site.register(Cidade)
