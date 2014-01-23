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
	<div class="wellcome col-md-8">
		<h2>Welcome to The Battlegame!!!</h2>
		<h3>A game to play!</h3>
		<p>This game is so much fun!, create your own Troop and battle your friends!!</p>
	</div>
	<div class="join-battlegame col-md-4">
		<h2>Join Battlegame</h2>
		<p>Click here to <a href="#">Log In</a></p>
		<p>Click here to <a href="#">Sign Up</a></p>
	</div>
	<div class="game-info">
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
		
		</p>
	</div>
</content>