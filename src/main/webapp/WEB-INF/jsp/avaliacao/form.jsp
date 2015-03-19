<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<layout:base>
<aside id="main" class="col-md-12">
	<h2>Cadastrar Avaliacao</h2>
	<form:form id="avaliacaoForm" modelAttribute="avaliacao" method="post"
		class="form-horizontal" action="criar_ou_atualizar?servico=${param.servico}">
		<form:hidden path="servico" value="${param.servico}"/>
		
		<div class="form-group">
			<form:label path="comentario" class="col-sm-2 control-label">Comentário:</form:label>
			<div class="col-sm-10">
				<form:textarea path="comentario" rows="5" class="form-control" />
			</div>
		</div>	
			
		<div class="form-group">
			<form:label path="nota" class="col-sm-2 control-label">Nota de Serviço:</form:label>
               <div class="col-sm-10">
               	<input type="number" name="nota" id="star-rating" class="rating" data-size="xs" data-show-clear="false" data-show-caption="false">
              </div>
        </div>

		<div class="form-group">
    		<div class="col-sm-offset-2 col-sm-10">
      			<button type="submit" class="btn btn-success">Salvar</button>
    		</div>
  		</div>
  		
	</form:form>
</aside>
</layout:base>

