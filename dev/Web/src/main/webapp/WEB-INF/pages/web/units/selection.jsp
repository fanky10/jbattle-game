<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>

<content tag="title">Unit Selection!</content>
<content tag="styles"> <%-- some link rel to this page in specific --%>
</content>
<content tag="jscriptlibs"> <%-- some jscript libraries rel to this page in specific --%>
</content>
<content tag="jscript"> <script type="text/javascript">
	$(document).ready(function() {
		var config = {
			'unitsSelected' : 0, //units count selection
			'maxSelectedUnits' : '${maxUnits}' //max unit selection
		};
		config.unitsSelected = $(".unitsSelection:checked").length;
		//this works!!
		$('.unitsSelection').bind('click', function() {
			//could be checked here... and do nothing at all.
			if (config.unitsSelected == config.maxSelectedUnits) {
				if (this.checked) {
					this.checked = false;
					return;

				}
			}

			if (this.checked) {
				config.unitsSelected++;
			} else {
				config.unitsSelected--;
			}
		});
	});
</script> </content>

<content tag="bodyContent"> <c:set var="currentGameType"
	value="${requestScope['org.springframework.web.servlet.HandlerMapping.uriTemplateVariables']['gameType']}" />
<div class="unit-selection">
	<h2>Select your troop!</h2>
	<c:url var="formAction" value="/units/select/${currentGameType}" />
	<form:form method="POST" modelAttribute="selectUnitsForm"
		action="${formAction}">
		<div class="unit-list">

			<c:forEach var="unit" items="${availableUnits}">
				<div class="col-sm-4 col-md-4">
					<div class="unit">
						<h4>${unit.name}</h4>
						<div class="unit-status">
							<p>Health: ${unit.health }</p>
							<p>Damage: ${unit.damage }</p>
							<p>Defense: ${unit.defense }</p>
							<p>Defense: ${unit.speed }</p>
						</div>
						<p>
							<form:checkbox class="unitsSelection" path="selectedUnits"
								value="${unit.name}" />
						</p>
					</div>
				</div>
			</c:forEach>
		</div>

		<button type="submit">Change Troop</button>
	</form:form>
</div>


</content>