<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
	<jsp:include page="./../../common/head.jsp" />
	<title>${bien.typeOperation} ${bien.typeBien} ${bien.ville}(${bien.codePostal}) ${bien.superficie} m2</title>
</head>
<body>
	<spring:url value="/users/photo" var="userPhotoUrl" />	
	<spring:url value="/biens/photo" var="photoUrl" />
	<spring:url value="/biens/upload/{bienId}/show.htm" var="addPhotoUrl">
		<spring:param name="bienId" value="${bien.id}" />
	</spring:url>
	<div id="wrap">
		<jsp:include page="../../common/menu.jsp" />
		<div id="content">
			<jsp:include page="../../common/sub-menu.jsp" />
			<div id="main">
					<jsp:include page="../../common/navigator.jsp" />					
			<div class="group">
				<h2>
					${bien.typeOperation} ${bien.typeBien} ${bien.ville}(${bien.codePostal}) ${bien.superficie} m2
				</h2>				
				<div id="single_item_details">
						<div>
							<c:if test="${bien.typeOperation =='OFFRE_VENDRE' || bien.typeOperation =='DEMANDE_ACHAT'}">
							 	<div class="listingprices">
								 	<span class="price"><spring:message code="bien.prixVente" /> : ${bien.prixVente} </span> 
									<span class="pricesmall"><spring:message code="bien.honoraires" /> : ${bien.chargesMensuel} ${currency}</span>
								 </div>
							</c:if> 
							<c:if test="${bien.typeOperation =='OFFRE_LOCATION' || bien.typeOperation =='DEMANDE_LOCATION' }">
							<div class="listingprices">
							 	 <span class="price"><spring:message code="bien.loyerMensuel" /> : ${bien.loyerMensuel} ${currency} </span> 
								<span class="pricesmall"><spring:message code="bien.chargesMensuel" /> : ${bien.chargesMensuel} ${currency}</span>
								</div>
							</c:if>
						</div>
						<div id="adressediv">
									<p>
										${bien.adresse} 
									</p>
									<p>
										${bien.ville}(${bien.codePostal}) <br />
									</p>
						</div>
				</div>
				
				<div id="single_item_details">
					<div id="leftcolumn">
						<div id="carrousel">
							<c:if test="${fn:length(bien.photos) == 0 }">
								<img width="320" height="230"
									src='<c:url value="/resources/graphics/no-photos.jpg"/>'
									class="previewimg">
							</c:if>
							<c:if test="${fn:length(bien.photos) > 0 }">
								<c:forEach var="photo" items="${bien.photos}" varStatus="status">
									<div id="slide${status.count}" class="slide">
										<div class="visu">
											<img width="320" height="230"
												src="${photoUrl}/${bien.id}/${status.count}"
												class="previewimg"/>
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
						<div class="divdetails">
							 <table class="im12_detTabDetails">
								<tbody>
									<tr class="auto2010_detTabTR">
										<td class="auto2010_detTD1First"><spring:message code="bien.superficie" /></td>
										<td class="auto2010_detTD1First">${bien.superficie} m2</td>
									</tr>
									<c:if test="${not empty bien.proximite}">
										 <tr class="auto2010_detTabTR">
											 <td class="auto2010_detTD1First"><spring:message code="bien.proximite" /></td>
											 <td class="auto2010_detTD1First">${bien.proximite}</td>
									 	 </tr>
									</c:if>
									<c:if test="${bien.typeBien=='APPARTEMENT' || bien.typeBien=='MAISON'}">
									   <tr class="auto2010_detTabTR">
										 <td class="auto2010_detTD1First"><spring:message code="bien.nbPieces" /></td>
										 <td class="auto2010_detTD1First">${bien.nbPieces}</td>
									   </tr>
									  <c:if test="${ bien.cuisineEquipee}">	
									   <tr class="auto2010_detTabTR">
										 <td class="auto2010_detTD1First"><spring:message code="bien.cuisineEquipee" /></td>
										 <td class="auto2010_detTD1First">
										 		<img width="20" height="20"
													src='<c:url value="/resources/graphics/Checked.png"/>'>
												<%-- <spring:message code="yes" /> --%>
										</td>
									   	</tr>
									   </c:if>
									</c:if>
									<c:if test="${bien.typeBien=='APPARTEMENT' || bien.typeBien=='STUDIO' }">
										<tr class="auto2010_detTabTR">
											 <td class="auto2010_detTD1First"><spring:message code="bien.etage" /></td>
											 <td class="auto2010_detTD1First">${bien.etage}</td>
									 	 </tr>
									 	 <c:if test="${ bien.ascenseur}">	
									 	   <tr class="auto2010_detTabTR">
										  	<td class="auto2010_detTD1First"><spring:message code="bien.ascenseur" /></td>
											<td class="auto2010_detTD1First">
													<%-- <spring:message code="yes" /> --%>
													<img width="20" height="20"
													src='<c:url value="/resources/graphics/Checked.png"/>'>
											</td>
									  	  </tr>
									  	  </c:if>
									</c:if>
									
									<c:if test="${bien.typeBien=='APPARTEMENT' || bien.typeBien=='STUDIO' || bien.typeBien=='COMMERCE'  || bien.typeBien=='MAISON' }">
										 <tr class="auto2010_detTabTR">
											 <td class="auto2010_detTD1First"><spring:message code="bien.age" /></td>
											 <td class="auto2010_detTD1First">${bien.age}</td>
									 	 </tr>
									 	 <tr class="auto2010_detTabTR">
											 <td class="auto2010_detTD1First"><spring:message code="bien.etatBien" /></td>
											 <td class="auto2010_detTD1First">${bien.etatBien}</td>
									 	 </tr>
									</c:if>
									
								</tbody>
							 </table>
							</div>
						
				
					</div>
					<div id="rightcolumndetail">
							<p class="user">
								<spring:message code="bien.reference" />: ${bien.reference}
							</p>
							<p class="user">
								<spring:message code="date.miseajour" />: ${bien.dateMiseAjour}
							</p>
							<p class="decscription">
								${bien.description}
							</p>
							<div id="tabs">
								<div class="userDetails" >
										<c:if test="${empty user.photo }">
											<img width="130" height="130"  src='<c:url value="/resources/graphics/no-photos.jpg"/>' class="previewimg">
										</c:if>
										<c:if test="${not empty user.photo }">
											<img width="130" height="130" src="${userPhotoUrl}/${user.id}" class="previewimg">
										</c:if>
										<p>
											${user.firstName} (${user.typeUser})
										</p>
										<p>
											${user.contact.telephoneMobile }
										</p>
								</div> 
								<div id="tabs-1" class="hiddentab">
									<p>
										<img src='<c:url value="/resources/graphics/fav.gif"/>'
											alt="FAv" width="18" height="13" />&nbsp;<a href="#">Add to my Favorites</a>
									</p>
									<p>
										<img src='<c:url value="/resources/graphics/emailalert.gif"/>'
											alt="email" width="18" height="15" />&nbsp;<a href="#">Contact by 
											Email</a>
									</p>
									<p>
										<img src='<c:url value="/resources/graphics/sms.gif"/>'
											alt="sms" width="18" height="16" />&nbsp;<a href="#">Contact by
											SMS</a>
									</p>
								</div>
							</div>
					</div>
					<div class="clear">&nbsp;</div>
						<div class="barreoutils">
									<ul class="barreoutilsgardez flor">
										<li>
											<span class="listbuttons"> <spring:url
													value="/biens/{bienId}/edit.htm" var="bienUrl">
													<spring:param name="bienId" value="${bien.id}" />
												</spring:url> <a href="${fn:escapeXml(bienUrl)}">Edit Bien</a>
											</span>
										</li>
										<li>
											<span class="listbuttons"> <spring:url value="/biens/{bienId}/delete.htm" var="bienUrl">
												<spring:param name="bienId" value="${bien.id}" />
											</spring:url> <a href="${fn:escapeXml(bienUrl)}">Delete bien</a></span>
										</li>
										<li>
											<span class="listbuttons"> <a
												href="${fn:escapeXml(bienslistUrl)}"><spring:message code="user.action.showbienlist" /></a>
											</span>
										</li>
									</ul>
									<div class="fin"></div>
						</div>
					</div>
					</div>
						
						<div class="group">
							<h2>More infos</h2>
							<div id="listing_details">
						  <table>
							<tr>
								<td>
									<spring:message code="bien.status" />
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
									${bien.transport}
								</td>
							</tr>

							<c:if test="${(bien.typeBien=='APPARTEMENT' || bien.typeBien=='STUDIO') && bien.gardien}">
								<tr>
									<td>
										<spring:message code="bien.gardien" />
									</td>
									<td>
										<%-- <spring:message code="yes" /> --%>
										<img width="40" height="40"
													src='<c:url value="/resources/graphics/Checked.png"/>'>
									</td>
								</tr>
							</c:if>
							<c:if test="${bien.typeBien=='MAISON' && bien.jardin}">
								<tr>
									<td>
										<spring:message code="bien.jardin" />
									</td>
									<td>
										<img width="40" height="40"
													src='<c:url value="/resources/graphics/Checked.png"/>'>
										
									</td>
								</tr>
							</c:if>
							<c:if test="${bien.typeBien=='MAISON' && bien.piscine}">
								<tr>
									<td>
										<spring:message code="bien.piscine" />
									</td>
									<td>
										<img width="40" height="40"
													src='<c:url value="/resources/graphics/Checked.png"/>'>
									</td>
								</tr>
							</c:if>
							<c:if test="${(bien.typeBien=='APPARTEMENT' || bien.typeBien=='STUDIO') && bien.adapteHandicape  }">
								<tr>
									<td>
										<spring:message code="bien.adapteHandicape" />
									</td>
									<td>
										<img width="40" height="40"
													src='<c:url value="/resources/graphics/Checked.png"/>'>
									</td>
								</tr>
								</c:if>
							<c:if test="${bien.typeBien=='APPARTEMENT' || bien.typeBien=='STUDIO' || bien.typeBien=='COMMERCE'  || bien.typeBien=='MAISON' }">
								<c:if test="${bien.nbTerrasses > 0}">
									<tr>
										<td>
											<spring:message code="bien.nbTerrasses" />
										</td>
										<td>
											${bien.nbTerrasses}
										</td>
									</tr>
								</c:if>		
								<c:if test="${bien.nbBalcons > 0}">							
									<tr>
										<td>
											<spring:message code="bien.nbBalcons" />
										</td>
										<td>
											${bien.nbBalcons}
										</td>
									</tr>
								</c:if>
								<c:if test="${bien.nbParkingInt > 0}">		
									<tr>
										<td>
											<spring:message code="bien.nbParkingInt" />
										</td>
										<td>
											${bien.nbParkingInt}
										</td>
									</tr>
								</c:if>
								<c:if test="${bien.nbParkingExt > 0}">		
							  	 <tr>
									<td>
										<spring:message code="bien.nbParkingExt" />
									</td>
									<td>
										${bien.nbParkingExt}
									</td>
								 </tr>
								</c:if>
								<c:if test="${ bien.interphone}">		
								 <tr>
									<td>
										<spring:message code="bien.interphone" />
									</td>
									<td>
													<img width="40" height="40"
													src='<c:url value="/resources/graphics/Checked.png"/>'>
									</td>
								 </tr>
								</c:if>
								<c:if test="${ bien.digicode}">	
								 <tr>
									<td>
										<spring:message code="bien.digicode" />
									</td>
									<td>
										<img width="40" height="40"
													src='<c:url value="/resources/graphics/Checked.png"/>'>
									</td>
								 </tr>
								</c:if>
								<c:if test="${ bien.meuble}">	
								 <tr>
									<td>
										<spring:message code="bien.meuble" />
									</td>
									<td>
										<img width="40" height="40"
													src='<c:url value="/resources/graphics/Checked.png"/>'>
									</td>
								 </tr>
								</c:if>
								<tr>
									<td>
										<spring:message code="bien.typeEauChaude" />
									</td>
									<td>
										${bien.typeEauChaude}
									</td>
								</tr>
								<tr>
									<td>
										<spring:message code="bien.natureChauffage" />
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
										${bien.typeChauffage}
									</td>
								</tr>
							</c:if>
						</table>
					</div>	
						<c:if test="${bien.typeBien=='APPARTEMENT' || bien.typeBien=='STUDIO' || bien.typeBien=='COMMERCE'  || bien.typeBien=='MAISON' }">
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
						</c:if>			
					</div>			
			</div>
		<div id="home_sidebar">
				<div class="block advert">
	
					 <img src='<c:url value="/resources/graphics/advertisehere.jpg"/>'
						alt="Advertise Here" style="width: 315px;" /> 
					<%-- <jsp:include page="./../immobilier/right-side-recherche.jsp" /> --%>
				</div>
				<jsp:include page="./../../common/slide-right.jsp" />
		</div>
	</div>
		<div class="clear">&nbsp;</div>
		<div class="clear">&nbsp;</div>
		<jsp:include page="../../common/footer.jsp" />
	</div>
</body>
</html>
