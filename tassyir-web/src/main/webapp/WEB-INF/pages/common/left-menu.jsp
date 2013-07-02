<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ include file="/WEB-INF/pages/common/header.jsp" %>

<div class="menulist block">
				<h2 class="sidebar_head">Offres</h2>
				<ul class="normalmenu">
					<li><a href="${contextPath}/biens/recherche-logement/2.htm">Location</a></li>
					<li><a href="${contextPath}/biens/recherche-logement/1.htm">Vente</a></li>
					<li><a href="${contextPath}/biens/recherche-logement/5.htm">Echange</a></li>
					<li><a href="${contextPath}/biens/recherche-logement/3.htm">Vacances</a></li>
					<li><a href="${contextPath}/biens/recherche-logement/6.htm">Commerces</a></li>
					<li><a href="${contextPath}/biens/recherche-logement/7.htm">Autres</a></li>	
					<li ><a href="${contextPath}/biens/new.htm" style="color : #DF0D3D"> &#62;&#62; Passer une annonce</a></li>
				</ul>
				<div class="clear">&nbsp;</div>
</div>
<div class="menulist block" >
				<h2 class="sidebar_head">Demandes</h2>
				<ul class="normalmenu" >
					<li><a href="${contextPath}/biens/recherche-logement/9.htm">Location</a></li>
					<li><a href="${contextPath}/biens/recherche-logement/8.htm">Vente</a></li>
					<li><a href="${contextPath}/biens/recherche-logement/5.htm">Echange</a></li>
					<li><a href="${contextPath}/biens/recherche-logement/10.htm">Vacances</a></li>
					<li><a href="${contextPath}/biens/recherche-logement/12.htm">Commerces</a></li>	
				</ul>
				<div class="clear">&nbsp;</div>
</div>
<div class="menulist block" >
 <img src='<c:url value="/resources/graphics/advertisehere.jpg"/>'
						alt="Advertise Here" style="width: 195px;" />
</div> 
<div class="menulist block">
				<spring:url value="/biens/recherche-logement-by-dep" var="searchByTownUrl"/>
				<h2 class="sidebar_head">Annonces par Wilaya </h2>
				<ul class="normalmenu">
				  <li><a href="${searchByTownUrl}/16.htm">Annonces d'Alger(16)</a></li>
				  <li><a href="${searchByTownUrl}/31.htm">Annonces d'Oran(31)</a></li>
				  <li><a href="${searchByTownUrl}/25.htm">Annonces de Constantine(25)</a></li>
				  <li><a href="${searchByTownUrl}/17.htm">Annonces de Djelfa(17)</a></li>
				  <li><a href="${searchByTownUrl}/19.htm">Annonces de Setif(19)</a></li>
				  <li><a href="${searchByTownUrl}/35.htm">Annonces de Boumerdes(35)</a></li>
				  <li><a href="${searchByTownUrl}/10.htm">Annonces de Blida(10)</a></li>
				</ul>
				<div class="clear">&nbsp;</div>
</div>