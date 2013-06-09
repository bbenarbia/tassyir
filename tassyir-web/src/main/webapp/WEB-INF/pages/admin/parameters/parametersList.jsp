<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title></title>
	<jsp:include page="./../../common/head.jsp"/>
</head>
<body>
	<spring:url value="/parameters/{paramId}.htm" var="cancelParamUrl">
					<spring:param name="paramId" value="${parameter.id}" />
		</spring:url>
	
	<spring:url value="/parameters.htm" var="paramListUrl" />
	<spring:url value="/parameters/new.htm" var="addParamUrl" /> 
	
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
					<h1>Parameters Listing</h1>
					
					<ul class="listing">
						<c:forEach var="parameter" items="${selections}">
							<li>
								<div class="listinfo">
									<h3>${parameter.name}</h3>
									<div class="divdetails">
										 <table class="im12_detTab"  style="width: 600px">
											<tbody>
											<tr class="auto2010_detTabTR">
												<td class="auto2010_detTD1First" >Valeur</td>
												<td class="auto2010_detTD1First">${parameter.value}</td>
											</tr>
											<tr class="auto2010_detTabTR">
												<td class="auto2010_detTD1First">Description</td>
												<td class="auto2010_detTD1First">${parameter.description}</td>
											</tr>
											</tbody>
										</table>
									<%-- <span class="price">${parameter.value}</span> <span
										class="price">${parameter.description}</span> --%>
									</div>
									</div>
									<div class="listingbtns">
										<span class="listbuttons"> 
											<spring:url value="/parameters/{paramId}/edit.htm" var="editParamUrl">
													<spring:param name="paramId" value="${parameter.id}" />
											</spring:url>
											<a href="${fn:escapeXml(editParamUrl)}"><spring:message code="param.action.edit" /></a>
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
			<jsp:include page="../../common/footer.jsp" />
	</div>
</body>
</html>