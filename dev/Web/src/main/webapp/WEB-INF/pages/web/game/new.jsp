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
	<script type="text/javascript" >
	function getEvents(element) {
		jsonData = {};
		$.ajax({
			contentType : 'application/json',
			data : JSON.stringify(jsonData),
			dataType : 'json',
			success : function(data) {
				$("#responseMessage").html(data.message);
				$("#responseMessage").append("<ul>");
				$.each(data.content,function(i,item){$("#responseMessage").append("<li>"+item.message+"</li>");});
				$("#responseMessage").append("</ul>");
			},
			error : function() {
				$("#responseMessage").html(
						"Failed response: " + data.message);
			},
			processData : false,
			type : 'POST',
			url : '${ctx}/game/events.json'
		});
	}
	</script>
</content>

<content tag="bodyContent">
	<div class="jumbotron">
		<h2>Game Mode: ${selectedGame.gameMode} - Type: ${selectedGame.gameType}</h2>
		<h2>Battlefield ${selectedGame.battlefield}</h2>
		<h2>Your Selected Units!</h2>
		<ul>
		<c:forEach var="unit" items="${selectedUnits}">
			<li>
			${unit.name}
			</li>
		</c:forEach>
		</ul>
		<h2>Foe Selected Units!</h2>
		<ul>
		<c:forEach var="unit" items="${foeSelectedUnits}">
			<li>
			${unit.name}
			</li>
		</c:forEach>
		</ul>
		<button onclick="getEvents(this); return false;">Battle!</button>
		<button>Other Battlefield!</button>
		<div id="responseMessage"></div>
	</div>
		
	</ul>
</content>