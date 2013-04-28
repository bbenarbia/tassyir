<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
	<jsp:include page="./common/head.jsp"/>
</head>
<body>
	<div id="wrap">
		<jsp:include page="./common/menu.jsp"/>
		<div id="content">
				<jsp:include page="./common/sub-menu.jsp"/>

			<div id="home_main">
				<div id="search">
					<div class="tab">
						<h2>Search Property To Buy / Rent</h2>
					</div>
					<div class="container">
						<jsp:include page="./common/carroussel.jsp"/>
					</div>
				</div>
				
				<div id="search_bien">
					<div class="tab">
						<h2>Find bien</h2>
					</div>
					<div class="container_home">
						<form:form method="post" id="form1" modelAttribute="findBiens" action="biens/find-biens-reduit.htm">
							<table class="search_form" style="width: 100%; border: none;">
								<tr>
									<td class="label"><spring:message code="biens.recherche" /></td>
									<td><label> <form:select path="typeOperationBien"
												class="select_field">
												<c:forEach var="item" items="${typesOperationsList}">
															<option value="${item}"> ${item} </option>
												</c:forEach>
											</form:select>
									</label></td>
									<td class="label"><spring:message code="biens.typebien" /></td>
									<td><label> <form:select path="typeBien"
												class="select_field">
												<option>
													<spring:message code="biens.indifferent" />
												</option>
												<c:forEach var="item" items="${typesLogementList}">
															<option value="${item.index}"> ${item}</option>
												</c:forEach>
											</form:select>
									</label></td>
								</tr>
								<tr>
									<td class="label"><spring:message code="biens.departement" /></td>
									<td colspan="3"><label> <form:select
												path="departementBien" class="select_field">
												<form:option value="-1">
													<spring:message code="biens.indifferent" />
												</form:option>
												<c:forEach var="item" items="${departementsList}">
															<form:option value="${item.reference}">  ${item.name} </form:option>
												</c:forEach>
											</form:select>
									</label></td>
								</tr>
							
								<tr>
									<td class="label"><spring:message
											code="biens.superficie.min" /></td>
									<td><label> <form:input label="surfaceMin"
												path="surfaceMin" class="text mediumtext" />
									</label></td>
									<td class="label"><spring:message
											code="biens.superficie.max" /></td>
									<td><label> <form:input label="surfaceMax"
												path="surfaceMax" class="text mediumtext" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><spring:message code="biens.budget.max" /></td>
									<td><label> <form:input label="loyerMin"
												path="loyerMin" class="text mediumtext" />
									</label></td>
									<td class="label"><spring:message code="biens.budget.max" />:</td>
									<td><label> <form:input label="loyerMax"
												path="loyerMax" class="text mediumtext" />
									</label></td>
								</tr>
								<tr>
									<td class="label">&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td class="label"><label> <input type="image"
											src='<c:url value="/resources/graphics/searchbtn.gif"/>'
											alt="search
      " name="button2" id="button2"
											value="Submit" />
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
		</div>
		
		<div class="clear">&nbsp;</div>
		<div class="clear">&nbsp;</div>
		<jsp:include page="./common/footer.jsp"/>
	</div>
</body>
</html>