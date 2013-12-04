<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>

<content tag="title">Unit Selection!</content>
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
		<h1>Game Mode: ${selectedGame.gameMode} - Type: ${selectedGame.gameType}</h1>
		<h2>Your Selected Units!</h2>
		<ul>
		<c:forEach var="unit" items="${selectedUnits}">
			<li>
			${unit.name}
			</li>
		</c:forEach>
	</div>
		
	</ul>
</content>