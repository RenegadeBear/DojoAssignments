<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <title>New Ninja</title>
</head>
<body>
    <h1>New Ninja</h1>
    <fieldset>
        <legend>Add New Ninja</legend>
        <form:form method="POST" action="/addninja" modelAttribute="newninja">
            <p>Dojo</p>
            <form:select path="dojo">
                <c:forEach items="${dojos}" var="dojo">
                    <form:option value="${dojo.id}">${dojo.name}</form:option>
                </c:forEach>
            </form:select>
            <br><br>
            <form:label path="first_name">First Name:
            <form:errors path="first_name"/>
            <form:input path="first_name"/></form:label>
            <br><br>

            <form:label path="last_name">Last Name:
            <form:errors path="last_name"/>
            <form:input path="last_name"/></form:label>
            <br><br>
            Date of Birth
            <input type="date" name="DATEOFBIRTH"/>
            <br><br>

            <input type="submit" value="Create"/>
        </form:form>
    </fieldset>
</body>
</html>