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

	<jsp:include page="../common/menu.jsp"/>
	<jsp:include page="../common/menu-users.jsp" />
	<div class="container">
		<h2>Users</h2>

		<div class="CSS_Table_Example" style="width: 600px; height: 150px;">
			<table>
				<tr>
					<td style="width: 350px;">Name</td>
					<td style="width: 350px;">Code</td>
					<td style="width: 300px;">Login</td>
					<td style="width: 150px;">locked</td>
					<td style="width: 150px;">Admin</td>
				</tr>
				<c:forEach var="user" items="${selections}">
					<tr>
						<td><spring:url value="users/{userId}.html" var="userUrl">
								<spring:param name="userId" value="${user.id}" />
							</spring:url> <a href="${userUrl}"><c:out
									value="${user.firstName} ${user.lastName}" /></a> 
						</td>
						<td><c:out value="${user.code}" /></td>
						<td><c:out value="${user.login}" /></td>
						<td>
							<input type="checkbox"  name="locked" value="locked" disabled="disabled" <c:if test="${user.locked}">checked="checked"</c:if>> 
						</td>
						<td>
							<input type="checkbox"  name="isAdmin" value="isAdmin"  disabled="disabled" <c:if test="${user.isAdmin}">checked="checked"</c:if>>
						</td>
					</tr>
				</c:forEach>
				<tr>
				<td colspan="4" /> 
				<td>
                  	 <spring:url value="/users/new" var="userUrl" />
			                    <a href="${fn:escapeXml(userUrl)}">Add User</a>
			         </td>
				</tr>
			</table>
		</div>

	</div>
</body>

</html>