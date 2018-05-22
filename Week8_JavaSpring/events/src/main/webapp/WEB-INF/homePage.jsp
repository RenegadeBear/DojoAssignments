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
            <h1 class="title">Welcome <c:out value="${currentUser.first_name}"></c:out>!</h1>
            
            <form id="logoutForm" method="POST" action="/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" value="Logout!" style="float:right;" />
            </form>

            </div>
        </div>
    </section>
    <div class="container">
    <div class="notification"


  <section class="section">
    <div class="container">
      <h4 class="title is-4">Here are some of the events in your state:</h4>
     
 
          <table class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
            <tr>
                <th>Name</th>
                <th>Date</th>
                <th>Location</th>
                <th>Host</th>
                <th>Action/Status</th>
            </tr>
            <c:forEach items="${localevents}" var="local">
                <tr>
                    <td><a href="/event/${local.id}">${local.name}</a></td>
                    <td>${local.eventDate}</td>
                    <td>${local.location}</td>
                    <td>${local.host.getFirst_name()}</td>
                    <td>
                        <c:if test= "${local.host.id==currentUser.id}">
                            <a href="#">Edit</a> <a href="#">Delete</a>
                        </c:if>

                        <c:if test = "${local.host.id!=currentUser.id}">

                                <c:if test="${local.getUsers().contains(currentUser)}">    
                                    Joined  <a href="/${local.id}/${currentUser.username}/cancel">Cancel</a>
                                </c:if>
                                <c:if test="${!local.getUsers().contains(currentUser)}"> 
                                    <a href="/${local.id}/${currentUser.username}/join">Join</a>
                                </c:if>
                        </c:if> 
                    </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </section>

    <section class="section">
        <div class="container">
            <h4 class="title is-4">Here are some events in other states:</h4>
            <table class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
                <tr>
                    <th>Name</th>
                    <th>Date</th>
                    <th>Location</th>
                    <th>State</th>
                    <th>Host</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${distantevents}" var="distant">
                    <tr>
                        <td><a href="event/${distant.id}">${distant.name}</a></td>
                        <td>${distant.eventDate}</td>
                        <td>${distant.location}</td>
                        <td>${distant.state.getName()}</td>
                        <td>${distant.host.getFirst_name()}</td>
                        <td>
                            <c:if test= "${distant.host.id==currentUser.id}">
                                <a href="#">Edit</a> <a href="#">Delete</a>
                            </c:if>

                            <c:if test = "${distant.host.id!=currentUser.id}">

                                    <c:if test="${distant.getUsers().contains(currentUser)}">    
                                        Joined  <a href="/${distant.id}/${currentUser.username}/cancel">Cancel</a>
                                    </c:if>
                                    <c:if test="${!distant.getUsers().contains(currentUser)}"> 
                                        <a href="/${distant.id}/${currentUser.username}/join">Join</a>
                                    </c:if>
                            </c:if> 
                        </td>
                    </tr>

                </c:forEach>
            </table>
        </div>
    </section>

        <section class="section">
    <div class="container">
        <fieldset>
            <legend>Create an Event</legend>
            <form:form method="POST" action="/event" modelAttribute="newevent">
                <form:label path="name">Name</form:label>
                <form:input path="name"/><br><br>

                <form:label path="eventDate">Date</form:label>
                <form:input path="eventDate" type="date"/><br><br>

                <form:label path="location">Location</form:label>
                <form:input path="location"/>
                
                <form:select path="state">
                    <c:forEach items="${states}" var="st">
                        <option value="${st.id}">${st.name}</option>
                    </c:forEach>
                </form:select>
                <br><br>
                <input type="hidden" name="host" value="${currentUser.id}"/>
                <button type="submit" class="button is-info">Create Event</button>
            </form:form>
        </fieldset>
            <div class = "has-text-danger">
                <p><form:errors path="newevent.*"/></p>
            </div>
            <a href="/">Dashboard</a>

           </div>
  </section>
    </div>
</div>

        <!-- <fieldset> -->
            <!-- <label>First Name:</label>  <c:out value="${currentUser.first_name}"></c:out><br> -->
            <!-- <label>Last Name:</label>  <c:out value="${currentUser.last_name}"></c:out><br> -->
            <!-- <label>Email:</label>  <c:out value="${currentUser.username}"></c:out><br> -->
            <!-- <label>Sign up date:</label>  <c:out value="${currentUser.createdAt}"></c:out><br> -->
            <!-- <label>Last Sign in:</label>  <c:out value="${currentUser.last_sign_in}"></c:out> -->
        <!-- </fieldset> -->



</body>
</html>