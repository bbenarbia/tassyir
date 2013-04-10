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

			<div id="home_main_edit">
				<div id="edit">
					<div class="tab">
						<h2>Add new  group</h2>
					</div>
					<div class="container">
						
					<form:form modelAttribute="group" method="post" id="form1">

						<table class="edit_form" style="width: 100%; border: none;">
								<tr>
									<td class="label"><form:label path="name">Name</form:label></td>
									<td><label> <form:input label="Group Name" path="name"  class="text" />
										</label>
									</td>
								</tr>
								<tr>
									<td  style="font-weight: bold;">Roles</td>
									<td>
									 <table>
										<tr>
											<td style="font-weight: bold;">N°</td>
											<td style="font-weight: bold; width: 150px;">Name</td>
											<td style="font-weight: bold; width: 450px;">description</td>
											<td style="font-weight: bold;">Included</td>
										</tr>
										<c:forEach items="${group.roleFormList.roles}" var="roleForm"
											varStatus="status">
											<tr>
												<td><label> ${status.count}</label></td>
												<td><label>${roleForm.role.name}</label>
												<label><form:hidden  path="roleFormList.roles[${status.index}].role.name" /></label></td>
												<td><label>${roleForm.role.description}</label></td>
												<td><label><form:checkbox path="roleFormList.roles[${status.index}].included" /></label></td>
											</tr>
										</c:forEach>
									 </table>
									</td>
								</tr>
								<tr>
									<td class="label">&nbsp;</td>
									<td>&nbsp;</td>
									<td colspan="2" class="label"><label> <input
											type="image" src='<c:url value="/resources/graphics/searchbtn.gif"/>' alt="search"
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
			<div class="clear">&nbsp;</div>
			<div class="clear">&nbsp;</div>
			<jsp:include page="../common/footer.jsp" />
		</div>
	</div>
</body>
</html>

				