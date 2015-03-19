<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<layout:base>
	<aside id="main" class="col-md-12">		
	
		<p>${globalMessage}</p>

		<form class="form-horizontal" action="change_password" method="post">
			<fieldset>
	        	<legend>Mudar senha</legend>
				
				<input type="hidden" name="user" value="${param.user}" /> 
				<input type="hidden" name="token" value="${param.token}" /> 
				
				<label>Senha</label>
				<div class="form-group">
					<input id="password" type="password" name="password" class="form-control" placeholder="senha" required>
				</div>
	
				<label>Confirmar senha</label>
				<div class="form-group">
					<input id="confirm_password" type="password" class="form-control" placeholder="confirmar senha" oninput="check(this)"  required>
				</div>
				<button type="submit" class="btn btn-default">Resetar</button>
				
			</fieldset>
		</form>
		
		<script>
			function check(input) {
				if (input.value != document.getElementById('password').value) {
					input.setCustomValidity('Senhas não são iguais!');
				} else {					
					input.setCustomValidity('');
				}
			}
		</script>

	</aside>
</layout:base>
