<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<layout:admin>
	<h2>Solicitação de Destaque</h2>
	<form:form id="destaqueForm" modelAttribute="destaque" method="post"
		class="form-horizontal" action="/destaques/criar">
		<form:hidden path="id" value="${destaque.id}"/>
		<form:hidden path="servico.id" value="${servico.id}"/>
		<div class="form-group">
			<form:label path="servico" class="col-sm-2 control-label">Serviço</form:label>
			<div class="col-sm-10">
				<div class="form-control-static">${servico.titulo}</div>
			</div>
		</div>
		<div class="form-group">
			<form:label path="tempo" class="col-sm-2 control-label">Tempo</form:label>
			<div class="col-sm-10">
				<form:select path="tempo" class="form-control">
					<form:options items="${meses}" />
				</form:select>
			</div>
		</div>
		<div class="form-group">
    		<div class="col-sm-offset-2 col-sm-10">
      			<button type="submit" class="btn btn-success">Salvar</button>
    		</div>
  		</div>
	</form:form>
</layout:admin>