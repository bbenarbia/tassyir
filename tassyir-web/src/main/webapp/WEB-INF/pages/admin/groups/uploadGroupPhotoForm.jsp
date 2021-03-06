<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<jsp:include page="./../../common/head.jsp"/>
</head>
<body>
	<spring:url value="/groups/{groupId}.htm" var="detailGroupUrl">
				<spring:param name="groupId" value="${group.id}" />
	</spring:url> 
	<spring:url value="/" var="homeUrl"> </spring:url>
	<div id="wrap">
		<jsp:include page="../../common/menu.jsp" />
		<div id="content">
			<jsp:include page="../../common/sub-menu.jsp" />

			<div id="home_main">
				<div class="navig">
						<c:forEach var="navig" items="${navigations}" varStatus="status">
							&laquo;
							<spring:url value="${navig.url}" var="navigs" />
							<a href="${navigs}"><spring:message code="${navig.name}" /></a>
						</c:forEach>
					</div>
					
				<div id="search">
					<div class="tab">
						<h2>Add Photos</h2>
					</div>
					<div class="container">

						<form:form method="post" action="save.html"
							modelAttribute="uploadForm" enctype="multipart/form-data"
							id="form1">
							
							<table class="search_form" style="width: 100%; border: none; padding-top: 80px; ">
									<tr>
										<td class="label">Photo: </td>
										<td><label><input
												name="files[0]" type="file" accept="image/*" />
										</label></td>
									</tr>
								<tr>
									<td><span class="listbuttons">
										<a class="buttonmenured"  href="${fn:escapeXml(detailGroupUrl)}"><spring:message code="group.action.cancel" /></a>
										</span>
									</td>
									<td class="label"><label> <input type="image"
											src='<c:url value="/resources/graphics/searchbtn.gif"/>'
											alt="search" name="button2" id="button2" value="<spring:message code="photo.upload" />" />
									</label></td>
								</tr>
								</table>
						</form:form>
					</div>
					<div class="bottom"></div>
				</div>
				<spring:url value="/groups.htm" var="groupListUrl" />
				<spring:url value="/groups/new.htm" var="addGroupUrl" />
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
			<jsp:include page="../../common/footer.jsp" />
		</div>
	</div>
</body>
</html>


