<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<html lang="en">
<head>
<jsp:include page="./../../common/head.jsp"/>
</head>
<body>
	<div id="container">
		<jsp:include page="../../common/menu.jsp" />
		<h2>rechercher logements</h2>

		<div class="CSS_Table_Example" style="width: 600px; height: 150px;">
			<table>
				<tr>
					<td><select name="departementsList">
							<c:forEach var="item" items="${departementsList}">
								<c:choose>
									<option value="${item}">${item}</option>
								</c:choose>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td><select name="typesLogementList">
							<c:forEach var="item" items="${typesLogementList}">
								<c:choose>
									<option value="${item}">${item}</option>
								</c:choose>
							</c:forEach>
					</select></td>
				</tr>
			</table>
		</div>
	</div>
</body>

</html>