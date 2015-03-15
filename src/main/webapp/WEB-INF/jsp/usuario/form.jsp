<div class="form-group">
	<form:label path="firstName" class="col-sm-2 control-label">Nome</form:label>
	<div class="col-sm-10">
		<form:input path="firstName" value="${usuario.firstName}" class="form-control" />
	</div>
</div>

<div class="form-group">
	<form:label path="lastName" class="col-sm-2 control-label">Sobrenome</form:label>
	<div class="col-sm-10">
		<form:input path="lastName" value="${usuario.lastName}" class="form-control" />
	</div>
</div>

<div class="form-group">
	<form:label path="email" class="col-sm-2 control-label">Email</form:label>
	<div class="col-sm-10">
		<form:input path="email" value="${usuario.email}" class="form-control" />
	</div>
</div>
<div class="form-group">
	<form:label path="username" class="col-sm-2 control-label">Username</form:label>
	<div class="col-sm-10">
		<form:input path="username" value="${usuario.username}"
			class="form-control" />
	</div>
</div>
<div class="form-group">
	<form:label path="password" class="col-sm-2 control-label">Senha</form:label>
	<div class="col-sm-10">
		<form:input type="password" path="password"
			value="${usuario.password}" class="form-control" />
	</div>
</div>

