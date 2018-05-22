<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
<link type="text/css" rel="stylesheet" href="/css/style.css">
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
</head>
<body>
    <div class="container">
        <div class="hero is-dark">
            <div class="hero-body is-bold">
                <h1 class="title">
                	<span><i class="fas fa-tv"></i></span>
                	<span>Skills Demo</span>
                </h1>
            </div>
        </div>
        <h1>Welcome to the Admin Page <c:out value="${currentUser.username}"></c:out></h1>
        
        <form id="logoutForm" method="POST" action="/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" value="Logout!" />
        </form>

    </div>
</body>
</html>