<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<jsp:include page="./../common/head.jsp" />
<title>Tassyir: update group</title>
</head>
<body>
	<spring:url value="/groups/{groupId}.htm" var="cancelGroupUrl">
		<spring:param name="groupId" value="${group.id}" />
	</spring:url>
	<spring:url value="/groups.htm" var="groupListUrl" />
	<spring:url value="/groups/new.htm" var="addGroupUrl" />
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
						<h2>Update group</h2>
					</div>
					<div
						style="margin: 10px; background: none repeat scroll 0px 0px rgb(248, 248, 248); padding: 14px;">
						<form:form modelAttribute="group" method="put" id="form1">
							<fieldset>
								<legend>general Info</legend>
								<dl>
									<dt>
										<form:label path="name">
											<spring:message code="group.name" />
										</form:label>
									</dt>
									<dd>
										<form:input label="name" path="name" class="text"
											cssErrorClass="error" />
									</dd>
								</dl>
							</fieldset>

							<fieldset>
								<legend>
									<spring:message code="user.roles" />
								</legend>
								<c:forEach items="${group.roleFormList.roles}" var="roleForm"
									varStatus="status">
									<dl>
										<dt>${status.count} - ${roleForm.role.name}</dt>
										<dd>
											<form:hidden
												path="roleFormList.roles[${status.index}].role.name" />
											<form:checkbox
												path="roleFormList.roles[${status.index}].included" />
										</dd>
									</dl>
								</c:forEach>

							</fieldset>

							<fieldset class="action">
								<dl>
									<dt>
										<input type="image"
											src='<c:url value="/resources/graphics/searchbtn.gif"/>'
											alt="search" name="button2" id="button2" value="Submit" />
									</dt>
									<dd>
										<a class="buttonmenured" href="${fn:escapeXml(cancelGroupUrl)}"><spring:message
												code="biens.action.cancel" /></a>
									</dd>
								</dl>
							</fieldset>
						</form:form>
					</div>
					<div class="bottom"></div>
				</div>

				<div id="main_action_edit">
					<span class="listbuttons"> <a class="buttonmenu"
						href="${fn:escapeXml(addGroupUrl)}"><spring:message
								code="user.action.add" /></a>
					</span> <span class="listbuttons"> <a class="buttonmenu"
						href="${fn:escapeXml(groupListUrl)}"><spring:message
								code="user.action.userlist" /></a>
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


