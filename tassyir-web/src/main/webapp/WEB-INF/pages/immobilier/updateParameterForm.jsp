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
<link rel="stylesheet" href="<c:url value="/stylesheets/screen.css"/>"
	type="text/css" media="screen" />
</head>

<body>
	<div id="container">
		<jsp:include page="../common/menu.jsp" />
		
	<h2>Parameter</h2>

	<form:form modelAttribute="parameter" method="put" id="form1">

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
				<button type="submit">Update user</button>
			</p>
		</form:form>
</div>
</body>

</html>
