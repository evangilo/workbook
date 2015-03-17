<%@tag description="Main Layout template" pageEncoding="UTF-8"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<layout:base>
<aside id="left" class="col-md-3">
<div class="list-group">
	<a class="list-group-item" href="<c:url value="/destaques/listar"/>">Destaques</a>
    <a class="list-group-item" href="<c:url value="/categoria/listar"/>">Categorias</a>
    <a class="list-group-item" href="<c:url value="/cidade/listar"/>">Cidades</a>
</div>
</aside>
<aside id="main" class="col-md-9">
	<jsp:doBody/>
</aside>
</layout:base>