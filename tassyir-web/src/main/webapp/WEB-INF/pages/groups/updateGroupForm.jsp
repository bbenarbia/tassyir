<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<jsp:include page="./../common/head.jsp"/>
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

			<div id="home_main_edit">
				<div class="navig">
						<c:forEach var="navig" items="${navigations}" varStatus="status">
							&laquo;
							<spring:url value="${navig.url}" var="navigs" />
							<a href="${navigs}"><spring:message code="${navig.name}" /></a>
						</c:forEach>
				</div>
				<div id="edit">
					<div class="tab">
						<h2>Edit group</h2>
					</div>
					<div class="container">
					<form:form modelAttribute="group" method="put" id="form1">

							<table class="edit_form" style="width: 100%; border: none;">
								<tr>
									<td class="label"><form:label path="name"><spring:message code="group.name" /></form:label></td>
									<td><label> <form:input path="name"  class="text" cssErrorClass="error"/>
										</label>
										<form:errors path="name" cssClass="error_code"/>
									</td>
								</tr>
								<tr>
									<td  style="font-weight: bold;"><spring:message code="user.roles" /></td>
									<td>
									 <table>
										<tr>
											<td style="font-weight: bold;"><spring:message code="user.num" /></td>
											<td style="font-weight: bold; width: 260px;"><spring:message code="user.rolename" /></td>
											<td style="font-weight: bold;"><spring:message code="user.included" /></td>
										</tr>
										<c:forEach items="${group.roleFormList.roles}" var="roleForm"
											varStatus="status">
											<tr>
												<td><label> ${status.count}</label></td>
												<td><label>${roleForm.role.name}</label>
												<label><form:hidden  path="roleFormList.roles[${status.index}].role.name" /></label></td>
												<td><label><form:checkbox path="roleFormList.roles[${status.index}].included" /></label></td>
											</tr>
										</c:forEach>
									 </table>
									</td>
								</tr>
							
								<tr>
									<td class="label">&nbsp;</td>
									<td><span class="listbuttons">
										<a class="buttonmenured"  href="${fn:escapeXml(cancelGroupUrl)}"><spring:message code="group.action.cancel" /></a>
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
					<div class="bottom">
					</div>
				</div>
				
					<div id="main_action_edit">
								<span class="listbuttons">
									 <a class="buttonmenu"  href="${fn:escapeXml(addGroupUrl)}"><spring:message code="group.action.add" /></a>
								</span> 
								<span class="listbuttons"> 
										<a class="buttonmenu"  href="${fn:escapeXml(groupListUrl)}"><spring:message code="group.action.grouplist" /></a>
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

				