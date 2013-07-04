<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<jsp:include page="./../../common/head.jsp" />
<title>Tassyir: User details</title>
</head>
<body>
	<spring:url value="/users/photo" var="photoUrl" />
	<spring:url value="/users/{userId}/edit.htm" var="editUserUrl">
		<spring:param name="userId" value="${user.id}" />
	</spring:url>
	<spring:url value="/users/remove-favorite/{userId}"
		var="removeFromFavoriteUrl">
		<spring:param name="userId" value="${user.id}" />
	</spring:url>

	<spring:url value="/biens/activate" var="activateBienUrl"> </spring:url>


	<spring:url value="/users/upload/{userId}/show" var="addPhotoUrl">
		<spring:param name="userId" value="${user.id}" />
	</spring:url>
	<spring:url value="/users/{userId}/delete.htm" var="userDeleteUrl">
		<spring:param name="userId" value="${user.id}" />
	</spring:url>
	<spring:url value="/users/new.htm" var="addUserUrl" />
	<spring:url value="/users.htm" var="userListUrl">
	</spring:url>
	<spring:url value="/" var="homeUrl">
	</spring:url>
	<spring:url value="/users/{userId}/editpassword.htm"
		var="editPasswordUrl">
		<spring:param name="userId" value="${user.id}" />
	</spring:url>
	<spring:url value="/users/{userId}/reset-password.htm"
		var="resetPasswordUrl">
		<spring:param name="userId" value="${user.id}" />
	</spring:url>
	<spring:url value="/users/{userId}/lock-user.htm" var="lockUrl">
		<spring:param name="userId" value="${user.id}" />
	</spring:url>
	<spring:url value="/users/{userId}/activate-user.htm" var="activateUrl">
		<spring:param name="userId" value="${user.id}" />
	</spring:url>
	<spring:url value="/biens/{userId}/user-biens.htm" var="bienslistUrl">
		<spring:param name="userId" value="${user.id}" />
	</spring:url>

	<div id="wrap">
		<jsp:include page="../../common/menu.jsp" />
		<div id="content">
			<jsp:include page="../../common/sub-menu.jsp" />
			<div id="home_sidebar_left">
				<jsp:include page="./../../common/left-menu.jsp" />
			</div>
			<div id="main" style="width: 597px;">
				<jsp:include page="../../common/navigator.jsp" />
				<div class="group">
					<h2>My profile</h2>

					<div id="single_item_details">
						<div id="leftcolumn">
							<c:if test="${empty user.photo }">
								<img width="230" height="180"
									src='<c:url value="/resources/graphics/no-photos.jpg"/>'
									class="previewimg">
								<p>
									<a href="${fn:escapeXml(addPhotoUrl)}"><spring:message
											code="user.action.addphoto" /></a>
								</p>
							</c:if>
							<c:if test="${not empty user.photo }">
								<img width="230" height="180" src="${photoUrl}/${user.id}"
									class="previewimg">
								<p>
									<a href="${fn:escapeXml(addPhotoUrl)}"><spring:message
											code="user.action.editphoto" /></a>
								</p>
							</c:if>
							<div class="divdetails">
								<table class="im12_detTabDetails">
									<tbody>
										<c:if test="${!empty user.contact.adresse }">
											<tr class="auto2010_detTabTR">
												<td class="auto2010_detTD1First"><spring:message
														code="user.adresse" /></td>
												<td class="auto2010_detTD1First">${user.contact.adresse}</td>
											</tr>
										</c:if>


										<c:if test="${!empty user.contact.codePostal }">
											<tr class="auto2010_detTabTR">
												<td class="auto2010_detTD1First"><spring:message
														code="user.codePostal" /></td>
												<td class="auto2010_detTD1First">${user.contact.codePostal}</td>
											</tr>
										</c:if>
										<c:if test="${!empty user.contact.ville }">
											<tr class="auto2010_detTabTR">
												<td class="auto2010_detTD1First"><spring:message
														code="user.ville" /></td>
												<td class="auto2010_detTD1First">${user.contact.ville}</td>
											</tr>
										</c:if>
										<c:if test="${!empty user.contact.adresseMail }">
											<tr class="auto2010_detTabTR">
												<td class="auto2010_detTD1First"><spring:message
														code="user.email" /></td>
												<td class="auto2010_detTD1First">${user.contact.adresseMail}</td>
											</tr>
										</c:if>
										<c:if test="${!empty user.contact.siteWeb }">
											<tr class="auto2010_detTabTR">
												<td class="auto2010_detTD1First"><spring:message
														code="user.website" /></td>
												<td class="auto2010_detTD1First">${user.contact.siteWeb}</td>
											</tr>
										</c:if>
										<c:if test="${!empty user.contact.telephonePerso }">
											<tr class="auto2010_detTabTR">
												<td class="auto2010_detTD1First"><spring:message
														code="user.telephonePerso" /></td>
												<td class="auto2010_detTD1First">
													${user.contact.telephonePerso} <c:choose>
														<c:when test="${user.contact.alerteSurTelephone1}">
															<img width="30" height="30"
																src='<c:url value="/resources/graphics/phone_accept.png"/>'>
														</c:when>
														<c:otherwise>
															<img width="30" height="30"
																src='<c:url value="/resources/graphics/phone_delete.png"/>'>
														</c:otherwise>
													</c:choose>
												</td>
											</tr>
										</c:if>
										<c:if test="${!empty user.contact.telephoneProf }">
											<tr class="auto2010_detTabTR">
												<td class="auto2010_detTD1First"><spring:message
														code="user.telephoneProf" /></td>
												<td class="auto2010_detTD1First"><c:choose>
														<c:when test="${user.contact.alerteSurTelephone2}">
															<img width="30" height="30"
																src='<c:url value="/resources/graphics/phone_accept.png"/>'>
														</c:when>
														<c:otherwise>
															<img width="30" height="30"
																src='<c:url value="/resources/graphics/phone_delete.png"/>'>
														</c:otherwise>
													</c:choose></td>
											</tr>
										</c:if>
										<c:if test="${!empty user.contact.telephoneMobile }">
											<tr class="auto2010_detTabTR">
												<td class="auto2010_detTD1First"><spring:message
														code="user.mobile" /></td>
												<td class="auto2010_detTD1First">${user.contact.telephoneMobile}</td>
											</tr>
										</c:if>
									</tbody>
								</table>
							</div>
						</div>
						<div id="rightcolumndetail" style="width: 190px;">
							<p class="user">${user.firstName} ${user.lastName}</p>
							<p class="user">
								<spring:message code="date.miseajour" />:
							</p>
							
							<p class="user">
								 ${user.dateMiseAjour}
							</p>
							<p class="user">
								<img src='<c:url value="/resources/graphics/usericon.gif"/>'
									alt="user" />
								<spring:message code="user.login" />
								: ${user.login}
							</p>
						</div>
						<div class="listingbtns">
								<span class="listbuttons"> <a
									href="${fn:escapeXml(editUserUrl)}"><spring:message
											code="user.action.edit" /></a>
								</span> <span class="listbuttons"> <a
									href="${fn:escapeXml(addUserUrl)}"><spring:message
											code="user.action.add" /></a>
								</span> <span class="listbuttons"> <a
									href="${fn:escapeXml(userDeleteUrl)}"><spring:message
											code="user.action.delete" /></a>
								</span> <span class="listbuttons"> <a
									href="${fn:escapeXml(editPasswordUrl)}"><spring:message
											code="user.action.editpassword" /></a>
								</span> <span class="listbuttons"> <a
									href="${fn:escapeXml(resetPasswordUrl)}"><spring:message
											code="user.action.resetpassword" /></a>
								</span>

								<c:choose>
									<c:when test="${!user.locked }">
										<span class="listbuttons"> <a
											href="${fn:escapeXml(lockUrl)}"><spring:message
													code="user.action.lockuser" /></a>
										</span>
									</c:when>
									<c:otherwise>
										<span class="listbuttons"> <a
											href="${fn:escapeXml(activateUrl)}"><spring:message
													code="user.action.activateuser" /></a>
										</span>
									</c:otherwise>
								</c:choose>
								<span class="listbuttons"> <a
									href="${fn:escapeXml(bienslistUrl)}"><spring:message
											code="user.action.showbienlist" /></a>
								</span>
							</div>
						<div class="clear">&nbsp;</div>
					</div>
				</div>

				<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
					<div class="group">
						<h2>
							<spring:message code="user.roles" />
						</h2>
						<table>
							<tr>
								<td><ul>
										<c:forEach var="role" items="${user.roles}" varStatus="status">
											<li>${status.count} : <c:out value="${role.name}" /></li>
										</c:forEach>
									</ul></td>
							</tr>
							<tr>
								<td><h3>
										<spring:message code="user.group.roles" />
									</h3></td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td><ul>
										<c:forEach var="role" items="${groupRoles}" varStatus="status">
											<li>${status.count} : <c:out value="${role}" /></li>
										</c:forEach>
									</ul></td>
							</tr>
						</table>
					</div>
				</sec:authorize>
				<c:if test="${not empty user.biens }">
				<div class="group">
					<h2>User Biens</h2>
						<table>
							<tr>
								<td><ul>
										<c:forEach var="bien" items="${user.biens}" varStatus="status">
											<spring:url value="/biens/{bienId}.htm" var="DetailbienUrl">
												<spring:param name="bienId" value="${bien.id}" />
											</spring:url>
											<li>${status.count} :  <a href="${DetailbienUrl}"><c:out value="${bien.name}" /></a></li>
										</c:forEach>
									</ul>
								</td>
								<td>
									<c:if test="${bien.toDelete}">
													(toDelete)
									</c:if>
								</td>
								<td>
									<a href="${fn:escapeXml(blockAnnonce)}">Bloquer</a>
								</td>
								<td>
									<a href="${fn:escapeXml(deleteAnnonce)}">Delete</a>
								</td>
							</tr>
						</table>
				</div>
				</c:if>
				<c:if test="${not empty user.favorites }">
				<div class="group">
					<h2>User Favoris</h2>
								<table>
									<tr>
										<td><h3>Mes favoris</h3></td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td><ul>
												<c:forEach var="bien" items="${user.favorites}"
													varStatus="status">
													<spring:url value="/biens/{bienId}.htm" var="DetailbienUrl">
														<spring:param name="bienId" value="${bien.id}" />
													</spring:url>
													<li>${status.count} : <a href="${DetailbienUrl}"><c:out
																value="${bien.name}" /></a> <a
														href="${removeFromFavoriteUrl}/${bien.id}.htm">Remove</a></li>
												</c:forEach>
											</ul></td>
									</tr>
								</table>
				</div>
				</c:if>
				<c:if test="${not empty toActivatedBiens }">
				<div class="group">
					<h2>biens A activer</h2>
								<table>
									<tr>
										<td><h3>biens A activer</h3></td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td><ul>
												<c:forEach var="bien" items="${toActivatedBiens}"
													varStatus="status">
													<spring:url value="/biens/{bienId}.htm" var="DetailbienUrl">
														<spring:param name="bienId" value="${bien.id}" />
													</spring:url>
													<li>${status.count} : <a href="${DetailbienUrl}"><c:out value="${bien.name}" /></a> <a
														href="${activateBienUrl}/${bien.id}.htm">Activate</a></li>
												</c:forEach>
											</ul></td>
									</tr>
								</table>
				</div>
				</c:if>
			</div>
			<div id="home_sidebar">
				<jsp:include page="./../../common/slide-right.jsp" />
			</div>
		</div>
		<div class="clear">&nbsp;</div>
		<div class="clear">&nbsp;</div>
		<jsp:include page="../../common/footer.jsp" />
	</div>
</body>
</html>