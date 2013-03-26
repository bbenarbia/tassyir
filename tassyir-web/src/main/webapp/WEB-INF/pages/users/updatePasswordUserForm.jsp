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
	<h2>Update User password</h2>

	<form:form modelAttribute="userPassword" method="put" id="add-user-form">
		<div class="CSS_Table_Example">
		
			<table>
				<tr>
					<td><form:label path="oldPassword">Old password</form:label></td>
					<td><form:password path="oldPassword" /> <form:errors
										cssClass="error" path="oldPassword" /></td>
				</tr>
				<tr>
					<td><form:label path="password">New password</form:label></td>
					<td><form:password path="password" /><form:errors
										cssClass="error" path="password" /></td>
				</tr>
				<tr>
					<td><form:label path="passwordConfirmation">passwordConfirmation</form:label></td>
					<td><form:password path="passwordConfirmation" /><form:errors
										cssClass="error" path="passwordConfirmation" /></td>
				</tr>
			</table>
		</div>

		<div class="CSS_Table_Example" style="text-align: right;">
			<table>
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
