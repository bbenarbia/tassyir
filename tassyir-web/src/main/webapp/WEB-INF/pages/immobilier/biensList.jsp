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
														<td class="label">Département</td>
														<td colspan="3"><label> 
															<form:select path="departementBien"  class="select_field">
																		<option>indifferent</option>
																		<c:forEach var="item" items="${departementsList}">
																				<option value="${item.reference}">${item.name}</option>
																		</c:forEach>
															</form:select>
														</label></td>
												</tr>
												<tr>
														<td class="label">Type</td>
														<td colspan="3"><label> 
															<form:select path="typeBien" class="select_field">
																<option>indifferent</option>
																<c:forEach var="item" items="${typesLogementList}">
																		<option value="${item.index}">${item}</option>
																</c:forEach>
															</form:select>
														</label></td>
												</tr>	
												<tr>
														<td class="label">Pièces Min:</td>
														<td><label> 
															<form:select path="nbPiecesMin" class="select_field">
																<option>indifferent</option>
																<c:forEach varStatus="status" begin="1" end="6">
																	<option value="${status.count}">${status.count}</option>
																</c:forEach>
															</form:select>
															</label></td>
															<td class="label">Pièces Max:</td>
															<td><label>
															<form:select path="nbPiecesMax" class="select_field">
																<option>indifferent</option>
																<c:forEach varStatus="status" begin="1" end="6">
																	<option value="${status.count}">${status.count}</option>
																</c:forEach>
															</form:select>
														</label></td>
												</tr>	
												<tr>
														<td class="label">Superficie Min</td>
														<td><label> 
															<form:select path="surfaceMin"  class="select_field">
																<option>indifferent</option>
																<c:forEach varStatus="status" begin="1" end="10" >
																	<option value="${status.count*10}">${status.count*10}</option>
																</c:forEach>
															</form:select>
															</label></td>
															<td class="label">Superficie Max</td>
															<td><label>
															<form:select path="surfaceMax"  class="select_field">
																<option>indifferent</option>
																<c:forEach varStatus="status" begin="1" end="10" >
																	<option value="${status.count*10}">${status.count*10}</option>
																</c:forEach>
															</form:select>
														</label></td>
												</tr>	
												<tr>
														<td class="label">Budget Min</td>
														<td><label> 
															<form:select path="loyerMin"  class="select_field">
																<option>indifferent</option>
																<c:forEach varStatus="status" begin="1" end="15" >
																	<option value="${status.count*100}">${status.count*100}</option>
																</c:forEach>
															</form:select>
															</label></td>
															<td class="label">Budget Max:</td>
															<td><label>
															<form:select path="loyerMax"  class="select_field">
																<option>indifferent</option>
																<c:forEach varStatus="status" begin="1" end="15" >
																	<option value="${status.count*100}">${status.count*100}</option>
																</c:forEach>
															</form:select>
														</label></td>
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
					<h1>Users Listing</h1>
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