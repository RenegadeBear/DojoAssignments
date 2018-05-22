<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <title>New Dojo</title>
    <style>
        .red {
            color: red;
        }
    </style>
</head>
<body>
    <h1>New Dojo</h1>
     <fieldset>
        <legend>Add a New Dojo</legend>
        <br>
        <form:form method="POST" action="/adddojo"  modelAttribute="newdojo">
            <form:label path="name">Name
            <form:input path="name"/></form:label>
            <div class="red"><form:errors path="name"/></div>
            <br><br>            
            <input type="submit" value="Create"/>
            <br><br>
        </form:form>
    </fieldset>
    <a href = "/"><button>Back</button></a>
    <a href = "/ninja/new">New Ninja</a>

        
</body>
</html>