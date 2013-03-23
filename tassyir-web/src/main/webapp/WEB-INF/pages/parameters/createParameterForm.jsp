<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tassyir" tagdir="/WEB-INF/tags"%>


<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />


<title></title>
<link rel="stylesheet" href="<c:url value="/stylesheets/style.css"/>"
	type="text/css" />
</head>

<body>
	<jsp:include page="../common/menu.jsp" />
	<h2>Parameter</h2>

	<form:form modelAttribute="parameter" method="post"
		id="add-parameter-form">

		<div class="CSS_Table_Example">
			<table>
				<tr>
					<td colspan="2">Informations Parameter</td>
				</tr>
				<tr>
					<td><form:label path="name">Name</form:label></td>
					<td><form:input label="name" path="name" /> <form:errors
							cssClass="error" path="name" /></td>
				</tr>
				<tr>
					<td><form:label path="value">value</form:label></td>
					<td><form:input label="value" path="value" /> <form:errors
							cssClass="error" path="value" /></td>
				</tr>
				<tr>
					<td><form:label path="description">Description</form:label></td>
					<td><form:input label="description" path="description" /> <form:errors
							cssClass="error" path="description" /></td>
				</tr>
				<tr>
					<td>
						<button type="submit">Add user</button>
					</td>
				</tr>
			</table>
		</div>
	</form:form>

</body>

</html>
