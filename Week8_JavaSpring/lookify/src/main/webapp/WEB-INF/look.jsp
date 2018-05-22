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
        table {
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        tr:nth-child(even) {
            background-color: lightcoral;
            }
        ul, li {
            display: flex;
            list-style-type: none;
            padding: 5px;
        }
        form {
            display: flex;
        }
    </style>
</head>
<body>
    <div class="wrapper">
        <div class="header">
            <ul>
                <li><a href="/addsong">Add New</a></li>
                <li><a href="/topten">Top Songs</a></li>
            </ul>
            <fieldset data-function="all">
                <legend>Search by Artist</legend>
                <form action="/search" method="get">
                    <% if(request.getParameter("query") != null) { %>
                        <input type="text" name="query" placeholder="artist" value='<%= request.getParameter("q") %>'>
                    <% } else { %>
                        <input type="text" name="query" placeholder="artist">
                    <% } %>
                    <button type="submit">Search</button>
                </form>
            </fieldset>
        </div>
        <br>

        <table>
            <tr>
                <th>Title</th>
                <th>Artist</th>
                <th>Rating</th>
                <th>actions</th>
            </tr>
            <c:forEach items="${viewall}" var="record">
                <tr>
                    <td><a href="/show/${record.id}">${record.title}</a></td>
                    <td>${record.artist}</td>
                    <td>${record.rating}</td>
                    <td><a href ="delete/${record.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div> 


</body>
</html>