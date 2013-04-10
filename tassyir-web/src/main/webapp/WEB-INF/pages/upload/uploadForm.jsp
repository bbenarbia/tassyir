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
						<h2>Add Photos</h2>
					</div>
					<div class="container">

						<form:form method="post" action="save.html"
							modelAttribute="uploadForm" enctype="multipart/form-data"
							id="form1">
							
							<table class="search_form" style="width: 100%; border: none;">
								<c:forEach varStatus="status" begin="1" end="${nbFiles}">
									<tr>
										<td class="label">Photo: ${status.count}</td>
										<td><label><input
												name="files[${status.count-1}]" type="file" accept="image/*" />
										</label></td>
									</tr>
								</c:forEach>
								<tr>
									<td colspan="2" align="right"><input type="submit" value="Upload" /></td>
								</tr>
								</table>
						</form:form>
					</div>
					<div class="bottom"></div>
				</div>
			</div>
			<div class="clear">&nbsp;</div>
			<div class="clear">&nbsp;</div>
			<jsp:include page="../common/footer.jsp" />
		</div>
	</div>
</body>
</html>


