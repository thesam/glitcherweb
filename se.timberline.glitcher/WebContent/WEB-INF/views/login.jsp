<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login to Glitcher</title>
</head>
<body>
	<h1>Sign in to Glitcher</h1>
	<p>
		If you're using Glitcher, then that's amazing... we don't support it yet.
	</p>
	
	<s:url value="/j_spring_security_check" var="authUrl"/>
	<form method="post" class="signing" action="${authUrl}">
		<p><label for="username">Username:</label><input type="text" id="username" name="j_username"><br>
		   <label for="password">Password:</label><input type="password" id="password" name="j_password"><br>
		   <input id="remember_me" name="_spring_security_remember_me" type="checkbox">
		   <label for="remember_me" class="inline">Remember me</label></p>
		<p><input type="submit" name="commit" value="Sign In"></p>
	</form>
	
	<s:url var="newGlitcher" value="/glitchers?new"/>
	<p>No glitcher yet? Sign up <a href="${newGlitcher}">here!</a></p>
	
	<script type="text/javascript">
		document.getElementById('username').focus();
	</script>
</body>
</html>