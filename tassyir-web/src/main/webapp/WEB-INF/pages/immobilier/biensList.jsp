<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<jsp:include page="./../common/head.jsp"/>
</head>
<body>
	<div id="wrap">
		<jsp:include page="../common/menu.jsp" />
			<div id="content">
				<jsp:include page="../common/sub-menu.jsp" />

				<div id="home_main">
				  <div id="search">
					<div class="tab">
						<h2>Find bien</h2>
					</div>
					<div class="container">					
					<form:form modelAttribute="findBiens" method="post" id="form1">
						
						<table class="search_form" style="width: 100%; border: none;">
												<tr>
														<td class="label">Recherche</td>
														<td ><label> 
															<form:select path="typeOperationBien"  class="select_field">
																		<c:forEach var="item" items="${typesOperationsList}">
																				<c:choose>
																					<c:when test="${typeOperationBien == item}">
																						<form:option selected="true" value="${item}">
																               				 ${item} 
																            			</form:option>
																					</c:when>
																					<c:otherwise>
																						<form:option value="${item}">
																                  			 ${item}
																            			</form:option>
																					</c:otherwise>
																				</c:choose>
																		</c:forEach>
															</form:select>
														</label></td>
														<td class="label">Type</td>
														<td ><label> 
															<form:select path="typeBien" class="select_field">
																<option>indifferent</option>
																<c:forEach var="item" items="${typesLogementList}">
																		<c:choose>
																					<c:when test="${typeBien == item}">
																						<form:option selected="true" value="${item.index}">
																               				 ${item} 
																            			</form:option>
																					</c:when>
																					<c:otherwise>
																						<form:option value="${item.index}">
																                  			 ${item}
																            			</form:option>
																					</c:otherwise>
																		</c:choose>
																</c:forEach>
															</form:select>
														</label></td>
												</tr>			
												<tr>
														<td class="label">reference</td>
														<td><label> 
															<form:input label="refBien" path="refBien"
																	class="text" />
														</label></td>
												</tr>									
												<tr>
														<td class="label">Departement ${departementBien}</td>
														<td colspan="3"><label> 
															<form:select path="departementBien"  class="select_field">
																		<option value="-1">indifferent</option>
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
														<td class="label">Pièces Min:</td>
														<td><label> 
																<form:input label="nbPiecesMin" path="nbPiecesMin"
																	class="text" />
															</label></td>
															<td class="label">Max:</td>
															<td><label>
																<form:input label="nbPiecesMax" path="nbPiecesMax"
																	class="text" />
														</label></td>
												</tr>	
												<tr>
														<td class="label">Superficie Min</td>
														<td><label> 
															<form:input label="surfaceMin" path="surfaceMin"
																	class="text" />
															</label></td>
															<td class="label">Max</td>
															<td><label>
															<form:input label="surfaceMax" path="surfaceMax"
																	class="text" />
														</label></td>
												</tr>	
												<tr>
														<td class="label">Budget Min</td>
														<td><label> 
																<form:input label="loyerMin" path="loyerMin"
																	class="text" />
															</label></td>
															<td class="label">Max:</td>
															<td><label>
																<form:input label="loyerMax" path="loyerMax"
																	class="text" />
														</label></td>
												</tr>
												
												<tr>
													<td class="label" colspan="4">
													<table class="search_form">
													<tr>
															<td><label> 
																<form:checkbox path="ascenseur" />		
															</label></td>
															<td class="label"><form:label path="ascenseur" for="ascenseur">ascenseur</form:label></td>
															
															<td><label> 
																<form:checkbox path="cuisineEquipee" />		
															</label></td>
															<td class="label"><form:label path="cuisineEquipee" for="cuisineEquipee">cuisineEquipee</form:label></td>
													
															<td><label> 
																<form:checkbox path="jardin" />		
															</label></td>
															<td class="label"><form:label path="jardin" for="jardin">jardin</form:label></td>
														
															
															<td><label> 
																<form:checkbox path="interphone" />		
															</label></td>
															<td class="label"><form:label path="interphone" for="interphone">interphone	</form:label></td>
													</tr>	
													<tr>		
															<td><label> 
																<form:checkbox path="digicode" />		
															</label></td>
															<td class="label"><form:label path="digicode" for="digicode">digicode</form:label></td>
															
															<td><label> 
																<form:checkbox path="gardien" />		
															</label></td>
															<td class="label"><form:label path="gardien" for="gardien">gardien</form:label></td>
															
															<td><label> 
																<form:checkbox path="adapteHandicape" />		
															</label></td>
															<td class="label"><form:label path="adapteHandicape" for="adapteHandicape">adapté</form:label></td>
															
															<td><label> 
																<form:checkbox path="meuble" />		
															</label></td>
															<td class="label"><form:label path="meuble" for="meuble">meublé</form:label></td>
													</tr>
													<tr>		
															<td><label> 
																<form:checkbox path="piscine" />		
															</label></td>
															<td class="label"><form:label path="piscine" for="piscine">piscine</form:label></td>
															<td><label> 
																<form:checkbox path="caves" />		
															</label></td>
															<td class="label"><form:label path="caves" for="caves">caves</form:label></td>
															
															<td><label> 
																<form:checkbox path="parking" />		
															</label></td>
															<td class="label"><form:label path="parking" for="parking">parking</form:label></td>
															<td><label> 
																<form:checkbox path="terrassesBalcons" />		
															</label></td>
															<td class="label"><form:label path="terrassesBalcons" for="terrassesBalcons">terrassesBalcons</form:label></td>
													</tr>
													</table>
													</td>
													</tr>
												<tr>
									<td class="label">&nbsp;</td>
									<td>&nbsp;</td>
									<td colspan="2" class="label"><label> <input
											type="image" src='<c:url value="/resources/graphics/searchbtn.gif"/>'  alt="search
      "
											name="button2" id="button2" value="Submit" />
									</label></td>
								</tr>
			</table>
	</form:form>
						
					
					
					</div>
					
				<div class="bottom">
				</div>
				</div>
			</div>
				<div id="main">
					<h1>Biens Listing</h1>
					<ul class="listing">
					
					<c:forEach var="bien" items="${findBiens.listBiens}">
							<li>
								<div class="listinfo">
									
									<c:if test="${fn:length(bien.photos) == 0 }">
										<img  src='<c:url value="/resources/graphics/imageholder.jpg"/>'  alt="Listing Image"
										class="listingimage" />
									</c:if>
									<c:if test="${fn:length(bien.photos) > 0 }">
										<spring:url value="/biens/photo" var="photoUrl" />
										<img width="70" height="70"
												src="${photoUrl}/${bien.id}/${1}" class="listingimage">
									</c:if>
									<h3>${bien.name}</h3>
									<p>${bien.departement.name}</p>
									<span class="price">${bien.superficie}</span> 
									<span class="price">${bien.prixVente}</span> 
									<span class="price">${bien.loyerMensuel}</span>
									<span class="price">${bien.chargesMensuel}</span>
								</div>
								<div class="listingbtns">
								<span class="listbuttons"> <spring:url value="{bienId}.htm" var="DetailbienUrl">
									<spring:param name="bienId" value="${bien.id}" />
									</spring:url> 
									<a href="${DetailbienUrl}">Details Bien</a>
									</span> 
									<span class="listbuttons"> <spring:url value="{bienId}.htm" var="EditbienUrl">
								<spring:param name="bienId" value="${bien.id}" />
							</spring:url> 
							<a href="${EditbienUrl}">Edit Bien</a>
									</span> <span class="listbuttons"> <spring:url value="{bienId}.htm" var="deleteBienUrl">
								<spring:param name="bienId" value="${bien.id}" />
							</spring:url> 
							<a href="${deleteBienUrl}">Delete</a></span> 
								</div>
								<div class="clear">&nbsp;</div>
							</li>
						</c:forEach>
				
					</ul>
					<div id="paginations">
						<ul>
							<li><a href="#">&laquo;</a></li>

							<li class="current"><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">&raquo;</a></li>

						</ul>
						<div class="clear">&nbsp;</div>
					</div>

				</div>

			<div class="clear">&nbsp;</div>
			<div class="clear">&nbsp;</div>
			<jsp:include page="../common/footer.jsp" />
		</div>
		</div>
</body>
</html>