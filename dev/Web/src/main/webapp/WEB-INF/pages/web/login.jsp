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
	<div class="jumbotron">
		<div>
			<h2>Login</h2>
			<form name='f' action="<c:url value='j_spring_security_check' />"
			method='POST'>
		 		<ul>
					<li>
						<label>User:</label>
						<input type='text' name='j_username' value=''>
					</li>
					<li>
						<label>Password:</label>
						<input type='password' name='j_password' />
					</li>
					<li>
						<input name="submit" type="submit" value="submit" />
						<a href="<c:url value="/signup"/>">I dont want a bloody social account</a>
					</li>
				</ul>
			</form>
		</div>
		<div>
			<h3>Social Login</h3>
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
	</div>	
</content>