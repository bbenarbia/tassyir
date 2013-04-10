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

	<spring:url value="/biens/photo" var="photoUrl" />
	<spring:url value="/biens/upload/{bienId}/show" var="addPhotoUrl">
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
				<div id="single_item_details">
					<div id="leftcolumn">
						<div id="carrousel">
							<c:if test="${fn:length(bien.photos) == 0 }">
								<img width="220" height="220" src="${contextPath}/no-photos.jpg" class="previewimg">
							</c:if>
							<c:if test="${fn:length(bien.photos) > 0 }">
								<c:forEach var="photo" items="${bien.photos}" varStatus="status">
									<div id="slide${status.count}" class="slide">
										<div class="visu">
											<img width="220" height="220"
												src="${photoUrl}/${bien.id}/${status.count}" class="previewimg">
											<div class="title">
												<spring:url value="/biens/{bienId}/photo/delete/{photoId}"
													var="deletePhotoUrl">
													<spring:param name="photoId" value="${photo.id}" />
													<spring:param name="bienId" value="${bien.id}" />
												</spring:url>
												<span class="listbuttons"><spring:url value="/biens/new"
													var="bienUrl" /><a href="${fn:escapeXml(deletePhotoUrl)}">Delete the 
													photo</a> 
												</span>
											</div>
										</div>
									</div>
								</c:forEach>
							</c:if>
						</div>
					</div>

					<div id="rightcolumn">
						<h2>${bien.name}</h2>
						<p class="user">
							<img src="${contextPath}/usericon.gif" alt="user" />
							<spring:message code="bien.reference" />
							: ${bien.reference}
						</p>
						<p>
							<spring:message code="bien.departement" />
							:${bien.departement.name}(${bien.departement.reference})
						</p>
						<p>&nbsp;</p>
						<p class="price">
							<spring:message code="bien.prixVente" />
							: ${bien.prixVente}
						</p>

						<div id="tabs">
							<ul>
								<li><a href="#tabs-1">Save This</a></li>
								<li><a href="#tabs-2">Send This</a></li>
								<li><a href="#tabs-3">Report This</a></li>
							</ul>
							<div id="tabs-1" class="hiddentab">
								<p>
									<img src="${contextPath}/fav.gif" alt="FAv" width="18" height="13" />&nbsp;<a
										href="#">To My Favorites</a>
								</p>
								<p>
									<img src="${contextPath}/emailalert.gif" alt="email" width="18"
										height="15" />&nbsp;<a href="#">To Email Alerts</a>
								</p>
								<p>
									<img src="${contextPath}/sms.gif" alt="sms" width="18" height="16" />&nbsp;<a
										href="#">To SMS Alerts</a>
								</p>
							</div>
							<div id="tabs-2" class="hiddentab">
								<p>
									<img src="${contextPath}/emailalert.gif" alt="email" width="18"
										height="15" />&nbsp;<a href="#">By Email</a>
								</p>
								<p>
									<img src="${contextPath}/sms.gif" alt="sms" width="18" height="16" />&nbsp;<a
										href="#">By SMS</a>
								</p>
							</div>
							<div id="tabs-3" class="hiddentab">
								<p>
									<img src="${contextPath}/graphics/emailalert.gif" alt="email" width="18"
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
								value="/biens/{bienId}/edit" var="bienUrl">
								<spring:param name="bienId" value="${bien.id}" />
							</spring:url> <a href="${fn:escapeXml(bienUrl)}">Edit Bien</a>
						</span>

						<c:if test="${fn:length(bien.photos) < 5 }">
							<span class="listbuttons"> <a
								href="${fn:escapeXml(addPhotoUrl)}">Add photo</a>
							</span>
						</c:if>

						<span class="listbuttons"><spring:url value="/biens/new"
								var="bienUrl" /> <a href="${fn:escapeXml(bienUrl)}">Add
								Bien</a> </span> <span class="listbuttons"> <spring:url
								value="/biens/{bienId}/delete" var="bienUrl">
								<spring:param name="bienId" value="${bien.id}" />
							</spring:url> <a href="${fn:escapeXml(bienUrl)}">Delete bien</a></span>
					</div>

					<div id="imagesgallerylisting">
						<div class="imagegallink">
							<a href="#">view Image Gallery</a> <span>${fn:length(bien.photos)} photos</span>
						</div>
					</div>
					<div class="clear">&nbsp;</div>
				</div>

				<div id="moredetails">
					<div id="listing_details">
						<table>
							<tr>
								<td><h3>Details Bien</h3></td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td><ul>
										<li><spring:message code="bien.adresse" />: <c:out
												value="${bien.adresse}" /></li>
										<li><spring:message code="bien.superficie" />: <c:out
												value="${bien.superficie} m²" /></li>
										<li><spring:message code="bien.status" /> : <c:out
												value="${bien.status}" /></li>
										<li><spring:message code="bien.prixMinVente" />: <c:out
												value="${bien.prixMinVente}" /></li>
										<li><spring:message code="bien.loyerMensuel" />: <c:out
												value="${bien.loyerMensuel}" /></li>
										<li><spring:message code="bien.chargesMensuel" />: <c:out
												value="${bien.chargesMensuel}" /></li>
										<li><spring:message code="bien.typeOperation" />: <c:out
												value="${bien.typeOperation}" /></li>
										<li><spring:message code="bien.etatBien" />: <c:out
												value="${bien.etatBien}" /></li>
									<c:if test="${bien.typeBien=='APPARTEMENT' || bien.typeBien=='STUDIO' }">
											<li><spring:message code="bien.etage" />: <c:out
													value="${bien.etage}" /></li>
											<c:choose>
													<c:when test="${bien.gardien}">
														<li> <spring:message code="bien.gardien" />:Oui </li>
													</c:when>
											</c:choose>													
											<li><spring:message code="bien.ascenseur" />: <c:choose>
													<c:when test="${bien.ascenseur==false}">Oui </c:when>
													<c:otherwise>Non </c:otherwise>
												</c:choose></li>
									</c:if>		
									</ul></td>
								<td></td>
								<td><ul>
										<c:if test="${bien.typeBien=='APPARTEMENT' || bien.typeBien=='MAISON'}">
											<li><spring:message code="bien.nbPieces" />: <c:out
													value="${bien.nbPieces}" /><li>
											<c:choose>
													<c:when test="${bien.cuisineEquipee}">
														<li> <spring:message code="bien.cuisineEquipee" />:Oui </li>
													</c:when>
											</c:choose>
										</c:if>
										<c:if test="${bien.typeBien=='MAISON'}">
											<c:choose>
													<c:when test="${bien.jardin}">
														<li> <spring:message code="bien.jardin" />:Oui </li>
													</c:when>
											</c:choose>
											<c:choose>
													<c:when test="${bien.piscine}">
														<li> <spring:message code="bien.piscine" />:Oui </li>
													</c:when>
											</c:choose>
										</c:if>
										<c:if test="${bien.typeBien=='APPARTEMENT' || bien.typeBien=='STUDIO' || bien.typeBien=='COMMERCE'  || bien.typeBien=='MAISON' }">
											<li><spring:message code="bien.age" />: <c:out
													value="${bien.age}" /></li>
											<c:choose>
													<c:when test="${bien.nbTerrasses != 0 }">
														<li><spring:message code="bien.nbTerrasses" />:
															<c:out value="${bien.nbTerrasses}" />
														</li>
													</c:when>
											</c:choose>
											<c:choose>
													<c:when test="${bien.nbBalcons != 0 }">
														<li><spring:message code="bien.nbBalcons" />:
															<c:out value="${bien.nbBalcons}" />
														</li>
													</c:when>
											</c:choose>
											<c:choose>
													<c:when test="${bien.nbParkingInt != 0 }">
														<li><spring:message code="bien.nbParkingInt" />:
															<c:out value="${bien.nbParkingInt}" />
														</li>
													</c:when>
											</c:choose>
											<c:choose>
													<c:when test="${bien.nbParkingExt != 0 }">
														<li><spring:message code="bien.nbParkingExt" />:
															<c:out value="${bien.nbParkingExt}" />
														</li>
													</c:when>
											</c:choose>
											<c:choose>
													<c:when test="${bien.interphone}">
														<li> <spring:message code="bien.interphone" />:Oui </li>
													</c:when>
											</c:choose>
											<c:choose>
													<c:when test="${bien.digicode}">
														<li> <spring:message code="bien.digicode" />:Oui </li>
													</c:when>
											</c:choose>
											<c:choose>
													<c:when test="${bien.meuble}">
														<li> <spring:message code="bien.meuble" />:Oui </li>
													</c:when>
											</c:choose>
											<li><spring:message code="bien.typeEauChaude" />: <c:out
												value="${bien.typeEauChaude}" /></li>
											<li><spring:message code="bien.natureChauffage" />: <c:out
												value="${bien.natureChauffage}" /></li>			
											
											<li><spring:message code="bien.typeChauffage" />: <c:out
												value="${bien.typeChauffage}" /></li>
											<li><spring:message code="bien.consoEnergie" />: <c:out
												value="${bien.consoEnergie}" /></li>	
											
											<li><spring:message code="bien.impactConso" />: <c:out
												value="${bien.impactConso}" /></li>
														
										</c:if>			
									</ul></td>
							</tr>
						</table>
					</div>

				</div>
				
				<div id="moredetails">
					<div id="listing_details">
						<table>
							<tr>
								<td><h3>Details Bien</h3></td>
							</tr>
							<tr>
								<td>
									<img width="220" height="220" src="${contextPath}/graphics/dpe1.jpg" class="previewimg">
								</td>
							</tr>
							<tr>
								<td>
									<img width="220" height="220" src="${contextPath}/graphics/dpe2.jpg" class="previewimg">
								</td>
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
