# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models, migrations
import django.core.validators


class Migration(migrations.Migration):

    dependencies = [
        ('servicos', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='servico',
            name='nota',
            field=models.PositiveIntegerField(default=0, editable=False, validators=[django.core.validators.MaxValueValidator(5), django.core.validators.MinValueValidator(1)]),
        ),
    ]
