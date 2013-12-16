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
				$.each(data.content,function(i,item){
					if(item.status == "ATTACKING"){
						liClass = "Your-Team";
					}else if(item.status == "UNDER ATTACK"){
						liClass = "Enemy-Team";
					}else{
						liClass = "Battle-Result";
					}
					$("#responseMessage ul").append("<li class="+liClass+">"+item.message+"</li>");});
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
<c:set var="currentGameType" value="${requestScope['org.springframework.web.servlet.HandlerMapping.uriTemplateVariables']['gameType']}" />
        
	<div class="jumbotron battle-view">
		<h3>Game Mode: ${selectedGame.gameMode} - Type: ${selectedGame.gameType}</h3>
		<h3>Battlefield: ${selectedGame.battlefield}</h3>
		<div class="battle-group col-sm-12 col-md-6">
			<h4>Your Selected Units!</h4>
			<ul>
			<c:if test="${empty selectedUnits}">
				<form method="GET" action="<c:url value="/units/select/${currentGameType}"/>">
				    <button type="submit">You do not have any troops... Select them!</button>
				</form>
			</c:if>
			<c:forEach var="unit" items="${selectedUnits}">
				<li>
				${unit.name}
				</li>
			</c:forEach>
			</ul>
		</div>
		<div class="battle-group col-sm-12 col-md-6">
			<h4>Foe Selected Units!</h4>
			<ul>
			<c:forEach var="unit" items="${foeSelectedUnits}">
				<li>
				${unit.name}
				</li>
			</c:forEach>
			</ul>
		</div>
		<div class="actions">
			<button classs="take-battle" onclick="getEvents(this); return false;">Battle!</button>
			<button class="skip-battle" onclick="location.reload(false); return false;">Other Battlefield!</button>
			<form method="GET" action="<c:url value="/units/select/${currentGameType}"/>">
			    <button type="submit">Change Troop</button>
			</form>
		</div>
		<div id="responseMessage"></div>
	</div>
		
	</ul>
</content>