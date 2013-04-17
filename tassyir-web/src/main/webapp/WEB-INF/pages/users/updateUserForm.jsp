<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<jsp:include page="./../common/head.jsp"/>
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
												path="firstName" class="text" cssErrorClass="error"/>
									</label></td>
									<td class="label"><form:label path="lastName">lastName</form:label></td>
									<td><label> <form:input label="lastName"
												path="lastName" class="text mediumtext" cssErrorClass="error"/>
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="login">login</form:label></td>
									<td><label> <form:input label="login" path="login"
												class="text" cssErrorClass="error"/>
									</label> <form:errors path="login" cssClass="error"/></td>
									<td class="label"><form:label path="code">code</form:label></td>
									<td><label> <form:input label="code" path="code"
												class="text mediumtext" cssErrorClass="error"/>
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="locked">locked</form:label></td>
									<td><label> <form:checkbox label="Locked"
												path="locked" />
									</label></td>
									<td class="label"><form:label path="isAdmin">isAdmin</form:label></td>
									<td><label><form:checkbox 
												path="isAdmin" /> </label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="userCategory.name">group </form:label></td>
									<td><label> <form:select path="userCategory.name" cssErrorClass="error">
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
								<td colspan="4" align="center" style="font: bold;">Roles list</td>
								</tr>
								<tr>
									<td colspan="4">
									
										<table>
											<tr>
												<td style="font-weight: bold;width: 20px;">N°</td>
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
									<td rowspan="10" class="label"><form:label
											path="adresse">adresse</form:label></td>
									<td rowspan="10"><label> <form:textarea cols="26"
												rows="10" label="adresse"
												path="adresse" class="text textBoxfieldlong" cssErrorClass="error"/>
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="ville">ville</form:label></td>
									<td><label> <form:input
												label="ville" path="ville"
												class="text" cssErrorClass="error"/>
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label
											path="codePostal">codePostal</form:label></td>
									<td><label> <form:input
												label="codePostal"
												path="codePostal" class="text" cssErrorClass="error"/>
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label
											path="telephonePerso">telephonePerso</form:label></td>
									<td><label> <form:input
												label="telephonePerso"
												path="telephonePerso" class="text" cssErrorClass="error"/>
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label
											path="alerteSurTelephone1">alerte Telephone1</form:label></td>
									<td><label> <form:checkbox
												path="alerteSurTelephone1" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label
											path="telephoneProf">telephoneProf</form:label></td>
									<td><label> <form:input
												label="telephoneProf"
												path="telephoneProf" class="text" cssErrorClass="error"/>
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label
											path="alerteSurTelephone2">alerte  Telephone2</form:label></td>
									<td><label> <form:checkbox
												path="alerteSurTelephone2" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label
											path="telephoneMobile">telephoneMobile</form:label></td>
									<td><label> <form:input
												label="telephoneMobile"
												path="telephoneMobile" class="text" cssErrorClass="error"/>
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label
											path="adresseMail">EMail</form:label></td>
									<td><label> <form:input
												label="adresseMail"
												path="adresseMail" class="text" cssErrorClass="error"/>
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label
											path="siteWeb">site Web</form:label></td>
									<td><label> <form:input
												label="siteWeb" path="siteWeb"
												class="text" cssErrorClass="error"/>
									</label></td>
								</tr>
								<tr>
									<td class="label">&nbsp;</td>
									<td>&nbsp;</td>
									<td colspan="2" class="label"><label> <input
											type="image"  src='<c:url value="/resources/graphics/searchbtn.gif"/>' alt="search"
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

