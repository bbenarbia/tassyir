<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<jsp:include page="./../common/head.jsp"/>
	<title>Tassyir: Create a new group</title>
</head>
<body>
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
						<h2>Create group</h2>
					</div>
					<div
						style="margin: 10px; background: none repeat scroll 0px 0px rgb(248, 248, 248); padding: 14px;">
						<form:form modelAttribute="group" method="post" id="form1" enctype="multipart/form-data">
							<fieldset>
								<legend>General Info</legend>
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
								<legend><spring:message code="user.roles" /></legend>
								<c:forEach items="${group.roleFormList.roles}" var="roleForm" varStatus="status">
												<dl>
													<dt class="dtlong">${status.count} - ${roleForm.role.name}</dt>
													<dd>
														<form:hidden path="roleFormList.roles[${status.index}].role.name" />
														<form:checkbox path="roleFormList.roles[${status.index}].included" />
													</dd>
												</dl>
								</c:forEach>
							</fieldset>	
							<fieldset>
												<legend><spring:message code="user.photo" /></legend>
												<dl>
													<dt><spring:message code="user.photo" /></dt>
													<dd>
														<form:input
														path="photoFile" type="file" accept="image/*" cssErrorClass="error"/>
													</dd>
												</dl>
							</fieldset>	
							<fieldset class="action">
									<dl><dt>
    									<input type="submit"  alt="Create"  class="buttonmenu" value="Create" />
									</dt>
									<dd>
										<a class="buttonmenured"  href="${fn:escapeXml(cancelGroupUrl)}"><spring:message code="group.action.cancel" /></a>
									</dd>
									</dl>
    							</fieldset>
    							<fieldset class="action">
									<dl>
									<dd>
										<a class="buttonmenu"  href="${fn:escapeXml(groupListUrl)}"><spring:message code="group.gotolistgroup" /></a>
									</dd>
									</dl>
    							</fieldset>
							</form:form>
							</div>
				</div>
			</div>
			<div class="clear">&nbsp;</div>
			<div class="clear">&nbsp;</div>
			<jsp:include page="../common/footer.jsp" />
		</div>
	</div>
</body>
</html>



			
			
			
			
			

				