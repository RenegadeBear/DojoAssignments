<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <title>${language.name}</title>
</head>
<body>
    <a href="/">Dashboard</a><br><br>

    <h2>Name: ${language.name}</h2>
    <h2>Creator: ${language.creator}</h2>
    <h2>Version: ${language.version}</h2>

    <a href="/edit/${language.id}">Edit</a>
    <a href="/delete/${language.id}">Delete</a>
</body>
</html>