<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<jsp:include page="./../../../common/head.jsp"/>
</head>
<body>
	<spring:url value="/biens/find-biens.htm" var="bienListUrl"/>
	<spring:url value="/biens/new.htm" var="bienUrl" />	 
	<spring:url value="/biens/{BienId}.htm" var="detailBienUrl">
				<spring:param name="BienId" value="${bien.id}" />
	</spring:url> 
	
	<div id="wrap">
		<jsp:include page="../../../common/menu.jsp" />
		<div id="content">
			<jsp:include page="../../../common/sub-menu.jsp" />
		<div id="main_bien">
		   <jsp:include page="../../../common/navigator.jsp" />
				<div id="search_bien">
				 <div class="group">
					<h2><spring:message code="biens.appartement.action.new" /></h2>
					<ul>
						<li id="li_select_lang">
						<!-- <div style="margin: 10px; background: none repeat scroll 0px 0px rgb(248, 248, 248); padding: 14px;"> -->
						<form:form modelAttribute="bien" method="post" id="form1" enctype="multipart/form-data">
						<fieldset>
    						<legend>${bien.typeOperation} ${bien.typeBien} ${bien.ville} (${bien.codePostal})</legend>
    							<dl>
        							<dt><form:label path="name"><spring:message code="biens.name" /></form:label></dt>
					            	<dd>
					            		<form:input label="name" path="name"	class="text" />
									</dd>
						        </dl>
						        <dl>
									<dt><form:label path="description"><spring:message code="biens.description" /></form:label></dt>
									<dd><form:textarea cols="57" rows="6"	label="description" path="description" class="text textBoxfieldlong" />
									</dd>
								</dl>
								
						        <dl>
									<dt><form:label path="adresse"><spring:message code="biens.adresse" /></form:label></dt>
									<dd> <form:textarea cols="16" rows="6" label="adresse" path="adresse" class="text textBoxfieldlong" />
									</dd>
									<dt><form:label path="proximite"><spring:message code="biens.proximite" /></form:label></dt>
									<dd> 
										<form:textarea cols="16" rows="6" label="name" path="proximite" class="text textBoxfieldlong" />
									</dd>
									
								</dl>
        						<dl>
        							<dt><form:label path="superficie"><spring:message code="biens.superficie" /></form:label></dt>
					            	<dd>
					            		<form:input label="superficie" path="superficie" class="text smalltext" />m2
									</dd>
									<dt><form:label path="etage"><spring:message code="biens.etage" /></form:label></dt>
										<dd> 
											<form:input label="etage" path="etage" class="text smalltext" />										
									</dd>
						        </dl>
						         <dl>
								
									<dt><form:label path="age"><spring:message code="biens.age" /></form:label></dt>
									<dd> 
										<form:input label="age" path="age" class="text smalltext" />
									</dd>
									<dt><form:label path="etatBien"><spring:message code="biens.etatBien" /></form:label></dt>
										<dd>
													<form:select path="etatBien"  class="select_field">
														<c:forEach var="item" items="${etatBienList}">
																	<form:option  value="${item}"> ${item} </form:option>
														</c:forEach>
													</form:select>
									</dd>
								</dl>
							</fieldset>	
							<fieldset>
								<legend>Prix</legend>
								<dl>  
						        <c:if test="${bien.typeOperation =='OFFRE_LOCATION' || bien.typeOperation =='DEMANDE_LOCATION'}">
	        							<dt><form:label path="loyerMensuel"><spring:message code="biens.loyerMensuel" /></form:label></dt>
						            	<dd>	
						            		<form:input label="loyerMensuel"  path="loyerMensuel" class="text smalltext" />
										</dd>
								 </c:if>
								 <c:if test="${bien.typeOperation =='OFFRE_VENDRE' || bien.typeOperation =='DEMANDE_ACHAT'}">
										<dt><form:label path="prixVente"><spring:message code="biens.prixVente" /></form:label></dt>
										<dd> <form:input label="prixVente"
													path="prixVente" class="text smalltext" />
								 </c:if>
							 
        							<dt><form:label path="honoraires"><spring:message code="biens.honoraires" /></form:label></dt>
					            	<dd>
					            		<form:input label="honoraires" path="honoraires" class="text smalltext" />
									</dd>
						       </dl>
							</fieldset>
							<fieldset>		
								<legend>Options</legend>
								<table class="search_form">
									<tr>
										<td><label> <form:checkbox id="eauPotable" path="eauPotable" />  <form:label path="eauPotable"><spring:message code="biens.eauPotable" /></form:label></label></td>
										<td><label> <form:checkbox id="gaz" path="gaz" />  <form:label path="gaz"><spring:message code="biens.gaz" /></form:label></label></td>
									</tr>
								</table>			
        					</fieldset>	
        				
        					<fieldset>
        							<legend> Photos </legend>
        							<c:forEach varStatus="status" begin="1" end="${5}">
											<dl>
												<dt> Photo: ${status.count}</dt>
												<dd><input
														name="files[${status.count-1}]" type="file" accept="image/*" />
												</dd>
											</dl>
									</c:forEach>
									<dl hidden="hidden">
										<form:input  path="ville" />
										<form:input  path="codePostal" />
										<form:input  path="departement"  />	
										
									</dl>
        					</fieldset>	
							<fieldset class="action">
								<dl>
									<dd>
										<input type="submit" value="Create" name="submit">
									</dd>
									</dl>
							</fieldset>
							</form:form>
							</li>	
					</ul>
					
					</div>
					
				</div>
			</div>
			<div id="home_sidebar">
				<div class="block advert">
					 <img src='<c:url value="/resources/graphics/advertisehere.jpg"/>'
						alt="Advertise Here" style="width: 315px;" /> 
				</div>
				<div class="block advert">
					 <img src='<c:url value="/resources/graphics/advertisehere.jpg"/>'
						alt="Advertise Here" style="width: 315px;" /> 
				</div>
				
				<%-- <jsp:include page="./../immobilier/right-side-recherche.jsp" /> --%>
				<jsp:include page="./../../../common/slide-right.jsp" />

			</div>
			<div class="clear">&nbsp;</div>
			<div class="clear">&nbsp;</div>
			<jsp:include page="../../../common/footer.jsp" />
		</div>
	</div>
</body>
</html>
	
