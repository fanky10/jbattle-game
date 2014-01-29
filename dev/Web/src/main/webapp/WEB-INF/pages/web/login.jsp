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
	<div class="clasic-login col-md-7">
		<p class="disclaimer">To start playing you must Log in first...</p>
		<h2>Login</h2>
		<form name='f' action="<c:url value='j_spring_security_check' />"
		method='POST'>
	 		<ul>
	 			<li class="col-md-5 col-xs-6">
	 				<label>User:</label>
				</li>
				<li class="col-md-5 col-xs-6">
					<label>Password:</label>
				</li>
				<li class="col-md-5 col-xs-6">
					<input class="form-control" type='text' name='j_username' value=''>
				</li>
				<li class="col-md-5 col-xs-6">
					<input class="form-control" type='password' name='j_password' />
				</li>
				<li class="col-md-2 col-xs-4">
					<input class="btn btn-default" name="submit" type="submit" value="submit" />
				</li>
				<li class="col-md-12 col-xs-8">
					<a href="<c:url value="/signup"/>">I dont want a bloody social account</a>
				</li>
			</ul>
		</form>
	</div>
	<div class="social-login col-md-5">
		<p class="disclaimer">...Or, you can also Login with your social account.</p>
		<h2>Social Login</h2>
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