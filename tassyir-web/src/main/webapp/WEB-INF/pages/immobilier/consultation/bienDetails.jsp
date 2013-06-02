<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<jsp:include page="./../../common/head.jsp" />
</head>
<body>
	<spring:url value="/biens/photo" var="photoUrl" />
	<spring:url value="/biens/upload/{bienId}/show.htm" var="addPhotoUrl">
		<spring:param name="bienId" value="${bien.id}" />
	</spring:url>
	<div id="wrap">
		<jsp:include page="../../common/menu.jsp" />
		<div id="content">
			<jsp:include page="../../common/sub-menu.jsp" />
			<div id="main">
				<div class="navig">
					<c:forEach var="navig" items="${navigations}" varStatus="status">
						&laquo;
						<spring:url value="${navig.url}" var="navigs" />
						<a href="${navigs}"><spring:message code="${navig.name}" /></a>
					</c:forEach>
				</div>
				<h1>
					<spring:message code="bien.information" />
				</h1>
				<div id="single_item_details">
					<div id="leftcolumn">
						<div id="carrousel">
							<c:if test="${fn:length(bien.photos) == 0 }">
								<img width="290" height="230"
									src='<c:url value="/resources/graphics/no-photos.jpg"/>'
									class="previewimg">
							</c:if>
							<c:if test="${fn:length(bien.photos) > 0 }">
								<c:forEach var="photo" items="${bien.photos}" varStatus="status">
									<div id="slide${status.count}" class="slide">
										<div class="visu">
											<img width="290" height="230"
												src="${photoUrl}/${bien.id}/${status.count}"
												class="previewimg">
											<div class="title">
												<spring:url value="/biens/{bienId}/photo/delete/{photoId}"
													var="deletePhotoUrl">
													<spring:param name="photoId" value="${photo.id}" />
													<spring:param name="bienId" value="${bien.id}" />
												</spring:url>
												<span class="listbuttons"><spring:url
														value="/biens/new.htm" var="bienUrl" /> <a
													href="delete.html">Delete the photo</a> </span>
											</div>
										</div>
									</div>
								</c:forEach>
							</c:if>
						</div>
					</div>
					<div id="rightcolumn">
						<div class="leftpart">
							<h2>${bien.name}</h2>
							<p class="user">
								<spring:message code="bien.reference" />
								: ${bien.reference}
							</p>
							<c:if test="${bien.typeOperation =='OFFRE_LOCATION' || bien.typeOperation =='DEMANDE_LOCATION' }">
								<p class="price">
									<spring:message code="bien.loyerMensuel" />
									: ${bien.loyerMensuel} ${currency}
								</p>
								<p class="price">
									<spring:message code="bien.chargesMensuel" />
									: ${bien.chargesMensuel} ${currency}
								</p>
							</c:if>
							<c:if test="${bien.typeOperation =='OFFRE_VENDRE' || bien.typeOperation =='DEMANDE_ACHAT'}">
								<p class="price">
									<spring:message code="bien.prixVente" />
									: ${bien.prixVente} ${currency}
								</p>
								<p class="price">
									<spring:message code="bien.honoraires" />
									: ${bien.honoraires} ${currency}
								</p>
							</c:if>
							<p>
								${bien.adresse.adresse} <br /> ${bien.adresse.codePostal} <br />
								${bien.adresse.ville}
							</p>
							<p>
								<spring:message code="bien.departement" />
								:${bien.departement.name}(${bien.departement.reference})
							</p>
							<p>
								${bien.description}
							</p>
							<div id="tabs">
								<div id="tabs-1" class="hiddentab">
									<p>
										<img src='<c:url value="/resources/graphics/fav.gif"/>'
											alt="FAv" width="18" height="13" />&nbsp;<a href="#">
											Add to my Favorites</a>
									</p>
									<p>
										<img src='<c:url value="/resources/graphics/emailalert.gif"/>'
											alt="email" width="18" height="15" />&nbsp;<a href="#">Contact annoncer by 
											Email</a>
									</p>
									<p>
										<img src='<c:url value="/resources/graphics/sms.gif"/>'
											alt="sms" width="18" height="16" />&nbsp;<a href="#">Contact annoncer by
											SMS Alerts</a>
									</p>
								</div>

							</div>
						</div>
						<div class="listingbtns">
							<span class="listbuttons"> <spring:url
									value="/biens/{bienId}/edit.htm" var="bienUrl">
									<spring:param name="bienId" value="${bien.id}" />
								</spring:url> <a href="${fn:escapeXml(bienUrl)}">Edit Bien</a>
							</span>
							<c:if test="${fn:length(bien.photos) < 5 }">
								<span class="listbuttons"> <a
									href="${fn:escapeXml(addPhotoUrl)}">Add photo</a>
								</span>
							</c:if>

							<span class="listbuttons"><spring:url
									value="/biens/new.htm" var="bienUrl" /> <a
								href="${fn:escapeXml(bienUrl)}">Add Bien</a> </span> <span
								class="listbuttons"> <spring:url
									value="/biens/{bienId}/delete.htm" var="bienUrl">
									<spring:param name="bienId" value="${bien.id}" />
								</spring:url> <a href="${fn:escapeXml(bienUrl)}">Delete bien</a></span> <span
								class="listbuttons"> <a
								href="${fn:escapeXml(bienslistUrl)}"><spring:message
										code="user.action.showbienlist" /></a>
							</span>
						</div>
					</div>
					<div class="clear">&nbsp;</div>
				</div>

				<div id="moredetails">
					<div id="listing_details">
						<table>
							<tr>
								<td>
									<spring:message code="bien.superficie" />
								</td>
								<td>
								:
								</td>
								<td>
									${bien.superficie} m²
								</td>
								<td>
									<spring:message code="bien.status" />
								</td>
								<td>
								:
								</td>
								<td>
									${bien.status}
								</td>
							</tr>
							<tr>
								<td>
									<spring:message code="bien.transport" />
								</td>
								<td>
								:
								</td>
								<td>
									${bien.transport}
								</td>
								<td>
									<spring:message code="bien.proximite" />
								</td>
								<td>
								:
								</td>
								<td>
									${bien.proximite}
								</td>
							</tr>
							
							<c:if test="${bien.typeBien=='APPARTEMENT' || bien.typeBien=='STUDIO' }">
								<tr>
									<td>
										<spring:message code="bien.etage" />
									</td>
									<td>
										:
									</td>
									<td>
										${bien.etage}
									</td>
									<td>
										<spring:message code="bien.gardien" />
									</td>
									<td>
									:
									</td>
									<td>
										<c:choose>
											<c:when test="${bien.gardien}">
													<li><spring:message code="yes" /></li>
											</c:when>
											<c:otherwise>
													<li><spring:message code="no" /></li>
											</c:otherwise>
										</c:choose>
									</td>
								</tr>
							</c:if>
							<c:if test="${bien.typeBien=='APPARTEMENT' || bien.typeBien=='MAISON'}">
								<tr>
									<td>
										<spring:message code="bien.nbPieces" />
									</td>
									<td>
									:
									</td>
									<td>
										${bien.nbPieces}
									</td>
									<td>
										<spring:message code="bien.nbChambres" />
									</td>
									<td>
									:
									</td>
									<td>
										${bien.nbChambres}
									</td>
								</tr>
							</c:if>
							
							<c:if test="${bien.typeBien=='MAISON'}">
								<tr>
									<td>
										<spring:message code="bien.jardin" />
									</td>
									<td>
									:
									</td>
									<td>
										<c:choose>
											<c:when test="${bien.jardin}">
													<li><spring:message code="yes" /></li>
											</c:when>
											<c:otherwise>
													<li><spring:message code="no" /></li>
											</c:otherwise>
										</c:choose>
									</td>
									<td>
										<spring:message code="bien.piscine" />
									</td>
									<td>
									:
									</td>
									<td>
										<c:choose>
											<c:when test="${bien.piscine}">
													<li><spring:message code="yes" /></li>
											</c:when>
											<c:otherwise>
													<li><spring:message code="no" /></li>
											</c:otherwise>
										</c:choose>
									</td>
									<td></td>
									<td></td>
								</tr>
							</c:if>
							<c:if test="${bien.typeBien=='APPARTEMENT' || bien.typeBien=='STUDIO' }">
								<tr>	
									<td>
										<spring:message code="bien.ascenseur" />
									</td>
									<td>
									:
									</td>
									<td>
										<c:choose>
											<c:when test="${bien.ascenseur}">
													<li><spring:message code="yes" /></li>
											</c:when>
											<c:otherwise>
													<li><spring:message code="no" /></li>
											</c:otherwise>
										</c:choose>
									</td>
									<td>
										<spring:message code="bien.adapteHandicape" />
									</td>
									<td>
									:
									</td>
									<td>
										<c:choose>
											<c:when test="${bien.adapteHandicape}">
													<li><spring:message code="yes" /></li>
											</c:when>
											<c:otherwise>
													<li><spring:message code="no" /></li>
											</c:otherwise>
										</c:choose>	
									</td>
								</tr>
								</c:if>
							<c:if test="${bien.typeBien=='APPARTEMENT' || bien.typeBien=='STUDIO' || bien.typeBien=='COMMERCE'  || bien.typeBien=='MAISON' }">
								<tr>
									<td>
										<spring:message code="bien.age" />
									</td>
									<td>
									:
									</td>
									<td>
										${bien.age}
									</td>
									<td>
										<spring:message code="bien.nbTerrasses" />
									</td>
									<td>
									:
									</td>
									<td>
										${bien.nbTerrasses}
									</td>
								</tr>
								<tr>
									<td>
										<spring:message code="bien.nbBalcons" />
									</td>
									<td>
									:
									</td>
									<td>
										${bien.nbBalcons}
									</td>
									
									<td>
										<spring:message code="bien.nbParkingInt" />
									</td>
									<td>
									:
									</td>
									<td>
										${bien.nbParkingInt}
									</td>
								</tr>
								<tr>
									<td>
										<spring:message code="bien.nbParkingExt" />
									</td>
									<td>
									:
									</td>
									<td>
										${bien.nbParkingExt}
									</td>
									<td>
										<spring:message code="bien.interphone" />
									</td>
									<td>
									:
									</td>
									<td>
										<c:choose>
											<c:when test="${bien.interphone}">
													<li><spring:message code="yes" /></li>
											</c:when>
											<c:otherwise>
													<li><spring:message code="no" /></li>
											</c:otherwise>
										</c:choose>
									</td>
								</tr>
								<tr>
									<td>
										<spring:message code="bien.digicode" />
									</td>
									<td>
									:
									</td>
									<td>
										<c:choose>
											<c:when test="${bien.digicode}">
													<li><spring:message code="yes" /></li>
											</c:when>
											<c:otherwise>
													<li><spring:message code="no" /></li>
											</c:otherwise>
										</c:choose>
									</td>
									<td>
										<spring:message code="bien.meuble" />
									</td>
									<td>
									:
									</td>
									<td>
										<c:choose>
											<c:when test="${bien.meuble}">
													<li><spring:message code="yes" /></li>
											</c:when>
											<c:otherwise>
													<li><spring:message code="no" /></li>
											</c:otherwise>
										</c:choose>
									</td>
								</tr>
								<tr>
									<td>
										<spring:message code="bien.typeEauChaude" />
									</td>
									<td>
									:
									</td>
									<td>
										${bien.typeEauChaude}
									</td>
									<td>
										<spring:message code="bien.natureChauffage" />
									</td>
									<td>
									:
									</td>
									<td>
										${bien.natureChauffage}
									</td>
								</tr>
								<tr>
									<td>
										<spring:message code="bien.typeChauffage" />
									</td>
									<td>
									:
									</td>								
									<td>
										${bien.typeChauffage}
									</td>
									<td>
									</td>
								</tr>
							</c:if>
							<tr>
								<td>
									<spring:message code="bien.etatBien" />
								</td>
								<td>
								:
								</td>
								<td colspan="4">
									${bien.etatBien}
								</td>
							</tr>
							<c:if test="${bien.typeBien=='APPARTEMENT' || bien.typeBien=='MAISON'}">
								<tr>
									<td>
										<spring:message code="bien.cuisineEquipee" />
									</td>
									<td>
									:
									</td>
									<td>
										<c:choose>
											<c:when test="${bien.cuisineEquipee}">
													<li><spring:message code="yes" /></li>
											</c:when>
											<c:otherwise>
													<li><spring:message code="no" /></li>
											</c:otherwise>
										</c:choose>
									</td>
								</tr>
							</c:if>	
							
						</table>
					</div>					
				</div>
				<c:if
					test="${bien.typeBien=='APPARTEMENT' || bien.typeBien=='STUDIO' || bien.typeBien=='COMMERCE'  || bien.typeBien=='MAISON' }">
					<div id="moredetails">
						<div id="listing_details">
							<table>
								<tr>
									<td><spring:message code="bien.consoEnergie" />: <c:out
											value="${bien.consoEnergie}" /></td>
									<td><spring:message code="bien.impactConso" />: <c:out
											value="${bien.impactConso}" /></td>
								</tr>
								<tr>
									<td><img width="220" height="220"
										src='<c:url value="/resources/graphics/dpe/DPE_${bien.consoEnergie}.jpg"/>'
										class="previewimg"></td>
									<td><img width="220" height="220"
										src='<c:url value="/resources/graphics/dpe/GES_${bien.consoEnergie}.jpg"/>'
										class="previewimg"></td>
								</tr>
							</table>
						</div>
					</div>
				</c:if>
			</div>
		</div>

		<div class="clear">&nbsp;</div>
		<div class="clear">&nbsp;</div>
		<jsp:include page="../../common/footer.jsp" />
	</div>
</body>
</html>
