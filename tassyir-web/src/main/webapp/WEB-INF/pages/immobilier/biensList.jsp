<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet" href="<c:url value="/stylesheets/style.css"/>"
	type="text/css" />
</head>
<body>
	<div id="container">
		<jsp:include page="../common/menu.jsp" />
		<jsp:include page="../common/menu-users.jsp" />
		<h2>Biens disponibles</h2>
	<form:form modelAttribute="findBiens" method="post" id="form1">
	
	<div class="CSS_Table_Example" style="width: 600px; ">
			<table>
				<tr>
					<td colspan="2">rechercher un logement</td>
				</tr>
				<tr>
					<td>département</td>
					<td>
					<form:select path="departementBien">
							<option>indifferent</option>
							<c:forEach var="item" items="${departementsList}">
									<option value="${item.reference}">${item.name}</option>
							</c:forEach>
					</form:select></td>
				</tr>
				
				<tr>
					<td>Type d'appartement</td>
					<td><form:select path="typeBien">
							<option>indifferent</option>
							<c:forEach var="item" items="${typesLogementList}">
									<option value="${item.index}">${item}</option>
							</c:forEach>
					</form:select></td>
				</tr>
				
				<tr>
					<td>Nombres de pièces</td>
					<td>Min:<form:select path="nbPiecesMin">
							<option>indifferent</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
						</form:select>
						Max:<form:select path="nbPiecesMax">
							<option>indifferent</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
						</form:select>
					</td>
				</tr>
				<tr>
					<td>Superficie</td>
					<td>Min:<form:select path="surfaceMin">
							<option>indifferent</option>
							<option value="10">10</option>
							<option value="20">20</option>
							<option value="30">30</option>
							<option value="40">40</option>
							<option value="50">50</option>
							<option value="60">60</option>
							<option value="70">70</option>
							<option value="80">80</option>
							<option value="90">90</option>
							<option value="100">100</option>
						</form:select>
						Max:<form:select path="surfaceMax">
							<option>indifferent</option>
							<option value="10">10</option>
							<option value="20">20</option>
							<option value="30">30</option>
							<option value="40">40</option>
							<option value="50">50</option>
							<option value="60">60</option>
							<option value="70">70</option>
							<option value="80">80</option>
							<option value="90">90</option>
							<option value="100">100</option>
						</form:select>
					</td>
				</tr>
				<tr>
					<td>Loyer</td>
					<td>Min:<form:select path="loyerMin">
							<option>indifferent</option>
							<option value="100">100</option>
							<option value="200">200</option>
							<option value="300">300</option>
							<option value="400">400</option>
							<option value="500">500</option>
							<option value="600">600</option>
							<option value="700">700</option>
							<option value="800">800</option>
							<option value="900">900</option>
							<option value="1000">1000</option>
						</form:select>
						Max:<form:select path="loyerMax">
							<option>indifferent</option>
							<option value="100">100</option>
							<option value="200">200</option>
							<option value="300">300</option>
							<option value="400">400</option>
							<option value="500">500</option>
							<option value="600">600</option>
							<option value="700">700</option>
							<option value="800">800</option>
							<option value="900">900</option>
							<option value="1000">1000</option>
						</form:select>
					</td>
				</tr>
			</table>
			
			<p class="submit">
				<a class="cancelButton" href="javascript: history.go(-1)"> Back </a>
				<button type="submit">Search</button>
			</p>
	</div>
	<div class="CSS_Table_Example" style="width: 600px; height: 150px;">
			<table>
				<tr>
					<td style="width: 350px;">Name</td>
					<td style="width: 300px;">département</td>
					<td style="width: 150px;">superficie</td>
					<td style="width: 150px;">prixVente</td>
					<td style="width: 150px;">loyerMensuel</td>
					<td style="width: 150px;">chargesMensuel</td>
					<td style="width: 150px;">Edit</td>
					<td style="width: 150px;">Delete</td>
					
				</tr>
				<c:forEach var="bien" items="${findBiens.listBiens}">
					<tr>
						<td>
							<spring:url value="{bienId}.html" var="bienUrl">
								<spring:param name="bienId" value="${bien.id}" />
							</spring:url> 
							<a href="${bienUrl}"><c:out		value="${bien.name}" /></a>
						</td>			
						<td><b><c:out value="${bien.departement.name}" /></b></td>
						<td><b><c:out value="${bien.superficie}" /></b></td>
						<td><b><c:out value="${bien.prixVente}" /></b></td>
						<td><b><c:out value="${bien.loyerMensuel}" /></b></td>
						<td><b><c:out value="${bien.chargesMensuel}" /></b></td>
						<td>
							<spring:url value="{bienId}.html" var="bienUrl">
								<spring:param name="bienId" value="${bien.id}" />
							</spring:url> 
							<a href="${bienUrl}">Edit</a>
							
						</td>
						
						<td>
							<spring:url value="{bienId}.html" var="bienUrl">
								<spring:param name="bienId" value="${bien.id}" />
							</spring:url> 
							<a href="${bienUrl}">Delete</a>
							
						</td>
						
					</tr>
				</c:forEach>
				<tr>
				<td colspan="4" /> 
				<td>
                  	 <spring:url value="/biens/newAppartement" var="appartementUrl" />
			                    <a href="${fn:escapeXml(appartementUrl)}">Add appartement</a>
			         </td>
				</tr>
			</table>
		</div>
	</form:form>


	</div>
</body>

</html>