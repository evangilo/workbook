<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<layout:admin>
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
						<td><a href="editar/${categoria.id}"><i
								class="glyphicon glyphicon-edit"></i> Editar</a> <a
							href="deletar/${categoria.id}"><i
								class="glyphicon glyphicon-trash"></i> Remover</a></td>
						<td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</layout:admin>