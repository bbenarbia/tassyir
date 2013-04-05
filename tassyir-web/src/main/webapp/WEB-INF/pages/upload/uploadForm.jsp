<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

	<form:form method="post" action="save.html" modelAttribute="uploadForm"
		enctype="multipart/form-data">
		<div class="CSS_Table_Example" style="width: 600px; height: 150px;">
			<table style="width: 600px; height: 150px;">
				<tr>
					<td>Photos  </td>
					<td style="width: 350px;">Select photo(s)</td>
				</tr>
				<c:forEach varStatus="status" begin="1" end="${nbFiles}">
					<tr>
						<td>Photo  : ${status.count}</td> <td style="width: 350px;"> <input name="files[${status.count-1}]" type="file" accept="image/*" /></td>
					</tr>
				</c:forEach>
				<tr>
					<td><input type="submit" value="Upload" /></td>
				</tr>
			</table>
		</div>
	</form:form>
</body>
</html>