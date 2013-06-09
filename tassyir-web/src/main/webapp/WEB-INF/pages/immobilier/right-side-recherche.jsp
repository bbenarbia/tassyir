<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html >
<!-- <html dir="rtl"> -->
<head>
<jsp:include page="./../common/head.jsp" />

<c:url var="findStateCommunesURL" value="/biens/communes.htm" />
<c:url var="findStatesURL" value="/biens/states.htm" />


<script type="text/javascript">
$(document).ready(function() { 
	$('#states').change(
			function() {
				$.getJSON('${findStateCommunesURL}', {
					stateName : $(this).val(),
					ajax : 'true'
				}, function(data) {
					var html = '<option value=""><spring:message code="biens.commune" /></option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i].reference + '">'
								+ data[i].name + '</option>';
					}
					html += '</option>';

					$('#commune').html(html);
				});
			});
});
</script>

<script type="text/javascript">
	$(document).ready(
			function() {
				$.getJSON('${findStatesURL}', {
					ajax : 'true'
				}, function(data) {
					var html = '<option value=""><spring:message code="biens.departement" /></option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i].reference + '">'
								+ data[i].name+ '</option>';
					}
					html += '</option>';

					$('#states').html(html);
				});
			});
</script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#commune").change(onSelectChange);
	});

	function onSelectChange() {
		var selected = $("#commune option:selected");		
		var output = "";
		if(selected.val() != 0){
			output = "You selected commune " + selected.text();
		}
		$("#output").html(output);
	}
</script>
</head>
<body>
		<div  class="group">
				<form:form modelAttribute="findBiens" method="post" id="form1">
					<div id="searchoptions" class="pma_auto_slider slider_init_done" style="overflow: auto;">
								<table class="search_form">
									 <tr hidden="hidden">
									 	<td>
									 		<div  class="group">
												<table>
												 <tr>
												 	<td colspan="2"><label> 
															<form:select id="states" class="select_field" path="departementBien">
																</form:select>
															</label>
													</td>
												 </tr>
												 <tr>
													<td  colspan="2"><label>		
															<form:select id="commune" class="select_field" path="communeBien">
																<form:option value=""><spring:message code="biens.commune" /></form:option>
															</form:select>
														</label>
													</td>
												</tr>
												<tr>
													<td colspan="2"><label>
														<form:select path="typeOperationBien"
															class="select_field">
														   <optgroup label="<spring:message code="bien.action.recherche.offres" />"> 
														      <form:option value="1"><spring:message code="bien.action.recherche.vente" /></form:option> 
														      <form:option value="2"><spring:message code="bien.action.recherche.location" /></form:option> 
														      <form:option value="3"><spring:message code="bien.action.recherche.vacances" /></form:option> 
														      <form:option value="4"><spring:message code="bien.action.recherche.colocation" /></form:option> 
														      <form:option value="6"><spring:message code="bien.action.recherche.commerce" /></form:option> 
														   </optgroup> 
														   <optgroup label="<spring:message code="bien.action.recherche.demandes" />"> 
														      <form:option value="8"><spring:message code="bien.action.recherche.achat" /></form:option> 
														      <form:option value="9"><spring:message code="bien.action.recherche.location" /></form:option> 
														      <form:option value="10"><spring:message code="bien.action.recherche.vacances" /></form:option> 
														      <form:option value="11"><spring:message code="bien.action.recherche.colocation" /></form:option> 
														      <form:option value="12"><spring:message code="bien.action.recherche.commerce" /></form:option> 
														   </optgroup>
														   <form:option  value="5"><spring:message code="bien.action.recherche.echange" /></form:option> 
														   <form:option  value="7"><spring:message code="bien.action.recherche.autre" /></form:option>
		   											</form:select>																
											    	</label>
									      		 </td>
										 		</tr>
												</table>
											</div>
									 	</td>
									</tr>
									 <tr>
									 	<td>
									 	<div  class="group">
											<table>
											 <tr>
												<td>
													<label> <form:checkbox path="appartement" /></label>
													 <form:label path="appartement" for="appartement">
																				<spring:message code="bien.type.recherche.appartement" />
													 </form:label>
												</td>													
												<td>
													<label> <form:checkbox path="maison" /></label>
													<form:label path="maison" for="maison">
																			<spring:message code="bien.type.recherche.maison" />
													</form:label>
												</td>
											 </tr>
											 <tr>
												<td><label> <form:checkbox path="immeuble" /></label>
												<form:label path="immeuble" for="immeuble">
																			<spring:message code="bien.type.recherche.immeuble" />
																  </form:label>
												</td>
												<td><label> <form:checkbox path="terrain" /></label>
												<form:label path="terrain" for="terrain">
																		<spring:message code="bien.type.recherche.terrain" />
															  </form:label>
												</td>
											</tr>
											<tr>
												<td><label> <form:checkbox path="agricole" /></label>
															  <form:label path="agricole" for="agricole">
																		<spring:message code="bien.type.recherche.agricole" />
															  </form:label>
												</td>
												<td><label> <form:checkbox path="carcasse" /></label>
													<form:label path="carcasse" for="carcasse">
																		<spring:message code="bien.type.recherche.carcasse" />
													</form:label>
												</td>
											</tr>
											<tr>
												<td><label> <form:checkbox path="commercial" /></label>
															<form:label path="commercial" for="commercial">
																			<spring:message code="bien.type.recherche.commercial" />
															</form:label>
												</td>
												<td><label> <form:checkbox path="bungalow" /></label>
												<form:label path="bungalow" for="bungalow">
																		<spring:message code="bien.type.recherche.bungalow" />
															  </form:label>
												</td>
											</tr>
											<tr>
												<td><label> <form:checkbox path="ferme" /></label>
												<form:label path="ferme" for="ferme">
																			<spring:message code="bien.type.recherche.ferme" />
																  </form:label>
												</td>
										</tr>
									</table>
									</div>
									</td>
								  </tr>
								 <tr>
									 	<td>
									 	<div  class="group">
												<table>
												  <tr>
													<td>
														<tr>
														<td><spring:message
																code="biens.superficie.min" />
																<label> <form:input label="surfaceMin"
																	path="surfaceMin" class="text mediumtext1" />
														</label></td>
															<td><spring:message
																	code="biens.superficie.max" />
																	<label> <form:input label="surfaceMax"
																		path="surfaceMax" class="text mediumtext1" />
															</label></td>
														</tr>
														<tr>
															<td><spring:message code="biens.budget.max" />
															<label> <form:input label="loyerMin"
																		path="loyerMin" class="text mediumtext1" />
															</label></td>
															<td><spring:message code="biens.budget.max" />
															<label> <form:input label="loyerMax"
																		path="loyerMax" class="text mediumtext1" />
															</label></td>
														</tr>
														<tr>
															<td  ><spring:message code="biens.pieces.min" />
															<label> <form:input label="nbPiecesMin"
																		path="nbPiecesMin" class="text mediumtext1" />
															</label></td>
															<td  ><spring:message code="biens.pieces.max" />
															<label> <form:input label="nbPiecesMax"
																		path="nbPiecesMax" class="text mediumtext1" />
															</label></td>
														</tr>
													</td>
													
												</table> 	
											</div>
										</td>
								</tr>
								 <tr>
									 	<td>
									 		<div  class="group">
												<table>
												  <tr>
													<td>
														<tr>
															<td><label> <form:checkbox path="ascenseur" />
															</label>
															<form:label path="ascenseur"
																	for="ascenseur">
																	<spring:message code="biens.ascenseur" />
																</form:label></td>
																<td><label> <form:checkbox
																			path="cuisineEquipee" />
																</label>
																<form:label path="cuisineEquipee"
																		for="cuisineEquipee">
																		<spring:message code="biens.cuisineEquipee" />
																	</form:label></td>
														</tr>
														<tr>
																<td><label> <form:checkbox path="jardin" />
																</label>
																<form:label path="jardin"
																		for="jardin">
																		<spring:message code="biens.jardin" />
																</form:label></td>
																<td><label> <form:checkbox path="interphone" />
																</label>
																<form:label path="interphone"
																		for="interphone">
																		<spring:message code="biens.interphone" />
																	</form:label></td>
														</tr>
														<tr>
																<td><label> <form:checkbox path="digicode" />
																</label>
																<form:label path="digicode"
																		for="digicode">
																		<spring:message code="biens.digicode" />
																	</form:label></td>
																<td><label> <form:checkbox path="gardien" />
																</label>
																<form:label path="gardien"
																		for="gardien">
																		<spring:message code="biens.gardien" />
																	</form:label></td>
														</tr>
														<tr>
																<td><label> <form:checkbox
																			path="adapteHandicape" />
																</label>
																<form:label path="adapteHandicape"
																		for="adapteHandicape">
																		<spring:message code="biens.adapte" />
																	</form:label></td>
																<td><label> <form:checkbox path="meuble" />
																</label>
																<form:label path="meuble"
																		for="meuble">
																		<spring:message code="biens.meuble" />
																</form:label></td>
														</tr>
														<tr>
																<td><label> <form:checkbox path="piscine" />
																</label>
																<form:label path="piscine"
																		for="piscine">
																		<spring:message code="biens.piscine" />
																	</form:label></td>
																<td><label> <form:checkbox path="caves" />
																</label>
																<form:label path="caves" for="caves">
																		<spring:message code="biens.caves" />
																	</form:label></td>
														</tr>
														<tr>
																<td><label> <form:checkbox path="parking" />
																</label>
																<form:label path="parking"
																		for="parking">
																		<spring:message code="biens.parking" />
																	</form:label></td>
																<td><label> <form:checkbox
																			path="terrassesBalcons" />
																</label>
																<form:label path="terrassesBalcons"
																		for="terrassesBalcons">
																		<spring:message code="biens.terrassesBalcons" />
																	</form:label></td>
														</tr>
												</table> 
											</div>
										</td>
								</tr>
								<tr>
									<td style="text-align: center;">
										<input type="submit" value="Exécuter" name="submit"/>
									</td>
								</tr>
								
							</table>
					</div>
			</form:form>
		</div>
</body>
</html>