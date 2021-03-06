<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<jsp:include page="./../../common/head.jsp" />
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
		<jsp:include page="./../../common/menu.jsp" />
		<jsp:include page="./../../common/sub-menu.jsp" />
		<div id="content">
			<div id="home_sidebar_left">
				<jsp:include page="./../../common/left-menu.jsp" />
			</div>
			<div id="main_bien">
				<div id="search_bien">
					<div class="group">
						<h2><spring:message code="user.action.subscribe" /></h2>
						<ul>
							<li id="li_select_lang">
						<form:form modelAttribute="user" method="post" id="form1" enctype="multipart/form-data">
							<fieldset>
    						<legend><spring:message code="user.infos.general" /></legend>
        						<dl>
        							<dt><form:label path="firstName"><spring:message code="user.firstName" /></form:label></dt>
					            	<dd>
										<form:input label="firstName"
												path="firstName" class="text" cssErrorClass="error"/>
									</dd>
								</dl>
								<dl>
        							<dt><form:label path="lastName"><spring:message code="user.lastName" /></form:label></dt>
					            	<dd>
										<form:input label="lastName" path="lastName" class="text" cssErrorClass="error"/>
									</dd>
								</dl>
								<dl>
        							<dt><form:label path="login"><spring:message code="user.login" /></form:label></dt>
					            	<dd>
										<form:input label="login" path="login" class="text" cssErrorClass="error"/>
										<form:errors path="login" cssClass="error_code"/>
									</dd>
								</dl>
								<dl>
        							<dt><form:label path="code"><spring:message code="user.code" /></form:label></dt>
					            	<dd>
										<form:input label="code" path="code"
												class="text mediumtext" cssErrorClass="error"/>
												<form:errors path="code" cssClass="error_code"/>
									</dd>
								</dl>
								<dl>
        							<dt><form:label path="password"><spring:message code="user.password" /></form:label></dt>
					            	<dd>
										<form:password label="password" path="password" class="text" cssErrorClass="error"/>
										<form:errors path="password" cssClass="error_code"/>
									</dd>
								</dl>
								<dl>
        							<dt><form:label path="passwordConfirmation"><spring:message code="user.confirmation" /></form:label></dt>
					            	<dd>
										<form:password label="passwordConfirmation" path="passwordConfirmation"
												class="text mediumtext" cssErrorClass="error"/>
												<form:errors path="passwordConfirmation" cssClass="error_code"/>
									</dd>
								</dl>
								<dl>
									<dt><form:label path="adresse"><spring:message code="user.adresse" /></form:label></dt>
									<dd>
										<form:textarea cols="26" rows="4" label="adresse"
										path="adresse" class="text textBoxfieldlong" cssErrorClass="error"/>
									</dd>
								</dl>
								<dl>
									<dt><form:label path="ville"><spring:message code="user.ville" /></form:label></dt>
									<dd>
										<form:input label="ville" path="ville" class="text" cssErrorClass="error"/>
									</dd>
								</dl>
								<dl>
									<dt><form:label path="codePostal"><spring:message code="user.codePostal" /></form:label></dt>
									<dd>
										<form:input label="codePostal" path="codePostal" class="text" cssErrorClass="error"/>
									</dd>
								</dl>
								<dl>
									<dt><form:label path="telephonePerso"><spring:message code="user.telephonePerso" /></form:label></dt>
									<dd>
										 <form:input label="telephonePerso" path="telephonePerso" class="text" cssErrorClass="error"/>
									</dd>
								</dl>
								<dl>
									<dt><spring:message code="user.acceptalert" /></dt>
									<dd>
										<form:checkbox path="alerteSurTelephone1" />
									</dd>
								</dl>
								<dl>
									<dt><form:label path="telephoneProf"><spring:message code="user.telephoneProf" /></form:label></dt>
									<dd>
										<form:input label="telephoneProf" path="telephoneProf" class="text" cssErrorClass="error"/>
									</dd>
								</dl>
								<dl>
									<dt><spring:message code="user.acceptalert" /></dt>
									<dd>
										<form:checkbox path="alerteSurTelephone2" />
									</dd>
								</dl>
								<dl>
									<dt><form:label path="telephoneMobile"><spring:message code="user.mobile" /></form:label></dt>
									<dd>
										<form:input label="telephoneMobile" path="telephoneMobile" class="text" cssErrorClass="error"/>
									</dd>
								</dl>
								<dl>
									<dt><spring:message code="user.acceptalert" /></dt>
									<dd>
										<form:checkbox path="alerteSurTelephone2" />
									</dd>
								</dl>
								<dl>
									<dt><form:label path="siteWeb"><spring:message code="user.website" /></form:label></dt>
									<dd>
										<form:input label="siteWeb" path="siteWeb" class="text" cssErrorClass="error"/>
									</dd>
								</dl>
								<dl>
									<dt><form:label path="adresseMail"><spring:message code="user.email" /></form:label></dt>
									<dd>
										<form:input label="adresseMail" path="adresseMail" class="text" cssErrorClass="error"/>
									</dd>
								</dl>
								<dl>
									<dt><spring:message code="user.photo" /></dt>
									<dd>
										<input   name="photoFile" type="file" accept="image/*" />
									</dd>
								</dl>
								</fieldset>
								<fieldset class="action">
									<dl><dt>
    									<input type="submit" alt="Create" value="Create"   class="buttonmenu"  />
									</dt>
									<dd>
										<a class="buttonmenured"  href="${fn:escapeXml(userListUrl)}"><spring:message code="biens.action.cancel" /></a>
									</dd>
									</dl>
    							</fieldset>
							</form:form>
						</ul>
					</div>
				</div>
			</div>
			<div id="home_sidebar">
				<div class="block advert">

					<img src='<c:url value="/resources/graphics/advertisehere.jpg"/>'
						alt="Advertise Here" style="width: 200px;" />
					<%-- <jsp:include page="./../immobilier/right-side-recherche.jsp" /> --%>
				</div>
				<jsp:include page="./../../common/slide-right.jsp" />


			</div>
			<div class="clear">&nbsp;</div>
			<div class="clear">&nbsp;</div>
		</div>
		<div class="clear">&nbsp;</div>
		<div class="clear">&nbsp;</div>
		<jsp:include page="./../../common/footer.jsp" />
	</div>

</body>
</html>