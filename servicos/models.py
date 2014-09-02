from django.contrib.auth.models import User
from django.db import models


class Estado(models.Model):
    nome = models.CharField(max_length=45)
    sigla = models.CharField(max_length=2)

    def __unicode__(self):
        return self.nome


class Cidade(models.Model):
    nome = models.CharField(max_length=45)
    estado = models.ForeignKey(Estado)

    def __unicode__(self):
        return self.nome


class Categoria(models.Model):
    descricao = models.CharField(max_length=20)


class Servico(models.Model):
    usuario = models.ForeignKey(User)
    categoria = models.ForeignKey(Categoria, related_name="servicos")
    cidade = models.ForeignKey(Cidade, related_name="servicos")
    descricao = models.TextField()
    telefone = models.CharField(max_length=10)
    celular = models.CharField(max_length=11)