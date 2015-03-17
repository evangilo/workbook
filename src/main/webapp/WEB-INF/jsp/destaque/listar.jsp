<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<layout:base>
<aside id="main" class="col-md-12">
	<h1>Destaques</h1>
	<c:if test="${!empty destaques}">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Serviço</th>
					<th>Categoria</th>
					<th>Tempo (meses)</th>
					<th>Ultima atualização</th>
					<th>Situação</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${destaques}" var="destaque">
				<tr>
					<td>${destaque.servico.titulo}</td>
					<td>${destaque.servico.categoria.nome}</td>
					<td>${destaque.tempo}</td>
					<td>${destaque.atualizado}</td>
					<td>
						<c:choose>
						<c:when test="${destaque.situacao == 1}">Pendente</c:when>
						<c:when test="${destaque.situacao == 2}">Aceita</c:when>
						<c:when test="${destaque.situacao == 3}">Cancelada</c:when>
						<c:when test="${destaque.situacao == 4}">Finzalido</c:when>
						</c:choose>
					</td>
					<td>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
						<c:if test="${destaque.situacao == 1}">
						<a href="aceitar/${destaque.id}"><i class="fa fa-check-square-o"></i> Aceitar</a>
						</c:if>
						<c:if test="${destaque.situacao < 3}">
						<a href="cancelar?id=${destaque.id}"><i class="fa fa-times"></i> Cancelar</a>
						</c:if>
						</sec:authorize>
						<sec:authorize access="!hasRole('ROLE_ADMIN')">
						<c:if test="${destaque.situacao != 2}">
						<a href="deletar/${destaque.id}"><i class="fa fa-trash-o"></i> Remover</a>
						</c:if>
						</sec:authorize>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:if>
</aside>
</layout:base>