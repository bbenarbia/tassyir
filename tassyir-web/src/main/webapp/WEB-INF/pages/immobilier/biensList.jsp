<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<html lang="en">
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