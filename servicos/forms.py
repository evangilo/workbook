from django import forms
from django_select2 import *
from easy_select2 import select2_modelform
from .models import Categoria, Cidade, Servico


class CategoriasChoices(AutoModelSelect2TagField):
    queryset = Categoria.objects.all()
    search_fields = ['nome__icontains']

    def get_model_field_values(self, value):
        return {'nome': value}


class CidadesChoices(AutoModelSelect2MultipleField):
    queryset = Cidade.objects.all()
    search_fields = ['nome__icontains']


class ServicoForm(forms.ModelForm):
    categorias = CategoriasChoices(label='Categorias')
    cidades = CidadesChoices(label='Cidades')

    class Meta:
        model = Servico
