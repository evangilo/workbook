<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:if test="${!empty categorias}">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${categorias}" var="categoria">
				<tr>
					<td>${categoria.nome}</td>
					<td>
						<a href="editar/${categoria.id}"><i class="glyphicon glyphicon-edit"></i> Editar</a>
						<a href="deletar/${categoria.id}"><i class="glyphicon glyphicon-trash"></i> Remover</a>
					</td>
					<td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:if>

</body>
</html>