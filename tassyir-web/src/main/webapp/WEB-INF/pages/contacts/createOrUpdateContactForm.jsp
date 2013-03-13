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
			<c:when test="${contact['new']}">
				<c:set var="method" value="post" />
			</c:when>
			<c:otherwise>
				<c:set var="method" value="put" />
			</c:otherwise>
		</c:choose>

		<h2>
			<c:if test="${contact['new']}">New </c:if>
			Contact
		</h2>
		<form:form modelAttribute="contact" method="${method}"
			class="form-horizontal" id="add-contact-form">
			<tassyir:inputField label="Name" name="name" />
			<tassyir:inputField label="nomSocieteContact" name="nomSocieteContact" />
			<tassyir:inputField label="typeContact" name="typeContact" />
			<tassyir:inputField label="titreContact" name="titreContact" />
			<tassyir:inputField label="adresseContact1" name="adresseContact1" />
			<tassyir:inputField label="adresseContact2" name="adresseContact2" />
			<tassyir:inputField label="alerteSurTelephone1" name="alerteSurTelephone1" />
			<tassyir:inputField label="alerteSurTelephone2" name="alerteSurTelephone2" />
			<tassyir:inputField label="codePostalContact" name="codePostalContact" />
			<tassyir:inputField label="estContactPrincipal" name="estContactPrincipal" />
			<tassyir:inputField label="villeContact" name="villeContact" />
			<tassyir:inputField label="adresseMailContact" name="adresseMailContact" />
			<tassyir:inputField label="faxContact" name="faxContact" />
			<tassyir:inputField label="siteWebContact" name="siteWebContact" />
			<tassyir:inputField label="telephoneContact1" name="telephoneContact1" />
			<tassyir:inputField label="telephoneContact2" name="telephoneContact2" />

			<div class="form-actions">
				<c:choose>
					<c:when test="${contact['new']}">
						<button type="submit">Add contact</button>
					</c:when>
					<c:otherwise>
						<button type="submit">Update contact</button>
					</c:otherwise>
				</c:choose>
			</div>
		</form:form>
	</div>
</body>

</html>
