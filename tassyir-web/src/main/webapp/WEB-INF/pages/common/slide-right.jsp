<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<%-- <div class="menulist block">
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
</div> --%>

<spring:url value="/users/subscribe.htm" var="subsriningUrl"/>
<spring:url value="/users/login.htm" var="loginUrl"/>

<spring:url value="/users/reset-password.htm" var="initPasswordUrl"/>

<spring:url value="/users/my-profile.htm" var="myProfileUrl" />
<spring:url value="/users/my-messages.htm" var="messageUrl" />
<spring:url value="/biens/new.htm" var="newBienUrl" />
<spring:url value="/logout" var="logoutUrl" />



<div class="hot">
	<h2 class="sidebar_head">Mon espace utilisateur</h2>
	<div id="useractions" style="width: 197px;">
		<sec:authorize access="isAuthenticated()">
			<div id="headings">
				<p>
					<img src='<c:url value="/resources/graphics/user-icone.png"/>'
						alt="My profile" width="27" height="22" /> <a
						href="${myProfileUrl}">My profile</a>
				</p>
				<p>
					<img src='<c:url value="/resources/graphics/mail.png"/>'
						alt="Messages" width="27" height="22" /> <a
						href="${messageUrl}">Messages(0)</a>
				</p>
				</div>
				
				
				<div id="headings">
				<p>
					<img src='<c:url value="/resources/graphics/Home.png"/>'
						alt="Mes annonces" width="27" height="22" /> <a
						href="${contextPath}/biens/my-biens.htm">Mes annonces</a>
				</p>
				<p>
					<img src='<c:url value="/resources/graphics/Home-plus.png"/>'
						alt="New annonce" width="25" height="22" /> <a
						href="${newBienUrl}">Add new annonce</a>
				</p>
				</div>
				<div id="headings">
				<p>
					<img src='<c:url value="/resources/graphics/logout.png"/>'
						alt="Logout" width="27" height="22" /> <a
						href="${logoutUrl}">Logout</a>
				</p>
				
			</div>
		</sec:authorize>
		<sec:authorize access="isAnonymous()">
			<div id="headings">
				<h2>
					Inscription
				</h2>
				<p>
					<img  src='<c:url value="/resources/graphics/create_indi_usr.jpg"/>' alt="Individual User"
						width="25" height="22" /> <a href="${subsriningUrl}">Creer un compte</a>
				</p>
			</div>
			
			<div id="headings">
				<h2>
					Membres
				</h2>
				<p>
					<img  src='<c:url value="/resources/graphics/create_indi_usr.jpg"/>' alt="Individual User"
						width="25" height="22" /> <a href="${loginUrl}">Connexion</a>
				</p>
				<p>
					<img  src='<c:url value="/resources/graphics/create_indi_usr.jpg"/>' alt="Individual User"
						width="25" height="22" /> <a href="${initPasswordUrl}">Mot de passe perdu</a>
				</p>
			</div>
		</sec:authorize>	
	</div>
</div>
	<%-- 		
<c:if test="${fn:length(lastBiensAdded) > 0 }">		
<div class="hot">
	<h2 class="sidebar_head">
		 Les derniers annonces
	</h2>
	<ul>
		<c:forEach var="bien" items="${lastBiensAdded}">
				<spring:url value="/biens/{bienId}.htm" var="DetailbienUrl">
									<spring:param name="bienId" value="${bien.id}" />
				</spring:url>
		
			<li><span class="imageholder"> <img
				src='<c:url value="/resources/graphics/new.gif"/>' alt="new"
				width="50" height="50" />
			</span>
				<h5>
					<a href="${DetailbienUrl}">${bien.typeOperation} ${bien.typeBien} ${bien.ville} ${bien.superficie} m2</a>
				</h5>
				
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
</c:if> --%>


