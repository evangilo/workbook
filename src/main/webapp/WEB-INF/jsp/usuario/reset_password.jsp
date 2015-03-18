<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<layout:base>
	<aside id="main" class="col-md-12">
	
		<p>${globalMessage}</p>

		<form class="navbar-form navbar-left" action="reset_password" method="post">
			<label>Email</label>
			<div class="form-group">
				<input type="text" name="email" value="${param.email}" class="form-control" placeholder="email">
			</div>
			<button type="submit" class="btn btn-default">Resetar</button>
		</form>
	</aside>
</layout:base>