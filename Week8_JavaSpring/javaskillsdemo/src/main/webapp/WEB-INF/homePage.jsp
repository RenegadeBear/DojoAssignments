<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
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
                	<span>TV Show Reviews</span>
                </h1>
            </div>
        </div>

        
        <!-- <fieldset>
            <label>First Name:</label>  <c:out value="${currentUser.first_name}"></c:out><br>
            <label>Last Name:</label>  <c:out value="${currentUser.last_name}"></c:out><br>
            <label>Email:</label>  <c:out value="${currentUser.username}"></c:out><br>
            <label>Sign up date:</label>  <c:out value="${currentUser.createdAt}"></c:out><br>
            <label>Last Sign in:</label>  <c:out value="${currentUser.last_sign_in}"></c:out>
        </fieldset> -->
        <form id="logoutForm" method="POST" action="/logout" style="float:right;">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" value="Logout!" class="button is-danger" />
        </form>
        <h1 class="title is-h1">Welcome, <c:out value="${currentUser.first_name}"></c:out>!</h1>
        <h2 class="title is-h2">TV Shows</h2>
        <table class="table is-bordered is-striped is-fullwidth">
            <tr>
                <th>Show</th>
                <th>Network</th>
                <th>Avg Rating</th>
            </tr>
            <c:forEach items="${tvshows}" var="show">
                <tr>
                    <td><a href="view/${show.id}"> ${show.name} </a></td>
                    <td> ${show.network} </td>
                    <td> ${show.avg_rating} </td>
                </tr>
            </c:forEach>
        </table>

        <a href="/add_show"><button class="button is-primary">Add a show</button></a>

    </div>
</body>
</html>