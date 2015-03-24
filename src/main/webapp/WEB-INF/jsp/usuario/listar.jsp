<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<layout:admin>
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
						<td>${usuario.firstName}</td>
						<td>${usuario.email}</td>						
						<td>
							<c:choose>
      							<c:when test="${usuario.active}">
      								<a href="${pageContext.request.contextPath}/usuario/active/${usuario.id}/false">
									<i class="glyphicon glyphicon-edit"></i>Desativar</a> 
      							</c:when>      								
					      		<c:otherwise>
					      			<a href="${pageContext.request.contextPath}/usuario/active/${usuario.id}/true">
									<i class="glyphicon glyphicon-edit"></i>Ativar</a>
					      		</c:otherwise>					      	
							</c:choose>
														
							<a href="${pageContext.request.contextPath}/usuario/editar/${usuario.id}">
							<i class="glyphicon glyphicon-edit"></i> Editar</a> 
							<a href="${pageContext.request.contextPath}/usuario/deletar/${usuario.id}">
							<i class="glyphicon glyphicon-trash"></i> Remover</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</layout:admin>