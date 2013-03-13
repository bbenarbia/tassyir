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
	<div class="container">
		<c:choose>
			<c:when test="${user['new']}">
				<c:set var="method" value="post" />
			</c:when>
			<c:otherwise>
				<c:set var="method" value="put" />
			</c:otherwise>
		</c:choose>

		<h2>
			<c:if test="${user['new']}">New </c:if>
			User
		</h2>
		<form:form modelAttribute="user" method="${method}"
			class="form-horizontal" id="add-user-form">
			<tassyir:inputField label="First Name" name="firstName" />
			<tassyir:inputField label="Last Name" name="lastName" />
			<tassyir:inputField label="Login" name="login" />
			<tassyir:inputField label="Code" name="code" />
			<tassyir:inputField label="Password" name="password" />

			<div class="form-actions">
				<c:choose>
					<c:when test="${user['new']}">
						<button type="submit">Add user</button>
					</c:when>
					<c:otherwise>
						<button type="submit">Update user</button>
					</c:otherwise>
				</c:choose>
			</div>
		</form:form>
	</div>
</body>

</html>
