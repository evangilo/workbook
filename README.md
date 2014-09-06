workbook
========

Site de divulgação para prestadores de serviços

## Instalando

Instalar requisitos

	pip install -r requirements.txt --upgrade

Criar o banco de dados

	python manage.py migrate

Popular o banco de dados com todos os estados e cidades brasileiras

    python manage.py loaddata cidades_e_estados
