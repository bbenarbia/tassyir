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
	<spring:url value="/users/{userId}.htm" var="detailuserUrl">
				<spring:param name="userId" value="${user.id}" />
	</spring:url> 
	<spring:url value="/users.htm" var="userListUrl"> </spring:url>
	<spring:url value="/" var="homeUrl"> </spring:url>
	<spring:url value="/users/new.htm" var="userUrl" />
	
	<div id="wrap">
		<jsp:include page="../../common/menu.jsp" />
		<div id="content">
			<jsp:include page="../../common/sub-menu.jsp" />

			<div id="home_main">
				<div class="navig">
						<a href="${fn:escapeXml(homeUrl)}"><spring:message code="home" /></a>
						&laquo;
						<a href="${fn:escapeXml(userListUrl)}"><spring:message code="user.gotolistuser" /></a>
						&laquo;
						<a href="${fn:escapeXml(detailuserUrl)}"><spring:message code="user.action.details" /></a>
				</div>
					
				<div id="search">
					<div class="tab">
						<h2>Select user Photo</h2>
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
										<a class="buttonmenured"  href="${fn:escapeXml(detailuserUrl)}"><spring:message code="user.action.cancel" /></a>
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
			<jsp:include page="../../common/footer.jsp" />
		</div>
	</div>
</body>
</html>


