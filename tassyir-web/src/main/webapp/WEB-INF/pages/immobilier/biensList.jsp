<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


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
		
		<div class="CSS_Table_Example" style="width: 600px; ">
			<table>
				<tr>
					<td colspan="2">rechercher un logement</td>
				</tr>
				<tr>
					<td>département</td>
					<td><select name="departements">
							<c:forEach var="item" items="${departementsList}">
									<option value="${item}">${item}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Type d'appartement</td>
					<td><select name="typesLogement">
							<c:forEach var="item" items="${typesLogementList}">
									<option value="${item}">${item}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Nombres de pièces</td>
					<td>Min:<select name="nbPiecesMin">
							<option value="-1">indifferent</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
						</select>
						Max:<select name="nbPiecesMax">
							<option value="-1">indifferent</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Superficie</td>
					<td>Min:<select name="superficieMin">
							<option value="-1">indifferent</option>
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
						</select>
						Max:<select name="superficieMax">
							<option value="-1">indifferent</option>
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
						</select>
					</td>
				</tr>
				<tr>
					<td>Loyer</td>
					<td>Min:<select name="loyerMin">
							<option value="-1">indifferent</option>
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
						</select>
						Max:<select name="loyerMax">
							<option value="-1">indifferent</option>
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
						</select>
					</td>
				</tr>
			</table>
		</div>
		
		<div class="CSS_Table_Example" style="width: 600px; height: 150px;">
			<table>
				<tr>
					<td style="width: 350px;">Name</td>
					<td style="width: 300px;">adresse</td>
					<td style="width: 150px;">superficie</td>
					<td style="width: 150px;">prixVente</td>
					<td style="width: 150px;">loyerMensuel</td>
					<td style="width: 150px;">chargesMensuel</td>
					<td style="width: 150px;">Edit</td>
					<td style="width: 150px;">Delete</td>
					
				</tr>
				<c:forEach var="appartement" items="${selections}">
					<tr>
						<td>
							<spring:url value="biens/{appartementId}.html" var="appartementUrl">
								<spring:param name="appartementId" value="${appartement.id}" />
							</spring:url> <a href="${appartementUrl}"><c:out
									value="${appartement.name}" /></a>
						</td>			
						<td><b><c:out value="${appartement.adresse}" /></b></td>
						<td><b><c:out value="${appartement.superficie}" /></b></td>
						<td><b><c:out value="${appartement.prixVente}" /></b></td>
						<td><b><c:out value="${appartement.loyerMensuel}" /></b></td>
						<td><b><c:out value="${appartement.chargesMensuel}" /></b></td>
						
						
						<td><a href="appartements/${appartement.id}/edit">Edit</a></td>
						<td><a href="appartements/${appartement.id}/delete">Delete</a></td>
					</tr>
				</c:forEach>
				<tr>
				<td colspan="4" /> 
				<td>
                  	 <spring:url value="/appartements/new" var="appartementUrl" />
			                    <a href="${fn:escapeXml(appartementUrl)}">Add appartement</a>
			         </td>
				</tr>
			</table>
		</div>

	</div>
</body>

</html>