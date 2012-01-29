<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<div class="show-glitcher">
	<h2>User information for ${glitcher.username}</h2>
	<table class="glitcher-information">
		<tbody>
			<tr>
				<td>User name:</td>
				<td>${glitcher.username}</td>
			</tr>
			<tr>
				<td>Full name:</td>
				<td>${glitcher.fullname}</td>
			</tr>
		</tbody>
	</table>
	<h2>The last ${glitches.size()} glitches glitched by this user</h2>
	<p>
		<s:url value="/glitchers/{glitchername}/glitches?new" var="newGlitchUrl">
			<s:param name="glitchername" value="${glitcher.username}"/>
		</s:url>
		<a href="${newGlitchUrl}">Create a new Glitch</a>
	</p>
	<ul class="glitches-list">
		<c:forEach var="glitch"	items="${glitches}">
			<li>${glitch.content}</li>
		</c:forEach>
	</ul>
</div>