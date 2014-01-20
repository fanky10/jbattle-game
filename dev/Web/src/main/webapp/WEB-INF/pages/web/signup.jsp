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
	
		<h2>Create your account :D</h2>
		<c:url var="formAction" value="/signup"/>
		
		<form:form method="POST" modelAttribute="userForm" action="${formAction}">
			<label for="username">Username:</label>
			<input name="username" type="text" id="username"/>
			<br/>
		
			<label for="email">Email:</label>
			<input name="email" type="text" id="email"/>
			<br/>
			 
			<label for="firstName" id="lblFirstname">First Name: </label>
			<input name="firstName" type="text" id="firstName"/>
			<br/>
			 
			<label for="lastName" id="lblLastname">Last Name: </label>
			<input name="lastName" type="text" id="lastName"/>
			<br/>
			
			<label for="password" id="lblPassword">Password:</label>
			<input name="password" type="password" id="password"/>
			<br/>
		
		   <input type="submit" value="submit"/>
		
		</form:form>
		
	</div>
</content>