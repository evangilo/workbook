<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<layout:base>
	<aside id="main" class="col-md-12">
	
		<p>${globalMessage}</p>

		<form class="navbar-form navbar-left" action="change_password" method="post">
			<input type="hidden" name="user" value="${param.user}"/>
			<input type="hidden" name="token" value="${param.token}"/>
			<label>Password</label>
			<div class="form-group">
				<input type="text" name="password" class="form-control" placeholder="senha">
			</div>
			
			<label>Confirmar password</label>
			<div class="form-group">
				<input type="text" class="form-control" placeholder="confirmar senha">
			</div>
			<button type="submit" class="btn btn-default">Resetar</button>
		</form>
	</aside>
</layout:base>