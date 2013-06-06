<%@ include file="/WEB-INF/pages/common/head.jsp" %>
<div class="navig">
	<c:forEach var="navig" items="${navigations}" varStatus="status">
							&laquo;
							<spring:url value="${navig.url}" var="navigs" />
		<a href="${navigs}"><spring:message code="${navig.name}" /></a>
	</c:forEach>
</div>