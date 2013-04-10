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

			<div id="home_main">
				<div id="search">
					<div class="tab">
						<h2>Edit Parameter</h2>
					</div>
					<div class="container">						
					<form:form modelAttribute="parameter" method="put" id="form1">
						<table class="search_form" style="width: 100%; border: none;">
								<tr>
									<td class="label"><form:label path="name">Name</form:label></td>
									<td><label> <form:input label="param Name" path="name"  class="text longfield" />
										</label>
										<label><form:errors cssClass="error" path="name" />
										</label>
									</td>
								</tr>
								<tr>
									<td class="label"><form:label path="value">value</form:label></td>
									<td><label> <form:input label="param value" path="value"  class="text longfield" />
										</label>
										<label><form:errors cssClass="error" path="value" />
										</label>
									</td>
								</tr>
								<tr>
									<td class="label"><form:label path="description">description</form:label></td>
									<td><label> <form:textarea cols="20" rows="10" 
												label="description"
												path="description" class="text textBoxfieldlong" />
										</label>
										<label><form:errors cssClass="error" path="description" />
										</label>
									</td>
								</tr>
								<tr>
									<td class="label">&nbsp;</td>
									<td>&nbsp;</td>
									<td colspan="2" class="label"><label> <input
											type="image"  src='<c:url value="/resources/graphics/searchbtn.gif"/>' alt="search"
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