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
		<h4>A game to play!</h4>
		<p>This game is so much fun!, create your own Troop and battle your friends!!</p>
	</div>
	<div class="join-battlegame col-md-4">
		<h2>Join Battlegame</h2>
		<p>Click here to <a href="#">Log In</a></p>
		<p>Click here to <a href="#">Sign Up</a></p>
		<p>Get Social!!!</p>
	</div>
	<div class="game-info col-md-12">
		<p>Test our 3vs3 and 5vs5 Game Modes, crush your enemies to win awesome rewards (Thropies, monney, new Troops, whatever!!!)</p> 
	</div>
</content>