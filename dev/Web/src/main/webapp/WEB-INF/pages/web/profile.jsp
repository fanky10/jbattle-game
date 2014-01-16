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
		<h2>This is your profile: ${profile.firstName} - ${profile.signInProvider}</h2>
		<a href="<c:url value="/logout"/>">Take me outta here!</a>
		<h3>In the future you are going to do awesome things here!</h3>
	</div>
</content>