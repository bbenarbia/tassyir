<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<!-- <link rel="shortcut icon"   href="graphics/tassyir-icone.ico" /> -->
<link rel="stylesheet" href="<c:url value="/stylesheets/style.css"/>"
	type="text/css" />

<link rel="stylesheet" href="<c:url value="/stylesheets/carroussel.css"/>"
	type="text/css" />
		
<script type="text/javascript" src="scripts/jquery-1.9.1.js"> </script>
<script type="text/javascript" src="scripts/carroussel.js"> </script>

</head>
<body>

	<jsp:include page="common/menu.jsp"/>
	<jsp:include page="common/carroussel.jsp"/>
	
</body>
</html>