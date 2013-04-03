<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>

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
	<h2>
		<spring:message code="bien.information" />
	</h2>
	<div class="CSS_Table_Example" style="width: 600px;">
		<table>
			<tr>
				<td><spring:message code="bien.name" /></td>
				<td><b><c:out value="${bien.name}" /></b></td>
			</tr>
			<tr>
				<td><spring:message code="bien.reference" /></td>
				<td><c:out value="${bien.reference}" /></td>
			</tr>
			<tr>
				<td><spring:message code="bien.departement" /></td>
				<td><c:out value="${bien.departement.name}(${bien.departement.reference})" /></td>
			</tr>

			<tr>
				<td><spring:message code="bien.adresse" /></td>
				<td><c:out value="${bien.adresse}" /></td>
			</tr>
			<tr>
				<td><spring:message code="bien.superficie" /></td>
				<td><c:out value="${bien.superficie} m²" /></td>
			</tr>
			<tr>
				<td><spring:message code="bien.status" /></td>
				<td><c:out value="${bien.status}" /></td>
			</tr>
			<tr>
				<td><spring:message code="bien.prixVente" /></td>
				<td><c:out value="${bien.prixVente}" /></td>
			</tr>
			<tr>
				<td><spring:message code="bien.prixMinVente" /></td>
				<td><c:out value="${bien.prixMinVente}" /></td>
			</tr>
			<tr>
				<td><spring:message code="bien.loyerMensuel" /></td>
				<td><c:out value="${bien.loyerMensuel}" /></td>
			</tr>
			<tr>
				<td><spring:message code="bien.chargesMensuel" /></td>
				<td><c:out value="${bien.chargesMensuel}" /></td>
			</tr>
			<tr>
				<td><spring:message code="bien.typeOperation" /></td>
				<td><c:out value="${bien.typeOperation}" /></td>
			</tr>
			<tr>
				<td><spring:message code="bien.etatBien" /></td>
				<td><c:out value="${bien.etatBien}" /></td>
			</tr>			
			<c:if test="${bien.typeBien=='APPARTEMENT' || bien.typeBien=='STUDIO' }">
				<tr>
					<td><spring:message code="bien.etage" /></td>
					<td><c:out value="${bien.etage}" /></td>
				</tr>				
				<tr>
					<td><spring:message code="bien.ascenseur" /></td>
					<td>
							<c:choose> 
								<c:when test="${bien.ascenseur==false}" >Oui </c:when> 
								<c:otherwise>Non </c:otherwise>
							</c:choose>
				</tr>	
			</c:if>
			<c:if test="${bien.typeBien=='APPARTEMENT' || bien.typeBien=='STUDIO' || bien.typeBien=='COMMERCE'  || bien.typeBien=='MAISON' }">
				<tr>
					<td><spring:message code="bien.age" /></td>
					<td><c:out value="${bien.age}" /></td>
				</tr>	
			</c:if>
			<c:if test="${bien.typeBien=='APPARTEMENT' || bien.typeBien=='MAISON'}">
				<tr>
						<td><spring:message code="bien.nbPieces" /></td>
						<td><c:out value="${bien.nbPieces}" /></td>
				</tr>	
				<tr>
						<td><spring:message code="bien.cuisineEquipee" /></td>
						<td> 
							<c:choose> 
								<c:when test="${bien.cuisineEquipee==false}" >Oui </c:when> 
								<c:otherwise>Non </c:otherwise>
							</c:choose>
						</td>
				</tr>	
			</c:if>	
				
			<c:if test="${bien.typeBien=='MAISON'}">
				<tr>
					<td><spring:message code="bien.jardin" /></td>
					<td>
						<c:choose> 
								<c:when test="${bien.jardin==false}" >Oui </c:when> 
								<c:otherwise>Non </c:otherwise>
						</c:choose>
					</td>
				</tr>	
			</c:if>			
			
			<tr>
				<td><spring:url value="/biens/{bienId}/edit" var="bienUrl">
						<spring:param name="bienId" value="${bien.id}" />
					</spring:url> <a href="${fn:escapeXml(bienUrl)}">Edit Bien</a></td>

				<td><spring:url value="/biens/new" var="bienUrl" /> <a
					href="${fn:escapeXml(bienUrl)}">Add Bien</a></td>
			</tr>
			
		</table>
	</div>

</body>

</html>