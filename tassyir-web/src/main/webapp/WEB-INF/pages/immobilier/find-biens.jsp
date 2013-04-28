<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<jsp:include page="./../common/head.jsp" />
</head>
<body>
	<spring:url value="/biens/new.htm" var="addBienUrl" />
	<spring:url value="/biens/find-biens.htm" var="bienListUrl" />

	<div id="wrap">
		<jsp:include page="../common/menu.jsp" />
		<div id="content">
			<jsp:include page="../common/sub-menu.jsp" />

			<div id="main_bien">
				<div class="navig">
					<c:forEach var="navig" items="${navigations}" varStatus="status">
							&laquo;
							<spring:url value="${navig.url}" var="navigs" />
						<a href="${navigs}"><spring:message code="${navig.name}" /></a>
					</c:forEach>
				</div>
				<div id="search_bien">
					<div class="tab">
						<h2>Find bien</h2>
					</div>
					<div class="container">
						<form:form modelAttribute="findBiens" method="post" id="form1">
							<table class="search_form" style="width: 100%; border: none;">
								<tr>
									<td class="label"><spring:message code="biens.recherche" /></td>
									<td><label> <form:select path="typeOperationBien"
												class="select_field">
												<c:forEach var="item" items="${typesOperationsList}">
													<c:choose>
														<c:when test="${typeOperationBien == item}">
															<form:option selected="true" value="${item}">
																               				 ${item} 
																            			</form:option>
														</c:when>
														<c:otherwise>
															<form:option value="${item}">
																                  			 ${item}
																            			</form:option>
														</c:otherwise>
													</c:choose>
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
													<c:choose>
														<c:when test="${typeBien == item}">
															<form:option selected="true" value="${item.index}">
																               				 ${item} 
																            			</form:option>
														</c:when>
														<c:otherwise>
															<form:option value="${item.index}">
																                  			 ${item}
																            			</form:option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</form:select>
									</label></td>
								</tr>
								<tr>
									<td class="label"><spring:message code="biens.reference" /></td>
									<td><label> <form:input label="refBien"
												path="refBien" class="text mediumtext" />
									</label></td>
								</tr>
								<tr>
									<td class="label"><spring:message code="biens.departement" /></td>
									<td colspan="3"><label> <form:select
												path="departementBien" class="select_field">
												<option value="-1">
													<spring:message code="biens.indifferent" />
												</option>
												<c:forEach var="item" items="${departementsList}">
													<c:choose>
														<c:when test="${departementBien == item.reference}">
															<form:option selected="true" value="${item.reference}">
																               				 ${item.name} 
																            			</form:option>
														</c:when>
														<c:otherwise>
															<form:option value="${item.reference}">
																                  			 ${item.name}
																            			</form:option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</form:select>
									</label></td>
								</tr>
								<tr>
									<td class="label"><spring:message code="biens.pieces.min" />:</td>
									<td><label> <form:input label="nbPiecesMin"
												path="nbPiecesMin" class="text mediumtext" />
									</label></td>
									<td class="label"><spring:message code="biens.pieces.max" />:</td>
									<td><label> <form:input label="nbPiecesMax"
												path="nbPiecesMax" class="text mediumtext" />
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
									<td class="label" colspan="4">
										<table class="search_form">
											<tr>
												<td><label> <form:checkbox path="ascenseur" />
												</label></td>
												<td class="label"><form:label path="ascenseur"
														for="ascenseur">
														<spring:message code="biens.ascenseur" />
													</form:label></td>

												<td><label> <form:checkbox
															path="cuisineEquipee" />
												</label></td>
												<td class="label"><form:label path="cuisineEquipee"
														for="cuisineEquipee">
														<spring:message code="biens.cuisineEquipee" />
													</form:label></td>

												<td><label> <form:checkbox path="jardin" />
												</label></td>
												<td class="label"><form:label path="jardin"
														for="jardin">
														<spring:message code="biens.jardin" />
													</form:label></td>


												<td><label> <form:checkbox path="interphone" />
												</label></td>
												<td class="label"><form:label path="interphone"
														for="interphone">
														<spring:message code="biens.interphone" />
													</form:label></td>
											</tr>
											<tr>
												<td><label> <form:checkbox path="digicode" />
												</label></td>
												<td class="label"><form:label path="digicode"
														for="digicode">
														<spring:message code="biens.digicode" />
													</form:label></td>

												<td><label> <form:checkbox path="gardien" />
												</label></td>
												<td class="label"><form:label path="gardien"
														for="gardien">
														<spring:message code="biens.gardien" />
													</form:label></td>

												<td><label> <form:checkbox
															path="adapteHandicape" />
												</label></td>
												<td class="label"><form:label path="adapteHandicape"
														for="adapteHandicape">
														<spring:message code="biens.adapte" />
													</form:label></td>

												<td><label> <form:checkbox path="meuble" />
												</label></td>
												<td class="label"><form:label path="meuble"
														for="meuble">
														<spring:message code="biens.meuble" />
													</form:label></td>
											</tr>
											<tr>
												<td><label> <form:checkbox path="piscine" />
												</label></td>
												<td class="label"><form:label path="piscine"
														for="piscine">
														<spring:message code="biens.piscine" />
													</form:label></td>
												<td><label> <form:checkbox path="caves" />
												</label></td>
												<td class="label"><form:label path="caves" for="caves">
														<spring:message code="biens.caves" />
													</form:label></td>

												<td><label> <form:checkbox path="parking" />
												</label></td>
												<td class="label"><form:label path="parking"
														for="parking">
														<spring:message code="biens.parking" />
													</form:label></td>
												<td><label> <form:checkbox
															path="terrassesBalcons" />
												</label></td>
												<td class="label"><form:label path="terrassesBalcons"
														for="terrassesBalcons">
														<spring:message code="biens.terrassesBalcons" />
													</form:label></td>
											</tr>
										</table>
									</td>
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
			<jsp:include page="../common/footer.jsp" />
		</div>
	</div>
</body>
</html>