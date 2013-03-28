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

	<jsp:include page="../common/menu.jsp" />
	<jsp:include page="../common/menu-users.jsp" />
	<div class="container">
		<h2>groups</h2>

		<div class="CSS_Table_Example" style="width: 600px; height: 150px;">
			<table>
				<tr>
					<td style="width: 350px;">Name</td>
					<td style="width: 350px;">Roles</td>
					<td style="width: 300px;">Edit</td>
					<td style="width: 300px;">Delete</td>
				</tr>
				<c:forEach var="group" items="${selections}">
					<tr>
						<td><c:out value="${fn:escapeXml(group.name)}" /></td>

						<td>
							<ol>
								<c:forEach var="role" items="${group.roles}">

									<li><c:out value="${role.name}" /></li>
								</c:forEach>
							</ol>
						</td>						
						<td>
							<spring:url value="groups/{groupId}/edit.html" var="groupUrl">
								<spring:param name="groupId" value="${group.id}" />
							</spring:url> 
							<a href="${groupUrl}">Edit group</a>
						</td>

						<td>
							<spring:url value="groups/{groupId}/delete.html" var="groupUrl">
								<spring:param name="groupId" value="${group.id}" />
							</spring:url> 
							<a href="${groupUrl}">delete</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="3" />
					<td><spring:url value="/groups/new.html" var="groupUrl" /> <a
						href="${fn:escapeXml(groupUrl)}">Add group</a></td>
				</tr>
			</table>
		</div>

	</div>
</body>

</html>