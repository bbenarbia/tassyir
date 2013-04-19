<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
	<jsp:include page="./common/head.jsp"/>
</head>
<body>
	<div id="wrap">
		<jsp:include page="./common/menu.jsp"/>
		<div id="content">

    <h2>Something happened...</h2>
		<img width="220" height="220" src='<c:url value="/resources/graphics/error.png"/>'  class="previewimg">
    <p>${exception.message}</p>

     Exception: ${exception.message}.
		  	<c:forEach items="${exception.stackTrace}" var="stackTrace"> 
				${stackTrace} 
			</c:forEach>

		<div class="clear">&nbsp;</div>
		<div class="clear">&nbsp;</div>
		<jsp:include page="./common/footer.jsp"/>
	</div>
	</div>
</body>
</html>