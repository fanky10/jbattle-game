<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>

<content tag="title">Login</content>
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
<!-- spring messages customization -->
<spring:message code="login.header" var="msgLoginHeader" />
<spring:message code="login.username" var="msgUsername" />
<spring:message code="login.password" var="msgPassword" />
<spring:message code="login.signup" var="msgSignup" />
<spring:message code="login.error" var="msgError" />
<spring:message code="login.submit" var="msgSubmit" />
<spring:message code="login.socialMessage" var="msgSocialLogin" />
	<div class="jumbotron">
		<h2>${msgLoginHeader}</h2>
		<form name='f' action="<c:url value='j_spring_security_check' />"
		method='POST'>
 
		<table>
			<tr>
				<td>${msgUsername}</td>
				<td><input type='text' name='j_username' value=''>
				</td>
			</tr>
			<tr>
				<td>${msgPassword}</td>
				<td><input type='password' name='j_password' />
				</td>
			</tr>
			<tr>
				<td >
				<input name="submit" type="submit" value="${msgSubmit}" />
				
				</td>
				<td >
				<a href="<c:url value="/signup"/>">${msgSignup}</a>
				
				</td>
			</tr>
		</table>
		
	</form>
	
	<c:if test="${not empty param.status}">
		<div class="errorblock">
	    	${msgError}<br /> ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
	
	${msgSocialLogin}
	<form id="tw_signin" action="<c:url value="/signin/twitter"/>" method="POST">
		  <button type="submit">
		    <img src="<c:url value="/images/twitter_logo.png"/>" alt="Twitter"/>
		  </button>
		</form>
		<form id="fb_signin" action="<c:url value="/signin/facebook"/>" method="POST">
		  <button type="submit">
		    <img width="36" src="<c:url value="/images/facebook_logo.jpg"/>" alt="Facebook" />
		  </button>
		</form>
	
	</div>
</content>