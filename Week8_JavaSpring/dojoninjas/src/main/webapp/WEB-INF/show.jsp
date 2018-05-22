<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <title>Dojo Page</title>
</head>
<body>

    <h1>${dojo.name} Location Ninjas</h1>
    
    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Date of Birth</th>
            <th>Age</th>
        </tr>

        <c:forEach items="${ninjas}" var="ninja">
            <tr>
                <td>${ninja.first_name}</td>  
                <td>${ninja.last_name}</h4>
                <td>${ninja.dob}</h4>
                <td>${ninja.age}</h4>
            </tr>
        </c:forEach>
 
    </table>
</body>
</html>