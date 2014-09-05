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

    def __unicode__(self):
        return self.descricao

class Avaliacao(models.Model):

    avalista = models.ForeignKey(User)
    nota = models.IntegerField(max_length=5)
    comentario = models.TextField(max_length=150)
    resposta = models.TextField(max_length=200)

class Servico(models.Model):
    usuario = models.ForeignKey(User)
    titulo = models.CharField(max_length=50)
    categorias = models.ManyToManyField(Categoria, blank=True,
                                        related_name="servicos")
    cidades = models.ManyToManyField(Cidade, blank=True,
                                     related_name="servicos")
    descricao = models.TextField()
    telefone = models.CharField(max_length=10)
    celular = models.CharField(max_length=11)
