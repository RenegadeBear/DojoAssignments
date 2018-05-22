<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
<link type="text/css" rel="stylesheet" href="/css/style.css">
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
</head>
<body>
    <section class="hero">
        <div class="hero-body">
            <div class="container">
                <h1 class="title"><c:out value="${event.name}"></c:out></h1>
                <div class = "columns">
                    <div class ="column">
                        <p>Host: ${event.host.getFirst_name()} ${event.host.getLast_name()}</p>
                        <p>Date: ${event.eventDate}</p>
                        <p>Location: ${event.location}, ${event.state.getName()}</p>
                        <p>People who are attending this event: ${event.users.size()}</p>
                        <table>
                            <tr>
                                <th>Name</th>
                                <th>Location</th>
                            </tr>
                                <c:forEach items="${event.users}" var="attendee">
                                <tr>
                                    <td>${attendee.getFirst_name()} ${attendee.getLast_name()}</td>
                                    <td>${attendee.getCity()}</td>
                                </tr>
                                </c:forEach>                    
                        </table>
                    </div>
                    <div class = "column">
                        <h2 class="title">Message Wall</h2>
                        <c:forEach items="${usercomments}" var="comm">
                            <p>${comm.text} - ${comm.user.getFirst_name()}</p>
                        </c:forEach>
                        <div class = "box">

                        </div>
                        <h4>Add Comment ${currentUser.first_name}:</h4>
                        <form:form method="POST" action="/comment" modelAttribute="comment">

                            <form:input path="text" type="textarea"/>
                            
                            <input type="hidden" path="user" name="user" value="${currentUser.id}"/>
                            <input type="hidden" path="event" name="event" value="${event.id}"/>
                            <br>
                            <button type="submit" class="button is-info">Submit Comment</button>
                        </form:form>
                    </div>
                    <div class = "has-text-danger">
                        <p><form:errors path="comment.*"/></p>
                    </div>
            </div>
            <a href="/">Dashboard</a>
            </div>
        </div>
    </section>

    </body>
</html>