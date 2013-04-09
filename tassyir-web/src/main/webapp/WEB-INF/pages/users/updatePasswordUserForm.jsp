<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet" href="<c:url value="/stylesheets/style.css"/>"
	type="text/css" />
<link rel="stylesheet" href="<c:url value="/stylesheets/forms.css"/>"
	type="text/css" />

<link rel="stylesheet"
	href="<c:url value="/stylesheets/carroussel.css"/>" type="text/css" />
<script type="text/javascript" src="scripts/jquery-1.9.1.js">
	
</script>
<script type="text/javascript" src="scripts/carroussel.js">
	
</script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="../common/menu.jsp" />
		<div id="content">
			<jsp:include page="../common/sub-menu.jsp" />

			<div id="home_main">
				<div id="search">
					<div class="tab">
						<h2>Update user infos</h2>
					</div>
					<div class="container">
						<form:form modelAttribute="userPassword" method="put" id="form1">
							<table class="search_form" style="width: 100%; border: none;">
								<tr>
									<td class="label"><form:label path="oldPassword">Old password</form:label></td>
									<td><label> <form:password label="oldPassword"
												path="oldPassword" class="text" />
									</label></td>
									<td><label>
												<form:errors
															cssClass="error" path="oldPassword" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="password">new password</form:label></td>
									<td><label> <form:password label="password"
												path="password" class="text" /></label></td>
									<td><label>
												<form:errors
															cssClass="error" path="password" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><form:label path="passwordConfirmation">Confirm password</form:label></td>
									<td><label> <form:password label="passwordConfirmation"
												path="passwordConfirmation" class="text" /></label></td>
									<td><label>
												<form:errors
															cssClass="error" path="passwordConfirmation" />
									</label></td>
								</tr>
								
							<tr>
									<td class="label">&nbsp;</td>
									<td colspan="2" class="label"><label> <input
											type="image" src="../../graphics/searchbtn.gif" alt="search"
											name="button2" id="button2" value="Submit" />
									</label></td>
								</tr>
							</table>
						</form:form>
					</div>
					<div class="bottom"></div>
				</div>
			</div>
			<div class="clear">&nbsp;</div>
			<div class="clear">&nbsp;</div>
			<jsp:include page="../common/footer.jsp" />
		</div>
	</div>
</body>
</html>
