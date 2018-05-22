<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <title>New License</title>
</head>
<body>
    <h1>New License</h1>
    <fieldset>
        <legend>Generate a License</legend>
        <form:form method="POST" action="/newlicense" modelAttribute="generate">
            <p>Person</p>
            <form:select path="person">
                <c:forEach items="${people}" var="x">
                    <form:option value="${x.id}">${x.first} ${x.last}</form:option>
                </c:forEach>
            </form:select>
            <br><br>
            <form:label path="state">State
            <form:errors path="state"/>
            <form:input path="state"/></form:label>
            <br><br>

            <input type="submit" value="Create"/>
        </form:form>
    </fieldset>
</body>
</html>