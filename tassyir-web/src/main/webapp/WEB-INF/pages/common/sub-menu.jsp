<%@ include file="/WEB-INF/pages/common/header.jsp" %>

<div id="header-menu">
	<a href="/?lang=en"><img src="/images/lang/en.png" alt="English version" style="float : right ; margin : 4px 6px" /></a>
	<ul class="current" id="origine-menu">
		<li><a href="http://www.pap.fr">Offres</a></li>
	</ul>
	
	<ul class="sub_active" id="origine-sous-menu">
					<li><a href="${contextPath}/biens/recherche-logement/2.htm">Location</a></li>
					<li><a href="${contextPath}/biens/recherche-logement/1.htm">Vente</a></li>
					<li><a href="${contextPath}/biens/recherche-logement/5.htm">Echange</a></li>
					<li><a href="${contextPath}/biens/recherche-logement/3.htm">Vacances</a></li>
					<li><a href="${contextPath}/biens/recherche-logement/6.htm">Commerces</a></li>
					<li><a href="${contextPath}/biens/recherche-logement/7.htm">Autres</a></li>	
					<li ><a href="http://www.pap.fr/annonceur/passer" style="color : #DF0D3D">>> Passer une annonce</a></li>
	</ul>
	<ul class="select">
		<li><a href="http://www.pap.fr/evaluation">Demande		<!--[if gte IE 7]><!--></a><!--<![endif]--><!--[if lte IE 6]><table><tr><td><![endif]-->
		<ul class="sub">
					<li><a href="${contextPath}/biens/recherche-logement/9.htm">Location</a></li>
					<li><a href="${contextPath}/biens/recherche-logement/8.htm">Vente</a></li>
					<li><a href="${contextPath}/biens/recherche-logement/5.htm">Echange</a></li>
					<li><a href="${contextPath}/biens/recherche-logement/10.htm">Vacances</a></li>
					<li><a href="${contextPath}/biens/recherche-logement/12.htm">Commerces</a></li>		
		</ul>
		<!--[if lte IE 6]></td></tr></table></a><![endif]-->
		</li>
	</ul>
	<ul class="select">
		<li><a href="http://www.pap.fr/diagnostic">Services		<!--[if gte IE 7]><!--></a><!--<![endif]--><!--[if lte IE 6]><table><tr><td><![endif]-->
		<ul class="sub">
					<li><a href="${contextPath}/biens/find-biens.htm">Plans</a></li>
					<li><a href="${contextPath}/biens/find-biens.htm">Annuaire</a></li>
					<li><a href="${contextPath}/biens/find-biens.htm">Professionnels</a></li>
					<li><a href="${contextPath}/biens/find-biens.htm">Télechargements</a></li>		
		</ul>
		<!--[if lte IE 6]></td></tr></table></a><![endif]-->
		</li>
	</ul>
	<ul class="select">
		<li><a href="http://www.pap.fr/argent">Profesionnels		<!--[if gte IE 7]><!--></a><!--<![endif]--><!--[if lte IE 6]><table><tr><td><![endif]-->
		<ul class="sub">
			<li><a href="${contextPath}/biens/find-biens.htm">Agences</a></li>
					<li><a href="${contextPath}/biens/find-biens.htm">Promoteurs</a></li>
					<li><a href="${contextPath}/biens/find-biens.htm">publicité</a></li>
					<li><a href="${contextPath}/biens/find-biens.htm">Evenements</a></li>
			</ul>
		<!--[if lte IE 6]></td></tr></table></a><![endif]-->
		</li>
	</ul>
	<ul class="select">
		<li><a href="http://www.pap.fr/conseils">Offres		<!--[if gte IE 7]><!--></a><!--<![endif]--><!--[if lte IE 6]><table><tr><td><![endif]-->
		<ul class="sub">
					<li><a href="${contextPath}/biens/recherche-logement/2.htm">Location</a></li>
					<li><a href="${contextPath}/biens/recherche-logement/1.htm">Vente</a></li>
					<li><a href="${contextPath}/biens/recherche-logement/5.htm">Echange</a></li>
					<li><a href="${contextPath}/biens/recherche-logement/3.htm">Vacances</a></li>
					<li><a href="${contextPath}/biens/recherche-logement/6.htm">Commerces</a></li>
					<li><a href="${contextPath}/biens/recherche-logement/7.htm">Autres</a></li>					
			</ul>
		<!--[if lte IE 6]></td></tr></table></a><![endif]-->
		</li>
	</ul>
	<ul class="select">
		<li><a href="http://www.pap.fr/travaux-deco">Conseils		<!--[if gte IE 7]><!--></a><!--<![endif]--><!--[if lte IE 6]><table><tr><td><![endif]-->
		<ul class="sub">
					<li><a href="${contextPath}/biens/find-biens.htm">Agences</a></li>
					<li><a href="${contextPath}/biens/find-biens.htm">Promoteurs</a></li>
			</ul>
		<!--[if lte IE 6]></td></tr></table></a><![endif]-->
		</li>
	</ul>
	<ul class="select">
		<li><a href="http://www.pap.fr/services">Services		<!--[if gte IE 7]><!--></a><!--<![endif]--><!--[if lte IE 6]><table><tr><td><![endif]-->
		<ul class="sub">
				<li><a href="http://www.pap.fr/argent/calculettes">Calculettes</a></li>
				<li><a href="http://www.pap.fr/argent/indices">Indices &amp; chiffres</a></li>
				<li><a href="http://www.pap.fr/contrats-et-guides">Contrats &amp; guides</a></li>
				<li><a href="http://www.pap.fr/conseils/modeles-de-lettres">Modèles de lettres</a></li>
				<li><a href="http://www.pap.fr/evaluation">Evaluation</a></li>
				<li><a href="http://www.pap.fr/diagnostic">Diagnostic</a></li>
				<li><a href="http://www.pap.fr/services/copropriete">Copropriété</a></li>
		</ul>
		<!--[if lte IE 6]></td></tr></table></a><![endif]-->
		</li>
	</ul>
</div>


<%-- <div id="topcategorieslink" class="clear">
				<h2>Annonces</h2>
				<ul>
					<li><a href="${contextPath}/biens/location-biens.htm">Location</a></li>
					<li><a href="${contextPath}/biens/vente-biens.htm">Vente</a></li>
					<li><a href="${contextPath}/biens/colocation-biens.htm">Colocation</a></li>
					<li><a href="${contextPath}/biens/echange-biens.htm">Echange</a></li>
					<li><a href="${contextPath}/biens/vacances-biens.htm">Vacances</a></li>
					<li><a href="${contextPath}/biens/commerce-biens.htm">Commerces</a></li>					
					<li><a href="${contextPath}/biens/find-biens.htm">Autres</a></li>					
					<li><a href="${contextPath}/biens/new.htm">Add annonce</a></li>
				</ul>
</div> --%>

<%-- <div id="topcategorieslink" class="clear">
				<h2>Pour les pros</h2>
				<ul>
					<li><a href="${contextPath}/biens/find-biens.htm">Agences</a></li>
					<li><a href="${contextPath}/biens/find-biens.htm">Promoteurs</a></li>
					<li><a href="${contextPath}/biens/find-biens.htm">publicité</a></li>
					<li><a href="${contextPath}/biens/find-biens.htm">Evenements</a></li>
				</ul>
</div>
 --%>


