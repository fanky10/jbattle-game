<!doctype html>
<html class="no-js" lang="en">
<head>
	<meta charset="utf-8">
    <title><decorator:title /></title>
    
    <decorator:getProperty property="page.headerTags" />
    <decorator:getProperty property="page.styles" />
    <decorator:head />
    
    <script language="JavaScript" type="text/javascript">
        var url = "${fn:toLowerCase(pageContext.request.getRequestURI().replace('/','-'))}".replace(/^-|-$/g,"");
        var serverName = "${pageContext.request.getServerName()}";
        var region = "${fn:toLowerCase(currentCountry)}" || "us";
        var lang = "${fn:toLowerCase(currentLanguage)}" || "en";
        var channel = "mobile";
        var company = "${fn:toLowerCase(company)}" || serverName.indexOf("fire") >= 0 ? "fst" : "bst" 
        var sep = ":";
        var prefix = region + sep + lang + sep + channel + sep + company;              
    </script>
</head>

<body>
        <%@ include file="/WEB-INF/pages/mobile/common/header.jsp"%>

        <decorator:extractProperty property="page.bodyContent"></decorator:extractProperty>

        <%@ include file="/WEB-INF/pages/mobile/common/footer.jsp"%>
		<decorator:extractProperty property="page.jscript" />
        
    </body>
</html>

