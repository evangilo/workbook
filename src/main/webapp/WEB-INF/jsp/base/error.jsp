<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<layout:base>
	<aside id="main" class="col-md-12">
	
		<c:choose>
      <c:when test="${globalMessage}">pizza.
		<p>${globalMessage}</p>
      </c:when>

      <c:otherwise>
      	<p>Aconteceu um erro inesperado :(</p>
      <br />
      </c:otherwise>
		</c:choose>
		
	
	</aside>
</layout:base>