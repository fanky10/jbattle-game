<div id="wrap">
	<div class="container">
		<div class="header">
			<h1><a href="#">The Battlegame</a></h1>
		</div>
		<div class="row">
			<nav class="navbar navbar-default" role="navigation">
			  <!-- Brand and toggle get grouped for better mobile display -->
			  <div class="navbar-header">
			    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			      <span class="sr-only">Toggle navigation</span>
			      <span class="icon-bar"></span>
			      <span class="icon-bar"></span>
			      <span class="icon-bar"></span>
			    </button>
			    <!-- <a class="navbar-brand" href="#">Battlegame</a> -->
			  </div>
			  
			  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			    <ul class="nav navbar-nav">
			      <li><a href="#">Your Account</a></li>
			      <li class="dropdown">
			        <a href="#" class="dropdown-toggle active" data-toggle="dropdown">Battle <b class="caret"></b></a>
			        <ul class="dropdown-menu">
			          <li><a href="<c:url value="/auth/game/ia/3v3" />">IA - 3v3</a></li>
			          <li><a href="<c:url value="/auth/game/ia/5v5" />">IA - 5v5</a></li>
			          <li class="divider"></li>
			          <li><a href="#">PVP - 3v3</a></li>
			          <li><a href="#">PVP - 5v5</a></li>
			        </ul>
			      </li>
			      <li class="dropdown">
			        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Your Team <b class="caret"></b></a>
			        <ul class="dropdown-menu">
			          <li><a href="<c:url value="/units/select/3v3" />">Select your (3v3) Troop</a></li>
			          <li><a href="<c:url value="/units/select/5v5" />">Select your (5v5) Troop</a></li>
			          <li><a href="#">Select Formation</a></li>
			          <li><a href="#">Something else here</a></li>
			          <li class="divider"></li>
			          <li><a href="#">Separated link</a></li>
			          <li class="divider"></li>
			          <li><a href="#">One more separated link</a></li>
			        </ul>
			      </li>
			      <li><a href="#">Store</a></li>
			    </ul>
	
			    <form class="navbar-form navbar-right" role="search">
				   <div class="form-group">
				     <input type="text" class="form-control" placeholder="Search">
				   </div>
				   <button type="submit" class="btn btn-default">Submit</button>
				 </form>
			   </div><!-- /.navbar-collapse -->
			</nav>
		</div>
