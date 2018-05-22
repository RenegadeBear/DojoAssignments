<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Languages</title>
    <style>
        h1 {
            text-align: center;
        }
        table {
            border-collapse: collapse;
            width: 500px;
        }
        *{
            margin: 0px auto;
            padding: 0px;
            /* width: 500px; */
        }
        table, th, td {
            border: 1px solid black;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
            }
        fieldset {
            width: 500px;
            padding: 0px 0px 5px 10px;  
        }
        .red {
            color: red;
        }
    </style>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
</head>
<body>
    <h1>Languages</h1>
    <br>
    <table>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
            <th>action</th>
        </tr>
        <c:forEach items="${languages}" var="lang">
            <tr>
                <td><a href="/show/${lang.id}">${lang.name}</a></td>
                <td>${lang.creator}</td>
                <td>${lang.version}</td>
                <td><a href ="delete/${lang.id}">Delete</a> <a href ="edit/${lang.id}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
    
    <br>
    
    <fieldset>
        <legend>Add a New Language</legend>
        <br>
        <form:form method="POST" action="/addlang"  modelAttribute="language">
            <form:label path="name">Name
            <form:input path="name"/></form:label>
            <div class="red"><form:errors path="name"/></div>
            <br><br>
            <form:label path="creator">Creator
            <form:input path="creator"/>
            <div class="red"><form:errors path="creator"/></div>
            <br><br>
        </form:label>
            
            <form:label path="version">Version
            <form:input path="version"/></form:label>
            <div class="red"><form:errors path="version"/></div>
            <br><br>
            <input type="submit" value="Submit"/>

        </form:form>
    </fieldset>

</body>
</html>