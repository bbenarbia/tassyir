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
	<h2>User Information</h2>
	<div class="CSS_Table_Example" style="width: 600px;">
		<table>
			<tr>
				<td>Name</td>
				<td><b><c:out value="${user.firstName} ${user.lastName}" /></b></td>
			</tr>
			<tr>
				<td>Code</td>
				<td><c:out value="${user.code}" /></td>
			</tr>
			<tr>
				<td>Login</td>
				<td><c:out value="${user.login}" /></td>
			</tr>
			<tr>
				<td>Contact</td>
				<td><c:out value="${user.contact.name}" /></td>
			</tr>
			<tr>
				<td>titreContact</td>
				<td><spring:url value="../contacts/{contactId}.html"
						var="contactUrl">
						<spring:param name="contactId" value="${user.contact.id}" />
					</spring:url> <a href="${contactUrl}"><c:out value="${user.contact.name}" /></a>

				</td>
			</tr>

			<tr>
				<td>Roles</td>
				<td><c:forEach var="role" items="${user.roles}">
						<ol>
							<li><c:out value="${role.name}" /></li>
						</ol>
					</c:forEach></td>
			</tr>
			
			 <tr>
                            <td> 
                            	<spring:url value="/users/{userId}/edit" var="userUrl">
			                        <spring:param name="userId" value="${user.id}"/>
			                    </spring:url>
			                    <a href="${fn:escapeXml(userUrl)}">Edit User</a>
			                </td>
			                <td></td>

               	</tr>
		</table>

	</div>

</body>

</html>