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
	<spring:message code="login.disclaimer" var="msgDisclaimer" />
	<spring:message code="login.socialDisclaimer" var="msgSocialDisclaimer" />
	<div class="clasic-login col-md-7">
		<p class="disclaimer">${msgDisclaimer}</p>
		<h2>${msgLoginHeader}</h2>
		<form name='f' action="<c:url value='j_spring_security_check' />"
		method='POST'>
	 		<ul>
	 			<li class="col-md-5 col-xs-6">
	 				<label>${msgUsername}</label>
				</li>
				<li class="col-md-5 col-xs-6">
					<label>${msgPassword}</label>
				</li>
				<li class="col-md-5 col-xs-6">
					<input class="form-control" type='text' name='j_username' value=''>
				</li>
				<li class="col-md-5 col-xs-6">
					<input class="form-control" type='password' name='j_password' />
				</li>
				<li class="col-md-2 col-xs-4">
					<input class="btn btn-default" name="submit" type="submit" value="${msgSubmit}" />
				</li>
				<li class="col-md-12 col-xs-8">
					<a href="<c:url value="/signup"/>">${msgSignup}</a>
				</li>
			</ul>
		</form>
		<c:if test="${not empty param.status}">
			<div class="errorblock">
		    	${msgError}<br /> ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
			</div>
		</c:if>
	</div>
	<div class="social-login col-md-5">
		<p class="disclaimer">${msgSocialDisclaimer}</p>
		<h2>${msgSocialLogin}</h2>
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