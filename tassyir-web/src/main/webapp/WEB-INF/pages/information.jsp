<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<jsp:include page="./common/head.jsp" />
<title>Tassyir: <spring:message code="user.action.add" /></title>
</head>
<body>
	<spring:url value="/users.htm" var="userListUrl"> </spring:url>
	<spring:url value="/" var="homeUrl"> </spring:url>
	<spring:url value="/users/new.htm" var="newUserUrl" />
	
	
	<spring:url value="/users.htm" var="userListUrl"> </spring:url>
	<spring:url value="/" var="homeUrl"> </spring:url>
	<spring:url value="/users/new.htm" var="newUserUrl" />
	
	<div id="wrap">
		<jsp:include page="./common/menu.jsp" />
		<div id="content">
			<jsp:include page="./common/sub-menu.jsp" />

			<div id="home_main_edit_user">
					<jsp:include page="./common/navigator.jsp" />				
				<div id="edit_user">
					<div class="tab">
						<h2>${message.title}</h2>
					</div>
					<div style="margin: 10px; background: none repeat scroll 0px 0px rgb(248, 248, 248); padding: 14px;">
						<p>
							${message.text}
						</p>
					</div>
				</div>
			</div>
			<div class="clear">&nbsp;</div>
			<div class="clear">&nbsp;</div>
			<jsp:include page="./common/footer.jsp" />
		</div>
	</div>
</body>
</html>
