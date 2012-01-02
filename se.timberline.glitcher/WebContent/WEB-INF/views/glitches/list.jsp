<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<h2>Glitches for ${glitcher.username}</h2>
	
	<table>
		<c:forEach items="${glitchList}" var="glitch">
			<tr>
				<td>
					<img src="<s:url value="/resources/images/glitcher_avatar.png"/>" width="48" height="48" />
				</td>
				<td>
					<a href="<s:url value="/glitchers/${glitch.glitcher.username}"/>">${glitch.glitcher.username}</a>
					<c:out value="${glitch.content}"/><br/>
					<c:out value="${glitch.updatedAt}"/>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>