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
<link rel="stylesheet" href="<c:url value="/stylesheets/screen.css"/>"
	type="text/css" media="screen" />
</head>

<body>
	<div id="container">
		<jsp:include page="../common/menu.jsp" />
		<jsp:include page="../common/menu-users.jsp" />
		<h2>User</h2>

	<form:form modelAttribute="user" method="post" id="form1">
		<table>
			<tr>
				<td>
					<div class="CSS_Table_Example" >
						<table >
							<tr>
								<td colspan="2" >Informations Utilisateur</td>
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
							<tr>
								<td>Roles</td>
								<td>
									<table>
										<tr>
											<td style="width: 50px;">N°</td>
											<td style="width: 150px;">Name</td>
											<td style="width: 150px;">description</td>
											<td style="width: 150px;">Included</td>
										</tr>
										<c:forEach items="${user.roleFormList.roles}" var="roleForm"
											varStatus="status">
											<tr>
												<td align="center">${status.count}</td>
												<td>
													<c:out value="${roleForm.role.name}"></c:out> <form:hidden
														path="roleFormList.roles[${status.index}].role.name" /></td>
												<td>
													<c:out value="${roleForm.role.description}"></c:out></td>
												<td>
													<form:checkbox
														path="roleFormList.roles[${status.index}].included" /></td>
											</tr>
										</c:forEach>
									</table>
								</td>
							</tr>
						</table>
					</div>
				</td>
				</tr>
				<tr>
				<td>
					<div class="CSS_Table_Example">
						<table>
							<tr>
								<td colspan="4" width="80%;">Informations Contact</td>
							</tr>
							<tr>
								<td ><form:label path="contact.nameContact">contact name</form:label>
								</td>
								<td><form:input path="contact.nameContact" /> <form:errors
										cssClass="error" path="contact.nameContact" /></td>
								<td><form:label path="contact.nomSocieteContact">nomSocieteContact</form:label>
								</td>
								<td><form:input path="contact.nomSocieteContact" /> <form:errors
										cssClass="error" path="contact.nomSocieteContact" /></td>
							</tr>
							<tr>
								<td>
									<form:label path="contact.typeContact">typeContact</form:label>
								</td>
								<td>
									<form:select path="contact.typeContact" items="${typeContactList}" />
								</td> 
								
								<td><form:label path="contact.titreContact">titreContact</form:label>
								</td>
								<td><form:input path="contact.titreContact" /> <form:errors
										cssClass="error" path="contact.titreContact" /></td>
							</tr>
							<tr>
								<td><form:label path="contact.adresseContact1">adresseContact1</form:label>
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
		</table>

		<p class="submit">
				<a class="cancelButton" href="javascript: history.go(-1)"> Back </a>
				<button type="submit">Add user</button>
		</p>
	</form:form>

</div>
</body>

</html>
