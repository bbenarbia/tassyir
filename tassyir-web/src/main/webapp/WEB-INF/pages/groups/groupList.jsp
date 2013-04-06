<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet" href="<c:url value="/stylesheets/style.css"/>"
	type="text/css" />

<link rel="stylesheet"
	href="<c:url value="/stylesheets/carroussel.css"/>" type="text/css" />
<script type="text/javascript" src="scripts/jquery-1.9.1.js">
	
</script>
<script type="text/javascript" src="scripts/carroussel.js">
	
</script>
</head>
<body>
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
									<h3>${group.name}</h3>
									<c:forEach var="role" items="${group.roles}">
										<span class="price">${role.name}</span>
									</c:forEach>
								</div>
								<div class="listingbtns">
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
