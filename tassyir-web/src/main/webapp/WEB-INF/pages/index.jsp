<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
	<jsp:include page="./common/head.jsp"/>
	<script type="text/javascript">
			$(document).ready(function(){
			        $(".slidingDiv").hide();
			        $(".show_hide").show();
			 
			    $('.show_hide').click(function(){
			    $(".slidingDiv").slideToggle();
			    });
			 
			});
 
</script>
</head>
<body>

	<div id="wrap">
		<jsp:include page="./common/menu.jsp"/>
		<jsp:include page="./common/sub-menu.jsp"/>
		<div id="content">
			<div id="main_bien">
				<div id="search_bien">
					<div class="tab">
						<h2>Bienvenue</h2>
					</div>
					<div class="container">
						<p>Bienvenue sur le site Tassyir, votre portail Web sur l'immobilier </p>
						<jsp:include page="./common/carroussel.jsp"/>
					</div>
				</div>
				
				<div id="search_bien">
				
					<div class="tab">
						<h2>Recherche de biens</h2>
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
									
									<td class="label"><spring:message code="biens.pieces.min" /></td>
									<td><label> <form:input label="nbPiecesMin"
												path="nbPiecesMin" class="text mediumtext" />
									</label></td>
									<td class="label"><spring:message code="biens.pieces.max" /></td>
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
										
									<a href="#" class="show_hide">Afficher/Masquer les options</a>
									<div class="slidingDiv">
										
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
			
			<div class="clear">&nbsp;</div>

			<div class="clear">&nbsp;</div>
		</div>
		
		<div class="clear">&nbsp;</div>
		<div class="clear">&nbsp;</div>
		<jsp:include page="./common/footer.jsp"/>
	</div>
	
</body>
</html>