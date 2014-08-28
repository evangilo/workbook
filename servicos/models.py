from django.db import models
from django.db import models


class Categoria(models.Model):
	descricao = models.CharField(max_length=100)


class Servico (models.Model):
	categoria = models.ForeignKey(Categoria)
	descricao = models.TextField()
	endereco = models.CharField(max_length=100)
	telefone = models.BigIntegerField()
	celular = models.BigIntegerField()