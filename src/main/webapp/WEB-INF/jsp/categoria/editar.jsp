<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="form.jsp">
	<c:param name="button_form">Atualizar</c:param>
	<c:param name="url_action">${pageContext.request.contextPath}/categoria/editar</c:param>
</c:import>
