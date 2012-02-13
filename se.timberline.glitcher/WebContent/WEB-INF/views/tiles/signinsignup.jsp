<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<s:url value="/signin" var="signin_url"/>
<s:url value="/glitchers?new" var="join_url"/>
<div id="signin-signup">
<sec:authorize access="isAnonymous()">
	<h2 id="signin-signup-header">Please sign in!</h2>
	<form method="POST" action="${signin_url}">
		<p>
		<label for="signin-username">Username</label>
		<input type="text" name="username" id="signin-username">
		</p>
		
		<p>
		<label for="signin-password">Password</label>
		<input type="text" name="password" id="signin-password">
		</p>
		
		<input type="submit">
	</form>
	
	<div id="signin-signup-no-account">
		<p>No account to log into? <a href="${join_url}">Sign in for free!</a></p>
	</div>
</sec:authorize>
</div>