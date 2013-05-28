<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<jsp:include page="./../../common/head.jsp"/>
</head>
<body>
	<spring:url value="/users/photo" var="photoUrl" />
		<spring:url value="/users/upload/{userId}/show" var="addPhotoUrl">
		<spring:param name="userId" value="${user.id}" />
	</spring:url>
	<spring:url value="/users/new.htm"  var="addUserUrl" />
	<spring:url value="/users.htm" var="userListUrl"> </spring:url>
	<spring:url value="/" var="homeUrl"> </spring:url>
	<div id="wrap">
		<jsp:include page="../../common/menu.jsp" />
			<div id="content">
				<jsp:include page="../../common/sub-menu.jsp" />
				<div id="main">
					<div class="navig">
						<c:forEach var="navig" items="${navigations}" varStatus="status">
							&laquo;
							<spring:url value="${navig.url}" var="navigs" />
							<a href="${navigs}"><spring:message code="${navig.name}" /></a>
						</c:forEach>
					</div>
					<h1><spring:message code="biens.list" /></h1>
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
				
						 <li>
							<span class="listbuttons">
										<a class="buttonmenu" href="${fn:escapeXml(addBienUrl)}"><spring:message code="biens.action.add" /></a>
								</span> 
							<div class="clear">&nbsp;</div>
						</li>	 
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
			<jsp:include page="../../common/footer.jsp" />
		</div>
		</div>
</body>
</html>