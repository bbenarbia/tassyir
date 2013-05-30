<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<jsp:include page="./../../common/head.jsp"/>
</head>
<body>
	<spring:url value="/biens/find-biens.htm" var="bienListUrl"/>
	<spring:url value="/biens/new.htm" var="bienUrl" />
	<spring:url value="/biens/{BienId}.htm" var="detailBienUrl">
				<spring:param name="BienId" value="${bien.id}" />
	</spring:url> 
	<div id="wrap">
		<jsp:include page="../../common/menu.jsp" />
		<div id="content">
			<jsp:include page="../../common/sub-menu.jsp" />

				<div id="home_main_edit_user">
				<div class="navig">
					<c:forEach var="navig" items="${navigations}" varStatus="status">
						&laquo;
						<spring:url value="${navig.url}" var="navigs" />
						<a href="${navigs}"><spring:message code="${navig.name}" /></a>
					</c:forEach>
				</div>
				<div id="edit_user">
					<div class="tab">
						<h2><spring:message code="biens.maison.action.edit" /></h2>
					</div>
					<div style="margin: 10px; background: none repeat scroll 0px 0px rgb(248, 248, 248); padding: 14px;">
						<form:form modelAttribute="bien" method="put" id="form1">
						<fieldset>
    						<legend>General Info</legend>
        						<dl>
        							<dt><form:label path="typeOperation"><spring:message code="biens.typeOperation" /></form:label></dt>
					            	<dd>
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
									</dd>
        							<dt><form:label path="status"><spring:message code="biens.status" /></form:label></dt>
					            	<dd>
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
									</dd>
						        </dl>
						        
						        <dl>
        							<dt><form:label path="name"><spring:message code="biens.name" /></form:label></dt>
					            	<dd>
					            		<form:input label="name" path="name"	class="text" />
									</dd>
        							<dt><form:label path="reference"><spring:message code="biens.ref" /></form:label></dt>
					            	<dd>
					            		<form:input label="reference" path="reference" class="text smalltext" />
									</dd>
						        </dl>
						        <c:if test="${bien.typeOperation =='LOCATION'}">
						        <dl>
        							<dt><form:label path="loyerMensuel"><spring:message code="biens.loyerMensuel" /></form:label></dt>
					            	<dd>	
					            		<form:input label="loyerMensuel"  path="loyerMensuel" class="text smalltext" />
									</dd>
        							<dt><form:label path="chargesMensuel"><spring:message code="biens.chargesMensuel" /></form:label></dt>
					            	<dd>
					            		<form:input label="chargesMensuel" path="chargesMensuel" class="text smalltext" />
									</dd>
						        </dl>
						        <dl>
        							<dt><form:label path="honoraires"><spring:message code="biens.honoraires" /></form:label></dt>
					            	<dd>
					            		<form:input label="honoraires" path="honoraires" class="text smalltext" />
									</dd>
        							<dt><form:label path="depotGarantie"><spring:message code="biens.depotGarantie" /></form:label></dt>
					            	<dd>
					            		<form:input label="depotGarantie" path="depotGarantie" class="text smalltext" />
									</dd>
						        </dl>
						        
							 </c:if>
							 <c:if test="${bien.typeOperation =='VENTE'}">
							   	<dl>
									<dt><form:label path="prixVente"><spring:message code="biens.prixVente" /></form:label></dt>
									<dd> <form:input label="prixVente"
												path="prixVente" class="text smalltext" />
									<dt><form:label path="prixMinVente"><spring:message code="biens.prixVenteMin" /></form:label></dt>
									<dd> 
										<form:input label="prixMinVente" path="prixMinVente" class="text smalltext" />
									</dd>
								</dl>
								<dl>
									<dt><form:label path="honoraires"><spring:message code="biens.honoraires" /></form:label></dt>
									<dd> <form:input label="honoraires"
												path="honoraires" class="text smalltext" />
									<dt><form:label path="depotGarantie"><spring:message code="biens.depotGarantie" /></form:label></dt>
									<dd> 
										<form:input label="depotGarantie" path="depotGarantie" class="text smalltext" />
									</dd>
							   </dl> 
							 </c:if>
							 	<dl>
        							<dt><form:label path="superficie"><spring:message code="biens.superficie" /></form:label></dt>
					            	<dd>
					            		<form:input label="superficie" path="superficie" class="text smalltext" />
									</dd>
        							<dt><form:label path="departement"><spring:message code="biens.departement" /></form:label></dt>
					            	<dd>
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
									</dd>
						        </dl>
								<dl>
								<dt><form:label path="codePostal"><spring:message code="biens.codepostal" /></form:label></dt>
									<dd>
										<form:input label="codePostal" path="codePostal"
													class="text smalltext" />										
									</dd>
								  <dt><form:label path="ville"><spring:message code="biens.ville" /></form:label></dt>
										<dd> 
											<form:input label="ville" path="ville" class="text smalltext" />										
									   </dd>
								</dl>	
								<dl>
									<dt><form:label path="adresse"><spring:message code="biens.adresse" /></form:label></dt>
									<dd> <form:textarea cols="16" rows="6" label="adresse" path="adresse" class="text textBoxfieldlong" />
									</dd>
									<dt><form:label path="description"><spring:message code="biens.description" /></form:label></dt>
									<dd><form:textarea cols="16" rows="6"	label="description" path="description" class="text textBoxfieldlong" />
									</dd>
								</dl>
								<dl>
									<dt><form:label path="transport"><spring:message code="biens.transport" /></form:label></dt>
									<dd> 
										<form:textarea cols="16" rows="6" label="name" path="transport" class="text textBoxfieldlong" />
									</dd>
									<dt><form:label path="proximite"><spring:message code="biens.proximite" /></form:label></dt>
									<dd> 
										<form:textarea cols="16" rows="6" label="name" path="proximite" class="text textBoxfieldlong" />
									</dd>
								</dl>
								<dl>
									<dt><form:label path="age"><spring:message code="biens.age" /></form:label></dt>
									<dd> 
										<form:input label="age" path="age" class="text smalltext" />
									</dd>
									<dt><form:label path="etatBien"><spring:message code="biens.etatBien" /></form:label></dt>
									<dd>
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
											</dd>
								</dl>						
								<dl>
									<dt><form:label path="nbPieces"><spring:message code="biens.nbPieces" /></form:label></dt>
									<dd> 
										<form:input label="name" path="nbPieces"
												class="text" />										
									</dd>
									<dt><form:label path="nbChambres"><spring:message code="biens.nbChambres" /></form:label></dt>
									<dd> 
										<form:input label="name" path="nbChambres" class="text" />		
								</dl>
								<dl>
									<dt><form:label path="nbTerrasses"><spring:message code="biens.nbTerrasses" /></form:label></dt>
									<dd> 
										<form:input label="name" path="nbTerrasses" class="text" />		
									</dd>
									<dt><form:label path="nbBalcons"><spring:message code="biens.nbBalcons" /></form:label></dt>
									<dd> 
										<form:input label="name" path="nbBalcons" class="text" />	
									</dd>
								</dl>
								<dl>
									<dt><form:label path="nbParkingInt"><spring:message code="biens.nbParkingInt" /></form:label></dt>
										<dd> 
												<form:input label="name" path="nbParkingInt"
												class="text" />	
									</dd>
									<dt><form:label path="nbParkingExt"><spring:message code="biens.nbParkingExt" /></form:label></dt>
										<dd> 
											<form:input label="name" path="nbParkingExt"
												class="text" />												
									</dd>
								</dl>
								<dl>
									<dt><form:label path="nbCaves"><spring:message code="biens.nbCaves" /></form:label></dt>
										<dd> 
											<form:input label="name" path="nbCaves"
												class="text" />												
									</dd>
									<dt><form:label path="nbSallesBains" for="nbSallesBains"><spring:message code="biens.nbSallesBains" /></form:label></dt>
									<dd> 
										<form:input label="name" path="nbSallesBains"
												class="text" />		
									</dd>
								</dl>
							</fieldset>	
								
							<fieldset>	
								<legend>Informations Energitiques</legend>
								<dl>
									<dt><form:label path="typeEauChaude"><spring:message code="biens.typeEauChaude" /></form:label></dt>
											<dd>
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
											</dd>
								</dl>
								<dl>
									<dt><form:label path="natureChauffage"><spring:message code="biens.natureChauffage" /></form:label></dt>
											<dd>
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
											</dd>
									<dt><form:label path="typeChauffage"><spring:message code="biens.typeChauffage" /></form:label></dt>
											<dd>
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
											</dd>
								</dl>
								<dl>
									<dt><form:label path="consoEnergie"><spring:message code="biens.consoEnergie" /></form:label></dt>
										<dd>
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
											</dd>
									<dt><form:label path="impactConso"><spring:message code="biens.impactConso" /></form:label></dt>
											<dd>
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
											</dd>
									</dl>
							</fieldset>			
							<fieldset>		
								<legend>Options</legend>
								<dl>
									<dt>
											<form:checkbox path="interphone" id="interphone"/><form:label path="interphone" for="interphone"><spring:message code="biens.interphone" /></form:label>
									</dt>
									<dd> 	
											<form:checkbox id="digicode" path="digicode" /><form:label path="digicode" for="digicode"><spring:message code="biens.digicode" /></form:label>
									</dd>
									<dt> 
											<form:checkbox id="cuisineEquipee" path="cuisineEquipee" /><form:label path="cuisineEquipee"><spring:message code="biens.cuisineEquipee" /></form:label>
									</dt>
									<dd>
											<form:checkbox id="jardin" path="jardin" /><form:label path="jardin"><spring:message code="biens.jardin" /></form:label>
									</dd>
								</dl>
								<dl>
									<dt>
											<form:checkbox id="meuble" path="meuble" /><form:label path="meuble"><spring:message code="biens.meuble" /></form:label>
									</dt>
									<dt>
											<form:checkbox id="adapteHandicape" path="adapteHandicape" /> <form:label path="adapteHandicape" for="adapteHandicape"><spring:message code="biens.adapteHandicape" /></form:label>	
									</dt>
									<dd>
											<form:checkbox id="piscine" path="piscine" /> <form:label path="piscine" for="piscine"><spring:message code="biens.piscine" /></form:label>
									</dd>
        						</dl>
        						</fieldset>		
								<fieldset class="action">
									<dl><dt>
    									<input type="submit"  alt="Update"  class="buttonmenu" value="Update" />
									</dt>
									<dd>
										<a class="buttonmenured"  href="${fn:escapeXml(detailBienUrl)}"><spring:message code="biens.action.cancel" /></a>
									</dd>
									</dl>
    							</fieldset>
    							<fieldset class="action">
									<dl>
									<dt>
    									<a class="buttonmenu"  href="${fn:escapeXml(bienUrl)}"><spring:message code="biens.action.add" /></a>
									</dt>
									<dd>
										<a class="buttonmenu"  href="${fn:escapeXml(bienListUrl)}"><spring:message code="biens.action.bienlist" /></a>
									</dd>
									</dl>
    							</fieldset>
							</form:form>
							</div>
				</div>
			</div>
			<div class="clear">&nbsp;</div>
			<div class="clear">&nbsp;</div>
			<jsp:include page="../../common/footer.jsp" />
		</div>
	</div>
</body>
</html>
