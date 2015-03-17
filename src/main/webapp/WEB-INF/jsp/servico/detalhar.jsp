<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<layout:base>
	<aside id="main" class="col-md-12">
		<img class="img-responsive" src="http://placehold.it/1140x400" alt="">
		<div class="col-md-9">
			<h1>${servico.titulo}</h1>
			<div>${servico.descricao}</div>
		</div>
		<div class="col-md-3">
			<h4>Avaliação</h4>
			<div class="text-lg text-warning">
				<layout:stars value="${servico.media}" />
				<span class="badge badge-default text-lg"
					title="Total de avaliações">${servico.total}</span>
			</div>
			<h4>Categoria</h4>
			<div>${servico.categoria.nome}</div>
			<h4>Contatos</h4>
			<div>
				<b>Telefone:</b> ${servico.telefone}
			</div>
			<div>
				<b>Celular:</b> ${servico.celular}
			</div>
			<p>&nbsp;</p>
		</div>
		<div class="col-md-12">
			<div class="well">
				<div class="text-right">
					<a class="btn btn-success">Deixe sua opni&atilde;o</a>
				</div>
				<hr>
				<div class="row">
					<div class="col-md-12">
						<layout:stars value="5" />
						Anonymous <span class="pull-right">10 days ago</span>
						<p>This product was great in terms of quality. I would
							definitely buy another!</p>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-md-12">
						<layout:stars value="7" />
						Anonymous <span class="pull-right">12 days ago</span>
						<p>I've alredy ordered another one!</p>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-md-12">
						<layout:stars value="10" />
						Anonymous <span class="pull-right">15 days ago</span>
						<p>I've seen some better than this, but not at this price. I
							definitely recommend this item.</p>
					</div>
				</div>
			</div>
		</div>
	</aside>
</layout:base>