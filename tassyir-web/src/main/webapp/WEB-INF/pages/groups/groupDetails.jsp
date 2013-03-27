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
	<h2>
		<spring:message code="user.information" />
	</h2>
	<div class="CSS_Table_Example" style="width: 600px;">
		<table>
			<tr>
				<td><spring:message code="group.name" /></td>
				<td><b><c:out value="${group.name}" /></b></td>
			</tr>

			<tr>
				<td><spring:message code="group.roles" /></td>
				<td>
					<ol>
						<c:forEach var="role" items="${group.roles}">

							<li><c:out value="${role.name}" /></li>
						</c:forEach>
					</ol> <spring:url value="/groups/{groupId}/roles.htm" var="editRoleUrl">
						<spring:param name="groupId" value="${group.id}" />
					</spring:url> <a href="${fn:escapeXml(editRoleUrl)}">Edit Role</a>
				</td>
			</tr>
			<tr>
				<td><spring:url value="/groups/{groupId}/edit" var="groupUrl">
						<spring:param name="groupId" value="${group.id}" />
					</spring:url> <a href="${fn:escapeXml(groupUrl)}">Edit group</a></td>

				<td><spring:url value="/groups/new" var="groupUrl" /> <a
					href="${fn:escapeXml(groupUrl)}">Add group</a></td>
			</tr>
		</table>
	</div>

</body>

</html>