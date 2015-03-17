<%@tag description="Place bootstrap stars" pageEncoding="UTF-8"%>
<%@attribute name="value" required="true" type="java.lang.Integer"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach begin="1" end="${value /2}" var="star">
	<span class="fa fa-star"></span>
</c:forEach>
<c:if test="${(value % 2) == 1}">
	<span class="fa fa-star-half-o"></span>
</c:if>
<c:forEach begin="1" end="${5 - (value /2)}" var="star">
	<span class="fa fa-star-o"></span>
</c:forEach>