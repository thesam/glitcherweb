<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Glitch Creator</title>
</head>
<body>
	<h1>Please, identify yourself!</h1>
	
	<sf:form>
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
		<label for="username">Username:</label><input type="text" name="username" id="username"/><br/>
		<label for="password">Password:</label><input type="text" name="password" id="password"/><br/>
		<input type="submit" name="_eventId_continue" value="Continue"/>
	</sf:form>
</body>
</html>