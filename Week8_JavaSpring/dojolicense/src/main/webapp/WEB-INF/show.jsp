<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <title>New License</title>
</head>
<body>

    <h1>${person.first} ${person.last}</h1>
    <h4>License Number: ${license.number}</h4>  
    <h4>State:  ${license.state}</h4>
    <h4>Expiration Date: ${license.expiration}</h4>  <br><br>

</body>
</html>