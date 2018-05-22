<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Lookify!</title>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <style>
        .red {
            color: red;
            display: flex;
        }
        .header {
            display: flex;
        }
    </style>
</head>
<body>
<fieldset>
        <legend>Add a New Song</legend>
        <br>
        <form:form method="POST" action="/add"  modelAttribute="newsong">
            <form:label path="title">Title
            <form:input path="title"/></form:label>
            <div class="red"><form:errors path="title"/></div>
            <br><br>
            <form:label path="artist">Artist
            <form:input path="artist"/></form:label>
            <div class="red"><form:errors path="artist"/></div>
            <br><br>

            
            <form:label path="rating">Rating
            <form:input type="number" min="1" max="10" path="rating"/></form:label>
            <div class="red"><form:errors path="rating"/></div>
            <br><br>
            <input type="submit" value="Submit"/>

        </form:form>
    </fieldset>
    <a href = "/lookify"><button>Back</button></a>
</body>

</html>