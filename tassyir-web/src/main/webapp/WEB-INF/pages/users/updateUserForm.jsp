<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet" href="<c:url value="/stylesheets/style.css"/>"
	type="text/css" />
<link rel="stylesheet" href="<c:url value="/stylesheets/forms.css"/>"
	type="text/css" />

<link rel="stylesheet"
	href="<c:url value="/stylesheets/carroussel.css"/>" type="text/css" />
<script type="text/javascript" src="scripts/jquery-1.9.1.js">
	
</script>
<script type="text/javascript" src="scripts/carroussel.js">
	
</script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="../common/menu.jsp" />
		<div id="content">
			<jsp:include page="../common/sub-menu.jsp" />

			<div id="home_main_edit_user">
				<div id="edit_user">
					<div class="tab">
						<h2>Update user infos</h2>
					</div>
					<div class="container">
						<form:form modelAttribute="user" method="put" id="form1">
							<table class="edit_form_user" style="width: 100%; border: none;">
								<tr>
									<td class="label"><form:label path="firstName">firstName</form:label></td>
									<td><label> <form:input label="firstName"
												path="firstName" class="text" />
									</label></td>
									<td class="label"><form:label path="lastName">lastName</form:label></td>
									<td><label> <form:input label="lastName"
												path="lastName" class="text mediumtext" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="login">login</form:label></td>
									<td><label> <form:input label="login" path="login"
												class="text" />
									</label></td>
									<td class="label"><form:label path="code">code</form:label></td>
									<td><label> <form:input label="code" path="code"
												class="text mediumtext" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="locked">locked</form:label></td>
									<td><label> <form:checkbox label="Locked"
												path="locked" />
									</label></td>
									<td class="label"><form:label path="isAdmin">isAdmin</form:label></td>
									<td><label><form:checkbox label="Admin"
												path="isAdmin" /> </label></td>
								</tr>
								<tr>
									<td style="font-weight: bold;">Roles</td>
									<td>
										<table>
											<tr>
												<td style="font-weight: bold;">N°</td>
												<td style="font-weight: bold; width: 150px;">Name</td>
												<td style="font-weight: bold; width: 450px;">description</td>
												<td style="font-weight: bold;">Included</td>
											</tr>
											<c:forEach items="${user.roleFormList.roles}" var="roleForm"
												varStatus="status">
												<tr>
													<td><label> ${status.count}</label></td>
													<td><label>${roleForm.role.name}</label> <label><form:hidden
																path="roleFormList.roles[${status.index}].role.name" /></label></td>
													<td><label>${roleForm.role.description}</label></td>
													<td><label><form:checkbox
																path="roleFormList.roles[${status.index}].included" /></label></td>
												</tr>
											</c:forEach>
										</table>
									</td>
								</tr>
							</table>

							<table class="edit_form" style="width: 100%; border: none;">

								<tr>
									<td class="label"><form:label path="contact.nameContact">nameContact</form:label></td>
									<td><label> <form:input
												label="contact.nameContact" path="contact.nameContact"
												class="text" />
									</label></td>
									<td class="label"><form:label
											path="contact.nomSocieteContact">nomSocieteContact</form:label></td>
									<td><label> <form:input
												label="contact.nomSocieteContact"
												path="contact.nomSocieteContact" class="text mediumtext" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="contact.typeContact">typeContact</form:label></td>
									<td><label> <form:select
												path="contact.typeContact">
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
									</label></td>
									<td class="label"><form:label path="contact.titreContact">titreContact</form:label></td>
									<td><label> <form:input
												label="contact.titreContact" path="contact.titreContact"
												class="text mediumtext" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label
											path="contact.adresseContact1">adresseContact1</form:label></td>
									<td><label> <form:input
												label="contact.adresseContact1"
												path="contact.adresseContact1" class="text" />
									</label></td>
									<td class="label"><form:label
											path="contact.adresseContact2">adresseContact2</form:label></td>
									<td><label> <form:input
												label="contact.adresseContact2"
												path="contact.adresseContact2" class="text mediumtext" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label
											path="contact.alerteSurTelephone1">alerteSurTelephone1</form:label></td>
									<td><label> <form:checkbox
												label="alerteSurTelephone1"
												path="contact.alerteSurTelephone1" />
									</label></td>
									<td class="label"><form:label
											path="contact.alerteSurTelephone1">alerteSurTelephone1</form:label></td>
									<td><label> <form:checkbox
												label="alerteSurTelephone2"
												path="contact.alerteSurTelephone2" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label
											path="contact.codePostalContact">codePostalContact</form:label></td>
									<td><label> <form:input
												label="contact.codePostalContact"
												path="contact.codePostalContact" class="text" />
									</label></td>
									<td class="label"><form:label
											path="contact.estContactPrincipal">estContactPrincipal</form:label></td>
									<td><label> <form:checkbox
												label="estContactPrincipal"
												path="contact.estContactPrincipal" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="contact.villeContact">villeContact</form:label></td>
									<td><label> <form:input
												label="contact.villeContact" path="contact.villeContact"
												class="text" />
									</label></td>
									<td class="label"><form:label
											path="contact.adresseMailContact">adresseMailContact</form:label></td>
									<td><label> <form:input
												label="contact.adresseMailContact"
												path="contact.adresseMailContact" class="text mediumtext" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="contact.faxContact">faxContact</form:label></td>
									<td><label> <form:input label="contact.faxContact"
												path="contact.faxContact" class="text" />
									</label></td>
									<td class="label"><form:label
											path="contact.siteWebContact">siteWebContact</form:label></td>
									<td><label> <form:input
												label="contact.siteWebContact" path="contact.siteWebContact"
												class="text mediumtext" />
									</label></td>
								</tr>

								<tr>
									<td class="label"><form:label
											path="contact.telephoneContact1">telephoneContact1</form:label></td>
									<td><label> <form:input
												label="contact.telephoneContact1"
												path="contact.telephoneContact1" class="text" />
									</label></td>
									<td class="label"><form:label
											path="contact.telephoneContact2">telephoneContact2</form:label></td>
									<td><label> <form:input
												label="contact.telephoneContact2"
												path="contact.telephoneContact2" class="text mediumtext" />
									</label></td>
								</tr>

								<tr>
									<td class="label"><form:label path="userCategory.name">userCategory </form:label></td>
									<td><label> <form:select path="userCategory.name">
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
									</label></td>
								</tr>
								<tr>
									<td class="label">&nbsp;</td>
									<td>&nbsp;</td>
									<td colspan="2" class="label"><label> <input
											type="image" src="../../graphics/searchbtn.gif" alt="search"
											name="button2" id="button2" value="Submit" />
									</label></td>
								</tr>
							</table>
						</form:form>
					</div>
					<div class="bottom"></div>
				</div>
			</div>
			<div class="clear">&nbsp;</div>
			<div class="clear">&nbsp;</div>
			<jsp:include page="../common/footer.jsp" />
		</div>
	</div>
</body>
</html>

