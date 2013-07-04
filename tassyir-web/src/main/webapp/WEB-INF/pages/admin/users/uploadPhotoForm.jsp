<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<jsp:include page="./../../common/head.jsp" />
</head>
<body>
	<spring:url value="/users/{userId}.htm" var="detailuserUrl">
		<spring:param name="userId" value="${user.id}" />
	</spring:url>
	<spring:url value="/users.htm" var="userListUrl">
	</spring:url>
	<spring:url value="/" var="homeUrl">
	</spring:url>
	<spring:url value="/users/new.htm" var="userUrl" />

	<div id="wrap">
		<jsp:include page="../../common/menu.jsp" />
		<div id="content">
			<jsp:include page="../../common/sub-menu.jsp" />
			<div id="home_sidebar_left">
				<jsp:include page="./../../common/left-menu.jsp" />
			</div>
			<div id="main_bien">
				<jsp:include page="../../common/navigator.jsp" />
				<div class="group">
					<h2>Select user Photo</h2>
					<ul>
						<li id="li_select_lang"><form:form method="post"
								action="save.html" modelAttribute="uploadForm"
								enctype="multipart/form-data" id="form1">
								<fieldset>
									<legend></legend>
									<dl>
										<dt>Photo:
											<label><input name="files[0]" type="file"
												accept="image/*" /> </label>
										</dt>
									</dl>
									<dl>
										<dt>
											<a class="buttonmenured"
												href="${fn:escapeXml(detailuserUrl)}"> <spring:message
													code="user.action.cancel" /></a>
										</dt>
										<dd>
											<label> <input type="image"
												src='<c:url value="/resources/graphics/searchbtn.gif"/>'
												alt="search" name="button2" id="button2"
												value="<spring:message code="photo.upload" />" />
											</label>
										</dd>
									</dl>
								</fieldset>
							</form:form>
						</li>
					</ul>
				</div>

			</div>
		</div>
		<div id="home_sidebar">
			<div class="block advert">
				<img src='<c:url value="/resources/graphics/advertisehere.jpg"/>'
					alt="Advertise Here" style="width: 200px;" />
			</div>

			<%-- <jsp:include page="./../immobilier/right-side-recherche.jsp" /> --%>
			<jsp:include page="./../../common/slide-right.jsp" />

		</div>
		<div class="clear">&nbsp;</div>
		<div class="clear">&nbsp;</div>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	</div>
</body>
</html>

