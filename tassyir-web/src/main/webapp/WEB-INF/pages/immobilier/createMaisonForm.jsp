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
            $('#spn6').spinit({min:0,max:3000,stepInc:1,pageInc:10,  width: 80 });
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
						<h2>Create Maison</h2>
					</div>
					<div class="container">
						<form:form modelAttribute="maison" method="post" id="form1" enctype="multipart/form-data">
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
										<td><label> <form:input label="age" path="age"
													class="text smalltext" />
									</label></td>
									<td class="label"><form:label path="etage">etage</form:label></td>
										<td><label> <form:input label="etage" path="etage"
													class="text smalltext" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="departement">departement</form:label></td>
										<td><label> 										
													<form:select path="departement"  class="select_field">
																		<option>indifferent</option>
																		<c:forEach var="item" items="${departementsList}">
																				<option value="${item.reference}">${item.name}</option>
																		</c:forEach>
													</form:select>
									</label></td>
								<td class="label"><form:label path="codePostal">code postal</form:label></td>
										<td><label> 
											<form:input label="codePostal" path="codePostal"
													class="text smalltext" />										
									</label></td>
								</tr>	
								<tr>
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
									<td class="label"><form:label path="transport">transport</form:label></td>
										<td><label> 
											<form:input label="name" path="transport"
												class="text" />												
									</label></td>
									<td class="label"><form:label path="proximite">proximite</form:label></td>
										<td><label> 
											<form:input label="name" path="proximite"
												class="text" />												
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="nbPieces">nbPieces</form:label></td>
									<td><label> 
											<form:input type="text" path="nbPieces" id="spn1" class="smartspinner"/>
									</label></td>
									<td class="label"><form:label path="nbChambres">nbChambres</form:label></td>
									<td><label> 
											<form:input type="text" path="nbChambres" id="spn2" class="smartspinner"/>
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="nbTerrasses">nbTerrasses</form:label></td>
										<td><label> 
												<form:input type="text" path="nbTerrasses" id="spn3" class="smartspinner"/>
									</label></td>
									<td class="label"><form:label path="nbBalcons">nbBalcons</form:label></td>
										<td><label> 
												<form:input type="text" path="nbBalcons" id="spn4" class="smartspinner"/>
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="nbParkingInt">nbParkingInt</form:label></td>
										<td><label> 
												<form:input type="text" path="nbParkingInt" id="spn5" class="smartspinner"/>
									</label></td>
									<td class="label"><form:label path="nbParkingExt">nbParkingExt</form:label></td>
										<td><label> 
												<form:input type="text" path="nbParkingExt" id="spn6" class="smartspinner"/>
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
									<td class="label"><form:label path="cuisineEquipee">cuisineEquipee</form:label></td>
									<td><label> 
										<form:checkbox path="cuisineEquipee" />									
									</label></td>
									
									<td class="label"><form:label path="jardin">jardin</form:label></td>
										<td><label> 
											<form:checkbox path="jardin" />		
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="meuble">meuble</form:label></td>
										<td><label> <form:checkbox path="meuble" />
													
									</label></td>
									<td class="label"><form:label path="piscine">piscine</form:label></td>
										<td><label> 
											<form:checkbox path="piscine" />		
									</label></td>
								</tr>
								<tr>
								<td class="label"><form:label path="adapteHandicape" for="adapteHandicape">adapteHandicape</form:label></td>
									<td><label> 
										<form:checkbox path="adapteHandicape" />		
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="etatBien">etatBien</form:label></td>
									<td>
										<table>
											<tr>
											
												<form:select path="etatBien"  class="select_field">
																			<c:forEach var="etatBien" items="${etatBienList}">
																					<option value="${etatBien}">${etatBien}</option>
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
																			<c:forEach var="typeEauChaude" items="${typeEauChaudeList}">
																					<option value="${typeEauChaude}">${typeEauChaude}</option>
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
																			<c:forEach var="natureChauffage" items="${typeNatureChauffageList}">
																					<option value="${natureChauffage}">${natureChauffage}</option>
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
																			<c:forEach var="natureChauffage" items="${typeTypeChauffageList}">
																					<option value="${natureChauffage}">${natureChauffage}</option>
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
																			<c:forEach var="consoEnergie" items="${typeConsoEnergieList}">
																					<option value="${consoEnergie}">${consoEnergie}</option>
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
																			<c:forEach var="impactConso" items="${typeImpactConsoList}">
																					<option value="${impactConso}">${impactConso}</option>
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
																			<c:forEach var="status" items="${statusList}">
																					<option value="${status}">${status}</option>
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
																			<c:forEach var="typeOperation" items="${typesOperationsList}">
																					<option value="${typeOperation}">${typeOperation}</option>
																			</c:forEach>
												</form:select>
											</tr>
										</table>
									</td>
								</tr>	
								<tr>
								<td colspan="4">
									<table class="search_form" style="width: 100%; border: none;">
										<c:forEach varStatus="status" begin="1" end="${5}">
											<tr>
												<td  class="label">Photo: ${status.count}</td>
												<td><label><input
														name="files[${status.count-1}]" type="file" accept="image/*" />
												</label></td>
											</tr>
										</c:forEach>
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


