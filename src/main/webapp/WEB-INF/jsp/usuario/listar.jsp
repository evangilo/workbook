<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${!empty usuarios}">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuarios}" var="usuario">
					<tr>
						<td>${usuario.id}</td>
						<td>${usuario.nome}</td>
						<td>${usuario.email}</td>
						<td><a
							href="${pageContext.request.contextPath}/usuario/editar/${usuario.id}"><i
								class="glyphicon glyphicon-edit"></i> Editar</a> <a
							href="${pageContext.request.contextPath}/usuario/deletar/${usuario.id}"><i
								class="glyphicon glyphicon-trash"></i> Remover</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>

</body>
</html>