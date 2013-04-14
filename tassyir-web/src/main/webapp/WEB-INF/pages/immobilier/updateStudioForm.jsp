<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<jsp:include page="./../common/head.jsp"/>
	<script type="text/javascript">
 
        $(document).ready(function() {
            $('#spn1').spinit({min:0,max:200,stepInc:1,pageInc:10,  width: 80 });
            $('#spn2').spinit({min:0,max:200,stepInc:1,pageInc:10,  width: 80 });
            $('#spn3').spinit({min:0,max:200,stepInc:1,pageInc:10,  width: 80 });
            $('#spn4').spinit({min:0,max:200,stepInc:1,pageInc:10,  width: 80 });
            $('#spn5').spinit({min:0,max:3000,stepInc:1,pageInc:10,  width: 80 });
        });
    </script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="../common/menu.jsp" />
		<div id="content">
			<jsp:include page="../common/sub-menu.jsp" />

			<div id="home_main_edit_user">
				<div id="edit_user">
					<div class="tab">
						<h2>Edit studio</h2>
					</div>
					<div class="container">
						<form:form modelAttribute="bien" method="put" id="form1">
							<table class="edit_form_user" style="width: 100%; border: none;">
								<tr>
									<td class="label" style="width: 30px; "><form:label path="name">name</form:label></td>
									<td><label> <form:input label="name" path="name"
												class="text" />
									</label></td>
									<td class="label"><form:label path="reference">reference</form:label></td>
									<td><label> <form:input label="reference"
												path="reference" class="text smalltext" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="prixVente">prixVente</form:label></td>
									<td><label> <form:input label="prixVente"
												path="prixVente" class="smalltext" />
									</label></td>
									<td class="label"><form:label path="superficie">superficie</form:label></td>
									<td><label> <form:input label="superficie"
												path="superficie" class="text smalltext" />
									</label></td>
								</tr>

								<tr>
									<td class="label"><form:label path="loyerMensuel">loyerMensuel</form:label></td>
									<td><label> <form:input label="loyerMensuel"
												path="loyerMensuel" class="text smalltext" />
									</label></td>

									<td class="label"><form:label path="chargesMensuel">chargesMensuel</form:label></td>
									<td><label> <form:input label="chargesMensuel"
												path="chargesMensuel" class="text smalltext" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="age">age</form:label></td>
										<td><label> 
												<form:input label="age" path="age"
													class="text smalltext" />
									</label></td>
									<td class="label"><form:label path="departement">departement</form:label></td>
										<td><label> 										
													<form:select path="departement"  class="select_field">
																		<option>indifferent</option>
																		<c:forEach var="item" items="${departementsList}">
																				<option value="${item.reference}">${item.name}</option>
																		</c:forEach>
													</form:select>
									</label></td>
								</tr>
								<tr>
								<td class="label"><form:label path="codePostal">code postal</form:label></td>
										<td><label> 
											<form:input label="codePostal" path="codePostal"
													class="text smalltext" />										
									</label></td>
								<td class="label"><form:label path="ville">Ville</form:label></td>
										<td><label> 
											<form:input label="ville" path="ville"
													class="text smalltext" />										
									</label></td>
								</tr>	
								<tr>
									<td class="label"><form:label path="adresse">adresse</form:label></td>
									<td ><label> <form:textarea cols="22" rows="10"
												label="adresse" path="adresse" class="text textBoxfieldlong" />
									</label>
									</td>
									<td  class="label"><form:label path="description">description</form:label></td>
									<td ><label> <form:textarea cols="22" rows="10"
												label="description" path="description" class="text textBoxfieldlong" />
									</label>
									</td>
								</tr>
									
									<tr>
									<td class="label"><form:label path="nbPieces">nbPieces</form:label></td>
									<td><label> 
										<%-- <form:input type="text" path="nbPieces" id="spn1" class="text smartspinner"/> --%>
										<form:input label="name" path="nbPieces"
												class="text" />										
									</label></td>
									<td class="label"><form:label path="nbChambres">nbChambres</form:label></td>
									<td><label> 
											<%-- <form:input type="text" path="nbChambres" id="spn2" class="smartspinner"/> --%>
											<form:input label="name" path="nbChambres"
												class="text" />		
									</label></td>
									
								</tr>
								<tr>
									<td class="label"><form:label path="nbCaves">nbCaves</form:label></td>
										<td><label> 
											<form:input label="name" path="nbCaves"
												class="text" />												
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="nbTerrasses">nbTerrasses</form:label></td>
										<td><label> 
											<%-- <form:input type="text" path="nbTerrasses" id="spn4" class="smartspinner"/> --%>
											<form:input label="name" path="nbTerrasses"
												class="text" />		
									</label></td>
									<td class="label"><form:label path="nbBalcons">nbBalcons</form:label></td>
										<td><label> 
											<%-- <form:input type="text" path="nbBalcons" id="spn5" class="smartspinner"/> --%>
											<form:input label="name" path="nbBalcons"
												class="text" />	
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="nbParkingInt">nbParkingInt</form:label></td>
										<td><label> 
												<%-- <form:input type="text" path="nbParkingInt" id="spn6" class="smartspinner"/> --%>
												<form:input label="name" path="nbParkingInt"
												class="text" />	
									</label></td>
									<td class="label"><form:label path="nbParkingExt">nbParkingExt</form:label></td>
										<td><label> 
											<%-- <form:input type="text" path="nbParkingExt" id="spn7" class="smartspinner"/> --%>
											<form:input label="name" path="nbParkingExt"
												class="text" />												
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="interphone">interphone</form:label></td>
										<td><label> 
											<form:checkbox path="interphone" />		
									</label></td>
									<td class="label"><form:label path="digicode">digicode</form:label></td>
										<td><label> 
											<form:checkbox path="digicode" />	
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="gardien">gardien</form:label></td>
										<td><label> 
											<form:checkbox path="gardien" />		
									</label></td>
							
									<td class="label"><form:label path="meuble">meuble</form:label></td>
										<td><label> <form:checkbox path="meuble" />
													
									</label></td>
								</tr>
								<tr>
										<td class="label"><form:label path="ascenseur" for="ascenseur">ascenseur</form:label></td>
									<td><label> 
										<form:checkbox path="ascenseur" />		
									</label></td>
								</tr>
								
								
								<tr>
									<td class="label"><form:label path="etatBien">etatBien</form:label></td>
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
									<td class="label"><form:label path="typeEauChaude">typeEauChaude</form:label></td>
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
									<td class="label"><form:label path="natureChauffage">natureChauffage</form:label></td>
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
									<td class="label"><form:label path="typeChauffage">typeChauffage</form:label></td>
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
									<td class="label"><form:label path="consoEnergie">consoEnergie</form:label></td>
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
									<td class="label"><form:label path="impactConso">impactConso</form:label></td>
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
									<td class="label"><form:label path="status">status</form:label></td>
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
									<td class="label"><form:label path="typeOperation">Operation</form:label></td>
									<td>
										<table>
											<tr>
												<form:select path="typeOperation"  class="select_field">
													<c:forEach var="item" items="${typeOperationList}">
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


