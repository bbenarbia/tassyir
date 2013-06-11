<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<jsp:include page="./../../common/head.jsp" />

<c:url var="findStateCommunesURL" value="/biens/communes.htm" />
<c:url var="findStatesURL" value="/biens/states.htm" />
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#states')
								.change(
										function() {
											$
													.getJSON(
															'${findStateCommunesURL}',
															{
																stateName : $(
																		this)
																		.val(),
																ajax : 'true'
															},
															function(data) {
																var html = '<option value=""><spring:message code="biens.commune" /></option>';
																var len = data.length;
																for ( var i = 0; i < len; i++) {
																	html += '<option value="' + data[i].reference + '">'
																			+ data[i].name
																			+ '</option>';
																}
																html += '</option>';

																$('#commune')
																		.html(
																				html);
															});
										});
					});
</script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$
								.getJSON(
										'${findStatesURL}',
										{
											ajax : 'true'
										},
										function(data) {
											var html = '<option value=""><spring:message code="biens.departement" /></option>';
											var len = data.length;
											for ( var i = 0; i < len; i++) {
												html += '<option value="' + data[i].reference + '">'
														+ data[i].name
														+ '</option>';
											}
											html += '</option>';

											$('#states').html(html);
										});
					});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#commune").change(onSelectChange);
	});

	function onSelectChange() {
		var selected = $("#commune option:selected");
		var output = "";
		if (selected.val() != 0) {
			output = "You selected commune " + selected.text();
		}
		$("#output").html(output);
	}
</script>
</head>
<body>
	
	<div id="wrap">
		<jsp:include page="./../../common/menu.jsp" />
		<jsp:include page="./../../common/sub-menu.jsp" />
		<div id="content">
			<div id="main_bien">

				<div id="search_bien">
					<div class="group">
						<h2>Selectionner le type de biens</h2>
						<ul>
							<li id="li_select_lang"><form:form
									modelAttribute="findBiens" method="post" id="form1">
									<table class="search_form" style="width: 100%; border: none;">
										<tr>
											<td colspan="4">
												<div id="searchoptions"
													class="pma_auto_slider slider_init_done" title="Options"
													style="overflow: auto;">
													<fieldset id="fieldset_select_fields">
														<legend>
															<spring:message code="biens.zoneRecherche" />
														</legend>
														<table class="search_form">
															<tr>
																<td><label> <form:select id="states"
																			class="select_field" path="departementBien" >
																		</form:select>
																		 
																</label></td>
																<td><label> <form:select id="commune" 
																			class="select_field" path="communeBien">
																			<form:option value="">
																				<spring:message code="biens.commune"/>
																			</form:option>
																		</form:select>
																		
																</label></td>
																<td>
																	<form:errors path="*" cssClass="error_code"/>
																</td>
															</tr>
															<tr>
																<td><label> <form:select
																			path="typeOperationBien" class="select_field">
																			<optgroup
																				label="<spring:message code="bien.action.recherche.offres" />">
																				<form:option value="1">
																					<spring:message code="bien.action.recherche.vente" />
																				</form:option>
																				<form:option value="2">
																					<spring:message
																						code="bien.action.recherche.location" />
																				</form:option>
																				<form:option value="3">
																					<spring:message
																						code="bien.action.recherche.vacances" />
																				</form:option>
																				<form:option value="4">
																					<spring:message
																						code="bien.action.recherche.colocation" />
																				</form:option>
																				<form:option value="6">
																					<spring:message
																						code="bien.action.recherche.commerce" />
																				</form:option>
																			</optgroup>
																			<optgroup
																				label="<spring:message code="bien.action.recherche.demandes" />">
																				<form:option value="8">
																					<spring:message code="bien.action.recherche.achat" />
																				</form:option>
																				<form:option value="9">
																					<spring:message
																						code="bien.action.recherche.location" />
																				</form:option>
																				<form:option value="10">
																					<spring:message
																						code="bien.action.recherche.vacances" />
																				</form:option>
																				<form:option value="11">
																					<spring:message
																						code="bien.action.recherche.colocation" />
																				</form:option>
																				<form:option value="12">
																					<spring:message
																						code="bien.action.recherche.commerce" />
																				</form:option>
																			</optgroup>
																			<form:option value="5">
																				<spring:message code="bien.action.recherche.echange" />
																			</form:option>
																			<form:option value="7">
																				<spring:message code="bien.action.recherche.autre" />
																			</form:option>
																		</form:select>
																</label></td>
																<td><label> <form:select path="typeBien"
																			class="select_field">
																			<option value="1">
																				<spring:message
																					code="bien.type.recherche.appartement" />
																			</option>
																			<option value="2">
																				<spring:message code="bien.type.recherche.maison" />
																			</option>
																			<option value="3">
																				<spring:message code="bien.type.recherche.immeuble" />
																			</option>
																			<option value="4">
																				<spring:message code="bien.type.recherche.terrain" />
																			</option>
																			<option value="5">
																				<spring:message code="bien.type.recherche.agricole" />
																			</option>
																			<option value="6">
																				<spring:message code="bien.type.recherche.carcasse" />
																			</option>
																			<option value="7">
																				<spring:message
																					code="bien.type.recherche.commercial" />
																			</option>
																			<option value="8">
																				<spring:message code="bien.type.recherche.bungalow" />
																			</option>
																			<option value="9">
																				<spring:message code="bien.type.recherche.ferme" />
																			</option>
																		</form:select>
																</label></td>
															</tr>
															<tr>
																<td class="label">&nbsp;</td>
																<td>&nbsp;</td>
																<td class="label"><label> <input
																		class="buttonGo" type="submit" value="Suivant"
																		name="submit">
																</label></td>
															</tr>
														</table>
													</fieldset>
													<br style="clear: both;">
												</div>
											</td>
										</tr>
									</table>
								</form:form></li>
						</ul>
					</div>
				</div>
			</div>
			<div id="home_sidebar">
				<div class="block advert">

					<img src='<c:url value="/resources/graphics/advertisehere.jpg"/>'
						alt="Advertise Here" style="width: 315px;" />
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