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
	<div class="container">
		<h2>Parameters</h2>

		<div class="CSS_Table_Example" style="width: 600px; height: 150px;">
			<table>
				<tr>
					<td style="width: 350px;">Name</td>
					<td style="width: 350px;">Value</td>
					<td style="width: 300px;">Description</td>
					<td style="width: 150px;">Edit</td>
					<td style="width: 150px;">Add</td>
				</tr>
				<c:forEach var="parameter" items="${selections}">
					<tr>
						<td><b><c:out value="${parameter.name}" /></b></td>
						<td><c:out value="${parameter.value}" /></td>
						<td><c:out value="${parameter.description}" /></td>
						
						<td><a href="parameters/${parameter.id}/edit">Edit</a></td>
						<td><a href="parameters/${parameter.id}/delete">Delete</a></td>
					</tr>
				</c:forEach>
				<tr>
				<td colspan="4" /> 
				<td>
                  	 <spring:url value="/parameters/new" var="parameterUrl" />
			                    <a href="${fn:escapeXml(parameterUrl)}">Add parameter</a>
			         </td>
				</tr>
			</table>
		</div>

	</div>
</body>

</html>