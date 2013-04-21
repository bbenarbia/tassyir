<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<jsp:include page="./../common/head.jsp"/>
</head>
<body>
	<div id="wrap">
		<jsp:include page="../common/menu.jsp" />
		<div id="content">
			<jsp:include page="../common/sub-menu.jsp" />

			<div id="home_main_edit_user">
				<div id="edit_user">
					<div class="tab">
						<h2><spring:message code="biens.appartement.action.edit" /></h2>
					</div>
					<div class="container">
						<form:form modelAttribute="bien" method="put" id="form1">
							<table class="edit_form_user" style="width: 100%; border: none;">
								<tr>
									<td class="label" style="width: 30px; "><form:label path="name"><spring:message code="biens.name" /></form:label></td>
									<td><label> <form:input label="name" path="name"
												class="text" />
									</label></td>
									<td class="label"><form:label path="reference"><spring:message code="biens.ref" /></form:label></td>
									<td><label> <form:input label="reference"
												path="reference" class="text smalltext" />
									</label></td>
								</tr>
							  <c:if test="${bien.typeOperation =='A_LOUER'}">
								<tr>
										<td class="label"><form:label path="loyerMensuel"><spring:message code="biens.loyerMensuel" /></form:label></td>
										<td><label> <form:input label="loyerMensuel"
													path="loyerMensuel" class="text smalltext" />
										</label></td>
	
										<td class="label"><form:label path="chargesMensuel"><spring:message code="biens.chargesMensuel" /></form:label></td>
										<td><label> <form:input label="chargesMensuel"
													path="chargesMensuel" class="text smalltext" />
										</label></td>
								</tr>
								 <tr>
									<td class="label"><form:label path="honoraires"><spring:message code="biens.honoraires" /></form:label></td>
									<td><label> <form:input label="honoraires"
												path="honoraires" class="text smalltext" />
									</label></td>
									<td class="label"><form:label path="depotGarantie"><spring:message code="biens.depotGarantie" /></form:label></td>
										<td><label> <form:input label="depotGarantie"
													path="depotGarantie" class="text smalltext" />
									</label></td>
							   </tr> 
							   
							   <tr>
									<td class="label"><form:label path="departement"><spring:message code="biens.departement" /></form:label></td>
										<td><label> 	
												<form:select path="departement"  class="select_field">
													<c:forEach var="item" items="${departementsList}">
														<c:choose>
															<c:when test="${departement == item.reference}">
																<form:option selected="true" value="${item.reference}">
										               				 ${item.name} 
										            			</form:option>
															</c:when>
															<c:otherwise>
																<form:option value="${item.reference}">
										                  			 ${item.name}
										            			</form:option>
															</c:otherwise>
														</c:choose>
												</c:forEach>
												</form:select>
									</label></td>
								</tr>	
								<tr>
								<td class="label"><form:label path="codePostal"><spring:message code="biens.codepostal" /></form:label></td>
										<td><label> 
											<form:input label="codePostal" path="codePostal"
													class="text smalltext" />										
									</label></td>
							
								<td class="label"><form:label path="ville"><spring:message code="biens.ville" /></form:label></td>
										<td><label> 
											<form:input label="ville" path="ville"
													class="text smalltext" />										
									</label></td>
								</tr>	
							 </c:if>
							 <c:if test="${bien.typeOperation =='A_VENDRE'}">
							   	<tr>
									<td class="label"><form:label path="prixVente"><spring:message code="biens.prixVente" /></form:label></td>
									<td><label> <form:input label="prixVente"
												path="prixVente" class="text smalltext" />
									</label></td>
									<td class="label"><form:label path="prixMinVente"><spring:message code="biens.prixVenteMin" /></form:label></td>
									<td><label> <form:input label="prixMinVente"
												path="prixMinVente" class="text smalltext" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="honoraires"><spring:message code="biens.honoraires" /></form:label></td>
									<td><label> <form:input label="honoraires"
												path="honoraires" class="text smalltext" />
									</label></td>
									<td class="label"><form:label path="depotGarantie"><spring:message code="biens.depotGarantie" /></form:label></td>
										<td><label> <form:input label="depotGarantie"
													path="depotGarantie" class="text smalltext" />
									</label></td>
							   </tr> 
							   <tr>
									<td class="label"><form:label path="departement"><spring:message code="biens.departement" /></form:label></td>
									<td><label> 	
												<form:select path="departement"  class="select_field">
													<c:forEach var="item" items="${departementsList}">
														<c:choose>
															<c:when test="${departement == item.reference}">
																<form:option selected="true" value="${item.reference}">
										               				 ${item.name} 
										            			</form:option>
															</c:when>
															<c:otherwise>
																<form:option value="${item.reference}">
										                  			 ${item.name}
										            			</form:option>
															</c:otherwise>
														</c:choose>
												</c:forEach>
												</form:select>
									</label></td>
								</tr>	
								<tr>
								<td class="label"><form:label path="ville"><spring:message code="biens.ville" /></form:label></td>
										<td><label> 
											<form:input label="ville" path="ville"
													class="text smalltext" />										
									</label></td>
									<td class="label"><form:label path="codePostal"><spring:message code="biens.codepostal" /></form:label></td>
									<td><label> 
												<form:input label="codePostal" path="codePostal"
														class="text smalltext" />										
									</label></td>
								</tr>	
							 </c:if>
								<tr>
									<td class="label"><form:label path="adresse"><spring:message code="biens.adresse" /></form:label></td>
									<td ><label> <form:textarea cols="19" rows="4"
												label="adresse" path="adresse" class="text textBoxfieldlong" />
									</label>
									</td>
									<td  class="label"><form:label path="description"><spring:message code="biens.description" /></form:label></td>
									<td ><label> <form:textarea cols="19" rows="4"
												label="description" path="description" class="text textBoxfieldlong" />
									</label>
									</td>
								</tr>
								<tr>
									<td class="label"><form:label path="age"><spring:message code="biens.age" /></form:label></td>
										<td><label> <form:input label="age" path="age"
													class="text smalltext" />
									</label></td>
									
									<td class="label"><form:label path="etage"><spring:message code="biens.etage" /></form:label></td>
										<td><label> 
											<form:input label="etage" path="etage"
													class="text smalltext" />										
									</label></td>
									
								</tr>						
								<tr>
									<td class="label"><form:label path="nbPieces"><spring:message code="biens.nbPieces" /></form:label></td>
									<td><label> 
										<form:input label="name" path="nbPieces"
												class="text" />										
									</label></td>
									<td class="label"><form:label path="nbChambres"><spring:message code="biens.nbChambres" /></form:label></td>
									<td><label> 
											<form:input label="name" path="nbChambres"
												class="text" />		
									</label></td>
									
								</tr>
								<tr>
									<td class="label"><form:label path="nbTerrasses"><spring:message code="biens.nbTerrasses" /></form:label></td>
										<td><label> 
											<form:input label="name" path="nbTerrasses"
												class="text" />		
									</label></td>
									<td class="label"><form:label path="nbBalcons"><spring:message code="biens.nbBalcons" /></form:label></td>
										<td><label> 
											<form:input label="name" path="nbBalcons"
												class="text" />	
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="nbParkingInt"><spring:message code="biens.nbParkingInt" /></form:label></td>
										<td><label> 
												<form:input label="name" path="nbParkingInt"
												class="text" />	
									</label></td>
									<td class="label"><form:label path="nbParkingExt"><spring:message code="biens.nbParkingExt" /></form:label></td>
										<td><label> 
											<form:input label="name" path="nbParkingExt"
												class="text" />												
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="nbCaves"><spring:message code="biens.nbCaves" /></form:label></td>
										<td><label> 
											<form:input label="name" path="nbCaves"
												class="text" />												
									</label></td>
									<td class="label"><form:label path="nbSallesBains" for="nbSallesBains"><spring:message code="biens.nbSallesBains" /></form:label></td>
									<td><label> 
										<form:input label="name" path="nbSallesBains"
												class="text" />		
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="transport"><spring:message code="biens.transport" /></form:label></td>
										<td><label> 
											<form:input label="name" path="transport"
												class="text" />												
									</label></td>
									<td class="label"><form:label path="proximite"><spring:message code="biens.proximite" /></form:label></td>
										<td><label> 
											<form:input label="name" path="proximite"
												class="text" />												
									</label></td>
								</tr>
								
								<tr>
									<td class="label"><form:label path="interphone"><spring:message code="biens.interphone" /></form:label></td>
										<td><label> 
											<form:checkbox path="interphone" />		
									</label></td>
									<td class="label"><form:label path="digicode"><spring:message code="biens.digicode" /></form:label></td>
										<td><label> 
											<form:checkbox path="digicode" />	
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="cuisineEquipee"><spring:message code="biens.cuisineEquipee" /></form:label></td>
									<td><label> 
										<form:checkbox path="cuisineEquipee" />									
									</label></td>
									<td class="label"><form:label path="gardien"><spring:message code="biens.gardien" /></form:label></td>
										<td><label> 
											<form:checkbox path="gardien" />		
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="meuble"><spring:message code="biens.meuble" /></form:label></td>
										<td><label> <form:checkbox path="meuble" />
													
									</label></td>
										<td class="label"><form:label path="ascenseur" for="ascenseur"><spring:message code="biens.ascenseur" /></form:label></td>
									<td><label> 
										<form:checkbox path="ascenseur" />		
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="adapteHandicape" for="adapteHandicape"><spring:message code="biens.adapteHandicape" /></form:label></td>
									<td><label> 
										<form:checkbox path="adapteHandicape" />		
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="etatBien"><spring:message code="biens.etatBien" /></form:label></td>
									<td>
										<table>
											<tr>
												<form:select path="etatBien"  class="select_field">
													<c:forEach var="item" items="${etatBienList}">
														<c:choose>
															<c:when test="${etatBien == item}">
																<form:option selected="true" value="${item}">
										               				 ${item} 
										            			</form:option>
															</c:when>
															<c:otherwise>
																<form:option value="${item}">
										                  			 ${item}
										            			</form:option>
															</c:otherwise>
														</c:choose>
												</c:forEach>
												</form:select>
											</tr>
										</table>
									</td>
									<td class="label"><form:label path="typeEauChaude"><spring:message code="biens.typeEauChaude" /></form:label></td>
									<td>
										<table>
											<tr>
												<form:select path="typeEauChaude"  class="select_field">
													<c:forEach var="item" items="${typeEauChaudeList}">
														<c:choose>
															<c:when test="${typeEauChaude == item}">
																<form:option selected="true" value="${item}">
										               				 ${item} 
										            			</form:option>
															</c:when>
															<c:otherwise>
																<form:option value="${item}">
										                  			 ${item}
										            			</form:option>
															</c:otherwise>
														</c:choose>
												</c:forEach>
												</form:select>
											</tr>
										</table>
									</td>
								</tr>

								<tr>
									<td class="label"><form:label path="natureChauffage"><spring:message code="biens.natureChauffage" /></form:label></td>
									<td>
										<table>
											<tr>
												<form:select path="natureChauffage"  class="select_field">
													<c:forEach var="item" items="${typeNatureChauffageList}">
														<c:choose>
															<c:when test="${natureChauffage == item}">
																<form:option selected="true" value="${item}">
										               				 ${item} 
										            			</form:option>
															</c:when>
															<c:otherwise>
																<form:option value="${item}">
										                  			 ${item}
										            			</form:option>
															</c:otherwise>
														</c:choose>
												</c:forEach>
												</form:select>
											</tr>
										</table>
									</td>
									<td class="label"><form:label path="typeChauffage"><spring:message code="biens.typeChauffage" /></form:label></td>
									<td>
										<table>
											<tr>
												<form:select path="typeChauffage"  class="select_field">
													<c:forEach var="item" items="${typeTypeChauffageList}">
														<c:choose>
															<c:when test="${typeChauffage == item}">
																<form:option selected="true" value="${item}">
										               				 ${item} 
										            			</form:option>
															</c:when>
															<c:otherwise>
																<form:option value="${item}">
										                  			 ${item}
										            			</form:option>
															</c:otherwise>
														</c:choose>
												</c:forEach>
												</form:select>
											</tr>
										</table>
									</td>
								</tr>
								
								<tr>
									<td class="label"><form:label path="consoEnergie"><spring:message code="biens.consoEnergie" /></form:label></td>
									<td>
										<table>
											<tr>
												<form:select path="consoEnergie"  class="select_field">
													<c:forEach var="item" items="${typeConsoEnergieList}">
														<c:choose>
															<c:when test="${consoEnergie == item}">
																<form:option selected="true" value="${item}">
										               				 ${item} 
										            			</form:option>
															</c:when>
															<c:otherwise>
																<form:option value="${item}">
										                  			 ${item}
										            			</form:option>
															</c:otherwise>
														</c:choose>
												</c:forEach>
												</form:select>
											</tr>
										</table>
									</td>
									<td class="label"><form:label path="impactConso"><spring:message code="biens.impactConso" /></form:label></td>
									<td>
										<table>
											<tr>
												<form:select path="impactConso"  class="select_field">
													<c:forEach var="item" items="${typeImpactConsoList}">
														<c:choose>
															<c:when test="${impactConso == item}">
																<form:option selected="true" value="${item}">
										               				 ${item} 
										            			</form:option>
															</c:when>
															<c:otherwise>
																<form:option value="${item}">
										                  			 ${item}
										            			</form:option>
															</c:otherwise>
														</c:choose>
												</c:forEach>
												</form:select>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td class="label"><form:label path="status"><spring:message code="biens.status" /></form:label></td>
									<td>
										<table>
											<tr>
												<form:select path="status"  class="select_field">
													<c:forEach var="item" items="${statusList}">
														<c:choose>
															<c:when test="${status == item}">
																<form:option selected="true" value="${item}">
										               				 ${item} 
										            			</form:option>
															</c:when>
															<c:otherwise>
																<form:option value="${item}">
										                  			 ${item}
										            			</form:option>
															</c:otherwise>
														</c:choose>
												</c:forEach>
												</form:select>
											</tr>
										</table>
									</td>
									<td class="label"><form:label path="typeOperation"><spring:message code="biens.typeOperation" /></form:label></td>
									<td>
										<table>
											<tr>
												<form:select path="typeOperation"  class="select_field">
													<c:forEach var="item" items="${typesOperationsList}">
														<c:choose>
															<c:when test="${typeOperation == item}">
																<form:option selected="true" value="${item}">
										               				 ${item} 
										            			</form:option>
															</c:when>
															<c:otherwise>
																<form:option value="${item}">
										                  			 ${item}
										            			</form:option>
															</c:otherwise>
														</c:choose>
												</c:forEach>
												</form:select>
											</tr>
										</table>
									</td>
								</tr>							
								<tr>
									<td class="label">&nbsp;</td>
									<td>&nbsp;</td>
									<td colspan="2" class="label"><label> <input
											type="image" src='<c:url value="/resources/graphics/searchbtn.gif"/>'  alt="search"
											name="button2" id="button2" value="Submit" />
									</label></td>
								</tr>
							</table>
						</form:form>
					</div>
					<div class="bottom">
					</div>
				</div>
			</div>
			<div class="clear">&nbsp;</div>
			<div class="clear">&nbsp;</div>
			<jsp:include page="../common/footer.jsp" />
		</div>
	</div>
</body>
</html>
