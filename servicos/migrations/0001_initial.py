# -*- coding: utf-8 -*-
from south.utils import datetime_utils as datetime
from south.db import db
from south.v2 import SchemaMigration
from django.db import models


class Migration(SchemaMigration):

    def forwards(self, orm):
        # Adding model 'Categoria'
        db.create_table(u'servicos_categoria', (
            (u'id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('descricao', self.gf('django.db.models.fields.CharField')(max_length=100)),
        ))
        db.send_create_signal(u'servicos', ['Categoria'])

        # Adding model 'Servico'
        db.create_table(u'servicos_servico', (
            (u'id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('categoria', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['servicos.Categoria'])),
            ('titulo', self.gf('django.db.models.fields.CharField')(max_length=100)),
            ('descricao', self.gf('django.db.models.fields.TextField')()),
            ('endereco', self.gf('django.db.models.fields.CharField')(max_length=100)),
            ('telefone', self.gf('django.db.models.fields.BigIntegerField')()),
            ('celular', self.gf('django.db.models.fields.BigIntegerField')()),
        ))
        db.send_create_signal(u'servicos', ['Servico'])


    def backwards(self, orm):
        # Deleting model 'Categoria'
        db.delete_table(u'servicos_categoria')

        # Deleting model 'Servico'
        db.delete_table(u'servicos_servico')


    models = {
        u'servicos.categoria': {
            'Meta': {'object_name': 'Categoria'},
            'descricao': ('django.db.models.fields.CharField', [], {'max_length': '100'}),
            u'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'})
        },
        u'servicos.servico': {
            'Meta': {'object_name': 'Servico'},
            'categoria': ('django.db.models.fields.related.ForeignKey', [], {'to': u"orm['servicos.Categoria']"}),
            'celular': ('django.db.models.fields.BigIntegerField', [], {}),
            'descricao': ('django.db.models.fields.TextField', [], {}),
            'endereco': ('django.db.models.fields.CharField', [], {'max_length': '100'}),
            u'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'telefone': ('django.db.models.fields.BigIntegerField', [], {}),
            'titulo': ('django.db.models.fields.CharField', [], {'max_length': '100'})
        }
    }

    complete_apps = ['servicos']