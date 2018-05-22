<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Crack the Code!</title>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <style>
            .wrapper {
                margin: 0px auto;
                padding: 0px;
                text-align: center;
            }
            .error {
                color: red;
            }

        </style>
    </head>
    <body>
        <div = "wrapper">
            <p class="error">${error}</p>
            <h2>What is the code?</h2>
            <form action="/trycode" method="post">
                <textarea name="code"></textarea><br>
                <button type="submit">Try Code</button>
            </form>
        </div>
    </body>
</html>