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
	<div class="container">
		<h2>Parameters</h2>

		

			<form:form method="post" action="save.html"
				modelAttribute="contactForm">
				<div class="CSS_Table_Example" style="width: 600px; height: 150px;">
				<table>
					<tr>
						<th>N°</th>
						<th>Name</th>
						<th>Value</th>
						<th>Desc</th>
					</tr>
					<c:forEach items="${selections}" var="parameter" varStatus="status">
						<tr>
							<td align="center">${status.count}</td>
							<td><input name="selections[${status.index}].name"
								value="${parameter.name}" /></td>
							<td><input name="selections[${status.index}].value"
								value="${parameter.value}" /></td>
							<td><input name="selections[${status.index}].description"
								value="${parameter.description}" /></td>
						</tr>
					</c:forEach>
				</table>
				</div>
				<br />
				<input type="submit" value="Save" />
				
			</form:form>

		</div>

	
</body>

</html>




