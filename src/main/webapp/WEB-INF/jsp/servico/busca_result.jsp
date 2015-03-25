<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<layout:base>
	<aside id="left" class="col-sm-3">
		<div class="list-group">
			<div class="list-group-item"><b>Categorias</b></div>
			<c:url value="/servico/buscar" var="buscarUrl">
  				<c:param name="s" value="${param.s}" />
			</c:url>
			<a class="list-group-item <c:if test="${empty param.c}">active</c:if>" href="${buscarUrl}">Todas as categorias</a>
			<c:forEach items="${categorias}" var="categoria">
			<c:url value="/servico/buscar" var="buscarUrl">
  				<c:param name="s" value="${param.s}" />
  				<c:param name="c" value="${categoria.id}" />
			</c:url>
			<a class="list-group-item <c:if test="${categoria.id == param.c}">active</c:if>" href="${buscarUrl}">${categoria.nome}</a>
			</c:forEach>
			<div>
				Filtrar por avaliação: <input type="number" id="star-rating" class=" pull-left rating caption" data-size="xs" value="0" data-show-clear="false" data-show-caption="false">
			</div>
		</div>
	</aside>
	<aside id="main" class="col-sm-9">
		<div class="row">
		<c:choose>
		<c:when test="${!empty servicos}">
		<c:forEach items="${servicos}" var="servico">
		<div class="col-sm-6 col-md-6 col-lg-4">
			<div class="thumbnail">
				<img class="servico_image" src="<c:url value='/servico/image/${servico.id}' />" alt="${servico.titulo}" />
				<div class="caption">

				<h3><a href="/servico/detalhar/${servico.id}">${servico.titulo}</a></h3>
				</div>
				<div class="caption hidden-xs">
					<p class="text-list">${servico.descricao}</p>
				</div>
	            <div class="caption ratings">
	            	<input type="number" id="star-rating" class="rating" data-readonly="true" data-size="xs" value="${servico.media }" data-show-clear="false" data-show-caption="false">
	           	</div>
	         </div>
		</div>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<div class="well text-center">Não há serviços à exibir</div>
		</c:otherwise>
		</c:choose>
		</div>
	</aside>
</layout:base>
<script type="text/javascript">
$(function($){
	$("#star-rating").on('rating.change', function(event, value, caption) {
		window.location.href= "/servico/listarPorAvaliacao/?s=${param.s}&c=${param.c}&a="+value;
	});
});
</script>
