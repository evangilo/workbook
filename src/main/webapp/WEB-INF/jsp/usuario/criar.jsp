<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>WorkBook</title>
</head>
<body>
	<form:form modelAttribute="usuario" method="post" class="form-horizontal" action="${pageContext.request.contextPath}/usuario/criar">
		<%@ include file="form.jsp" %>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-success">Registrar</button>
			</div>
		</div>
	</form:form>
</body>
</html>
