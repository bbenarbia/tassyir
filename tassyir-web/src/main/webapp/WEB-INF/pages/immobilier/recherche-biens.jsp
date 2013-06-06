<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html >
<!-- <html dir="rtl"> -->
<head>
		
<jsp:include page="./../common/head.jsp" />

<script type="text/javascript">
			$(document).ready(function(){
			        $(".slidingDiv").hide();
			        $(".show_div").show();
			        $(".hide_div").hide();
			        
			    $('.show_div').click(function(){
			    $(".slidingDiv").slideToggle();
			    $(".show_div").hide();
		        $(".hide_div").show();
			    });
			    
			    $('.hide_div').click(function(){
				    $(".slidingDiv").slideToggle();
				    $(".show_div").show();
			        $(".hide_div").hide();
				    });
			 
			});
</script>

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
	<spring:url value="/biens/new.htm" var="addBienUrl" />
	<spring:url value="/biens/find-biens.htm" var="bienListUrl" />

	<div id="wrap">
		<jsp:include page="../common/menu.jsp" />
		<div id="content">
			<jsp:include page="../common/sub-menu.jsp" />
			<div id="main_bien">
				<jsp:include page="../common/navigator.jsp" />
				<div id="search_bien">
				 <div class="group">
						<c:if test="${mainOperation == 1}">
							<h2>offres Vente</h2>
						</c:if>
						<c:if test="${mainOperation == 2}">
							<h2>offres Location</h2>
						</c:if>
						<c:if test="${mainOperation == 3}">
							<h2>offres Vacances</h2>
						</c:if>
						<c:if test="${mainOperation == 4}">
							<h2>offres Colocation</h2>
						</c:if>
						<c:if test="${mainOperation == 5}">
							<h2>Echange</h2>
						</c:if>
						<c:if test="${mainOperation == 6}">
							<h2>offres Commerce</h2>
						</c:if>
						<c:if test="${mainOperation == 7}">
							<h2>Autres</h2>
						</c:if>
						<c:if test="${mainOperation == 8}">
							<h2>Demandes Achat</h2>
						</c:if>
						<c:if test="${mainOperation == 9}">
							<h2>Demandes Location</h2>
						</c:if>
						<c:if test="${mainOperation == 10}">
							<h2>Demandes Vacances</h2>
						</c:if>
						<c:if test="${mainOperation == 11}">
							<h2>Demandes Colocation</h2>
						</c:if>
						<c:if test="${mainOperation == 12}">
							<h2>Demandes Commerce</h2>
						</c:if>		
					<ul>
						<li id="li_select_lang">
							<form:form modelAttribute="findBiens" method="post" id="form1">
							<table class="search_form" style="width: 100%; border: none;">
								 <tr>
								 	<td colspan="4">
										<div id="searchoptions" class="pma_auto_slider slider_init_done" title="Options" style="overflow: auto;">
										<fieldset id="fieldset_select_fields">
											<legend><spring:message code="biens.zoneRecherche" /> </legend>
												<table class="search_form">
												 <tr>
												 	 <td ><label> 
															<form:select id="states" class="select_field" path="departementBien">
															</form:select>
														</label>
													</td>
													<td ><label>		
															<form:select id="commune" class="select_field" path="communeBien">
																<form:option value=""><spring:message code="biens.commune" /></form:option>
															</form:select>
														</label>
														</td>
														<td hidden="hidden"><label>
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
											</fieldset>
											</div>
								 	</td>
								</tr>
								<tr>
								<td colspan="4">
									<div id="searchoptions" class="pma_auto_slider slider_init_done" title="Options" style="overflow: auto;">
									<fieldset id="fieldset_select_fields">
										<legend><spring:message code="biens.typebien" /></legend>
										<table class="search_form">
											<tr>
												<td><label> <form:checkbox path="appartement" /></label></td>
												<td class="label"><form:label path="appartement" for="appartement">
																			<spring:message code="bien.type.recherche.appartement" />
																  </form:label>
												</td>
												<td><label> <form:checkbox path="maison" /></label></td>
												<td class="label"><form:label path="maison" for="maison">
																			<spring:message code="bien.type.recherche.maison" />
																  </form:label>
												</td>
												<td><label> <form:checkbox path="immeuble" /></label></td>
												<td class="label"><form:label path="immeuble" for="immeuble">
																			<spring:message code="bien.type.recherche.immeuble" />
																  </form:label>
												</td>
												</tr>
												<tr>
												<td><label> <form:checkbox path="terrain" /></label></td>
												<td class="label"><form:label path="terrain" for="terrain">
																			<spring:message code="bien.type.recherche.terrain" />
																  </form:label>
												</td>
												<td><label> <form:checkbox path="agricole" /></label></td>
												<td class="label"><form:label path="agricole" for="agricole">
																			<spring:message code="bien.type.recherche.agricole" />
																  </form:label>
												</td>
												
												<td><label> <form:checkbox path="carcasse" /></label></td>
												<td class="label"><form:label path="carcasse" for="carcasse">
																			<spring:message code="bien.type.recherche.carcasse" />
																  </form:label>
												</td>
												</tr>
												<tr>
												<td><label> <form:checkbox path="commercial" /></label></td>
												<td class="label"><form:label path="commercial" for="commercial">
																			<spring:message code="bien.type.recherche.commercial" />
																  </form:label>
												</td>
												<td><label> <form:checkbox path="bungalow" /></label></td>
												<td class="label"><form:label path="bungalow" for="bungalow">
																			<spring:message code="bien.type.recherche.bungalow" />
																  </form:label>
												</td>
												<td><label> <form:checkbox path="ferme" /></label></td>
												<td class="label"><form:label path="ferme" for="ferme">
																			<spring:message code="bien.type.recherche.ferme" />
																  </form:label>
												</td>
												</tr>
										</table>
									</fieldset>
										<br style="clear: both;">
									</div>
								</td>
								</tr>
								<tr>
								<td colspan="4">
									<a href="#" class="show_div"><spring:message code="biens.moreoption"/></a>
									<a href="#" class="hide_div" hidden="hidden"> <spring:message code="biens.lessoption"/></a>
									<div class="slide-wrapper slidingDiv" >				
									<div id="searchoptions" class="pma_auto_slider slider_init_done" title="Options" style="overflow: auto;">
									 <fieldset id="fieldset_select_fields">
										<legend><spring:message code="biens.optionsbien" /></legend>
										<table class="search_form">
											<tr>
												<td class="label"><spring:message code="biens.reference" /></td>
												<td><label> <form:input label="refBien"
															path="refBien" class="text mediumtext" />
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
												<td   class="label"><spring:message code="biens.pieces.min" /></td>
												<td   ><label> <form:input label="nbPiecesMin"
															path="nbPiecesMin" class="text mediumtext" />
												</label></td>
												<td   class="label"><spring:message code="biens.pieces.max" /></td>
												<td  ><label> <form:input label="nbPiecesMax"
															path="nbPiecesMax" class="text mediumtext" />
												</label></td>
											</tr>
											<tr>
											<td colspan="4">
													
									<!-- <div class="slide-wrapper slidingDiv" >
									<div id="searchoptions" class="pma_auto_slider slider_init_done" title="Options" style="overflow: auto;"> -->
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
											</tr>
											<tr>
												<td><label> <form:checkbox path="interphone" />
												</label></td>
												<td class="label"><form:label path="interphone"
														for="interphone">
														<spring:message code="biens.interphone" />
													</form:label></td>
											
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
											</tr>
											<tr>
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
											
												<td><label> <form:checkbox path="piscine" />
												</label></td>
												<td class="label"><form:label path="piscine"
														for="piscine">
														<spring:message code="biens.piscine" />
													</form:label></td>
											</tr>
											<tr>
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
								</table>
									</fieldset>
								</div>
								</div>
								</td>
							  </tr>								
								<tr>
									<td class="label">&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td class="label"><label> 
									<input type="submit" value="Exécuter" name="submit">
									<%-- <input type="image"
											src='<c:url value="/resources/graphics/searchbtn.gif"/>'
											alt="search
      " name="button2" id="button2"
											value="Submit" /> --%>
									</label></td>
								</tr>
							</table>
						</form:form>
						</li>	
					</ul>
					<div class="error">Veuillez selectionner au moins un type .Veuillez selectionner au moins un type .Veuillez selectionner au moins un type .</div>
					</div>
					
				</div>
			</div>
			<div id="home_sidebar">
				<jsp:include page="./../common/slide-right.jsp" />
			</div>
			<div class="clear">&nbsp;</div>
			<div class="clear">&nbsp;</div>
			<jsp:include page="../common/footer.jsp" />
		</div>
	</div>
</body>
</html>