<%@tag description="Base Layout template" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/font-awesome-4.1.0/css/font-awesome.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/workbook.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/star-rating.min.css"/>" rel="stylesheet">
    
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.10.2.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/star-rating.min.js"/>"></script>
    <title>WorkBook</title>
</head>
<body>
<!-- Header -->
<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">WorkBook</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <form class="navbar-form navbar-left" role="search" action="<c:url value="/servico/buscar"/>">
                <div class="form-group">
                    <input type="text" name="s" value="${param.s}" class="form-control" placeholder="Pesquisar">
                </div>
                <button type="submit" class="btn btn-default">Pesquisar</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
			<sec:authorize access="isAnonymous()">
				<li><a href="<c:url value="/usuario/criar"/>">Registrar</a></li>
				<li><a href="<c:url value="/login"/>">Entrar</a></li>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="<c:url value="/categoria/listar"/>">Admininistrar</a></li>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
                <li class="hidden-sm"><a href="<c:url value='/destaques/listar'/>">Destaques</a></li>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_USER')">
                <li><a href="<c:url value="/servico/listar"/>">Meus Servi&ccedil;os</a></li>
                </sec:authorize>
                <li class="dropdown">
                    <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#">
	                    <i class="glyphicon glyphicon-user"></i>
	                    <sec:authentication property="principal.username" />
	                    <span class="caret"></span>
                    </a>
                    <ul id="g-account-menu" class="dropdown-menu" role="menu">
                        <li><a href="<c:url value="/logout"/>">Sair</a></li>
                    </ul>
                </li>
			</sec:authorize>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<div class="container">
<div class="row">
<jsp:doBody/>
</div>
</div><!--/container-->
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>
