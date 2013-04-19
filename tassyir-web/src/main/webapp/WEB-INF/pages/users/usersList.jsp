<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<jsp:include page="./../common/head.jsp"/>
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
		<jsp:include page="../common/menu.jsp" />
			<div id="content">
				<jsp:include page="../common/sub-menu.jsp" />
				<div id="main">
					<div class="navig">
						<c:forEach var="navig" items="${navigations}" varStatus="status">
							&laquo;
							<spring:url value="${navig.url}" var="navigs" />
							<a href="${navigs}"><spring:message code="${navig.name}" /></a>
						</c:forEach>
					</div>
					<h1>Users Listing</h1>
					<ul class="listing">
						<c:forEach var="user" items="${selections}">
							<li>
								<div class="listinfo">
										
									<c:if test="${empty user.photo }">
										<img  src='<c:url value="/resources/graphics/imageholder.jpg"/>' alt="Listing Image"
										class="listingimage" />
									</c:if>
									<c:if test="${not empty user.photo }">
										<img width="70" height="70" src="${photoUrl}/${user.id}" class="listingimage" />
									</c:if>
									<h3>${user.firstName} ${user.lastName}</h3>
									<p>${user.login}</p>
									<span class="price">${user.contact.adresse}</span> 
									<span class="price">${user.contact.telephonePerso}</span>
								</div>
								<div class="listingbtns">
									<span class="listbuttons"> <spring:url
											value="users/{userId}.html" var="userUrl">
											<spring:param name="userId" value="${user.id}" />
										</spring:url> <a href="${userUrl}">View Details</a>
									</span> 
									<span class="listbuttons"> <spring:url
												value="/users/{userId}/edit.htm" var="userUrl">
												<spring:param name="userId" value="${user.id}" />
											</spring:url> <a href="${fn:escapeXml(userUrl)}"><spring:message code="user.action.edit" /></a>
										</span> 
										 
										<span class="listbuttons"> <spring:url
												value="/users/{userId}/delete.htm" var="userUrl">
												<spring:param name="userId" value="${user.id}" />
											</spring:url> <a href="${fn:escapeXml(userUrl)}"><spring:message code="user.action.delete" /></a>
										</span>
								</div>
								<div class="clear">&nbsp;</div>
							</li>
						</c:forEach>
						<li>
								<span class="listbuttons">
										<a class="buttonmenu" href="${fn:escapeXml(addUserUrl)}"><spring:message code="user.action.add" /></a>
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
			</div>

			<div class="clear">&nbsp;</div>
			<div class="clear">&nbsp;</div>
			<jsp:include page="../common/footer.jsp" />
		</div>
</body>
</html>