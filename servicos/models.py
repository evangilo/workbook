from django.db import models
from django.db import models


class Categoria(models.Model):
	descricao = models.CharField(max_length=100)
	def __str__(selfie):
		return selfie.descricao


class Servico (models.Model):
	categoria = models.ForeignKey(Categoria)
	titulo = models.CharField(max_length=100)
	descricao = models.TextField()
	endereco = models.CharField(max_length=100)
	telefone = models.BigIntegerField()
	celular = models.BigIntegerField()