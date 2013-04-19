<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<jsp:include page="./../common/head.jsp" />
</head>
<body>
	<spring:url value="/groups/photo" var="photoUrl" />
	<spring:url value="/groups/upload/{groupId}/show.htm" var="addPhotoUrl">
		<spring:param name="groupId" value="${group.id}" />
	</spring:url>
	<spring:url
		value="/groups/{groupId}/edit.htm" var="editGroupUrl">
		<spring:param name="groupId" value="${group.id}" />
	</spring:url>
	<spring:url value="/groups/new.htm" var="addGroupUrl" /> 
	
	<spring:url value="/groups.htm" var="groupListUrl" />
	<spring:url
			value="/groups/{groupId}/delete.htm" var="deleteGroupUrl">
			<spring:param name="groupId" value="${group.id}" />
	</spring:url>												
	<div id="wrap">
		<jsp:include page="../common/menu.jsp" />
		<div id="content">
			<jsp:include page="../common/sub-menu.jsp" />
			<div id="main">
				<div class="navig">
					<c:forEach var="navig" items="${navigations}" varStatus="status">
							&laquo;
							<spring:url value="${navig.url}" var="navigs" />
						<a href="${navigs}"><spring:message code="${navig.name}" /></a>
					</c:forEach>
				</div>
				<h1>${group.name}</h1>
				<div id="single_item_details">
					<div id="leftcolumn">
						<div id="carrousel">
							<c:if test="${empty group.photo }">
								<img width="210" height="210"
									src='<c:url value="/resources/graphics/no-photos.jpg"/>'
									class="previewimg">
							</c:if>
							<c:if test="${not empty group.photo }">
								<img width="210" height="210" src="${photoUrl}/${group.id}"
									class="previewimg">
							</c:if>
						</div>

					</div>
					<div id="rightcolumn">
						<div class="leftpart">
							<h2>${group.name}</h2>
							<p>
								<spring:message code="group.description" />
								: description (to update it) <br />
							</p>
							<p>&nbsp;</p>
							<div id="tabs">
								<p>
									<img src='<c:url value="/resources/graphics/emailalert.gif"/>'
										alt="email" width="18" height="15" />&nbsp;
									<spring:url value="/groups/{groupId}/send-email.htm"
										var="sendemailUrl">
										<spring:param name="groupId" value="${group.id}" />
									</spring:url>
									<a href="${fn:escapeXml(sendemailUrl)}"><spring:message
											code="group.action.sendemail" /></a>
								</p>
								<p>
									<img src='<c:url value="/resources/graphics/sms.gif"/>'
										alt="sms" width="18" height="16" />&nbsp;
									<spring:url value="/groups/{groupId}/send-sms.htm"
										var="sendSmsUrl">
										<spring:param name="groupId" value="${group.id}" />
									</spring:url>
									<a href="${fn:escapeXml(sendSmsUrl)}"><spring:message
											code="group.action.sendsms" /></a>
								</p>
							</div>
						</div>
						<div class="listingbtns">
							<span class="listbuttons"> 
								 <a href="${fn:escapeXml(editGroupUrl)}"><spring:message code="group.action.edit" /></a>
							</span> 
							<span class="listbuttons"> 
								<a href="${fn:escapeXml(addGroupUrl)}"><spring:message code="group.action.add" /></a>
							</span> 
							<span class="listbuttons"> 
									 <a href="${fn:escapeXml(deleteGroupUrl)}"><spring:message code="group.action.deletegroup" /></a>
							</span> 
							<span class="listbuttons"> <a
								href="${fn:escapeXml(addPhotoUrl)}"><spring:message code="group.action.updatephoto" /></a>
							</span>
						</div>
						<div class="clear">&nbsp;</div>
					</div>
					<div class="clear">&nbsp;</div>

					<div id="moredetails">
						<div id="listing_details">
							<table>
								<tr>
									<td><h3>
											<spring:message code="group.roles" />
										</h3></td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td><ul>
											<c:forEach var="role" items="${group.roles}"
												varStatus="status">
												<li>${status.count} : <c:out value="${role.name}" /></li>
											</c:forEach>
										</ul></td>
								</tr>
							</table>
						</div>
					</div>
					<div id="main_action">
								<span class="listbuttons">
										<a class="buttonmenu" href="${fn:escapeXml(addGroupUrl)}"><spring:message code="group.action.add" /></a>
								</span> 
								<span class="listbuttons"> 
										<a class="buttonmenu"  href="${fn:escapeXml(groupListUrl)}"><spring:message code="group.action.grouplist" /></a>
								</span>
					</div>
				</div>
			</div>
		</div>

		<div class="clear">&nbsp;</div>
		<div class="clear">&nbsp;</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>


