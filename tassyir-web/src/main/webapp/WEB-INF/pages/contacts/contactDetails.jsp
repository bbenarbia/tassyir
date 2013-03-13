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
	<h2>Contact Details</h2>
	<div class="CSS_Table_Example" style="width: 800px;">
		<table>
			<tr>
				<td>Name</td>
				<td><b><c:out value="${contact.name}" /></b></td>
			</tr>

			<tr>
				<td>nomSocieteContact</td>
				<td><b><c:out value="${contact.nomSocieteContact}" /></b></td>
			</tr>
			<tr>
				<td>typeContact</td>
				<td><b><c:out value="${contact.typeContact}" /></b></td>
			</tr>
			<tr>
				<td>titreContact</td>
				<td><b><c:out value="${contact.titreContact}" /></b></td>
			</tr>			
			<tr>
				<td>adresseContact1</td>
				<td><b><c:out value="${contact.adresseContact1}" /></b></td>
			</tr>
			<tr>
				<td>adresseContact2</td>
				<td><b><c:out value="${contact.adresseContact2}" /></b></td>
			</tr>			
			<tr>
				<td>alerteSurTelephone1</td>
				<td><b><c:out value="${contact.alerteSurTelephone1}" /></b></td>
			</tr>			
			<tr>
				<td>alerteSurTelephone2</td>
				<td><b><c:out value="${contact.alerteSurTelephone2}" /></b></td>
			</tr>						
			<tr>
				<td>codePostalContact</td>
				<td><b><c:out value="${contact.codePostalContact}" /></b></td>
			</tr>								
			<tr>
				<td>estContactPrincipal</td>
				<td><b><c:out value="${contact.estContactPrincipal}" /></b></td>
			</tr>					
			<tr>
				<td>villeContact</td>
				<td><b><c:out value="${contact.villeContact}" /></b></td>
			</tr>			
			<tr>
				<td>adresseMailContact</td>
				<td><b><c:out value="${contact.adresseMailContact}" /></b></td>
			</tr>			
			<tr>
				<td>faxContact</td>
				<td><b><c:out value="${contact.faxContact}" /></b></td>
			</tr>				
			<tr>
				<td>siteWebContact</td>
				<td><b><c:out value="${contact.siteWebContact}" /></b></td>
			</tr>				
			<tr>
				<td>telephoneContact1</td>
				<td><b><c:out value="${contact.telephoneContact1}" /></b></td>
			</tr>				
			<tr>
				<td>telephoneContact2</td>
				<td><b><c:out value="${contact.telephoneContact2}" /></b></td>
			</tr>
			
			<tr>
                            <td> 
                            	<spring:url value="/contacts/{contactId}/edit" var="contactUrl">
			                        <spring:param name="contactId" value="${contact.id}"/>
			                    </spring:url>
			                    <a href="${fn:escapeXml(contactUrl)}">Edit Contact</a>
			                </td>
			                <td></td>

               	</tr>
		</table>

	</div>

</body>

</html>