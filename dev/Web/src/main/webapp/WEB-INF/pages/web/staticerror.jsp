<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<html>
<head>
<title>
	${statusCode} - ${title}
</title>

</head>
<body>
	<h1>${statusCode} - ${title}</h1>
	<h3>${label}</h3>
	<p>${body}</p>
	<c:url var="homeURL" value="/home" ></c:url>
	<a class="btn_med_blue" href="${homeURL}"><span>Get me back home</span></a>
</body>
</html>