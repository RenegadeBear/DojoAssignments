<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <title>${song.title}</title>
</head>
<body>
    <a href="/lookify">Dashboard</a><br><br>

    <h2>Title: ${song.title}</h2>
    <h2>Artist: ${song.artist}</h2>
    <h2>Rating (1-10): ${song.rating}</h2>

    <a href="/delete/${song.id}">Delete</a>
</body>
</html>