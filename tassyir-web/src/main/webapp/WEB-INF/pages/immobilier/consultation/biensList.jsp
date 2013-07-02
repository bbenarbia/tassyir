<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<jsp:include page="./../../common/head.jsp"/>
</head>
<body>
	<spring:url value="/users/photo" var="userPhotoUrl" />
	<spring:url value="/users/upload/{userId}/show" var="addPhotoUrl">
		<spring:param name="userId" value="${user.id}" />
	</spring:url>
	<spring:url value="/users/new.htm"  var="addUserUrl" />
	<spring:url value="/users.htm" var="userListUrl"> </spring:url>
	<spring:url value="/" var="homeUrl"> </spring:url>
	
	<spring:url value="/users/photo" var="photoUrl" />
	<div id="wrap">
		<jsp:include page="../../common/menu.jsp" />
			<div id="content">
				<jsp:include page="../../common/sub-menu.jsp" />
				<div id="home_sidebar_left">
					<jsp:include page="./../../common/left-menu.jsp" />
					<%-- <jsp:include page="./../../common/slide-right.jsp" /> --%>
				</div>
				<div id="main">
					<jsp:include page="../../common/navigator.jsp" />					
					 <div class="group" >
					 <h2><spring:message code="biens.list" /> : ${fn:length(findBiens.listBiens)} <spring:message code="biens.nbresult" />  </h2>
					 <ul class="listing">
    					<c:forEach var="bien" items="${findBiens.listBiens}" varStatus="status" begin="${(page-1)*5 }" end="${(page)*5 }">
    						<c:if test="${status.count % 4 == 0 }">
	    						<li>
	    							<div class="listinfo">
	    								Publicité
	    							</div>
	    						</li>
    						</c:if>
							<li>
								<spring:url value="/biens/{bienId}.htm" var="DetailbienUrl">
									<spring:param name="bienId" value="${bien.id}" />
								</spring:url>
	
								<div class="listinfo">									
									<c:if test="${fn:length(bien.photos) == 0 }">
										<img  width="120" height="120" src='<c:url value="/resources/graphics/imageholder.jpg"/>'  alt="Listing Image"
										class="listingimage" />
									</c:if>
									<c:if test="${fn:length(bien.photos) > 0 }">
										<spring:url value="/biens/photo" var="photoUrl" />
										<img width="120" height="120"
												src="${photoUrl}/${bien.id}/${1}" class="listingimage">
									</c:if>
									<h3>${bien.typeOperation} ${bien.departement}(${bien.codePostal}) ${bien.superficie} ${bien.uniteSuperficie}</h3>
									<p>${bien.shortDescription} ... <a href="${DetailbienUrl}"> Details </a></p>
									
								</div>
								 <div class="listingbtns">
								 	<span class="price">${bien.prixVente} ${bien.unitePrix}</span> 
									<span class="pricesmall">loyer:${bien.loyerMensuel} ${bien.unitePrix}</span>
									<span class="pricesmall">charges:${bien.chargesMensuel} ${bien.unitePrix}</span>
								 </div>
								<div class="clear">&nbsp;</div>
							</li>
						</c:forEach>
					</ul>
					</div>
					<c:if test="${fn:length(findBiens.listBiens) > 0 }">
					<div id="paginations">
						<ul>
							<spring:url value="/biens/search-result" var="biensListUrl" />
							<c:if test="${page > 1 }">
								<li><a href="${biensListUrl}/${page-1}.htm">&laquo;</a></li>
							</c:if> 
							<c:forEach varStatus="status" begin="1" end="${nbpages}" step="1">								
								<c:choose>
									<c:when test="${status.count == page}">
										<li class="current"><a href="${biensListUrl}/${status.count}.htm">${status.count}</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="${biensListUrl}/${status.count}.htm">${status.count}</a></li>
									</c:otherwise>								
								</c:choose>
							</c:forEach>
							<c:if test="${page < nbpages}">
								<li><a href="${biensListUrl}/${page+1}.htm">&raquo;</a></li>
							</c:if> 
						</ul>
						<div class="clear">&nbsp;</div>
					</div>
					</c:if>
				</div>
			<div id="home_sidebar">
				<c:if test="${not showCustomSearch}">
					<div class="block advert">
						 <img src='<c:url value="/resources/graphics/advertisehere.jpg"/>'
							alt="Advertise Here" style="width: 290px;" /> 
					</div>
				</c:if>
				<jsp:include page="./../../common/slide-right.jsp" />
			</div>
			<div class="clear">&nbsp;</div>
			<div class="clear">&nbsp;</div>
			<jsp:include page="../../common/footer.jsp" />
		</div>
		</div>
</body>
</html>