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
    categoria = models.ForeignKey(to=Categoria, related_name="categorias")
    cidade = models.ForeignKey(to=Cidade, related_name="cidades")
    descricao = models.TextField()
    telefone = models.CharField(max_length=10)
    celular = models.CharField(max_length=11)