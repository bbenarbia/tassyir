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
	<h2>
		User
	</h2>

	<form:form modelAttribute="user" method="put" id="add-user-form">

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
								<td><form:input label="First Name" path="firstName" /></td>
							</tr>
							<tr>
								<td><form:label path="lastName">lastName</form:label></td>
								<td><form:input label="Last Name" path="lastName" /></td>
							</tr>
							<tr>
								<td><form:label path="login">login</form:label></td>
								<td><form:input label="Login" path="login" /></td>
							</tr>
							<tr>
								<td><form:label path="code">code</form:label></td>
								<td><form:input label="Code" path="code" /></td>
							</tr>
							<tr>
								<td><form:label path="password">password</form:label></td>
								<td><form:password  path="password" /></td>
							</tr>
							<tr>
								<td><form:label path="passwordConfirmation">passwordConfirmation</form:label></td>
								<td><form:password path="passwordConfirmation" /></td>
							</tr>
							<tr>
								<td><form:label path="locked">locked</form:label></td>
								<td><form:checkbox label="Locked" path="locked" /></td>
							</tr>
							<tr>
								<td><form:label path="isAdmin">Admin</form:label></td>
								<td><form:checkbox label="Admin" path="isAdmin" /></td>
							</tr>
						<%--  <tr>
								<td><form:label path="userCategory">user group</form:label></td>
								<td>
									<form:select path="userCategory" items="${userGroupList}" />
								<form:select  path="userCategory" >
										<form:options items="${userGroupList}" itemLabel="${userCategory.name}" itemValue="${userCategory.id}"/>
								</form:select>
								</td>
							</tr>  --%>
							
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
								<td><form:input label="contact.nameContact" path="contact.nameContact" />
								</td>
								<td><form:label path="contact.nomSocieteContact">contact.nomSocieteContact</form:label>
								</td>
								<td><form:input label="contact.nomSocieteContact"
										path="contact.nomSocieteContact" /></td>
							</tr>
							<tr>
								<td>
									<form:label path="contact.typeContact">contact.typeContact</form:label>
								</td>
								<td>
									<form:select path="contact.typeContact">
									<c:forEach var="item" items="${typeContactList}">
									    <c:choose>
									        <c:when test="${user.contact.typeContact == item}">
									            <form:option selected="true" value="${item}">
									                ${item} 
									            </form:option>
									        </c:when>
									
									        <c:otherwise>
									            <form:option value="${item}">
									                   ${item}
									            </form:option>
									        </c:otherwise>
									    </c:choose>
									</c:forEach>
									</form:select>
								</td>
								<td><form:label path="contact.titreContact">contact.titreContact</form:label>
								</td>
								<td><form:input label="contact.titreContact"
										path="contact.titreContact" /></td>
							</tr>
							<tr>
								<td><form:label path="contact.adresseContact1">contact adresseContact1</form:label>
								</td>
								<td><form:input label="contact.adresseContact1"
										path="contact.adresseContact1" /></td>
								<td><form:label path="contact.adresseContact2">adresseContact2</form:label>
								</td>
								<td><form:input label="contact.adresseContact2"
										path="contact.adresseContact2" /></td>
							</tr>
							<tr>
								<td><form:label path="contact.alerteSurTelephone1">alerteSurTelephone1</form:label>
								</td>
								<td><form:checkbox label="alerteSurTelephone1"
										path="contact.alerteSurTelephone1" /></td>
								<td><form:label path="contact.alerteSurTelephone2">alerteSurTelephone2</form:label>
								</td>
								<td><form:checkbox label="alerteSurTelephone2"
										path="contact.alerteSurTelephone2" /></td>
							</tr>
							<tr>
								<td><form:label path="contact.codePostalContact">codePostalContact</form:label>
								</td>
								<td><form:input label="contact.codePostalContact"
										path="contact.codePostalContact" /></td>
								<td><form:label path="contact.estContactPrincipal">estContactPrincipal</form:label>
								</td>
								<td><form:checkbox label="estContactPrincipal"
										path="contact.estContactPrincipal" /></td>
							</tr>
							<tr>
								<td><form:label path="contact.villeContact">villeContact</form:label>
								</td>
								<td><form:input label="contact.villeContact"
										path="contact.villeContact" /></td>
								<td><form:label path="contact.adresseMailContact">adresseMailContact</form:label>
								</td>
								<td><form:input label="contact.adresseMailContact"
										path="contact.adresseMailContact" /></td>
							</tr>
							<tr>
								<td><form:label path="contact.faxContact">faxContact</form:label>
								</td>
								<td><form:input label="contact.faxContact"
										path="contact.faxContact" /></td>
								<td><form:label path="contact.siteWebContact">siteWebContact</form:label>
								</td>
								<td><form:input label="contact.siteWebContact"
										path="contact.siteWebContact" /></td>
							</tr>
							<tr>
								<td><form:label path="contact.telephoneContact1">telephoneContact1</form:label>
								</td>
								<td><form:input label="contact.telephoneContact1"
										path="contact.telephoneContact1" /></td>
								<td><form:label path="contact.telephoneContact2">telephoneContact2</form:label>
								</td>
								<td><form:input label="contact.telephoneContact2"
										path="contact.telephoneContact2" /></td>
							</tr>
							<tr>
								<td><form:label path="userCategory.name">userCategory.name</form:label>
								</td>
								<td>
									<form:select path="userCategory.name">
									<c:forEach var="item" items="${userGroupList}">
									    <c:choose>
									        <c:when test="${user.userCategory.name == item}">
									            <form:option selected="true" value="${item}">
									                ${item} 
									            </form:option>
									        </c:when>
									
									        <c:otherwise>
									            <form:option value="${item}">
									                   ${item}
									            </form:option>
									        </c:otherwise>
									    </c:choose>
									</c:forEach>
									</form:select>
										</td>
								<td></td>
								<td></td>

							</tr> 
						</table>
					</div>
				</td>
			</tr>
		</table>

		<div class="CSS_Table_Example" style="text-align: right;">
			<table>
				<tr>
					<td>
						<button type="submit">Update user</button>
					</td>
				</tr>
			</table>
		</div>


	</form:form>


</body>

</html>
