# -*- coding: utf-8 -*-
from django.contrib.auth.models import User
from django.db import models
from django.core.validators import MaxValueValidator, MinValueValidator


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
    nome = models.CharField(max_length=20)

    def __unicode__(self):
        return self.nome


class Avaliacao(models.Model):
    avalista = models.ForeignKey(User)
    nota = models.PositiveIntegerField(validators=[
        MaxValueValidator(10), MinValueValidator(1)])
    comentario = models.TextField(verbose_name='comentário')
    resposta = models.TextField()

    class Meta:
        verbose_name = 'avaliação'


class Servico(models.Model):
    usuario = models.ForeignKey(User)
    titulo = models.CharField(max_length=50, verbose_name='título')
    nota = models.PositiveIntegerField(editable=False, default=0)
    categorias = models.ManyToManyField(Categoria, blank=True,
                                        related_name="servicos")
    cidades = models.ManyToManyField(Cidade, blank=True,
                                     related_name="servicos")
    descricao = models.TextField(verbose_name='descrição')
    telefone = models.CharField(max_length=10, blank=True, null=True)
    celular = models.CharField(max_length=11, blank=True, null=True)

    class Meta:
        verbose_name = 'serviço'
