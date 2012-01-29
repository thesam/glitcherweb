<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div id="glitch-edit">
	<h2>Create a glitch for ${glitcher.username}</h2>

	<sf:form method="POST" modelAttribute="glitch">
		<sf:label path="content">Glitch content:</sf:label><br/>
		<sf:textarea path="content"/><br/>
		<sf:errors path="content" cssClass="error"/>
		<input type="submit"/>
	</sf:form>
</div>