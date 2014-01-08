<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>

<content tag="title">Un titulo</content>
<content tag="styles">
	<%-- some link rel to this page in specific --%>	
</content>
<content tag="jscriptlibs">
	<%-- some jscript libraries rel to this page in specific --%>	
</content>
<content tag="jscript">
	<script type="text/javascript" src="<c:url value="/js/app.js"/>"></script>
</content>

<content tag="bodyContent">
	<div class="jumbotron">
		<h2>Welcome to The Battlegame!!!</h2>
		<h3>A game to play!</h3>
		<p>This game is so much fun!, create your own Troop and battle your friends!!</p>
		<c:choose>
		<c:when test="${empty profile}">
			<form action="<c:url value="/connect/facebook" />" method="POST">
			    <p>You haven't created any connections with Facebook yet. Click the button to create
			       a connection between your account and your Facebook profile.</p>
			    <p><button type="submit"></button></p>
			</form>
		</c:when>
		<c:otherwise>${profile.firstName}</c:otherwise>
		</c:choose>
	</div>
</content>