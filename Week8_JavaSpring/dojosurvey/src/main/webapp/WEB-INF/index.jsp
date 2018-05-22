<!DOCTYPE html>
<html>
<head>
	<title>Survey</title>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<h1>Dojo Survey</h1>
	
	<p>You have visited this page: ${count} times.</p>
	
	<c:if test="false">
		<c:out value="${nombres}"></c:out>
	</c:if>
	
	<c:forEach items="${nombres}" var="nombre" varStatus="loop">
		<p>${loop.index+1}. ${nombre}</p>
	</c:forEach>
	
</body>
</html>