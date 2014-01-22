<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<html>

<%-- i18n handling --%>
<spring:message code="home.goback" var="goHome" />
<c:url value="${homeURL}" var="hrefHome"/>
<head>
<title>
	${statusCode} - ${title}
</title>

</head>
<body>
	<h1>${statusCode} - ${title}</h1>
	<h3>${label}</h3>
	<p>${body}</p>
	<!--
    
    Exception Message:  ${exceptionObject.message}
    Exception StackTrace:
    <c:forEach items="${exceptionObject.stackTrace}" var="ste">    
    	${ste} 
    </c:forEach>
    
    -->
	
	<a class="btn_med_blue" href="${hrefHome}"><span>${goHome}</span></a>
</body>
</html>