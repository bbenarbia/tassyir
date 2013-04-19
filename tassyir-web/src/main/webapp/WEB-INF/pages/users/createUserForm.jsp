<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<jsp:include page="./../common/head.jsp" />
<title>Tassyir: Create a new user</title>
</head>
<body>
	<spring:url value="/users.htm" var="userListUrl"> </spring:url>
	<spring:url value="/" var="homeUrl"> </spring:url>
	<spring:url value="/users/new.htm" var="userUrl" />
	
	<div id="wrap">
		<jsp:include page="../common/menu.jsp" />
		<div id="content">
			<jsp:include page="../common/sub-menu.jsp" />

			<div id="home_main_edit_user">
				<div class="navig">
					<c:forEach var="navig" items="${navigations}" varStatus="status">
						&laquo;
						<spring:url value="${navig.url}" var="navigs" />
						<a href="${navigs}"><spring:message code="${navig.name}" /></a>
					</c:forEach>
				</div>
				
				<div id="edit_user">
					<div class="tab">
						<h2>Create new user</h2>
					</div>
					<div class="container">
						<form:form modelAttribute="user" method="put" id="form1">
							<table class="edit_form_user" style="width: 100%; border: none;">							 
								<tr>
									<td class="label"><form:label path="firstName"><spring:message code="user.firstName" /></form:label></td>
									<td><label> <form:input label="firstName"
												path="firstName" class="text" cssErrorClass="error"/>
									</label></td>
									<td class="label"><form:label path="lastName"><spring:message code="user.lastName" /></form:label></td>
									<td><label> <form:input label="lastName"
												path="lastName" class="text" cssErrorClass="error"/>
									</label></td> 
								</tr>
								<tr>
									<td class="label"><form:label path="login"><spring:message code="user.login" /></form:label></td>
									<td><label> <form:input label="login" path="login"
												class="text" cssErrorClass="error"/>
												<form:errors path="login" cssClass="error_code"/>
									</label></td>
									<td class="label"><form:label path="code"><spring:message code="user.code" /></form:label></td>
									<td><label> <form:input label="code" path="code"
												class="text mediumtext" cssErrorClass="error"/>
												<form:errors path="code" cssClass="error_code"/>
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="locked"><spring:message code="user.locked" /></form:label></td>
									<td><label> <form:checkbox
												path="locked" />
									</label></td>
									<td class="label"><form:label path="isAdmin"><spring:message code="user.isAdmin" /></form:label></td>
									<td><label><form:checkbox path="isAdmin" /> </label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="password"><spring:message code="user.password" /></form:label></td>
									<td><label> <form:password label="password"
												path="password" class="text" cssErrorClass="error"/></label></td>
									<td class="label"><form:label path="passwordConfirmation"><spring:message code="user.confirmation" /></form:label></td>
									<td><label> <form:password label="passwordConfirmation"
												path="passwordConfirmation" class="text" cssErrorClass="error"/></label></td>
									
								</tr>
								
								<tr>
									<td class="label"><form:label path="userCategory.name"><spring:message code="user.group" /> </form:label></td>
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
									<td colspan="4" align="center" style="font: bold;"><spring:message code="user.roles" />
									</td>
								</tr>
								<tr>
									<td colspan="4">
										<table>
											<tr>
												<td style="font-weight: bold; width: 20px;"><spring:message code="user.num" /></td>
												<td style="font-weight: bold; width: 150px;"><spring:message code="user.rolename" /></td>
												<td style="font-weight: bold; width: 300px;"><spring:message code="user.roledescription" /></td>
												<td style="font-weight: bold;"><spring:message code="user.included" /></td>
											</tr>
											<c:forEach items="${user.roleFormList.roles}" var="roleForm" varStatus="status">
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
									<td colspan="4" align="center"><spring:message code="user.contact" /></td>
								</tr>
								<tr>
									<td  class="label"><form:label
											path="adresse"><spring:message code="user.adresse" /></form:label></td>
								</tr>
								<tr>
									<td rowspan="8"><label> <form:textarea cols="26"
												rows="10" label="adresse"
												path="adresse" class="text textBoxfieldlong" cssErrorClass="error"/>
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="ville"><spring:message code="user.ville" /></form:label></td>
									<td colspan="2"><label> <form:input
												label="ville" path="ville"
												class="text" cssErrorClass="error"/>
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label
											path="codePostal"><spring:message code="user.codePostal" /></form:label></td>
									<td colspan="2"><label> <form:input
												label="codePostal"
												path="codePostal" class="text" cssErrorClass="error"/>
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label
											path="telephonePerso"><spring:message code="user.telephonePerso" /></form:label></td>
									<td><label> <form:input
												label="telephonePerso"
												path="telephonePerso" class="text" cssErrorClass="error"/>
									</label></td>
									<td><form:checkbox path="alerteSurTelephone1" /><spring:message code="user.acceptalert" /></td>
								</tr>
								<tr>
									<td class="label"><form:label
											path="telephoneProf"><spring:message code="user.telephoneProf" /></form:label></td>
									<td><label> <form:input
												label="telephoneProf"
												path="telephoneProf" class="text" cssErrorClass="error"/>
									</label></td>
									<td><form:checkbox path="alerteSurTelephone2" /><spring:message code="user.acceptalert" /></td>
								</tr>
								<tr>
									<td class="label"><form:label
											path="telephoneMobile"><spring:message code="user.mobile" /></form:label></td>
									<td colspan="2"><label> <form:input
												label="telephoneMobile"
												path="telephoneMobile" class="text" cssErrorClass="error"/>
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label
											path="adresseMail"><spring:message code="user.email" /></form:label></td>
									<td colspan="2"><label> <form:input
												label="adresseMail"
												path="adresseMail" class="text" cssErrorClass="error"/>
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label
											path="siteWeb"><spring:message code="user.website" /></form:label></td>
									<td colspan="2"><label> <form:input
												label="siteWeb" path="siteWeb"
												class="text" cssErrorClass="error"/>
									</label></td>
								</tr>
								<tr>
								<td colspan="4">
									<table class="search_form" style="width: 100%; border: none;">
											<tr>
												<td  class="label"><spring:message code="user.photo" /></td>
												<td><label><form:input
														path="photoFile" type="file" accept="image/*" cssErrorClass="error"/>
												</label></td>
											</tr>
									</table>
								</td>
								</tr>	
								<tr>
									<td class="label">&nbsp;</td>
									<td>&nbsp;</td>
									<td><span class="listbuttons">
										<a class="buttonmenured"  href="${fn:escapeXml(userListUrl)}"><spring:message code="user.action.cancel" /></a>
										</span>
									</td>
									
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
				<div id="main_action_edit">
								<span class="listbuttons">
									 <a class="buttonmenu"  href="${fn:escapeXml(userUrl)}"><spring:message code="user.action.add" /></a>
								</span> 
								<span class="listbuttons"> 
										<a class="buttonmenu"  href="${fn:escapeXml(userListUrl)}"><spring:message code="user.action.userlist" /></a>
								</span>
				</div>
			</div>
			<div class="clear">&nbsp;</div>
			<div class="clear">&nbsp;</div>
			<jsp:include page="../common/footer.jsp" />
		</div>
	</div>
</body>
</html>


