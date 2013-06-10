<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

			
<div class="hot">
	<h2 class="sidebar_head">
		 Les derniers
		annonces
	</h2>
	<ul>
		
		<c:forEach var="bien" items="${lastBiensAdded}">
			<li><span class="imageholder"> <img
				src='<c:url value="/resources/graphics/new.gif"/>' alt="new"
				width="66" height="66" />
			</span>
				<h3>
					<a href="DetailbienUrl">${bien.typeOperation} ${bien.typeBien} ${bien.ville} ${bien.superficie} m2</a>
				</h3>
				<%-- <p class="description">
						${bien.shortDescription} 
				</p> --%>
				<c:if test="${bien.typeOperation =='OFFRE_VENDRE' || bien.typeOperation =='DEMANDE_ACHAT'}">
					<p class="description">
						${bien.adresse} <span class="price">${bien.prixVente}</span>
					</p>
				</c:if> 
				<c:if test="${bien.typeOperation =='OFFRE_LOCATION' || bien.typeOperation =='DEMANDE_LOCATION' }">
					<p class="description">
						${bien.adresse} <span class="price">${bien.loyerMensuel} ${currency}</span>
					</p>
				</c:if>
							
				
				<div class="clear">&nbsp;</div></li>
			
		</c:forEach>
	</ul>
</div>
<div class="menulist block">
				<spring:url value="/biens/recherche-logement-by-dep" var="searchByTownUrl"/>
				<h2 class="sidebar_head">Annonces par Wilaya </h2>
				<ul class="normalmenu">
				  <li><a href="${searchByTownUrl}/16.htm">Annonces Wilaya d'Alger(16)</a></li>
				  <li><a href="${searchByTownUrl}/31.htm">Annonces Wilaya d'Oran(31)</a></li>
				  <li><a href="${searchByTownUrl}/25.htm">Annonces Wilaya de Constantine(25)</a></li>
				  <li><a href="${searchByTownUrl}/17.htm">Annonces Wilaya de Djelfa(17)</a></li>
				  <li><a href="${searchByTownUrl}/19.htm">Annonces Wilaya de Setif(19)</a></li>
				  <li><a href="${searchByTownUrl}/35.htm">Annonces Wilaya de Boumerdes(35)</a></li>
				  <li><a href="${searchByTownUrl}/10.htm">Annonces Wilaya de Blida(10)</a></li>
				</ul>
				<div class="clear">&nbsp;</div>
</div>
