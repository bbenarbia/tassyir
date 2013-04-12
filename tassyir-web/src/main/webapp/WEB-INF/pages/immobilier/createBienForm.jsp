<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<jsp:include page="./../common/head.jsp" />
</head>
<body>
	<spring:url value="/biens/photo" var="photoUrl" />
	<spring:url value="/biens/upload/{bienId}/show.htm" var="addPhotoUrl">
		<spring:param name="bienId" value="${bien.id}" />
	</spring:url>
	<div id="wrap">
		<jsp:include page="../common/menu.jsp" />
		<div id="content">
			<jsp:include page="../common/sub-menu.jsp" />
			<div id="main">
				<h1>
					<spring:message code="bien.information" />
				</h1>
				<div id="midraw_details">
					<div class="listingbtns">
						<span class="listbuttons"> <spring:url
								value="/biens/appartement/new.htm" var="createAppartUrl">
							</spring:url> <a href="${fn:escapeXml(createAppartUrl)}">Create appartement</a>
						</span> 
						<span class="listbuttons"> <spring:url
								value="/biens/studio/new.htm" var="createStudiotUrl">
							</spring:url> <a href="${fn:escapeXml(createStudiotUrl)}">Create Studio</a>
						</span> 
					</div>

					<div class="clear">&nbsp;</div>
				</div>
			</div>
		</div>
		<div class="clear">&nbsp;</div>
		<div class="clear">&nbsp;</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>