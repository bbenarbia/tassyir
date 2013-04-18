<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
	<jsp:include page="./../common/head.jsp"/>
	<title>Tassyir: User details</title>
</head>
<body>
	<spring:url value="/users/photo" var="photoUrl" />
	<spring:url value="/users/upload/{userId}/show" var="addPhotoUrl">
		<spring:param name="userId" value="${user.id}" />
	</spring:url>
	
	<div id="wrap">
		<jsp:include page="../common/menu.jsp" />
		<div id="content">
			<jsp:include page="../common/sub-menu.jsp" />
			<div id="main">
				<h1>
					<spring:message code="user.information" />
				</h1>
				<div id="single_item_details">
					<div id="leftcolumn">
						<div id="carrousel">
							<c:if test="${empty user.photo }">
								<img width="210" height="210"  src='<c:url value="/resources/graphics/no-photos.jpg"/>' class="previewimg">
							</c:if>
							<c:if test="${not empty user.photo }">
								<img width="210" height="210" src="${photoUrl}/${user.id}" class="previewimg">
							</c:if>
						</div>
					</div>
					<div id="rightcolumn">
						<div class="leftpart">
						<h2>${user.firstName} ${user.lastName}</h2>
						<p class="user">
							<img  src='<c:url value="/resources/graphics/usericon.gif"/>' alt="user" />
							<spring:message code="user.login" />: ${user.login}
						</p>
						<p>
							<spring:message code="user.code" /> :${user.code} 
							<br /> <spring:message code="user.createdon" />: put the date here
						</p>
						<p>&nbsp;</p>
						<p class="price">
							<spring:message code="user.group" />: ${user.userCategory.name}
						</p>
						<div id="tabs">
								<p>
									<img src='<c:url value="/resources/graphics/emailalert.gif"/>' alt="email" width="18"
										height="15" />&nbsp;
											<spring:url
											value="/users/{userId}/send-email.htm" var="sendemailUrl">
											<spring:param name="userId" value="${user.id}" />
											</spring:url> 
											<a href="${fn:escapeXml(sendemailUrl)}"><spring:message code="user.action.sendemail" /></a>
								</p>
								<p>
									<img src='<c:url value="/resources/graphics/sms.gif"/>' alt="sms" width="18" height="16" />&nbsp;
									<spring:url
											value="/users/{userId}/send-sms.htm" var="sendSmsUrl">
											<spring:param name="userId" value="${user.id}" />
									</spring:url> <a href="${fn:escapeXml(sendSmsUrl)}"><spring:message code="user.action.sendsms" /></a>
								</p>
								<p>
									<img  src='<c:url value="/resources/graphics/emailalert.gif"/>' alt="email" width="18"
										height="15" />&nbsp;
									<spring:url
											value="/users/{userId}/add-mailing-list.htm" var="addmailinglistUrl">
											<spring:param name="userId" value="${user.id}" />
									</spring:url> <a href="${fn:escapeXml(addmailinglistUrl)}"><spring:message code="user.action.addmailinglist" /></a>
								</p>							
						</div>
						</div>
					<div class="listingbtns">
						<span class="listbuttons"> <spring:url
								value="/users/{userId}/edit.htm" var="userUrl">
								<spring:param name="userId" value="${user.id}" />
							</spring:url> <a href="${fn:escapeXml(userUrl)}"><spring:message code="user.action.edit" /></a>
						</span> 
						<span class="listbuttons"> <spring:url value="/users/new.htm"
								var="userUrl" /> <a href="${fn:escapeXml(userUrl)}"><spring:message code="user.action.add" /></a>
						</span> 
						<span class="listbuttons"> <spring:url
								value="/users/{userId}/delete.htm" var="userUrl">
								<spring:param name="userId" value="${user.id}" />
							</spring:url> <a href="${fn:escapeXml(userUrl)}"><spring:message code="user.action.delete" /></a>
						</span>
						<span class="listbuttons"> <spring:url
								value="/users/{userId}/editpassword.htm" var="editPasswordUrl">
								<spring:param name="userId" value="${user.id}" />
							</spring:url> <a href="${fn:escapeXml(editPasswordUrl)}"><spring:message code="user.action.editpassword" /></a>
						</span>
						<span class="listbuttons"> <spring:url
												value="/users/{userId}/reset-password.htm" var="resetPasswordUrl">
												<spring:param name="userId" value="${user.id}" />
											</spring:url> <a href="${fn:escapeXml(resetPasswordUrl)}"><spring:message code="user.action.resetpassword" /></a>
										</span>
						<span class="listbuttons"> 
							<a href="${fn:escapeXml(addPhotoUrl)}"><spring:message code="user.action.editphoto" /></a>
						</span>
						
						<c:choose>
							<c:when test="${!user.locked }">
									<span class="listbuttons"> <spring:url
											value="/users/{userId}/lock-user.htm" var="lockUrl">
											<spring:param name="userId" value="${user.id}" />
										</spring:url> <a href="${fn:escapeXml(lockUrl)}"><spring:message code="user.action.lockuser" /></a>
									</span>						
							</c:when>
							<c:otherwise>
									<span class="listbuttons"> <spring:url
										value="/users/{userId}/activate-user.htm" var="activateUrl">
										<spring:param name="userId" value="${user.id}" />
									</spring:url> <a href="${fn:escapeXml(activateUrl)}"><spring:message code="user.action.activateuser" /></a>
									</span>
							</c:otherwise>
						</c:choose>
													
						
						
						<span class="listbuttons"> <spring:url
								value="/users/{userId}/biens-list.htm" var="bienslistUrl">
								<spring:param name="userId" value="${user.id}" />
							</spring:url> <a href="${fn:escapeXml(bienslistUrl)}"><spring:message code="user.action.showbienlist" /></a>
						</span>
				</div>
					</div>
					<div class="clear">&nbsp;</div>
				</div>

				<div id="moredetails">
					<div id="listing_details">
						<table>
							<tr>
								<td> <spring:message code="user.adresse" /></td>
								<td colspan="2"> ${user.contact.adresse}</td>
							</tr>
							<tr>
								<td><spring:message code="user.codePostal" /></td>
								<td colspan="2">${user.contact.codePostal}</td>
							</tr>
							<tr>	
								<td><spring:message code="user.ville" /></td>
								<td colspan="2">${user.contact.ville}</td>
							</tr>
							<tr>	
								<td><spring:message code="user.email" /></td>
								<td colspan="2">${user.contact.adresseMail}</td>
							</tr>
							<tr>	
								<td><spring:message code="user.website" /></td>
								<td colspan="2">${user.contact.siteWeb}</td>
							</tr>
							<tr>	
								<td><spring:message code="user.telephonePerso" /></td>
								<td >${user.contact.telephonePerso}</td>
								<td >
											<c:choose>
													<c:when test="${user.contact.alerteSurTelephone1}">
														<img width="30" height="30"  src='<c:url value="/resources/graphics/phone_accept.png"/>' class="previewimg">
													</c:when>
													<c:otherwise>
														<img width="30" height="30"  src='<c:url value="/resources/graphics/phone_delete.png"/>' class="previewimg">
													</c:otherwise>
											</c:choose>	
								</td>
							</tr>
							<tr>	
								<td><spring:message code="user.telephoneProf" />	</td>
								<td >${user.contact.telephoneProf}</td>
								<td >
											<c:choose>
													<c:when test="${user.contact.alerteSurTelephone2}">
														<img width="30" height="30"  src='<c:url value="/resources/graphics/phone_accept.png"/>' class="previewimg">
													</c:when>
													<c:otherwise>
														<img width="30" height="30"  src='<c:url value="/resources/graphics/phone_delete.png"/>' class="previewimg">
													</c:otherwise>
											</c:choose>	
								</td>
							</tr>
							<tr>	
								<td> <spring:message code="user.mobile" /></td>
								<td >${user.contact.telephoneMobile}</td>
								<td ></td>
							</tr>
						</table>
					</div>

				</div>
				
				<div id="moredetails">
					<div id="listing_detail">
						<table>
							<tr>
								<td><h3><spring:message code="user.roles" /></h3></td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td><ul>
									<c:forEach var="role" items="${user.roles}" varStatus="status">
										<li>${status.count} : <c:out value="${role.name}" /></li>
									</c:forEach>
									</ul></td>
							</tr>
						</table>
					</div>
				</div>
				<div id="main_action">
								<span class="listbuttons">
										<a class="buttonmenu" href="/users/new.htm"><spring:message code="user.action.add" /></a>
								</span> 
								<span class="listbuttons"> <spring:url
										value="/users.htm" var="userListUrl">
									</spring:url>
										<a class="buttonmenu"  href="${fn:escapeXml(userListUrl)}"><spring:message code="user.action.userlist" /></a>
								</span>
				</div>
				
			</div>
		</div>

		<div class="clear">&nbsp;</div>
		<div class="clear">&nbsp;</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>