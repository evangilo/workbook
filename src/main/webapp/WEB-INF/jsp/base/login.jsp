<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<layout:base>
	<aside id="main" class="col-md-12">
		<form class="form-horizontal" name='f' action='/login' method='POST'>
			<div class="form-group">
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<input type="text" name="username" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">Senha</label>
				<div class="col-sm-10">
					<input type="password" name="password" class="form-control" />
				</div>
			</div>						

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">Entrar</button>
				</div>
			</div>
		</form>

		<%-- <form class="form-horizontal" action="/connect/facebook" method="POST">
			<input type="hidden" name="scope" value="read_stream"></input>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">Connect to
						Facebook</button>
				</div>
			</div>
		</form> --%>
		<div class="form-group">
			<div class="col-sm-offset-2">
				<a href="/usuario/reset_password">Esqueceu a senha?</a>
			</div>
		</div>
		
	</aside>
</layout:base>