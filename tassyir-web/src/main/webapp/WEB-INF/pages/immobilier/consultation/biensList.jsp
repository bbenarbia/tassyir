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
				<div id="main">
					<jsp:include page="../../common/navigator.jsp" />					
					 <div class="group" style="width: 698px;">
					 <h2><spring:message code="biens.list" /></h2>
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
									<h3>${bien.typeOperation} ${bien.departement}(${bien.codePostal}) ${bien.superficie} m2</h3>
									<p>${bien.shortDescription} ... <a href="${DetailbienUrl}"> Details </a></p>
									
								</div>
								 <div class="listingbtns">
								 	<span class="price">${bien.prixVente} M.DA</span> 
									<span class="pricesmall">loyer:${bien.loyerMensuel} DA</span>
									<span class="pricesmall">charges:${bien.chargesMensuel} DA</span>
								 </div>
								<div class="clear">&nbsp;</div>
							</li>
						</c:forEach>
					</ul>
					</div>
					<div id="paginations">
						<ul>
							<!-- <li><a href="#">&laquo;</a></li> -->
							<li class="current"><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<!-- <li><a href="#">&raquo;</a></li> -->
						</ul>
						<div class="clear">&nbsp;</div>
					</div>

				</div>
			<div id="home_sidebar">
				<div class="block advert">
					<jsp:include page="./../right-side-recherche.jsp" /> 
				</div>
				<jsp:include page="./../../common/slide-right.jsp" />
			</div>
			<div class="clear">&nbsp;</div>
			<div class="clear">&nbsp;</div>
			<jsp:include page="../../common/footer.jsp" />
		</div>
		</div>
</body>
</html>