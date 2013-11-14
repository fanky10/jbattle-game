<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<html>
<head>
<title>
	<c:if test="${statusCode < 500}">Perdón - No hemos podido encontrar la página</c:if>
	<c:if test="${statusCode >= 500}">Perdón - Estamos teniendo dificultades técnicas </c:if>
</title>

</head>
<body>
	<c:if test="${statusCode < 500}">
		<h3>Perdón - No hemos podido encontrar la página</h3>
		<p>Dirección no encontrada.</p>
		
		
	</c:if>
	<c:if test="${statusCode >= 500}">
		<h3>Perdón - Estamos teniendo dificultades técnicas</h3>
		<p>Algo ha pasado de nuestro lado.</p>
	</c:if>
	<p>Por favor vuelva a la pagina de inicio.</p>
	<c:url var="homeURL" value="/home" ></c:url>
	<a class="btn_med_blue" href="${homeURL}"><span>Volver a la página de inicio</span></a>
</body>
</html>