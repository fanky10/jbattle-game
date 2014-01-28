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
			<form:input path="username" id="username"/>
			<form:errors id="usernameError" path="username" cssClass="error" />
			<br/>
		
			<label for="email">Email:</label>
			<form:input path="email" id="email"/>
			<form:errors id="emailError" path="email" cssClass="error" />
			<br/>
			 
			<label for="firstName" id="lblFirstname">First Name: </label>
			<form:input path="firstName" id="firstName"/>
			<form:errors id="firstNameError" path="firstName" cssClass="error" />
			<br/>
			 
			<label for="lastName" id="lblLastname">Last Name: </label>
			<form:input path="lastName" id="lastName"/>
			<form:errors id="lastNameError" path="lastName" cssClass="error" />
			<br/>
			
			<label for="password" id="lblPassword">Password:</label>
			<form:input path="password" type="password" id="password"/>
			<form:errors id="passwordError" path="password" cssClass="error" />
			<br/>
		
		   <input type="submit" value="submit"/>
		
		</form:form>
		
	</div>
</content>