<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>
	<h2>A global community of glitches and glitchers.</h2>
	<h3>Look at what these people are glitching out right now...</h3>

	<ol class="glitch-list"> 
	<c:forEach var="glitch"	items="${glitches}">
		<s:url value="/glitchers/{glitcherName}" var="glitcher_url">
			<s:param name="glitcherName" value="${glitch.glitcher.username}" />

		</s:url>
		<li>
			<span class="glitchListImage"> <img src="" width="48"
				border="0" align="middle"
				onError="this.src='<s:url value="/resources/images"/>/spitter_avatar.png';" />
			</span>
			<span class="glitchListText"> <a href="${glitch_url}"> <c:out
						value="${glitch.glitcher.username}" /></a> - <c:out
					value="${glitch.text}" /><br /> <small><fmt:formatDate
						value="${glitch.when}" pattern="hh:mma MMM d, yyyy" /></small>
			</span>
		</li>
	</c:forEach>
	</ol>
</div>