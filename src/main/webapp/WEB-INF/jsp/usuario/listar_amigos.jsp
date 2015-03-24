<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<layout:admin>

	<c:forEach items="${friends}" var="friend">
		<p>${friend}</p>
	</c:forEach>

</layout:admin>