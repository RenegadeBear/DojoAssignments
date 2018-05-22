<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>New Person</title>
  
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
</head>
<body>
    <h1>New Person</h1>

    <fieldset>
        <legend>Add a New Person</legend>
        <br>
        <form:form method="POST" action="/addperson"  modelAttribute="new">
            <form:label path="first">First Name
            <form:input path="first"/></form:label>
            <div class="red"><form:errors path="first"/></div>
            <br><br>
            <form:label path="last">Last Name
            <form:input path="last"/></form:label>
            <div class="red"><form:errors path="last"/></div>
            <br><br>

            <input type="submit" value="Submit"/>
            <br><br>
        </form:form>
    </fieldset>
    <a href = "/"><button>Back</button></a>
    <a href = "#">New License</a>


</body>
</html>