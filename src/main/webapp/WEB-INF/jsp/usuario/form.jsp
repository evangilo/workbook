<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<layout:base>
	<aside id="main" class="col-md-12">
		<form:form modelAttribute="usuario" method="post" class="form-horizontal" action="${param.url_action}">			
			<div class="form-group">
				<form:label path="firstName" class="col-sm-2 control-label">Nome</form:label>
				<div class="col-sm-10">
					<form:input path="firstName" value="${usuario.firstName}"
						class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<form:label path="lastName" class="col-sm-2 control-label">Sobrenome</form:label>
				<div class="col-sm-10">
					<form:input path="lastName" value="${usuario.lastName}"
						class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<form:label path="email" class="col-sm-2 control-label">Email</form:label>
				<div class="col-sm-10">
					<form:input path="email" value="${usuario.email}"
						class="form-control" />
				</div>
			</div>
	>
			<div class="form-group">
				<form:label path="password" class="col-sm-2 control-label">Senha</form:label>
				<div class="col-sm-10">
					<form:input type="password" path="password"
						value="${usuario.password}" class="form-control" />
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
