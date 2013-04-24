<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<jsp:include page="./../common/head.jsp"/>
	<title>Tassyir: Create a new user</title>
</head>
<body>
	<spring:url value="/users.htm" var="userListUrl"> </spring:url>
	<spring:url value="/" var="homeUrl"> </spring:url>
	<spring:url value="/users/new.htm" var="newUserUrl" />
	<spring:url value="/users/{userId}.htm" var="detailuserUrl">
				<spring:param name="userId" value="${user.id}" />
	</spring:url> 
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
						<h2>Update user</h2>
					</div>
					<div style="margin: 10px; background: none repeat scroll 0px 0px rgb(248, 248, 248); padding: 14px;">
						<form:form modelAttribute="user" method="put" id="form1">
							<fieldset>
    						<legend>general Info</legend>
        						<dl>
        							<dt><form:label path="firstName"><spring:message code="user.firstName" /></form:label></dt>
					            	<dd>
										<form:input label="firstName"
												path="firstName" class="text" cssErrorClass="error"/>
									</dd>
								</dl>
								<dl>
        							<dt><form:label path="lastName"><spring:message code="user.lastName" /></form:label></dt>
					            	<dd>
										<form:input label="lastName" path="lastName" class="text" cssErrorClass="error"/>
									</dd>
								</dl>
								<dl>
        							<dt><form:label path="login"><spring:message code="user.login" /></form:label></dt>
					            	<dd>
										<form:input label="login" path="login" class="text" cssErrorClass="error"/>
										<form:errors path="login" cssClass="error_code"/>
									</dd>
								</dl>
								<dl>
        							<dt><form:label path="code"><spring:message code="user.code" /></form:label></dt>
					            	<dd>
										<form:input label="code" path="code"
												class="text mediumtext" cssErrorClass="error"/>
												<form:errors path="code" cssClass="error_code"/>
									</dd>
								</dl>
								<dl>
        							<dt><form:label path="locked"><spring:message code="user.locked" /></form:label></dt>
					            	<dd>
										<form:checkbox
												path="locked" />
									</dd>
								</dl>
								<dl>
        							<dt><form:label path="isAdmin"><spring:message code="user.isAdmin" /></form:label></dt>
					            	<dd>
										<form:checkbox path="isAdmin" />
									</dd>
								</dl>
							</fieldset>
							<fieldset>
								<legend>Category</legend>
								<dl>
        							<dt><form:label path="userCategory.name"><spring:message code="user.group" /> </form:label></dt>
					            	<dd>
					            		<form:select path="userCategory.name" cssErrorClass="error">
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
									</dd>
								</dl>
							</fieldset>		
							<fieldset>
								<legend><spring:message code="user.roles" /></legend>
								<c:forEach items="${user.roleFormList.roles}" var="roleForm" varStatus="status">
												<dl>
													<dt>${status.count} - ${roleForm.role.name}</dt>
													<dd>
														<form:hidden path="roleFormList.roles[${status.index}].role.name" />
														<form:checkbox path="roleFormList.roles[${status.index}].included" />
													</dd>
												</dl>
								</c:forEach>
											
							</fieldset>	
							<fieldset>
								<legend><spring:message code="user.contact" /></legend>
												<dl>
													<dt><form:label path="adresse"><spring:message code="user.adresse" /></form:label></dt>
													<dd>
														<form:textarea cols="26" rows="10" label="adresse"
														path="adresse" class="text textBoxfieldlong" cssErrorClass="error"/>
													</dd>
												</dl>
												
												<dl>
													<dt><form:label path="ville"><spring:message code="user.ville" /></form:label></dt>
													<dd>
														<form:input label="ville" path="ville" class="text" cssErrorClass="error"/>
													</dd>
												</dl>
												
												<dl>
													<dt><form:label path="codePostal"><spring:message code="user.codePostal" /></form:label></dt>
													<dd>
														<form:input label="codePostal" path="codePostal" class="text" cssErrorClass="error"/>
													</dd>
												</dl>
												
												<dl>
													<dt><form:label path="telephonePerso"><spring:message code="user.telephonePerso" /></form:label></dt>
													<dd>
														 <form:input label="telephonePerso" path="telephonePerso" class="text" cssErrorClass="error"/>
													</dd>
													<dt><spring:message code="user.acceptalert" /></dt>
													<dd>
														<form:checkbox path="alerteSurTelephone1" />
													</dd>
												</dl>
												<dl>
													<dt><form:label path="telephoneProf"><spring:message code="user.telephoneProf" /></form:label></dt>
													<dd>
														<form:input label="telephoneProf" path="telephoneProf" class="text" cssErrorClass="error"/>
													</dd>
													<dt><spring:message code="user.acceptalert" /></dt>
													<dd>
														<form:checkbox path="alerteSurTelephone2" />
													</dd>
												</dl>
												<dl>
													<dt><form:label path="telephoneMobile"><spring:message code="user.mobile" /></form:label></dt>
													<dd>
														<form:input label="telephoneMobile" path="telephoneMobile" class="text" cssErrorClass="error"/>
													</dd>
												</dl>
												<dl>
													<dt><form:label path="siteWeb"><spring:message code="user.website" /></form:label></dt>
													<dd>
														<form:input label="siteWeb" path="siteWeb" class="text" cssErrorClass="error"/>
													</dd>
												</dl>
												<dl>
													<dt><form:label path="adresseMail"><spring:message code="user.email" /></form:label></dt>
													<dd>
														<form:input label="adresseMail" path="adresseMail" class="text" cssErrorClass="error"/>
													</dd>
												</dl>
										</fieldset>
							<fieldset class="action">
									<dl><dt>
    								<input
											type="image" src='<c:url value="/resources/graphics/searchbtn.gif"/>'  alt="search"
											name="button2" id="button2" value="Submit" />
									</dt>
									<dd>
										<a class="buttonmenured"  href="${fn:escapeXml(detailuserUrl)}"><spring:message code="biens.action.cancel" /></a>
									</dd>
									</dl>
    							</fieldset>
							</form:form>
							</div>
					<div class="bottom"></div>
				</div>
				
				<div id="main_action_edit">
								<span class="listbuttons">
									 <a class="buttonmenu"  href="${fn:escapeXml(newUserUrl)}"><spring:message code="user.action.add" /></a>
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