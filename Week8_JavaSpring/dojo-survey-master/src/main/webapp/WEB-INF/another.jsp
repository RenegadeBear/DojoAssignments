<!DOCTYPE html>
<html>
<head>
	<title>Survey</title>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<h1>Dojo Survey</h1>
	
	<fieldset>
		<legend>Survey Results</legend>
		<ul>
			<li>Name: ${body.name}</li>
			<li>Location: ${body.location}</li>
			<li>Language: ${body.language}</li>
			<li>Comment: ${body.comment}</li>
		</ul>
		<a href="/"><button>Back</button></a>
	</fieldset>
	
</body>
</html>