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
	<h2>Parameter</h2>

	<form:form modelAttribute="parameter" method="put"
		id="add-parameter-form">
		<div class="CSS_Table_Example" style="text-align: right;">
			<table>
				<tr>
					<td colspan="2">Informations Parameters</td>
				</tr>
				<tr>
					<td><form:label path="name">name</form:label></td>
					<td><form:input label="name" path="name" /></td>
				</tr>
				<tr>
					<td><form:label path="value">value</form:label></td>
					<td><form:input label="value" path="value" /></td>
				</tr>
				<tr>
					<td><form:label path="description">description</form:label></td>
					<td><form:input label="description" path="description" /></td>
				</tr>
				<tr>
					<td>
						<button type="submit">Update user</button>
					</td>
				</tr>
			</table>
		</div>
	</form:form>

</body>

</html>
