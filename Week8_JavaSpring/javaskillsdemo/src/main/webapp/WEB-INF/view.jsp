<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <h1 class="title is-h1">
                	<span><i class="fas fa-tv"></i></span>
                	<span>${tvshow.name}</span>
                </h1>
                <h4 class="title is-h4">Network: ${tvshow.network}</h4>
            </div>
        </div>
        <a href="/">Home</a>
        <div class="hero-body is-bold">
            <h2 class="title is-h2">Users who rated this show</h2>
            <table class="table is-bordered is-striped is-fullwidth">
                <tr>
                    <th>Name</th>
                    <th>Rating</th>
                </tr>
                <c:forEach items="${ratings}" var="r">
                    <tr>
                        <td>${r.user.getFirst_name()} ${r.user.getLast_name()}</td>
                        <td>${r.rating}</td>
                    </tr>
                </c:forEach>
            </table>

            <div>
            <a href="edit/${tvshow.id}"><button class="button is-info">Edit</button></a>
            </div>
            <div class = "columns">
                <div class = "column">
                    <h4 class="title is-h4">Leave a Rating:</h4>
                    <form:form method="POST" action="/rate/${tvshow.id}" modelAttribute="review">
                        <div class="field">
                            <form:input path="rating" class="input" type="number" min="1" max="5"/>
                        </div>
                        <input type="hidden" name="user" value="${currentUser.id}"/>
                        <input type="hidden" name="tvshow" value="${tvshow.id}"/>
                        <input type="submit" value="Rate!" class="button is-primary"/>
                    </form:form>

                    <div class = "has-text-danger">
                        <p><form:errors path="review.*"/></p>
                    </div>
                </div>
                <div class="column"></div>
                <div class="column"></div>
                <div class="column"></div>
            </div>

    </div>
</body>
</html>