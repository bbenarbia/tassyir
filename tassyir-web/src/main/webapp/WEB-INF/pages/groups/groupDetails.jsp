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

<link rel="stylesheet"
	href="<c:url value="/stylesheets/carroussel.css"/>" type="text/css" />
<script type="text/javascript" src="scripts/jquery-1.9.1.js">
	
</script>
<script type="text/javascript" src="scripts/carroussel.js">
	
</script>
</head>
<body>
	<spring:url value="/groups/photo" var="photoUrl" />
		<spring:url value="/groups/upload/{groupId}/show" var="addPhotoUrl">
		<spring:param name="groupId" value="${group.id}" />
	</spring:url>
	
	<div id="wrap">
		<jsp:include page="../common/menu.jsp" />
		<div id="content">
			<jsp:include page="../common/sub-menu.jsp" />
			<div id="main">
				<h1>
					Name of group
				</h1>
				<div id="single_item_details">
					<div id="leftcolumn">
						<div id="carrousel">
							<c:if test="${empty group.photo }">
								<img width="220" height="220" src="../graphics/no-photos.jpg" class="previewimg">
							</c:if>
							<c:if test="${not empty group.photo }">
								<img width="220" height="220" src="${photoUrl}/${group.id}" class="previewimg">
							</c:if>
						</div>
					
					</div>
					<div id="rightcolumn">
						<h2>${group.name}</h2>
						<p class="user">
							<img src="../graphics/usericon.gif" alt="user" />
							group:  ${group.name}
						</p>

						<div id="tabs">
							<ul>
								<li><a href="#tabs-1">Save This</a></li>
								<li><a href="#tabs-2">Send This</a></li>

								<li><a href="#tabs-3">Report This</a></li>
							</ul>
							<div id="tabs-1" class="hiddentab">
								<p>
									<img src="../graphics/fav.gif" alt="FAv" width="18" height="13" />&nbsp;<a
										href="#">To My Favorites</a>
								</p>
								<p>
									<img src="../graphics/emailalert.gif" alt="email" width="18"
										height="15" />&nbsp;<a href="#">To Email Alerts</a>
								</p>
								<p>
									<img src="../graphics/sms.gif" alt="sms" width="18" height="16" />&nbsp;<a
										href="#">To SMS Alerts</a>
								</p>
							</div>
							<div id="tabs-2" class="hiddentab">
								<p>
									<img src="../graphics/emailalert.gif" alt="email" width="18"
										height="15" />&nbsp;<a href="#">By Email</a>
								</p>
								<p>
									<img src="../graphics/sms.gif" alt="sms" width="18" height="16" />&nbsp;<a
										href="#">By SMS</a>
								</p>
							</div>
							<div id="tabs-3" class="hiddentab">
								<p>
									<img src="../graphics/emailalert.gif" alt="email" width="18"
										height="15" />&nbsp;<a href="#">Report Spam</a>
								</p>
							</div>
						</div>

					</div>
					<div class="clear">&nbsp;</div>
				</div>
				<div id="midraw_details">
					<div class="listingbtns">
						<span class="listbuttons"> <spring:url
								value="/groups/{groupId}/edit" var="groupUrl">
								<spring:param name="groupId" value="${group.id}" />
							</spring:url> <a href="${fn:escapeXml(groupUrl)}">Edit Group</a>
						</span> <span class="listbuttons"> <spring:url value="/groups/new"
								var="groupUrl" /> <a href="${fn:escapeXml(groupUrl)}">Add
								Group</a></span> <span class="listbuttons"> <spring:url
								value="/groups/{groupId}/delete" var="groupUrl">
								<spring:param name="groupId" value="${group.id}" />
							</spring:url> <a href="${fn:escapeXml(groupUrl)}">Delete Group</a></span> 
							<span class="listbuttons"> <a
									href="${fn:escapeXml(addPhotoUrl)}">Select/modify photo</a>
							</span>
					</div>
					<div id="imagesgallerylisting">
						<div class="imagegallink">
							<a href="#">view Image Gallery</a> <span>12 Images
								Submitted</span>
						</div>
					</div>
					<div class="clear">&nbsp;</div>
				</div>
				
				<div id="moredetails">
					<div id="listing_details">
						<table>
							<tr>
								<td><h3><spring:message code="group.roles" /></h3></td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td><ul>
									<c:forEach var="role" items="${group.roles}" varStatus="status">
										<li>${status.count} : <c:out value="${role.name}" /></li>
									</c:forEach>
									</ul></td>
							</tr>
						</table>
					</div>

				</div>

			</div>
		</div>

		<div class="clear">&nbsp;</div>
		<div class="clear">&nbsp;</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>


