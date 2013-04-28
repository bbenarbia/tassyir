<%@ include file="/WEB-INF/pages/common/header.jsp" %>
<div id="topcategorieslink" class="clear">
				<h2>Categories</h2>
				<ul>
					<li class="current"><a href="${contextPath}">Home</a></li>
					<sec:authorize access="hasAnyRole('ROLE_MANAGER')">
						<li><a href="${contextPath}/users">Users</a></li>
						<li><a href="${contextPath}/groups">Groups</a></li>
					</sec:authorize>
					<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
						<li><a href="${contextPath}/parameters">Params</a></li>
					</sec:authorize>
					<li><a href="${contextPath}/biens/find-biens">Find bien</a></li>	
					<li><a href="#">Roles</a></li>
				</ul>
</div>