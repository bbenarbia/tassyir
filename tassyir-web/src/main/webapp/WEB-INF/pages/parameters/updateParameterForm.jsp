			
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<jsp:include page="./../common/head.jsp"/>
	<title>Tassyir: update params</title>
</head>
<body>
	<spring:url value="/parameters.htm" var="paramListUrl" />
	<spring:url value="/parameters/new.htm" var="addParamUrl" /> 
	
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
						<h2>Edit Parameter</h2>
					</div>
					<div
						style="margin: 10px; background: none repeat scroll 0px 0px rgb(248, 248, 248); padding: 14px;">
						<form:form modelAttribute="parameter" method="put" id="form1">
							<fieldset>
								<legend>General Info</legend>
								<dl>
									<dt>
										<form:label path="name">
											<spring:message code="param.name" />
										</form:label>
									</dt>
									<dd>
										<form:input label="name" path="name" class="text"
											cssErrorClass="error" />
									</dd>
								</dl>
								<dl>
									<dt>
										<form:label path="value">
											<spring:message code="param.value" />
										</form:label>
									</dt>
									<dd>
										<form:input label="value" path="value" class="text"
											cssErrorClass="error" />
									</dd>
								</dl>
								<dl>
									<dt>
										<form:label path="description">
											<spring:message code="param.description" />
										</form:label>
									</dt>
									<dd>
										<form:textarea cols="20" rows="5" 
												label="description"
												path="description" class="text textBoxfieldlong" />
									</dd>
								</dl>
							</fieldset>
							
								
							<fieldset class="action">
									<dl><dt>
    									<input type="submit"  alt="Update"  class="buttonmenu" value="Update" />
									</dt>
									<dd>
										<a class="buttonmenured"  href="${fn:escapeXml(paramListUrl)}"><spring:message code="parameter.action.cancel" /></a>
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
