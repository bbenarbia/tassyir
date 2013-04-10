<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title></title>
	<jsp:include page="./../common/head.jsp"/>
</head>
<body>
	<spring:url value="/groups/photo" var="photoUrl" />
		<spring:url value="/groups/upload/{groupId}/show" var="addPhotoUrl">
		<spring:param name="groupId" value="${group.id}" />
	</spring:url>
	<div id="wrap">
		<jsp:include page="../common/menu.jsp" />
		<div id="content">

			<div id="content">
				<jsp:include page="../common/sub-menu.jsp" />

				<div id="main">
					<h1>User Groups Listing</h1>
					<ul class="listing">
						<c:forEach var="group" items="${selections}">
							<li>
								<div class="listinfo">
									<c:if test="${empty group.photo }">
										<img src='<c:url value="/resources/graphics/imageholder.jpg"/>' alt="Listing Image"
										class="listingimage" />
									</c:if>
									<c:if test="${not empty group.photo }">
										<img width="70" height="70" src="${photoUrl}/${group.id}" class="listingimage" />
									</c:if>									
									<h3>${group.name}</h3>
									<c:forEach var="role" items="${group.roles}">
										<span class="price">${role.name}</span>
									</c:forEach>
								</div>
								<div class="listingbtns">
									<span class="listbuttons"> <spring:url
											value="groups/{groupId}.html" var="groupUrl">
											<spring:param name="groupId" value="${group.id}" />
										</spring:url> <a href="${groupUrl}">View Details</a>
									</span>
									<span class="listbuttons"> <spring:url
											value="groups/{groupId}/edit.html" var="groupUrl">
											<spring:param name="groupId" value="${group.id}" />
										</spring:url> <a href="${groupUrl}">Edit group</a>
									</span> <span class="listbuttons"> <spring:url
											value="/users/new" var="userUrl" /> <spring:url
											value="groups/{groupId}/delete.html" var="groupUrl">
											<spring:param name="groupId" value="${group.id}" />
										</spring:url> <a href="${groupUrl}">Delete group </a>
									</span>
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
			</div>

			<div class="clear">&nbsp;</div>
			<div class="clear">&nbsp;</div>
			<jsp:include page="../common/footer.jsp" />
		</div>
	</div>
</body>
</html>
