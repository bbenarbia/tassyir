<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<jsp:include page="./../common/head.jsp"/>
	<title>Tassyir: update group</title>
</head>
<body>
	<div id="wrap">
		<jsp:include page="../common/menu.jsp" />
		<div id="content">
			<jsp:include page="../common/sub-menu.jsp" />

			<div id="home_main_edit">
				<div id="edit">
					<div class="tab">
						<h2>Edit group</h2>
					</div>
					<div class="container">
						
					<form:form modelAttribute="group" method="put" id="form1">

							<table class="edit_form" style="width: 100%; border: none;">
								<tr>
									<td class="label"><form:label path="name"><spring:message code="group.name" /></form:label></td>
									<td><label> <form:input path="name"  class="text" cssErrorClass="error"/>
										</label>
										<form:errors path="name" cssClass="error_code"/>
									</td>
								</tr>
								<tr>
									<td  style="font-weight: bold;"><spring:message code="user.roles" /></td>
									<td>
									 <table>
										<tr>
											<td style="font-weight: bold;"><spring:message code="user.num" /></td>
											<td style="font-weight: bold; width: 150px;"><spring:message code="user.rolename" /></td>
											<td style="font-weight: bold; width: 450px;"><spring:message code="user.roledescription" /></td>
											<td style="font-weight: bold;"><spring:message code="user.included" /></td>
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
								<td colspan="4">
									<table class="search_form" style="width: 100%; border: none;">
											<tr>
												<td  class="label"><spring:message code="user.photo" /> </td>
												<td><label><input
														name="photoFile" type="file" accept="image/*" />
												</label></td>
											</tr>
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

				