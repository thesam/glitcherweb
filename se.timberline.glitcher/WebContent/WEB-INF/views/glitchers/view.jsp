<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<h2>The last ${glitches.size()} glitches glitched by this user:</h2>
	<ul class="glitches-list">
		<c:forEach var="glitch"	items="${glitches}">
			<li>${glitch.content}</li>
		</c:forEach>
	</ul>
</div>