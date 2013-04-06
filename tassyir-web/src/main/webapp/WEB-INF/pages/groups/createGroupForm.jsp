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
<link rel="stylesheet" href="<c:url value="/stylesheets/screen.css"/>"
	type="text/css" media="screen" />
</head>

<body>
	<div id="container">
		<jsp:include page="../common/menu.jsp" />

		<h2>User</h2>

		<form:form modelAttribute="group" method="post" id="form1">
			<fieldset>
				<legend>Informations group</legend>

				<p class="first">
					<label for="name">Name</label>
					<form:input label="Group Name" path="name" />
					<form:errors cssClass="error" path="name" />
				</p>
				<p>
				<div class="CSS_Table_Example" style="width: 80px;">
					<label for="value">value</label>

					<table>
						<tr>
							<td style="width: 20px;">N°</td>
							<td>Name</td>
							<td>description</td>
							<td>Included</td>
						</tr>
						<c:forEach items="${group.roleFormList.roles}" var="roleForm"
							varStatus="status">
							<tr>
								<td align="center">${status.count}</td>
								<td><c:out value="${roleForm.role.name}"></c:out></td>
								<td><c:out value="${roleForm.role.description}"></c:out></td>
								<%-- <td><form:input path="roleFormList.roles[${status.index}].role.description" /></td> --%>
								<td><form:checkbox
										path="roleFormList.roles[${status.index}].included" /></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				
				
				
			</fieldset>

			<p class="submit">
				<button type="submit">Create group</button>
				<a href="javascript: history.go(-1)">Back</a>
			</p>
		</form:form>
	</div>
</body>

</html>
