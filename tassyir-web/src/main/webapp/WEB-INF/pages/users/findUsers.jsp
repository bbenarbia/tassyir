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
	<div id="wrap">
		<jsp:include page="../common/menu.jsp" />
		<div id="content">
			<jsp:include page="../common/sub-menu.jsp" />

			<div id="home_main">
				<div id="search">
					<div class="tab">
						<h2>Find bien</h2>
					</div>
					<div class="container">
						<form:form modelAttribute="findBiens" method="post" id="form1">

							<table class="search_form" style="width: 100%; border: none;">
								<tr>
									<td class="label">Département</td>
									<td colspan="3"><label> <form:select
												path="departementBien" class="select_field">
												<option>indifferent</option>
												<c:forEach var="item" items="${departementsList}">
													<option value="${item.reference}">${item.name}</option>
												</c:forEach>
											</form:select>
									</label></td>
								</tr>
								<tr>
									<td class="label">Type d'appartement</td>
									<td colspan="3"><label> <form:select
												path="typeBien" class="select_field">
												<option>indifferent</option>
												<c:forEach var="item" items="${typesLogementList}">
													<option value="${item.index}">${item}</option>
												</c:forEach>
											</form:select>
									</label></td>
								</tr>
								<tr>
									<td class="label">Nombres pièces Min:</td>
									<td><label> <form:select path="nbPiecesMin"
												class="select_field">
												<option>indifferent</option>
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
												<option value="6">6</option>
											</form:select>
									</label></td>
									<td class="label">Nombres pièces Max:</td>
									<td><label> <form:select path="nbPiecesMax"
												class="select_field">
												<option>indifferent</option>
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
												<option value="6">6</option>
											</form:select>
									</label></td>
								</tr>
								<tr>
									<td class="label">Superficie Min</td>
									<td><label> <form:select path="surfaceMin"
												class="select_field">
												<option>indifferent</option>
												<option value="10">10</option>
												<option value="20">20</option>
												<option value="30">30</option>
												<option value="40">40</option>
												<option value="50">50</option>
												<option value="60">60</option>
												<option value="70">70</option>
												<option value="80">80</option>
												<option value="90">90</option>
												<option value="100">100</option>
											</form:select>
									</label></td>
									<td class="label">Superficie Max</td>
									<td><label> <form:select path="surfaceMax"
												class="select_field">
												<option>indifferent</option>
												<option value="10">10</option>
												<option value="20">20</option>
												<option value="30">30</option>
												<option value="40">40</option>
												<option value="50">50</option>
												<option value="60">60</option>
												<option value="70">70</option>
												<option value="80">80</option>
												<option value="90">90</option>
												<option value="100">100</option>
											</form:select>
									</label></td>
								</tr>
								<tr>
									<td class="label">Loyer Min</td>
									<td><label> <form:select path="loyerMin"
												class="select_field">
												<option>indifferent</option>
												<option value="100">100</option>
												<option value="200">200</option>
												<option value="300">300</option>
												<option value="400">400</option>
												<option value="500">500</option>
												<option value="600">600</option>
												<option value="700">700</option>
												<option value="800">800</option>
												<option value="900">900</option>
												<option value="1000">1000</option>
											</form:select>
									</label></td>
									<td class="label">Loyer Max:</td>
									<td><label> <form:select path="loyerMax"
												class="select_field">
												<option>indifferent</option>
												<option value="100">100</option>
												<option value="200">200</option>
												<option value="300">300</option>
												<option value="400">400</option>
												<option value="500">500</option>
												<option value="600">600</option>
												<option value="700">700</option>
												<option value="800">800</option>
												<option value="900">900</option>
												<option value="1000">1000</option>
											</form:select>
									</label></td>
								</tr>
								<tr>
									<td class="label">&nbsp;</td>
									<td>&nbsp;</td>
									<td colspan="2" class="label"><label> <input
											type="image"  src='<c:url value="/resources/graphics/searchbtn.gif"/>'
											alt="search
      " name="button2" id="button2"
											value="Submit" />
									</label></td>
								</tr>
							</table>
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