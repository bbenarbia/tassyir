<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tassyir" tagdir="/WEB-INF/tags"%>


<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />


<title></title>
<link rel="stylesheet" href="<c:url value="/stylesheets/style.css"/>"
	type="text/css" />
</head>

<body>
	<jsp:include page="../common/menu.jsp" />
	<h2>User</h2>

	<form:form modelAttribute="user" method="post" id="add-user-form">

		<table>

			<tr>
				<td>
					<div class="CSS_Table_Example">
						<table>
							<tr>
								<td colspan="2">Informations Utilisateur</td>
							</tr>
							<tr>
								<td><form:label path="firstName">firstName</form:label></td>
								<td><form:input label="First Name" path="firstName" /> <form:errors
										cssClass="error" path="firstName" /></td>
							</tr>
							<tr>
								<td><form:label path="lastName">lastName</form:label></td>
								<td><form:input label="Last Name" path="lastName" /> <form:errors
										cssClass="error" path="lastName" /></td>
							</tr>
							<tr>
								<td><form:label path="login">login</form:label></td>
								<td><form:input label="Login" path="login" /> <form:errors
										cssClass="error" path="login" /></td>
							</tr>
							<tr>
								<td><form:label path="code">code</form:label></td>
								<td><form:input label="Code" path="code" /> <form:errors
										cssClass="error" path="code" /></td>
							</tr>
							<tr>
								<td><form:label path="passwordConfirmation">passwordConfirmation</form:label></td>
								<td><form:password label="passwordConfirmation"
										path="passwordConfirmation" /> <form:errors cssClass="error"
										path="passwordConfirmation" /></td>
							</tr>
							<tr>
								<td><form:label path="password">password</form:label></td>
								<td><form:password label="Password" path="password" /> <form:errors
										cssClass="error" path="password" /></td>
							</tr>
							<tr>
								<td><form:label path="locked">locked</form:label></td>
								<td><form:checkbox label="Locked" path="locked" /> <form:errors
										cssClass="error" path="locked" /></td>
							</tr>
							<tr>
								<td><form:label path="isAdmin">Admin</form:label></td>
								<td><form:checkbox label="Admin" path="isAdmin" /> <form:errors
										cssClass="error" path="isAdmin" /></td>
							</tr>
						</table>
					</div>
				</td>
				<td>
					<div class="CSS_Table_Example">
						<table>
							<tr>
								<td colspan="4">Informations Contact</td>
							</tr>
							<tr>
								<td><form:label path="contact.nameContact">contact name</form:label>
								</td>
								<td><form:input path="contact.nameContact" /> <form:errors
										cssClass="error" path="contact.nameContact" /></td>
								<td><form:label path="contact.nomSocieteContact">contact.nomSocieteContact</form:label>
								</td>
								<td><form:input path="contact.nomSocieteContact" /> <form:errors
										cssClass="error" path="contact.nomSocieteContact" /></td>
							</tr>
							<tr>
								<td>
									<form:label path="contact.typeContact">contact.typeContact</form:label>
								</td>
								<td>
									<form:select path="contact.typeContact" items="${typeContactList}" />
								</td> 
								
								<td><form:label path="contact.titreContact">contact.titreContact</form:label>
								</td>
								<td><form:input path="contact.titreContact" /> <form:errors
										cssClass="error" path="contact.titreContact" /></td>
							</tr>
							<tr>
								<td><form:label path="contact.adresseContact1">contact adresseContact1</form:label>
								</td>
								<td><form:input path="contact.adresseContact1" /> <form:errors
										cssClass="error" path="contact.adresseContact1" /></td>
								<td><form:label path="contact.adresseContact2">adresseContact2</form:label>
								</td>
								<td><form:input path="contact.adresseContact2" /> <form:errors
										cssClass="error" path="contact.adresseContact2" /></td>
							</tr>
							<tr>
								<td><form:label path="contact.alerteSurTelephone1">alerteSurTelephone1</form:label>
								</td>
								<td><form:checkbox label="alerteSurTelephone1"
										path="contact.alerteSurTelephone1" /> <form:errors
										cssClass="error" path="contact.alerteSurTelephone1" /></td>
								<td><form:label path="contact.alerteSurTelephone2">alerteSurTelephone2</form:label>
								</td>
								<td><form:checkbox path="contact.alerteSurTelephone2" /> <form:errors
										cssClass="error" path="contact.alerteSurTelephone2" /></td>
							</tr>
							<tr>
								<td><form:label path="contact.codePostalContact">codePostalContact</form:label>
								</td>
								<td><form:input path="contact.codePostalContact" /> <form:errors
										cssClass="error" path="contact.codePostalContact" /></td>
								<td><form:label path="contact.estContactPrincipal">estContactPrincipal</form:label>
								</td>
								<td><form:checkbox path="contact.estContactPrincipal" /> <form:errors
										cssClass="error" path="contact.estContactPrincipal" /></td>
							</tr>
							<tr>
								<td><form:label path="contact.villeContact">villeContact</form:label>
								</td>
								<td><form:input path="contact.villeContact" /> <form:errors
										cssClass="error" path="contact.villeContact" /></td>
								<td><form:label path="contact.adresseMailContact">adresseMailContact</form:label>
								</td>
								<td><form:input path="contact.adresseMailContact" /> <form:errors
										cssClass="error" path="contact.adresseMailContact" /></td>
							</tr>
							<tr>
								<td><form:label path="contact.faxContact">faxContact</form:label>
								</td>
								<td><form:input path="contact.faxContact" /> <form:errors
										cssClass="error" path="contact.faxContact" /></td>
								<td><form:label path="contact.siteWebContact">siteWebContact</form:label>
								</td>
								<td><form:input path="contact.siteWebContact" /> <form:errors
										cssClass="error" path="contact.siteWebContact" /></td>
							</tr>
							<tr>
								<td><form:label path="contact.telephoneContact1">telephoneContact1</form:label>
								</td>
								<td><form:input path="contact.telephoneContact1" /> <form:errors
										cssClass="error" path="contact.telephoneContact1" /></td>
								<td><form:label path="contact.telephoneContact2">telephoneContact2</form:label>
								</td>
								<td><form:input path="contact.telephoneContact2" /> <form:errors
										cssClass="error" path="contact.telephoneContact2" /></td>
							</tr>
							<tr>
								<td><form:label path="userCategory.name">userCategory.name</form:label>
								</td>
								<td>
									<form:select path="userCategory.name" items="${userGroupList}" />
									</td>
								<td></td>
								<td></td>

							</tr>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<button type="submit">Add user</button>
				</td>
			</tr>
		</table>

	</form:form>


</body>

</html>
