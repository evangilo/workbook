<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Workbook</title>
</head>
<body>
	<h3>
		Hello, <span>${facebookProfile.name}</span>!
	</h3>
	
	<c:forEach items="${feed}" var="post">

	<div>
		<b>${post.from.name} </b> wrote:
		<p>${post.message} message text</p>
		<img src="${post.picture}" />		
	</div>
	</c:forEach>

</body>
</html>
