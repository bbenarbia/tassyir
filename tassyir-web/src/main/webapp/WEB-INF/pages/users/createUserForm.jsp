<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<jsp:include page="./../common/head.jsp" />
</head>
<body>
	<div id="wrap">
		<jsp:include page="../common/menu.jsp" />
		<div id="content">
			<jsp:include page="../common/sub-menu.jsp" />

			<div id="home_main_edit_user">
				<div id="edit_user">
					<div class="tab">
						<h2>Create new user</h2>
					</div>
					<div class="container">
						<form:form modelAttribute="user" method="post" id="form1">
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
									<td><label><form:checkbox path="isAdmin" /> </label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="password">password</form:label></td>
									<td><label> <form:password label="password"
												path="password" class="text" />
									</label></td>
									<td class="label"><form:label path="code">Confirmation</form:label></td>
									<td><label> <form:password
												label="passwordConfirmation" path="passwordConfirmation"
												class="text mediumtext" />
									</label></td>
								</tr>
								<tr>
									<td colspan="4" align="center" style="font: bold;">Roles
										list</td>
								</tr>
								<tr>
									<td colspan="4">
										<table>
											<tr>
												<td style="font-weight: bold; width: 20px;">N°</td>
												<td style="font-weight: bold; width: 150px;">Name</td>
												<td style="font-weight: bold; width: 300px;">description</td>
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
									<td colspan="4" align="center">Contact infos</td>
								</tr>
								<tr>
									<td class="label"><form:label path="contact.nameContact">nameContact</form:label></td>
									<td><label> <form:input
												label="contact.nameContact" path="contact.nameContact"
												class="text" />
									</label></td>
									<td class="label"><form:label
											path="contact.nomSocieteContact">nom Societe</form:label></td>
									<td><label> <form:input
												label="contact.nomSocieteContact"
												path="contact.nomSocieteContact" class="text" />
									</label></td>
								</tr>
								<tr>
									<td rowspan="2" class="label"><form:label
											path="contact.adresseContact1">adresse</form:label></td>
									<td rowspan="2"><label> <form:textarea cols="26"
												rows="10" label="contact.adresseContact1"
												path="contact.adresseContact1" class="text textBoxfieldlong" />
									</label></td>
									<td class="label"><form:label
											path="contact.codePostalContact">code Postal</form:label></td>
									<td><label> <form:input
												label="contact.codePostalContact"
												path="contact.codePostalContact" class="text" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="contact.villeContact">ville</form:label></td>
									<td><label> <form:input
												label="contact.villeContact" path="contact.villeContact"
												class="text" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label
											path="contact.telephoneContact1">telephone 1</form:label></td>
									<td><label> <form:input
												label="contact.telephoneContact1"
												path="contact.telephoneContact1" class="text" />
									</label></td>
									<td class="label"><form:label
											path="contact.alerteSurTelephone1">alerte Telephone1</form:label></td>
									<td><label> <form:checkbox
												path="contact.alerteSurTelephone1" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label
											path="contact.telephoneContact2">telephone 2</form:label></td>
									<td><label> <form:input
												label="contact.telephoneContact2"
												path="contact.telephoneContact2" class="text" />
									</label></td>
									<td class="label"><form:label
											path="contact.alerteSurTelephone1">alerte  Telephone2</form:label></td>
									<td><label> <form:checkbox
												path="contact.alerteSurTelephone2" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label
											path="contact.adresseMailContact">EMail</form:label></td>
									<td><label> <form:input
												label="contact.adresseMailContact"
												path="contact.adresseMailContact" class="text" />
									</label></td>
									<td class="label"><form:label
											path="contact.siteWebContact">site Web</form:label></td>
									<td><label> <form:input
												label="contact.siteWebContact" path="contact.siteWebContact"
												class="text" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="contact.typeContact">type Contact</form:label></td>
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
									<td class="label"><form:label path="userCategory.name">group </form:label></td>
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
									<td>&nbsp;</td>
									<td class="label"><label> <input type="image"
											src='<c:url value="/resources/graphics/searchbtn.gif"/>'
											alt="search" name="button2" id="button2" value="Submit" />
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


