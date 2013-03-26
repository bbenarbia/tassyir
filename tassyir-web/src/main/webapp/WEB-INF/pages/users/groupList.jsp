<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet" href="<c:url value="/stylesheets/style.css"/>"
	type="text/css" />
</head>
<body>

	<jsp:include page="../common/menu.jsp" />
	<div class="container">
		<h2>User group</h2>

		<div class="CSS_Table_Example" style="width: 600px; height: 150px;">

			<form:form method="post" action="groups/save.html"
				modelAttribute="groupFormList">
				<table>
					<tr>
						<td style="width: 350px;">N�</td>
						<td style="width: 350px;">Name</td>
					</tr>
					<c:forEach items="${groupFormList.groups}" var="groupForm"
						varStatus="status">
						<tr>
							<td align="center">${status.count}</td>
							<td><form:input path="groups[${status.index}].group.name"
								 /></td>							
						</tr>
					</c:forEach>
				</table>
				<br />
				<input type="submit" value="Save" />

			</form:form>
		</div>

	</div>
</body>

</html>