<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet" href="<c:url value="/stylesheets/style.css"/>"
	type="text/css" />
<link rel="stylesheet" href="<c:url value="/stylesheets/forms.css"/>"
	type="text/css" />

<link rel="stylesheet"
	href="<c:url value="/stylesheets/carroussel.css"/>" type="text/css" />
<script type="text/javascript" src="scripts/jquery-1.9.1.js">
	
</script>
<script type="text/javascript" src="scripts/carroussel.js">
	
</script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="../common/menu.jsp" />
		<div id="content">
			<jsp:include page="../common/sub-menu.jsp" />

			<div id="home_main_edit">
				<div id="edit">
					<div class="tab">
						<h2>Edit bien</h2>
					</div>
					<div class="container">
						<form:form modelAttribute="bien" method="put" id="form1">
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
									<td class="label"><form:label path="adresse">adresse</form:label></td>
									<td colspan="3"><label> <form:input
												label="adresse" path="adresse" class="text longfield" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="superficie">superficie</form:label></td>
									<td><label> <form:input label="superficie"
												path="superficie" class="text mediumtext" />
									</label></td>
									<td class="label"><form:label path="typeBien">typeBien</form:label></td>
									<td><label> <form:input label="typeBien"
												path="typeBien" class="text mediumtext" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="status">status</form:label></td>
									<td colspan="4">
										<table>
										 <tr>
										<c:forEach var="statusBien" items="${statusList}">
										<td>
											<label> 
													<form:radiobutton path="status" value="${statusBien}"  label="${statusBien}" />
											</label>
										</td>		
										</c:forEach>
										</tr>
										</table>
									</td>						
								</tr>
								<tr>
									<td class="label"><form:label path="prixVente">prixVente</form:label></td>
									<td><label> <form:input label="prixVente"
												path="prixVente" class="text" />
									</label></td>

									<td class="label"><form:label path="prixMinVente">prixMinVente</form:label></td>
									<td><label> <form:input label="prixMinVente"
												path="prixMinVente" class="text mediumtext" />
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


								<c:if test="${typeBien=='APPARTEMENT' || typeBien=='STUDIO' }"> 
									<tr>
										<td class="label"><form:label path="etage">etage</form:label></td>
										<td><label> <form:input label="etage"
													path="etage" class="text mediumtext" />
										</label></td>
										<td class="label"><form:label path="ascenseur">ascenseur</form:label></td>
										<td><label> <form:input label="ascenseur"
													path="ascenseur" class="text mediumtext" />
										</label></td>
									</tr>
								</c:if> 

								<c:if test="${typeBien=='APPARTEMENT' || typeBien=='MAISON'}">
									<tr>
										<td class="label"><form:label path="nbPieces">nbPieces</form:label></td>
										<td><label> <form:input label="nbPieces"
													path="nbPieces" class="text mediumtext" />
										</label></td>
									</tr>
									<tr>
										<td class="label"><form:label path="cuisineEquipee">cuisineEquipee</form:label></td>
										<td><label> <form:input label="cuisineEquipee"
													path="cuisineEquipee" class="text mediumtext" />
										</label></td>
									</tr>
								</c:if>
								<c:if
									test="${typeBien=='APPARTEMENT' || typeBien=='STUDIO' || typeBien=='COMMERCE'  || typeBien=='MAISON' }">
									<tr>
										<td class="label"><form:label path="age">age</form:label></td>
										<td><label> <form:input label="age" path="age"
													class="text mediumtext" />
										</label></td>
									</tr>
								</c:if>
								<c:if test="${typeBien=='MAISON'}">
									<tr>
										<td class="label"><form:label path="jardin">jardin</form:label></td>
										<td><label> <form:input label="jardin"
													path="jardin" class="text longfield" />
										</label></td>
									</tr>
								</c:if>
								<tr>
									<td class="label"><form:label path="typeOperation">Operation</form:label></td>
									<td colspan="4">
										<table>
										 <tr>
										<c:forEach var="typeOperationBien" items="${typeOperationList}">
										<td>
											<label> 
													<form:radiobutton path="typeOperation" value="${typeOperationBien}"  label="${typeOperationBien}" />
											</label>
										</td>		
										</c:forEach>
										</tr>
										</table>
									</td>						
								</tr>					
								<tr>
									<td class="label">&nbsp;</td>
									<td>&nbsp;</td>
									<td colspan="2" class="label"><label> <input
											type="image" src="../../graphics/searchbtn.gif" alt="search"
											name="button2" id="button2" value="Submit" />
									</label></td>
								</tr>
							</table>
						</form:form>

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


