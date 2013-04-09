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
<script type="text/javascript" src="../scripts/jquery-1.9.1.js">
	
</script>
<script type="text/javascript" src="../scripts/carroussel.js">
	
</script>

</head>
<body>
	<spring:url value="/users/photo" var="photoUrl" />
	<spring:url value="/users/upload/{userId}/show" var="addPhotoUrl">
		<spring:param name="userId" value="${user.id}" />
	</spring:url>
	
	
	<div id="wrap">
		<jsp:include page="../common/menu.jsp" />
		<div id="content">
			<jsp:include page="../common/sub-menu.jsp" />
			<div id="main">
				<h1>
					<spring:message code="user.information" />
				</h1>
				<div id="single_item_details">
					<div id="leftcolumn">
						<div id="carrousel">
							<c:if test="${empty user.photo }">
								<img width="220" height="220" src="../graphics/no-photos.jpg" class="previewimg">
							</c:if>
							<c:if test="${not empty user.photo }">
								<img width="220" height="220" src="${photoUrl}/${user.id}" class="previewimg">
							</c:if>
						</div>
					</div>
					<div id="rightcolumn">
						<h2>${user.firstName} ${user.lastName}</h2>
						<p class="user">
							<img src="../graphics/usericon.gif" alt="user" />
							<spring:message code="user.login" />
							${user.login}
						</p>
						<p>
							<spring:message code="user.code" />
							# :${user.code} <br /> Created On : put the date here
						</p>
						<p>&nbsp;</p>
						<p class="price">
							<spring:message code="user.group" />
							: ${user.userCategory.name}
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
								value="/users/{userId}/edit" var="userUrl">
								<spring:param name="userId" value="${user.id}" />
							</spring:url> <a href="${fn:escapeXml(userUrl)}">Edit User</a>
						</span> <span class="listbuttons"> <spring:url value="/users/new"
								var="userUrl" /> <a href="${fn:escapeXml(userUrl)}">Add
								User</a></span> <span class="listbuttons"> <spring:url
								value="/users/{userId}/delete" var="userUrl">
								<spring:param name="userId" value="${user.id}" />
							</spring:url> <a href="${fn:escapeXml(userUrl)}">Delete User</a></span> <span
							class="listbuttons"> <spring:url
								value="/users/{userId}/editpassword" var="editPasswordUrl">
								<spring:param name="userId" value="${user.id}" />
							</spring:url> <a href="${fn:escapeXml(editPasswordUrl)}">Edit password</a></span>
							
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
								<td><h3>Details Contact</h3></td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td><ul>
										<li><spring:message code="contact.name" />:<c:out value="${user.contact.name}" /></li>
										<li><spring:message code="contact.nomSocieteContact" />
											: <c:out value="${user.contact.nomSocieteContact}" /></li>
										<li><spring:message code="contact.typeContact" /> <c:out
												value="${user.contact.typeContact}" /></li>
										<li><spring:message code="contact.adresseContact1" /> <c:out
												value="${user.contact.adresseContact1}" /></li>
										<li><spring:message code="contact.alerteSurTelephone1" /> <c:out
												value="${user.contact.alerteSurTelephone1}" /></li>
										<li><spring:message code="contact.alerteSurTelephone2" /> <c:out
												value="${user.contact.alerteSurTelephone2}" /></li>
									</ul></td>
									<td></td>
								<td><ul>
										<li><spring:message code="contact.codePostal" /> <c:out
												value="${user.contact.codePostalContact}" /></li>
										<li><spring:message code="contact.ville" /> <c:out
												value="${user.contact.villeContact}" /></li>
										<li><spring:message code="contact.adresseMailContact" /> <c:out
												value="${user.contact.adresseMailContact}" /></li>
										
										<li><spring:message code="contact.siteWebContact" /> <c:out
												value="${user.contact.siteWebContact}" /></li>
										<li><spring:message code="contact.telephone1" /> <c:out
												value="${user.contact.telephoneContact1}" /></li>
										<li><spring:message code="contact.telephone2" /> <c:out
												value="${user.contact.telephoneContact2}" /></li>
									</ul></td>
							</tr>
						</table>
					</div>

				</div>
				
				<div id="moredetails">
					<div id="listing_details">
						<table>
							<tr>
								<td><h3><spring:message code="user.roles" /></h3></td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td><ul>
									<c:forEach var="role" items="${user.roles}" varStatus="status">
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