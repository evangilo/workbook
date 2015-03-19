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
				<input type="number" id="star-rating" class="rating" data-readonly="true" data-size="xs" value="${servicoResult.media }" data-show-clear="false" data-show-caption="false">
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
					<a href="<c:url value='/avaliacao/form' />/${servico.id}" class="btn btn-success">Deixe sua opni&atilde;o</a>
				</div>
				<hr>
				<div class="row">
	        <c:choose>
			<c:when test="${!empty avaliacaoList}">
			<c:forEach items="${avaliacaoList}" var="avaliacao">            
				<div class="col-md-12">
					 <span class="pull-right"><input type="number" id="star-rating" class="rating" data-readonly="true" data-size="xs" value="${avaliacao.nota }" data-show-clear="false" data-show-caption="false"></span>
	                
	                <p>${avaliacao.usuario.nome}</p>
	                <p>${avaliacao.comentario}</p>
	            </div>
	           </c:forEach>
			</c:when>
			<c:otherwise>
				<div>Não há itens para exibir. ;)</div>
			</c:otherwise>
			</c:choose>
        </div>			</div>
		</div>
	</aside>
</layout:base>