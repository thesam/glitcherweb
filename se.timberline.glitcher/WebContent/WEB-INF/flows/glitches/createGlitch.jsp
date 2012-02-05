<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Glitch Creator</title>
</head>
<body>
	<h1>Create a new Glitch for ${glitcher.fullname}</h1>
	
	<sf:form commandName="glitch">
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
		
		<label for="content">Content:</label><br/>
		<sf:textarea path="content" id="content"/>
		
		<input type="submit" name="_eventId_save" value="Save"/>
	</sf:form>
</body>
</html>