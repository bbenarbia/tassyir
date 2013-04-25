<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<jsp:include page="./../common/head.jsp"/>
</head>
<body>
	<spring:url value="/users/{userId}.htm" var="detailuserUrl">
				<spring:param name="userId" value="${user.id}" />
	</spring:url> 
	<spring:url value="/users.htm" var="userListUrl"> </spring:url>
	<spring:url value="/" var="homeUrl"> </spring:url>
	<spring:url value="/users/new.htm" var="userUrl" />
	
	
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
						<h2>Update user password</h2>
					</div>
					<div
						style="margin: 10px; background: none repeat scroll 0px 0px rgb(248, 248, 248); padding: 14px;">
						<form:form modelAttribute="userPassword" method="put" id="form1">
							<fieldset>
								<legend>Password Info</legend>
								<dl>
									<dt>
										<form:label path="oldPassword"><spring:message code="user.password" /></form:label>
									</dt>
									<dd>
										<form:password label="oldPassword"  path="oldPassword" class="text" cssErrorClass="error"/>
										<form:errors path="oldPassword" cssClass="error_code"/>
									</dd>
								</dl>
								
								<dl>
									<dt>
										<form:label path="password"><spring:message code="user.newpassword" /></form:label>
									</dt>
									<dd>
										<form:password label="password"  path="password" class="text" cssErrorClass="error"/>
										<form:errors path="password" cssClass="error_code"/>
									</dd>
								</dl>
								
								<dl>
									<dt>
										<form:label path="passwordConfirmation"><spring:message code="user.confirmation" /></form:label>
									</dt>
									<dd>
										<form:password label="passwordConfirmation"  path="passwordConfirmation" class="text" cssErrorClass="error"/>
										<form:errors path="passwordConfirmation" cssClass="error_code"/>
									</dd>
								</dl>
							</fieldset>
							
								
							<fieldset class="action">
									<dl><dt>
    									<input type="submit"  alt="Update"  class="buttonmenu" value="Update" />
									</dt>
									<dd>
										<a class="buttonmenured"  href="${fn:escapeXml(detailuserUrl)}"><spring:message code="parameter.action.cancel" /></a>
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