<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<s:url value="j_spring_security_logout" var="logout_url"/>

<sec:authorize access="isAuthenticated()">
	<p id="logout_paragraph"><a href="${logout_url}">Logout!</a></p>
</sec:authorize>