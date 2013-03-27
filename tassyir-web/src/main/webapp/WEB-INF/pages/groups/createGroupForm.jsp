<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tassyir" tagdir="/WEB-INF/tags"%>


<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet" href="<c:url value="/stylesheets/style.css"/>"
	type="text/css" />
</head>

<body>
	<jsp:include page="../common/menu.jsp" />
	<h2>User</h2>

	<form:form modelAttribute="group" method="post" id="add-user-form">
		<div class="CSS_Table_Example">
			<table>
				<tr>
					<td colspan="2">Informations group</td>
				</tr>
				<tr>
					<td><form:label path="name">group Name</form:label></td>
					<td><form:input label="Group Name" path="name" /></td>
				</tr>
				<tr>
					<table>
						<tr>
							<td style="width: 350px;">N�</td>
							<td style="width: 350px;">Name</td>
							<td style="width: 350px;">description</td>
							<td style="width: 350px;">Included</td>
						</tr>
						<c:forEach items="${group.roleFormList.roles}" var="roleForm"
							varStatus="status">
							<tr>
								<td align="center">${status.count}</td>
								<td><c:out value="${roleForm.role.name}"></c:out></td>
								<td><c:out value="${roleForm.role.description}"></c:out></td>
								<%-- <td><form:input path="roleFormList.roles[${status.index}].role.description" /></td> --%>
								<td><form:checkbox path="roleFormList.roles[${status.index}].included" /></td>
							</tr>
						</c:forEach>
					</table>
				</tr>
			</table>
		</div>

		<div class="CSS_Table_Example" style="text-align: right;">
			<table>
				<tr>
					<td>
						<button type="submit">Create group</button>
					</td>
				</tr>
			</table>
		</div>
	</form:form>
</body>

</html>