<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <title>Edit ${language.name}</title>

</head>
<body>
    <a href="/delete/${language.id}">Delete</a>
    <a href="/">Dashboard</a>
    <fieldset>
        <legend>Add a New Language</legend>
        <br>
        <form:form method="POST" action="/update/${language.id}"  modelAttribute="language">
            <form:label path="name">Name
            
            <form:input path="name"/></form:label>
            <br>
            <form:errors path="name"/>
            <br><br>
            <form:label path="creator">Creator
            
            <form:input path="creator"/>
            <form:errors path="creator"/>
            <br><br>
        </form:label>
            
            <form:label path="version">Version
            <form:errors path="version"/>
            <form:input path="version"/></form:label>
            <br><br>
            <input type="submit" value="Submit"/>

        </form:form>
    </fieldset>



</body>
</html>