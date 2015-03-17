<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<layout:base>
	<aside id="main" class="col-md-12">
		<form:form modelAttribute="categoria" action="${param.url_action}"
			method="post" class="form-horizontal">
			<form:hidden path="id" value="${categoria.id}" />
			<div class="form-group">
				<form:label path="nome" class="col-sm-2 control-label">Nome</form:label>
				<div class="col-sm-10">
					<form:input path="nome" value="${categoria.nome}"
						class="form-control" />
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