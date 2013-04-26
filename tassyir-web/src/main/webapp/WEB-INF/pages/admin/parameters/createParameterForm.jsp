<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tassyir" tagdir="/WEB-INF/tags"%>


<html lang="en">

<head>
<jsp:include page="./../../common/head.jsp"/>

</head>

<body>
	<div id="container">
		<jsp:include page="../../common/menu.jsp" />
		<c:forEach var="navig" items="${navigations}" varStatus="status">
							&laquo;
							<spring:url value="${navig.url}" var="navigs" />
							<a href="${navigs}"><spring:message code="${navig.name}" /></a>
		</c:forEach>
		<h2>Parameter</h2>

		<form:form modelAttribute="parameter" method="post" id="form1">

			<fieldset>
				<legend>Informations Parameter</legend>

				<p class="first">
					<label for="name">Name</label>
					<form:input label="name" path="name" />
					<form:errors cssClass="error" path="name" />
				</p>
				<p>
					<label for="value">value</label>
					<form:input label="value" path="value" />
					<form:errors cssClass="error" path="value" />
				</p>
			</fieldset>
			<fieldset>
				<p>
					<label for="description">Description</label>
					<form:textarea label="description" path="description" cols="30"
						rows="10" />
					<form:errors cssClass="error" path="description" />
				</p>
			</fieldset>
			<p class="submit">
				<button type="submit">Add user</button>
			</p>
		</form:form>
	</div>
</body>

</html>
