<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<layout:base>
<aside id="main" class="col-md-12">
	<h2>Cadastro de Serviço</h2>
	<form:form id="servicoForm" modelAttribute="servico" method="post"
		class="form-horizontal" action="${param.url_action}">
		<form:hidden path="id" value="${servico.id}"/>
		<div class="form-group">
			<form:label path="titulo" class="col-sm-2 control-label">Titulo</form:label>
			<div class="col-sm-10">
				<form:input path="titulo" value="${servico.titulo}" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<form:label path="descricao" class="col-sm-2 control-label">Descrição</form:label>
			<div class="col-sm-10">
				<form:input path="descricao" rows="5" value="${servico.descricao}" class="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<form:label path="telefone" class="col-sm-2 control-label">Telefone</form:label>
			<div class="col-sm-10">
				<form:input path="telefone" value="${servico.telefone}" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<form:label path="celular" class="col-sm-2 control-label">Celular</form:label>
			<div class="col-sm-10">
				<form:input path="celular" value="${servic.celular}" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<form:label path="categoria" class="col-sm-2 control-label">Categoria</form:label>
			<div class="col-sm-10">
				<form:select path="categoria.id" class="form-control">
					<c:forEach items="${categorias}" var="categoria">
						<form:option value="${categoria.id}">${categoria.nome}</form:option>
					</c:forEach>
				</form:select>
			</div>
		</div> 
		
		<div class="form-group">
			<form:label path="image" class="col-sm-2 control-label">Imagem</form:label>
			<div class="col-sm-10">
				<form:input path="image" value="${servico.image}" type="file" class="form-control" />
			</div>
		</div>
		<div class="form-group">
    		<div class="col-sm-offset-2 col-sm-10">
      			<button type="submit" class="btn btn-success">${param.button_form}</button>
    		</div>
  		</div>
	</form:form>
</aside>
</layout:base>