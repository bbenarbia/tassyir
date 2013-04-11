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
			<div id="home_main_edit">
				<div id="edit">
					<div class="tab">
						<h2>Create Appartement</h2>
					</div>
					<div class="container">
						<form:form modelAttribute="appartement" method="post" id="form1">
							<table class="edit_form" style="width: 100%; border: none;">
								<tr>
									<td class="label"><form:label path="name">name</form:label></td>
									<td><label> <form:input label="name" path="name"
												class="text" />
									</label></td>
									<td class="label"><form:label path="reference">reference</form:label></td>
									<td><label> <form:input label="reference"
												path="reference" class="text mediumtext" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="prixVente">prixVente</form:label></td>
									<td><label> <form:input label="prixVente"
												path="prixVente" class="text" />
									</label></td>

								</tr>

								<tr>
									<td class="label"><form:label path="loyerMensuel">loyerMensuel</form:label></td>
									<td><label> <form:input label="loyerMensuel"
												path="loyerMensuel" class="text mediumtext" />
									</label></td>

									<td class="label"><form:label path="chargesMensuel">chargesMensuel</form:label></td>
									<td><label> <form:input label="chargesMensuel"
												path="chargesMensuel" class="text mediumtext" />
									</label></td>
								</tr>
								
								<tr>
									<td class="label"><form:label path="nbPieces">nbPieces</form:label></td>
									<td><label> <form:input label="nbPieces"
												path="nbPieces" class="text mediumtext" />
									</label></td>
									<td class="label"><form:label path="ascenseur" for="ascenseur">ascenseur</form:label></td>
									<td><label> 
										<form:checkbox path="ascenseur" />		
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="cuisineEquipee">cuisineEquipee</form:label></td>
									<td><label> 
										<form:checkbox path="cuisineEquipee" />									
									</label></td>
									
								</tr>
								<tr>
									<td class="label"><form:label path="status">status</form:label></td>
									<td colspan="4">
										<table>
											<tr>
												<c:forEach var="statusBien" items="${statusList}">
													<td class="tdsmall"><label> <form:radiobutton path="status"
																value="${statusBien}" /> ${statusBien}
													</label></td>
												</c:forEach>
											</tr>
										</table>
									</td>
								</tr>								
								<tr>
									<td class="label"><form:label path="typeOperation">Operation</form:label></td>
									<td colspan="4">
										<table>
											<tr>
												<c:forEach var="typeOperationBien"
													items="${typeOperationList}">
													<td class="tdsmall"><label> <form:radiobutton
																path="typeOperation" value="${typeOperationBien}"
																 /> ${typeOperationBien}
													</label></td>
												</c:forEach>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td rowspan="2" class="label"><form:label path="adresse">adresse</form:label></td>
									<td  rowspan="2"><label> <form:textarea cols="20" rows="10"
												label="adresse" path="adresse" class="text textBoxfield" />
									</label></td>
									<td class="label"><form:label path="superficie">superficie</form:label></td>
									<td><label> <form:input label="superficie"
												path="superficie" class="text mediumtext" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="age">age</form:label></td>
										<td><label> <form:input label="age" path="age"
													class="text mediumtext" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="etatBien">etatBien</form:label></td>
										<td><label> <form:input label="etatBien" path="etatBien"
													class="text mediumtext" />
									</label></td>
									<td class="label"><form:label path="etage">etage</form:label></td>
										<td><label> <form:input label="etage" path="etage"
													class="text mediumtext" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="gardien">gardien</form:label></td>
										<td><label> <form:input label="gardien" path="gardien"
													class="text mediumtext" />
									</label></td>
									<td class="label"><form:label path="ascenseur">ascenseur</form:label></td>
										<td><label> <form:input label="ascenseur" path="ascenseur"
													class="text mediumtext" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="nbPieces">nbPieces</form:label></td>
										<td><label> <form:input label="nbPieces" path="nbPieces"
													class="text mediumtext" />
									</label></td>
									<td class="label"><form:label path="cuisineEquipee">cuisineEquipee</form:label></td>
										<td><label> <form:input label="cuisineEquipee" path="cuisineEquipee"
													class="text mediumtext" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="nbTerrasses">nbTerrasses</form:label></td>
										<td><label> <form:input label="nbTerrasses" path="nbTerrasses"
													class="text mediumtext" />
									</label></td>
									<td class="label"><form:label path="nbBalcons">nbBalcons</form:label></td>
										<td><label> <form:input label="nbBalcons" path="nbBalcons"
													class="text mediumtext" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="nbParkingInt">nbParkingInt</form:label></td>
										<td><label> <form:input label="nbParkingInt" path="nbParkingInt"
													class="text mediumtext" />
									</label></td>
									<td class="label"><form:label path="nbParkingExt">nbParkingExt</form:label></td>
										<td><label> <form:input label="nbParkingExt" path="nbParkingExt"
													class="text mediumtext" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="interphone">interphone</form:label></td>
										<td><label> <form:input label="interphone" path="interphone"
													class="text mediumtext" />
									</label></td>
									<td class="label"><form:label path="digicode">digicode</form:label></td>
										<td><label> <form:input label="digicode" path="digicode"
													class="text mediumtext" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="meuble">meuble</form:label></td>
										<td><label> <form:input label="meuble" path="meuble"
													class="text mediumtext" />
									</label></td>
									<td class="label"><form:label path="typeEauChaude">typeEauChaude</form:label></td>
										<td><label> <form:input label="typeEauChaude" path="typeEauChaude"
													class="text mediumtext" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="natureChauffage">natureChauffage</form:label></td>
										<td><label> <form:input label="natureChauffage" path="natureChauffage"
													class="text mediumtext" />
									</label></td>
									<td class="label"><form:label path="typeChauffage">typeChauffage</form:label></td>
										<td><label> <form:input label="typeChauffage" path="typeChauffage"
													class="text mediumtext" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="consoEnergie">consoEnergie</form:label></td>
										<td><label> <form:input label="consoEnergie" path="consoEnergie"
													class="text mediumtext" />
									</label></td>
									<td class="label"><form:label path="impactConso">impactConso</form:label></td>
										<td><label> <form:input label="impactConso" path="impactConso"
													class="text mediumtext" />
									</label></td>
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


