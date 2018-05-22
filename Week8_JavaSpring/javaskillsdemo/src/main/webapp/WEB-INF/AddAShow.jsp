<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a new show</title>
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
        <a href="/">Home</a>
        <div class="columns">
            <div class="column">
                <h2 class="title is-h2">Create a new show ${currentUser.first_name}</h2>
            
                <form:form method="POST" action="/newshow" modelAttribute="tvshow">
                    <div class="field">
                        <form:label path="name" class="label">Title</form:label>
                        <form:input path="name" class="input" placeholder="Title"/>
                    </div>

                    <div class="field">
                        <form:label path="network" class="label">Network</form:label>
                        <form:input path="network" class="input" placeholder="Network"/>
                    </div>
                    <input type="hidden" path="submitter" name="submitter" value="${currentUser.id}"/>
                    <input type="submit" value="Create" class="button is-primary"/>
                </form:form>
                
                <div class = "has-text-danger">
                    <p><form:errors path="tvshow.*"/></p>
                </div>
            </div>
            <div class="column">    
            </div>
        </div>


    </div>
</body>
</html>