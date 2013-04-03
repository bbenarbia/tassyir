<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tassyir" tagdir="/WEB-INF/tags"%>


<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet" href="<c:url value="/stylesheets/style.css"/>"
	type="text/css" />
</head>

<body>
	<jsp:include page="../common/menu.jsp" />
	<jsp:include page="../common/menu-users.jsp" />
	<h2>Biens</h2>

	<form:form modelAttribute="bien" method="put" id="add-user-form">
		<div class="CSS_Table_Example">
						<table>
							<tr>
								<td colspan="2">Informations Bien</td>
							</tr>
							<tr>
								<td><form:label path="name">name</form:label></td>
								<td><form:input label="name" path="name" /><form:errors
										cssClass="error" path="name" /></td>
							</tr>
							<tr>
								<td><form:label path="reference">reference</form:label></td>
								<td><form:input label="reference" path="reference" /></td>
							</tr>
							<tr>
								<td><form:label path="adresse">adresse</form:label></td>
								<td><form:input label="adresse" path="adresse" /></td>
							</tr>
							<tr>
								<td><form:label path="superficie">superficie</form:label></td>
								<td><form:input label="superficie" path="superficie" /></td>
							</tr>
							<tr>
								<td><form:label path="status">status</form:label></td>
								<td><form:input label="status" path="status" /></td>
							</tr>
							<tr>
								<td><form:label path="prixVente">prixVente</form:label></td>
								<td><form:input label="prixVente" path="prixVente" /></td>
							</tr>
							<tr>
								<td><form:label path="prixMinVente">prixMinVente</form:label></td>
								<td><form:input label="prixMinVente" path="prixMinVente" /></td>
							</tr>
							<tr>
								<td><form:label path="loyerMensuel">loyerMensuel</form:label></td>
								<td><form:input label="loyerMensuel" path="loyerMensuel" /></td>
							</tr>
							<tr>
								<td><form:label path="chargesMensuel">chargesMensuel</form:label></td>
								<td><form:input label="chargesMensuel" path="chargesMensuel" /></td>
							</tr>
							<tr>
								<td><form:label path="typeOperation">typeOperation</form:label></td>
								<td><form:input label="typeOperation" path="typeOperation" /></td>
							</tr>
							<tr>
								<td><form:label path="etatBien">etatBien</form:label></td>
								<td><form:input label="etatBien" path="etatBien" /></td>
							</tr>						
							<c:if test="${typeBien=='APPARTEMENT' || typeBien=='STUDIO' }">	
								<tr>
									<td><form:label path="etage">etage</form:label></td>
									<td><form:input label="etage" path="etage" /></td>
								</tr>							
								<tr>
									<td><form:label path="ascenseur">ascenseur</form:label></td>
									<td><form:input label="ascenseur" path="ascenseur" /></td>
								</tr>			
							</c:if>
							<c:if test="${typeBien=='APPARTEMENT' || typeBien=='STUDIO' || typeBien=='COMMERCE'  || typeBien=='MAISON' }">				
								<tr>
									<td><form:label path="age">age</form:label></td>
									<td><form:input label="age" path="age" /></td>
								</tr>							
							</c:if>
							<c:if test="${typeBien=='APPARTEMENT' || typeBien=='MAISON'}">	
								<tr>
									<td><form:label path="nbPieces">nbPieces</form:label></td>
									<td><form:input label="nbPieces" path="nbPieces" /></td>
								</tr>									
								<tr>
									<td><form:label path="cuisineEquipee">cuisineEquipee</form:label></td>
									<td><form:input label="cuisineEquipee" path="cuisineEquipee" /></td>
								</tr>		
							</c:if>
							<c:if test="${typeBien=='MAISON'}">
								<tr>
									<td><form:label path="jardin">jardin</form:label></td>
									<td><form:input label="jardin" path="jardin" /></td>
								</tr>								
							</c:if>
						</table>
			</div>
		<div class="CSS_Table_Example" style="text-align: right;">
			<table>
				<tr>
					<td>
						<button type="submit">Update Bien</button>
					</td>
				</tr>
			</table>
		</div>
	</form:form>
</body>

</html>
