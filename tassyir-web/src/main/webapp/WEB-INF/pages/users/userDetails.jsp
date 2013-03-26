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
	<h2><spring:message code="user.information"/></h2>
	<div class="CSS_Table_Example" style="width: 600px;">
		<table>
			<tr>
				<td><spring:message code="user.name"/></td>
				<td><b><c:out value="${user.firstName} ${user.lastName}" /></b></td>
			</tr>
			<tr>
				<td><spring:message code="user.code"/></td>
				<td><c:out value="${user.code}" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.login"/></td>
				<td><c:out value="${user.login}" /></td>
			</tr>
			
			<tr>
				<td><spring:message code="user.group"/></td>
				<td><c:out value="${user.userCategory.name}" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.roles"/></td>
				<td>
					<ol>
						<c:forEach var="role" items="${user.roles}">
						
							<li><c:out value="${role.name}" /></li>
						</c:forEach>
					</ol>
				<%--  <a href="/${user.id}/roles.htm">Edit Roles</a> --%>
				 
				 	<spring:url value="/users/{userId}/roles.htm" var="editRoleUrl">
			             <spring:param name="userId" value="${user.id}"/>
			        </spring:url>
			        <a href="${fn:escapeXml(editRoleUrl)}">Edit Role</a>
				</td>
			</tr>
			 <tr>
                            <td> 
                            	<spring:url value="/users/{userId}/edit" var="userUrl">
			                        <spring:param name="userId" value="${user.id}"/>
			                    </spring:url>
			                    <a href="${fn:escapeXml(userUrl)}">Edit User</a>
			                </td>
			             
               	 			<td> 
                            	<spring:url value="/users/new" var="userUrl" />
			                    <a href="${fn:escapeXml(userUrl)}">Add User</a>
			                </td>
			                </tr>
			                
			                <tr>
                            <td> 
                            	<spring:url value="/users/{userId}/editpassword" var="editPasswordUrl" >
                            		<spring:param name="userId" value="${user.id}"/>
                            	</spring:url>
			                    <a href="${fn:escapeXml(editPasswordUrl)}">Edit password</a>
			                </td>
			             
               	 			<td> 
                            
			                </td>
			                </tr>
		</table>

	<table>
			<tr>
				<td><spring:message code="contact.name"/></td>
				<td><b><c:out value="${user.contact.name}" /></b></td>
			</tr>

			<tr>
				<td><spring:message code="contact.nomSocieteContact"/></td>
				<td><b><c:out value="${user.contact.nomSocieteContact}" /></b></td>
			</tr>
			<tr>
				<td><spring:message code="contact.typeContact"/></td>
				<td><b><c:out value="${user.contact.typeContact}" /></b></td>
			</tr>
			<tr>
				<td><spring:message code="contact.titreContact"/></td>
				<td><b><c:out value="${user.contact.titreContact}" /></b></td>
			</tr>			
			<tr>
				<td><spring:message code="contact.adresseContact1"/></td>
				<td><b><c:out value="${user.contact.adresseContact1}" /></b></td>
			</tr>
			<tr>
				<td><spring:message code="contact.adresseContact2"/></td>
				<td><b><c:out value="${user.contact.adresseContact2}" /></b></td>
			</tr>			
			<tr>
				<td><spring:message code="contact.alerteSurTelephone1"/></td>
				<td><b><c:out value="${user.contact.alerteSurTelephone1}" /></b></td>
			</tr>			
			<tr>
				<td><spring:message code="contact.alerteSurTelephone2"/></td>
				<td><b><c:out value="${user.contact.alerteSurTelephone2}" /></b></td>
			</tr>						
			<tr>
				<td><spring:message code="contact.codePostal"/></td>
				<td><b><c:out value="${user.contact.codePostalContact}" /></b></td>
			</tr>								
			<tr>
				<td><spring:message code="contact.estContactPrincipal"/></td>
				<td><b><c:out value="${user.contact.estContactPrincipal}" /></b></td>
			</tr>					
			<tr>
				<td><spring:message code="contact.ville"/></td>
				<td><b><c:out value="${user.contact.villeContact}" /></b></td>
			</tr>			
			<tr>
				<td><spring:message code="contact.adresseMailContact"/></td>
				<td><b><c:out value="${user.contact.adresseMailContact}" /></b></td>
			</tr>			
			<tr>
				<td><spring:message code="contact.fax"/></td>
				<td><b><c:out value="${user.contact.faxContact}" /></b></td>
			</tr>				
			<tr>
				<td><spring:message code="contact.siteWebContact"/></td>
				<td><b><c:out value="${user.contact.siteWebContact}" /></b></td>
			</tr>				
			<tr>
				<td><spring:message code="contact.telephone1"/></td>
				<td><b><c:out value="${user.contact.telephoneContact1}" /></b></td>
			</tr>				
			<tr>
				<td><spring:message code="contact.telephone2"/></td>
				<td><b><c:out value="${user.contact.telephoneContact2}" /></b></td>
			</tr>
			
		</table>
	</div>

</body>

</html>