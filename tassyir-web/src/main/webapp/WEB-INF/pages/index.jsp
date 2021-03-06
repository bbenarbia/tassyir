<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<jsp:include page="./common/head.jsp" />

<!-- Fav -->
		<link rel="shortcut icon" type="image/png" href="/favicon.png" />
		<link rel="shortcut icon" type="image/x-icon" href="/favicon.ico" />
		<link rel="icon" type="image/png" href="logo-pap-114.png" />
		<link rel="apple-touch-icon" sizes="114x114" href="logo-pap-114.png" />



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

<spring:message code="biens.max" var="valmax"/>
<spring:message code="biens.min" var="valmin"/>
<spring:message code="biens.referenceputit" var="refplaceholder"/>
<spring:message code="biens.main.search.quoi" var="searchquoi"/>
<spring:message code="biens.main.search.ou" var="searchou"/>

												
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

	<div id="wrap">
		<jsp:include page="./common/menu.jsp" />
		<div id="content">
			<jsp:include page="./common/sub-menu.jsp" />
			<div id="home_sidebar_left">
					<jsp:include page="./common/left-menu.jsp" />
			</div>
			<div id="main_bien">
				<div id="search_bien">
					<div class="group">
						<h2><spring:message code="biens.rechercherapide" /></h2>
								<div id="searchoptions" class="pma_auto_slider slider_init_done"
									title="Options" style="overflow: auto;">
									<div class="box1 search">
											<form name="" method="post" action="searchrapide.htm">
												<h3 style="margin-left: 10px;font-size: 20px">QUI ?</h3>
												<div class="bg-input">
													<input type="text" class="textsearch"
														placeholder="${searchquoi }">
												</div>
												<h3 style="margin-top: 10px; margin-left: 10px;font-size: 20px">O� ?</h3>
												<div class="submitBtn right">
													<input type="submit" style="cursor: pointer;"
														value="Rechercher" id="rechercher" name="rechercher">
												</div>
												<div class="bg-input">
													<input class="textsearch" type="text"
														placeholder="${searchou}" class="ac_input">
												</div>
											</form>
										</div>
								</div>
					</div>
					
					<div class="group">
						<h2><spring:message code="biens.recherchedetaille" /></h2>
					 <ul>
						<li id="li_select_lang">
						<form:form modelAttribute="findBiens" method="post" id="form1">
							<table class="search_form" style="width: 100%; border: none;">
								 <tr>
								 	<td colspan="4">
										<%-- <div id="searchoptions" class="pma_auto_slider slider_init_done" title="Options" style="overflow: auto;">
										<fieldset id="fieldset_select_fields">
											<legend><spring:message code="biens.recherchedetaille" /> </legend> --%>
												<table class="search_form">
													<tr>
														<td colspan="4">
															<form:errors path="*" cssClass="error_code"/>
														</td>
													</tr>
												 	<tr>
												 		<td colspan="2">
												 			<form:radiobutton id="typeOperationBien1" path="typeOperationBien" value="1" ></form:radiobutton><label for="typeOperationBien1">    <spring:message code="bien.action.recherche.vente" /> </label>
												    	 </td>
												    	 <td colspan="2">
															<form:radiobutton id="typeOperationBien2" path="typeOperationBien"  value="2"></form:radiobutton><label for="typeOperationBien2">    <spring:message code="bien.action.recherche.location" /> </label> 
												    	 </td>
												    </tr>
												    <tr>
												 	   <td  colspan="2">
												 	   	<label> 
															<form:select id="states" class="select_field" path="departementBien">
															</form:select>
														</label>
													    </td>
													    <td  colspan="2"><label>		
															<form:select id="commune" class="select_field" path="communeBien">
																<form:option value=""><spring:message code="biens.commune" /></form:option>
															</form:select>
														</label>
														</td>
												 	</tr>
													<tr>
														<td><label> <form:checkbox
																	path="appartement" /> <spring:message
																	code="bien.type.recherche.appartement" /></label></td>
														<td><label> <form:checkbox path="maison" />
																<spring:message code="bien.type.recherche.maison" /></label></td>
														<td><label> <form:checkbox path="terrain" />
																<spring:message code="bien.type.recherche.terrain" /></label></td>
														<td><label> <form:checkbox path="agricole" />
																<spring:message code="bien.type.recherche.agricole" /></label></td>
													</tr>
													<tr>
														<td><label> <form:checkbox path="carcasse" />
																<spring:message code="bien.type.recherche.carcasse" /></label></td>
														<td><label> <form:checkbox
																	path="commercial" /> <spring:message
																	code="bien.type.recherche.commercial" /></label></td>
														<td><label> <form:checkbox path="vacances" />
																<spring:message code="bien.type.recherche.vacances" /></label></td>
													</tr>
											 			</table>
										<!--	</fieldset>
											</div> -->
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
											<%--  <tr>
												<td class="label"><spring:message code="biens.reference" /></td>
												<td><label> <form:input label="refBien"
															path="refBien" class="text mediumtext" />
												</label></td>
											 </tr>  --%>
											<tr>
												<td colspan="3" class="label">
													<fieldset>
														<legend>Reference</legend>
														<table>
															<tr>
																<td>
																<label> <form:input label="refBien" placeholder="${refplaceholder }"
																			path="refBien" class="text" />
																</label>
																</td>
															</tr>
														</table>
													</fieldset>
													</td>
											
												<td colspan="3" class="label">
													<fieldset>
														<legend>Superficie</legend>
														<table>
															<tr>
																<td>
																	 <form:input label="surfaceMin"
																				path="surfaceMin" placeholder="${valmin }" class="text mediumtext" />
																	</td>
																	<td><label> <form:input label="surfaceMax"
																				path="surfaceMax" placeholder="${valmax }" class="text mediumtext" />
																	</label>
																	
																	</td>
																	<td><form:select style="width: 60px;" path="uniteSuperficie"  class="select_field">
																		<c:forEach var="item" items="${uniteMesureSuperficie}">
																					<form:option  value="${item.id}">
															               				 ${item.abreviation} 
															            			</form:option>
																		</c:forEach>
																	</form:select>
																	</td>
															</tr>
														</table>
													</fieldset>
												</td>
											</tr>
											<tr>
												<td colspan="3" class="label">
													<fieldset >
														<legend>Budget</legend>
														<table>
															<tr>
																<td>
																	 <form:input label="loyerMin"
																			path="loyerMin"  placeholder="${valmin }" class="text mediumtext" />
																</td>
																<td><label> <form:input label="loyerMax"
																				path="loyerMax" class="text mediumtext"  placeholder="${valmax }"/>
																	</label>
																</td>
																<td><form:select style="width: 60px;" path="unitePrix"  class="select_field">
																		<c:forEach var="item" items="${uniteMesurePrix}">
																				<form:option  value="${item.id}">
														               				 ${item.abreviation} 
														            			</form:option>
																	</c:forEach>
																	</form:select>
																</td>
															</tr>
														</table>
													</fieldset>
												</td>
												<td colspan="3" class="label">
													<fieldset>
														<legend>Nombre de pieces</legend>
														<table>
															<tr>
																<td>
																	 <label> 
																	 	<form:input label="nbPiecesMin"
																				path="nbPiecesMin" class="text mediumtext" placeholder="${valmin }"/>
																	</label>
																</td>
																<td>
																	<label> <form:input label="nbPiecesMax"
																				path="nbPiecesMax" class="text mediumtext" placeholder="${valmax }" />
																	</label>
																</td>
															</tr>
														</table>
													</fieldset>
												</td>
											</tr>
											
											<tr>
											<td colspan="4">
													
									<!-- <div class="slide-wrapper slidingDiv" >
									<div id="searchoptions" class="pma_auto_slider slider_init_done" title="Options" style="overflow: auto;"> -->
													<fieldset>
														<legend>Plus d'options</legend>
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
										</fieldset>
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
									<input class="buttonGo" type="submit" value="Chercher" name="submit">
									</label></td>
								</tr>
							</table>
						</form:form>
					</li>
					</ul>					
					</div>
					<div class="bottom"></div>
				</div>
				
				<div id="search_bien">
					<div class="container">
						<p>Bienvenue sur le site Tassyir, votre portail Web sur
							l'immobilier</p>
						<jsp:include page="./common/carroussel.jsp" />
					</div>
				</div>
			</div>
			<div id="home_sidebar">
				
				<div class="block advert">
					 <img src='<c:url value="/resources/graphics/advertisehere.jpg"/>'
						alt="Advertise Here" style="width: 200px;" /> 
					<%-- <jsp:include page="./../immobilier/right-side-recherche.jsp" /> --%>
				</div>
				<jsp:include page="./common/slide-right.jsp" />
			</div>
			<div class="clear">&nbsp;</div>
			<div class="clear">&nbsp;</div>
		</div>

		<div class="clear">&nbsp;</div>
		<div class="clear">&nbsp;</div>
		<jsp:include page="./common/footer.jsp" />
	</div>

</body>
</html>