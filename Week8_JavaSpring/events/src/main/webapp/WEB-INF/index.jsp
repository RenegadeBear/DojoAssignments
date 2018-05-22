<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login & Registration</title>
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
<link type="text/css" rel="stylesheet" href="/css/style.css">
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
</head>
<body>

    <div class = "container">
        <div class = "columns">
            <div class = "column">
                <fieldset>
                <legend>Register!</legend>
                          
                <form:form method="POST" action="/registration" modelAttribute="user">
                    <p>
                        <form:label path="username">Email</form:label>
                        <form:input path="username"/>
                    </p>
                    <p>
                        <form:label path="first_name">First Name</form:label>
                        <form:input path="first_name"/>
                    </p>
                    <p>
                        <form:label path="last_name">Last Name</form:label>
                        <form:input path="last_name"/>
                    </p>
                    <p>
                        <form:label path="city">Location</form:label>
                        <form:input path="city"/>
                        <form:select path="state">
                            <c:forEach items="${states}" var="st">
                                <option value="${st.id}">${st.name}</option>
                            </c:forEach>
                        </form:select>
                    </p>
                    <p>
                        <form:label path="password">Password:</form:label>
                        <form:password path="password"/>
                    </p>
                    <p>
                        <form:label path="passwordConfirmation">Password Confirmation:</form:label>
                        <form:password path="passwordConfirmation"/>
                    </p>
                    <input type="submit" value="Register!"/>
                </form:form>
                </fieldset>
                <div class = "has-text-danger">
                    <p><form:errors path="user.*"/></p>
                </div>
               
               
            </div>


            <div class = "column">
                <div class = "has-text-danger">
                    <c:if test="${logoutMessage != null}">
                        <c:out value="${logoutMessage}"></c:out>
                    </c:if>
                </div>
                <fieldset>
                    <legend>Login</legend>
                    <c:if test="${errorMessage != null}">
                        <c:out value="${errorMessage}"></c:out>
                    </c:if>
                    <form method="POST" action="/login">
                        <p>
                            <label for="username">Email</label>
                            <input type="text" id="username" name="username"/>
                        </p>
                        <p>
                            <label for="password">Password</label>
                            <input type="password" id="password" name="password"/>
                        </p>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input type="submit" value="Login!"/>
                    </form>
                </fieldset>
            </div>
        </div>

    </div>


</body>
</html>