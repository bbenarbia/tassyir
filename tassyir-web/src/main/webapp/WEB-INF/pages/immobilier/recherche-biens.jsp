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
			        $(".show_hide").show();
			 
			    $('.show_hide').click(function(){
			    $(".slidingDiv").slideToggle();
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
					var html = '<option value="">All</option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i] + '">'
								+ data[i] + '</option>';
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
					var html = '<option value="">Departement</option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i].name + '">'
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
				<div class="navig">
					<c:forEach var="navig" items="${navigations}" varStatus="status">
							&laquo;
							<spring:url value="${navig.url}" var="navigs" />
						<a href="${navigs}"><spring:message code="${navig.name}" /></a>
					</c:forEach>
				</div>
				<div id="search_bien">
					<div class="tab">
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
					</div>
					<div class="container">
						<form:form modelAttribute="findBiens" method="post" id="form1">
							<table class="search_form" style="width: 100%; border: none;">
								<tr>
									<td class="label"><spring:message code="biens.recherche" /></td>
									<td><label>
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
								      
									<td class="label"><spring:message code="biens.reference" /></td>
									<td><label> <form:input label="refBien"
												path="refBien" class="text mediumtext" />
									</label></td>
								    </tr>
									<tr>
									<td class="label"><spring:message code="biens.typebien" /></td>
									<td><label> <form:select path="typeBien" class="select_field">
													<option>
														<spring:message code="bien.type.recherche.divers" />
													</option>
													<form:option  value="2"><spring:message code="bien.type.recherche.maison" /></form:option>
													<form:option  value="1"><spring:message code="bien.type.recherche.appartement" /></form:option>
													<form:option  value="3"><spring:message code="bien.type.recherche.immeuble" /></form:option>
													<form:option  value="4"><spring:message code="bien.type.recherche.terrain" /></form:option>
													<form:option  value="5"><spring:message code="bien.type.recherche.agricole" /></form:option>
													<form:option  value="6"><spring:message code="bien.type.recherche.carcasse" /></form:option>
													<form:option  value="7"><spring:message code="bien.type.recherche.commercial" /></form:option>
													<form:option  value="8"><spring:message code="bien.type.recherche.bungalow" /></form:option>
													<form:option  value="9"><spring:message code="bien.type.recherche.ferme" /></form:option>
											</form:select>
									</label></td>
									<td class="label"><spring:message code="biens.departement" /></td>
									<td colspan="3"><label> 
														<form:select id="states" path="departementBien">
														</form:select> 
														
														<form:select id="commune" path="communeBien">
															<form:option value="">commune</form:option>
														</form:select>
									
									<%-- <form:select
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
											</form:select> --%>
									</label>
									</td>
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
										
									<a href="#" class="show_hide">Afficher/Masquer les options</a>
									<div class="slidingDiv">
									<table class="search_form">
									<tr>
									
									<td class="label"><spring:message code="biens.pieces.min" /></td>
									<td><label> <form:input label="nbPiecesMin"
												path="nbPiecesMin" class="text mediumtext" />
									</label></td>
									<td class="label"><spring:message code="biens.pieces.max" /></td>
									<td><label> <form:input label="nbPiecesMax"
												path="nbPiecesMax" class="text mediumtext" />
									</label></td>
								</tr>	
								</table>
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
										</div>
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