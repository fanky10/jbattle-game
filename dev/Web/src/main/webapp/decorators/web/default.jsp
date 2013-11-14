<%----------------------------------------------------------------------------------------
  ----------------------------------------------------------------------------------------
  ||  This is the desktop and tablet decorator!!  
   ---------------------------------------------------------------------------------------%>

<!doctype html>
<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<%@ page language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.regex.*"%>

<%----------------------------------------------------------------------------------------
   Setup global server site variables 
   ---------------------------------------------------------------------------------------%>


    <%-- Device detection via request headers --%>    
    <%
    // mobile = iPod, iPhone, Android +mobile
    // tablet = iPad, Android -mobile, XOOM, Kindle
    String browser = ((String)request.getHeader("User-Agent")).toLowerCase();
    boolean tablet = browser.contains("ipad") || browser.contains("kindle") || browser.contains("xoom");
    if(!tablet){ tablet = browser.contains("android") && !browser.contains("mobile"); }
    if(!tablet){ tablet = browser.contains("android 3"); }
    request.setAttribute("isTablet", tablet);
    %>



<%----------------------------------------------------------------------------------------
   Setup IE classes
   ---------------------------------------------------------------------------------------%>

    <!--[if lt IE 7]> <html class="no-js ie lt-ie10 lt-ie9 lt-ie8 lt-ie7" lang="${fn:toLowerCase(currentLanguage)}"> <![endif]-->
    <!--[if IE 7]>    <html class="no-js ie lt-ie10 lt-ie9 lt-ie8" lang="${fn:toLowerCase(currentLanguage)}"> <![endif]-->
    <!--[if IE 8]>    <html class="no-js ie lt-ie10 lt-ie9" lang="${fn:toLowerCase(currentLanguage)}"> <![endif]-->
    <!--[if IE 9]>    <html class="no-js ie lt-ie10" lang="${fn:toLowerCase(currentLanguage)}"> <![endif]-->
    <!--[if gt IE 9]><!-->
    <html class="no-js" lang="es">
    <!--<![endif]-->
    <head>



    
<%----------------------------------------------------------------------------------------
   Page Meta data
   ---------------------------------------------------------------------------------------%>
    <meta charset="utf-8">
    <title><decorator:title /></title>
   	<decorator:getProperty property="page.headerTags" />
   	<link href="<c:url value="/images/foundation/orbit/favicon.ico"/>" rel="shortcut icon" type="image/vnd.microsoft.icon" />


<%----------------------------------------------------------------------------------------
   Load Cascade Style Sheets
   ---------------------------------------------------------------------------------------%>    
    <jsp:include page="/WEB-INF/pages/web/common/baseStyles.jsp" />
    <decorator:getProperty property="page.styles" />

<%----------------------------------------------------------------------------------------
   Load Scripts
   ---------------------------------------------------------------------------------------%>    
    <%-- Typekit --%>
    <%-- Setup variables needed for tracking and load scode --%>
	<script type="text/javascript">
	                 
	</script>
	<%-- common --%>
	<jsp:include page="/WEB-INF/pages/web/common/baseJScripts.jsp" />
	<%-- specific --%>
  	<decorator:getProperty property="page.jscriptlibs" />
  	<%-- written --%>
  	<decorator:getProperty property="page.jscript" />
<decorator:head />       
</head>


<%----------------------------------------------------------------------------------------
   Add attributes to the body tag needed
   ---------------------------------------------------------------------------------------%>
<body >
<%----------------------------------------------------------------------------------------
   Prompt IE 6 users to install Chrome Frame.
   ---------------------------------------------------------------------------------------%>

    <!--[if lt IE 7]><p class=chromeframe>Your browser is <em>ancient!</em> <a href="http://browsehappy.com/">Upgrade to a different browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to experience this site.</p><![endif]-->



<%----------------------------------------------------------------------------------------
   Remove the header for print pages (applies to tire details and dealers pages)
   ---------------------------------------------------------------------------------------%>
    
    <c:set var="currentURL">${pageContext.request.requestURL}</c:set>
    <c:if test="${not fn:contains(currentUrl, 'printable')}">
        <%@ include file="/WEB-INF/pages/web/common/header.jsp"%>
    </c:if>

<%----------------------------------------------------------------------------------------
    Include the page content and footer
   ---------------------------------------------------------------------------------------%>

    <decorator:extractProperty property="page.bodyContent"></decorator:extractProperty>

    <%@ include file="/WEB-INF/pages/web/common/footer.jsp"%>

<%----------------------------------------------------------------------------------------
    Include dependent scripts defined in the JSP
   ---------------------------------------------------------------------------------------%>
        
    <decorator:extractProperty property="page.jscript" />
     

</body>
</html>