<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet" href="<c:url value="/stylesheets/style.css"/>"
	type="text/css" />

<link rel="stylesheet" href="<c:url value="/stylesheets/carroussel.css"/>"
	type="text/css" />		
<script type="text/javascript" src="scripts/jquery-1.9.1.js"> </script>
<script type="text/javascript" src="scripts/carroussel.js"> </script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="common/menu.jsp"/>
		<div id="content">
		
		<div id="content">
				<jsp:include page="common/sub-menu.jsp"/>

			<div id="home_main">
				<div id="search">
					<div class="tab">
						<h2>Search Property To Buy / Rent</h2>
					</div>
					<div class="container">
						<jsp:include page="common/carroussel.jsp"/>
					</div>
				</div>
			</div>

			<div class="clear">&nbsp;</div>

			<div class="clear">&nbsp;</div>
		</div>
		
			
		</div>
		
		<div class="clear">&nbsp;</div>
		<div class="clear">&nbsp;</div>
		<jsp:include page="common/footer.jsp"/>
	</div>
</body>
</html>