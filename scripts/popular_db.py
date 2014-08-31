# -*- coding: utf-8 -*-
'''
Popular o banco de dados com todos os estados e cidades brasileiras
'''

import json
from servicos.models import Estado, Cidade


def popular_estados():
    estados = open('Estados.json', 'r')
    for estado in json.load(estados):
        Estado(id=int(estado['id']), nome=estado['nome'],  sigla=estado['sigla']).save()
    estados.close()


def popular_cidades():
    cidades = open('Cidades.json', 'r')
    for cidade in json.load(cidades):
        Cidade(id=int(cidade['id']), nome=cidade['nome'], estado_id=int(cidade['estado'])).save()
    cidades.close()


def run():
    print "Go drink coffee, because this operation will take!"
    popular_estados()
    popular_cidades()
